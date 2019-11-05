package com.clubTest.service;

import java.util.List;

import com.clubTest.entity.Project;

public interface ProjectService {
	
	public void save(Project project) ;
	
	/**
	 * 分页查询电影信息
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<Project> list(Project project,Integer page,Integer pageSize);
	
	/**
	 * 获取总记录数
	 * @return
	 */
	public Long getCount(Project project);
	
	/**
	 * 根据id查找实体
	 * @param id
	 * @return
	 */
	public Project findById(Integer id);
	
	/**
	 * 根据id删除电影
	 * @param id
	 */
	public void delete(Integer id);
	
	/**
	 * 获取上一个新闻
	 * @param id
	 * @return
	 */
	public Project getLast(Integer id);
	
	/**
	 * 获取下一个新闻
	 * @param id
	 * @return
	 */
	public Project getNext(Integer id);
	
	

}
