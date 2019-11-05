package com.clubTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.clubTest.entity.News;

public interface NewsRepository extends JpaRepository<News,Integer>,JpaSpecificationExecutor<News>{

	
	/**
	 * 获取上一个新闻
	 * @param id
	 * @return
	 */
	@Query(value="SELECT * FROM t_news WHERE id<?1 ORDER BY id DESC LIMIT 1",nativeQuery=true)
	public News getLast(Integer id);
	
	/**
	 * 获取下一个新闻
	 * @param id
	 * @return
	 */
	@Query(value="select * from t_news where id>?1 order by id asc limit 1",nativeQuery=true)
	public News getNext(Integer id);
	
}
