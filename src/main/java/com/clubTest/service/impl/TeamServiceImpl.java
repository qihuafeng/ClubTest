package com.clubTest.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.clubTest.entity.Team;
import com.clubTest.repository.TeamRepository;
import com.clubTest.service.TeamService;
/**
 * Team service实现类
 * @author Lenovo
 *
 */
@Service("teamService")
public class TeamServiceImpl implements TeamService{
	
	
	
	@Resource
	private TeamRepository teamRepository;
   
	@Override
	public List<Team> list(Integer page, Integer pageSize) {
		return teamRepository.findAll(new PageRequest(page, pageSize)).getContent();
	}
	@Override
	public Long getCount() {
		
		return teamRepository.count();
	}
	
	@Override
	public void save(Team team) {
		 teamRepository.save(team);
		
	}

	

	@Override
	public void delete(Integer id) {
		teamRepository.deleteById(id);
		
	}

	

	@Override
	public List<Team> listAll() {
		return teamRepository.findAll();
	}

	

}
