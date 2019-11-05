package com.clubTest.run;


import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.clubTest.entity.News;
import com.clubTest.entity.Project;
import com.clubTest.service.LinkService;
import com.clubTest.service.NewsService;
import com.clubTest.service.ProjectService;
import com.clubTest.service.TeamService;



@Component("startupRunner")
public class StartupRunner implements CommandLineRunner,ServletContextListener{

	private ServletContext application=null;
	
	@Resource
	private NewsService newsService;
	
	@Resource
	private LinkService linkService;
	
	@Resource
	private ProjectService projectService;
	
	@Resource
	private TeamService teamService;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		this.loadData();
	}
	
	/**
	 * 加载数据到applicaton缓存中
	 */
	public void loadData(){
		
		News news=new News();
		Project project = new Project();
		news.setHot(1);
		application.setAttribute("newestHotNewsList", newsService.list(news, 0, 10)); // 获取最新10条热门电影
		application.setAttribute("newestHotProjectList", projectService.list(project, 0, 10)); // 获取最新10条热门电影		
		application.setAttribute("linkList", linkService.listAll()); // 查询所有友情链接
		application.setAttribute("teamList", teamService.listAll()); // 查询所有成员信息
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		application=sce.getServletContext();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
