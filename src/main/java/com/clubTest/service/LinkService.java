package com.clubTest.service;

import java.util.List;

import com.clubTest.entity.Link;

/**
 * 友情链接Service接口
 * @author Administrator
 *
 */
public interface LinkService {

	/**
	 * 分页查询友情链接
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<Link> list(Integer page,Integer pageSize);
	
	/**
	 * 查询所有友情链接
	 * @return
	 */
	public List<Link> listAll();
	
	/**
	 * 获取总记录数
	 * @return
	 */
	public Long getCount();
	
	/**
	 * 添加或者修改友情链接
	 * @param link
	 */
	public void save(Link link);
	
	/**
	 * 根据id删除友情链接
	 * @param id
	 */
	public void delete(Integer id);
}
