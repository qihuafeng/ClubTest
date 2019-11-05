package com.clubTest.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.clubTest.entity.Project;
import com.clubTest.service.ProjectService;
import com.clubTest.util.PageUtil;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Resource
	private ProjectService projectService;
	
	
	
	/**
	 * 分页查询新闻信息
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list/{id}")
	public ModelAndView list(@PathVariable(value="id",required=false)Integer page)throws Exception{
		ModelAndView mav=new ModelAndView();
		List<Project> projectList=projectService.list(null, page-1, 6);
		Long total=projectService.getCount(null);
		mav.addObject("projectList", projectList);
		mav.addObject("pageCode", PageUtil.genPagination("/project/list", total, page, 6));
		mav.addObject("title", "电影列表");
		mav.addObject("mainPage", "project/list");
		mav.addObject("mainPageKey", "#f");
		mav.setViewName("projectIndexPage");
		return mav;
	}
	
	/**
	 * 根据id获取新闻详细信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/{id}")
	public ModelAndView view(@PathVariable(value="id",required=false)Integer id)throws Exception{
		ModelAndView mav=new ModelAndView();
	    Project project=projectService.findById(id);
		mav.addObject("project", project);
		mav.addObject("title", project.getName());		
		mav.addObject("pageCode", this.getUpAndDownPageCode(projectService.getLast(id), projectService.getNext(id)));
		mav.addObject("mainPage", "project/view");
		mav.addObject("mainPageKey", "#f");
		mav.setViewName("projectView");
		return mav;
	}

	/**
	 * 获取下一个新闻你和上一个新闻
	 * @param lastProject
	 * @param nextProject
	 * @return
	 */
	private String getUpAndDownPageCode(Project lastProject,Project nextProject){
		StringBuffer pageCode=new StringBuffer();
		if(lastProject==null || lastProject.getId()==null){
			pageCode.append("<p>上一篇：没有了</p>");
		}else{
			pageCode.append("<p>上一篇：<a href='/project/"+lastProject.getId()+"'>"+lastProject.getName()+"</a></p>");
		}
		if(nextProject==null || nextProject.getId()==null){
			pageCode.append("<p>下一篇：没有了</p>");
		}else{
			pageCode.append("<p>下一篇：<a href='/project/"+nextProject.getId()+"'>"+nextProject.getName()+"</a></p>");
		}
		return pageCode.toString();
	}
	
	
}
