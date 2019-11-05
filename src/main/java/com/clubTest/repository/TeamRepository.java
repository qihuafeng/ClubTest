package com.clubTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.clubTest.entity.Team;

/**
 *  团队Repository接口
 * @author Administrator
 *
 */
public interface TeamRepository extends JpaRepository<Team, Integer>,JpaSpecificationExecutor<Team>{
	

}