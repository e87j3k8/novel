package com.project.novel.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.project.novel.service.impl.ItemServiceImpl;
import com.project.novel.vo.ResponseVo;
import com.project.novel.vo.UserVo;

import utils.ProductUtils;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired ItemServiceImpl itemService;
	
	@RequestMapping(value="/{itemId:[\\d]+}", method = RequestMethod.GET)
	public ModelAndView getItem(@PathVariable long itemId, HttpServletResponse response, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("item",itemService.getItem(itemId));
		mav.setViewName("/item/itemView.bs");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="/viewCnt", method = RequestMethod.POST)
	public ResponseVo viewCountUp(HttpServletResponse response, HttpServletRequest request) throws Exception {
		ResponseVo res = new ResponseVo();
		try {
			HashMap<String, Long> map = new HashMap<String, Long>();
			UserVo user = (UserVo)request.getSession().getAttribute("user");
			long itemId = ProductUtils.getItemId(request);
			map.put("itemId", itemId);
			if(user == null) {
				map.put("userBy", 0L);
			}else {
				map.put("userBy", user.getId());
				if(itemService.isView(map)>0) {
					res.setCode(500);
					return res;
				}
			}
			if(itemService.insertView(map)==1) {
				res.setCode(200);
			}else {
				res.setCode(500);
			}
		} catch (Exception e) {
			res.setCode(500);
		}
		return res;
	}
}
