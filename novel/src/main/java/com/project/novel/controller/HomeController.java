package com.project.novel.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.novel.service.UserService;
import com.project.novel.vo.UserVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = { "", "/", "/index" })
	public ModelAndView index(HttpServletResponse response, HttpServletRequest request) throws Exception {
		String pqgeUrl = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		ModelAndView mav = new ModelAndView();
		UserVo vo = new UserVo();
		vo.setId(1);
		vo = userService.getUser(vo);
		
		mav.setViewName("/index.bs");
		return mav;
	}
	
}
