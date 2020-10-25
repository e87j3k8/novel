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

import com.project.novel.service.impl.NovelServiceImpl;
import com.project.novel.vo.NovelVo;
import com.project.novel.vo.ResponseVo;

@Controller
@RequestMapping("/products")
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired NovelServiceImpl novelService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ModelAndView productAll(@RequestParam(defaultValue="0",value="page") int page, HttpServletResponse response, HttpServletRequest request) throws Exception {
		String pageUrl = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		ModelAndView mav = new ModelAndView();
		NovelVo vo = new NovelVo();
		page*=5;
		vo.setPage(page);
		try {
			List<NovelVo> list = novelService.novelList(vo);
			mav.addObject("list", list);
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		mav.setViewName("/product/productList.bs");
		return mav;
	}
	
	@RequestMapping(value="/view/{novelId:[\\d]+}", method = RequestMethod.GET)
	public ModelAndView productView(@PathVariable long novelId,HttpServletResponse response, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setView(new RedirectView("/"));
		return mav;
	}
	
	
}
