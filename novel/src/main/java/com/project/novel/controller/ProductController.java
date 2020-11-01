package com.project.novel.controller;


import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.project.novel.service.impl.ItemServiceImpl;
import com.project.novel.service.impl.NovelServiceImpl;
import com.project.novel.vo.ItemsVo;
import com.project.novel.vo.NovelVo;
import com.project.novel.vo.ResponseVo;
import com.project.novel.vo.UserVo;

import utils.ProductUtils;

@Controller
@RequestMapping("/products")
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired NovelServiceImpl novelService;
	@Autowired ItemServiceImpl itemService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ModelAndView productAll(@RequestParam(defaultValue="1",value="page") int page, HttpServletResponse response, HttpServletRequest request) throws Exception {
		String pageUrl = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		if(page<1) {
			return new ModelAndView(new RedirectView("/products/all?page=1"));
		}
		ModelAndView mav = new ModelAndView();
		NovelVo vo = new NovelVo();
		try {
			int total = novelService.novelCnt();
			/* total=44; */
			int viewpage = vo.getVIEWPAGE();
			int last = (int)Math.ceil((double)total/(double)viewpage);
			int start = (page%viewpage)==0?(int)Math.ceil((page-1)/viewpage)*viewpage+1:(int)Math.ceil(page/viewpage)*viewpage+1;
			int end = start+viewpage-1>last?last:start+viewpage-1;
			if(last<page) {
				return new ModelAndView(new RedirectView("/products/all?page="+last));
			}
			mav.addObject("start", start);
			mav.addObject("end", end);
			mav.addObject("last", last);
			mav.addObject("view", viewpage);
			mav.addObject("page", page);
			page=viewpage*(page-1);
			vo.setPage(page);
			mav.addObject("list", novelService.novelList(vo));
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		mav.setViewName("/product/productList.bs");
		return mav;
	}
	
	@RequestMapping(value="/view/{novelId:[\\d]+}", method = RequestMethod.GET)
	public ModelAndView productView(@PathVariable long novelId,HttpServletResponse response, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		ItemsVo vo = new ItemsVo();
		NovelVo nvo = new NovelVo();
		nvo.setNovelId(novelId);
		vo.setNovelId(novelId);
		nvo = novelService.viewNovel(nvo);
		mav.addObject("novel",nvo);
		mav.addObject("list", itemService.getItemList(vo));
		mav.setViewName("/product/productView.bs");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="/getStatus", method = RequestMethod.GET)
	public ResponseVo getLikeStatus(HttpServletResponse response, HttpServletRequest request) throws Exception {
		long novelId = ProductUtils.getNovelId(request);
		ResponseVo res = new ResponseVo();
		try {
			UserVo user = (UserVo)request.getSession().getAttribute("user");
			if(user!=null) {
				HashMap<String, Long> map = new HashMap<>();
				map.put("userBy", user.getId());
				map.put("novelId", novelId);
				boolean isRecommend = false;
				ArrayList<Long> list = novelService.getRecommendStatus(map);
				if(list.size()>0) {
					isRecommend = true;
				}
				res.setData(isRecommend);
				res.setCode(200);
			}else {
				res.setCode(200);
			}
		} catch (Exception e) {
			res.setCode(500);
		}
		return res;
	}
	
	@ResponseBody
	@RequestMapping(value="/like", method = RequestMethod.POST)
	public ResponseVo productLike(@RequestParam("status")int status, HttpServletResponse response, HttpServletRequest request) throws Exception {
		ResponseVo res = new ResponseVo();
		UserVo user = (UserVo)request.getSession().getAttribute("user");
		if(user==null || (status!=0 && status !=1)) {
			res.setCode(500);
			return res;
		}
		long novelId = ProductUtils.getNovelId(request);
		try {
			HashMap<String,Long> map = new HashMap<String,Long>();
			map.put("novelId", novelId);
			map.put("userBy", user.getId());
			
			ArrayList<Long> list = novelService.getRecommendStatus(map);
			/*
			 * list의 사이즈가 0이면 추천기록 x
			 * 추천 기록이 없다면 입력하고,
			 * 기록이 있다면 기존 입력을 수정
			 */
			if(list.size()==0) {
				HashMap<String, Object> map2 = new HashMap<String, Object>();
				map2.put("novelId", novelId);
				map2.put("status", status);
				map2.put("userBy", user.getId());
				if(novelService.insertRecommend(map2)==1) { //입력 성공
					res.setCode(200);
				}else {
					res.setCode(500);
					return res;
				}
			}else {
				map.clear();
				map.put("id", list.get(0));
			}
			res.setData(novelService.getRecommend(novelId));
		} catch (Exception e) {
			res.setCode(500);
		}
		return res;
	}
	
	
}
