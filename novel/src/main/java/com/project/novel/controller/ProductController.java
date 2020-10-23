package com.project.novel.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.novel.service.impl.NovelServiceImpl;
import com.project.novel.vo.NovelVo;
import com.project.novel.vo.ResponseVo;

@Controller
@RequestMapping("/products")
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired NovelServiceImpl novelService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ModelAndView productAll(HttpServletResponse response, HttpServletRequest request) throws Exception {
		String pageUrl = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		ModelAndView mav = new ModelAndView();
		ResponseVo res = new ResponseVo();
		NovelVo vo = new NovelVo();
		try {
			List<NovelVo> list = novelService.novelList(vo);
			res.setCode(200);
		}catch(Exception e) {
			res.setCode(500);
			logger.error(e.getMessage());
		}
		mav.addObject("res", res);
		mav.setViewName("/product/genre.bs");
		return mav;
	}
	
	
}
