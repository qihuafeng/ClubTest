package com.clubTest.service;

import java.util.List;

import com.clubTest.entity.News;

public interface NewsService {
	
	public void save(News news) ;
	
	/**
	 * 分页查询电影信息
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<News> list(News news,Integer page,Integer pageSize);
	
	/**
	 * 获取总记录数
	 * @return
	 */
	public Long getCount(News news);
	
	/**
	 * 根据id查找实体
	 * @param id
	 * @return
	 */
	public News findById(Integer id);
	
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
	public News getLast(Integer id);
	
	/**
	 * 获取下一个新闻
	 * @param id
	 * @return
	 */
	public News getNext(Integer id);
	
	

}
