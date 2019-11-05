package com.clubTest.service;

import java.util.List;

import com.clubTest.entity.Team;

/**
 * 团队service接口
 * @author Lenovo
 *
 */
public interface TeamService {
	
	/**
	 * 分页成员信息链接
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<Team> list(Integer page,Integer pageSize);
	
	/**
	 * 获取总记录数
	 * @return
	 */
	public Long getCount();
	
	/**
	
	/**
	 * 查询所有成员信息
	 * @return
	 */
	public List<Team> listAll();
	
	/**
	 * 添加或者修改成员信息
	 * @param team
	 */
	public void save(Team team);
	
	
	
	/**
	 * 根据id删除成员实体
	 * @param id
	 */
	public void delete(Integer id);
	
	

}
