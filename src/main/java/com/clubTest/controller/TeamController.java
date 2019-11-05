package com.clubTest.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.clubTest.entity.Team;
import com.clubTest.service.TeamService;


@Controller
@RequestMapping("/team")
public class TeamController {
	
	@Resource
	private TeamService teamService;
	
	
	
	/**
	 * 分页查询新闻信息
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list/{id}")
	public ModelAndView list(@PathVariable(value="id",required=false)Integer page)throws Exception{
		ModelAndView mav=new ModelAndView();
		List<Team> teamList=teamService.listAll();
		
		mav.addObject("teamList", teamList);
	
		
		mav.setViewName("aboutMe");
		return mav;
	}
	
	/**
	 * 根据id获取新闻详细信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	
	
	
//	@RequestMapping("/{id}")
//	public ModelAndView view(@PathVariable(value="id",required=false)Integer id)throws Exception{
//		ModelAndView mav=new ModelAndView();
//	    News news=newsService.findById(id);
//		mav.addObject("news", news);
//		mav.addObject("title", news.getName());		
//		mav.addObject("pageCode", this.getUpAndDownPageCode(newsService.getLast(id), newsService.getNext(id)));
//		mav.addObject("mainPage", "news/view");
//		mav.addObject("mainPageKey", "#f");
//		mav.setViewName("newsView");
//		return mav;
//	}
//
//	/**
//	 * 获取下一个新闻你和上一个新闻
//	 * @param lastNews
//	 * @param nextNews
//	 * @return
//	 */
//	private String getUpAndDownPageCode(News lastNews,News nextNews){
//		StringBuffer pageCode=new StringBuffer();
//		if(lastNews==null || lastNews.getId()==null){
//			pageCode.append("<p>上一篇：没有了</p>");
//		}else{
//			pageCode.append("<p>上一篇：<a href='/news/"+lastNews.getId()+"'>"+lastNews.getName()+"</a></p>");
//		}
//		if(nextNews==null || nextNews.getId()==null){
//			pageCode.append("<p>下一篇：没有了</p>");
//		}else{
//			pageCode.append("<p>下一篇：<a href='/news/"+nextNews.getId()+"'>"+nextNews.getName()+"</a></p>");
//		}
//		return pageCode.toString();
//	}
	
	
}
  
