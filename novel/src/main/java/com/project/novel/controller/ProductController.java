package com.project.novel.controller;

import java.util.List;

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
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.project.novel.service.impl.ItemServiceImpl;
import com.project.novel.service.impl.NovelServiceImpl;
import com.project.novel.vo.ItemsVo;
import com.project.novel.vo.NovelVo;
import com.project.novel.vo.ResponseVo;

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
		final int VIEWPAGE = 5;
		NovelVo vo = new NovelVo();
		try {
			int total = novelService.novelCnt();
			int last = (int)Math.ceil((double)total/(double)VIEWPAGE);
			int start = (page%VIEWPAGE)==0?(int)Math.ceil((page-1)/VIEWPAGE)*VIEWPAGE+1:(int)Math.ceil(page/VIEWPAGE)*VIEWPAGE+1;
			int end = start+VIEWPAGE-1>last?last:start+VIEWPAGE-1;
			if(last<page) {
				return new ModelAndView(new RedirectView("/products/all?page="+last));
			}
			mav.addObject("start", start);
			mav.addObject("end", end);
			mav.addObject("last", last);
			mav.addObject("view", VIEWPAGE);
			mav.addObject("page", page);
			page=VIEWPAGE*(page-1);
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
		vo.setNovelId(novelId);
		mav.addObject("list", itemService.getItemList(vo));
		mav.setViewName("/product/productView.bs");
		return mav;
	}
	
	
}
