package com.project.novel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.novel.vo.ResponseVo;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/all")
	public ModelAndView productAll(HttpServletResponse response, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		ResponseVo res = new ResponseVo();
		try {
			res.setCode(200);
		}catch(Exception e) {
			res.setCode(500);
			logger.error(e.getMessage());
		}
		mav.addObject("res", res);
		mav.setViewName("");
		return mav;
	}
	
	
}
