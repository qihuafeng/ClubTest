package com.clubTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("title","你好!");
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/login")
	public String login(){
		return "/login";
		
	}
	
	@RequestMapping("/admin")
	public String toAdmin() {
		
		return "/admin/main";
	}
	
	/**
	 * 关于本站内容
	 * @return
	 */
	@RequestMapping("/serviceItem")
	public ModelAndView serviceItem(){
		ModelAndView mav=new ModelAndView();		
		mav.setViewName("serviceItem");
		return mav;
	}
	
	/**
	 * 关于本站
	 * @return
	 */
	@RequestMapping("/aboutMe")
	public ModelAndView aboutMe(){
		ModelAndView mav=new ModelAndView();		
		mav.setViewName("aboutMe");
		return mav;
	}
	
}
