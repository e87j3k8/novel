package com.project.novel.controller;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.novel.service.UserService;
import com.project.novel.service.impl.NovelServiceImpl;
import com.project.novel.vo.NovelVo;
import com.project.novel.vo.ResponseVo;
import com.project.novel.vo.UserVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired UserService userService;
	@Autowired NovelServiceImpl novelService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = { "", "/", "/index" })
	public ModelAndView index(HttpServletResponse response, HttpServletRequest request) throws Exception {
		String pageUrl = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		ModelAndView mav = new ModelAndView();
		UserVo vo = new UserVo();
		vo.setId(1);
		vo = userService.getUser(vo);
		
		mav.setViewName("/index.bs");
		return mav;
	}
	
	@RequestMapping(value = "/rankngtop", method=RequestMethod.GET)
	@ResponseBody
	public ResponseVo rankingTop(HttpServletResponse response, HttpServletRequest request) throws Exception {
		ResponseVo res = new ResponseVo();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("top", 3); //몇위까지?
		List<NovelVo> list = novelService.novelListRanking(map);
		res.setCode(200);
		res.setData(list);
		return res;
	}
	
}
