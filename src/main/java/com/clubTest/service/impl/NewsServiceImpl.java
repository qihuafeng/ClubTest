package com.clubTest.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.clubTest.entity.News;
import com.clubTest.repository.NewsRepository;
import com.clubTest.service.NewsService;
import com.clubTest.util.StringUtil;



@Service("newsService")
public class NewsServiceImpl implements NewsService{

	@Resource
	private NewsRepository newsRepository;
	
	@Override
	public void save(News news) {
		
		newsRepository.save(news);
	}

	@Override
	public List<News> list(News news, Integer page, Integer pageSize) {
		Pageable pageable=new PageRequest(page, pageSize,Sort.Direction.DESC,"publishDate");
		Page<News> pageWebSite=newsRepository.findAll(new Specification<News>() {
			
			@Override
			public Predicate toPredicate(Root<News> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate=cb.conjunction();
				if(news!=null){
					if(StringUtil.isNotEmpty(news.getName())){
						predicate.getExpressions().add(cb.like(root.get("name"), "%"+news.getName().trim()+"%"));
					}
					if(news.getHot()!=null && news.getHot()==1){
						predicate.getExpressions().add(cb.equal(root.get("hot"), 1));
					}
				}
				return predicate;
			}
		}, pageable);
		return pageWebSite.getContent();
	}

	@Override
	public Long getCount(News news) {
		Long count=newsRepository.count(new Specification<News>() {

			@Override
			public Predicate toPredicate(Root<News> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate=cb.conjunction();
				if(news!=null){
					if(StringUtil.isNotEmpty(news.getName())){
						predicate.getExpressions().add(cb.like(root.get("name"), "%"+news.getName().trim()+"%"));
					}
					if(news.getHot()!=null && news.getHot()==1){
						predicate.getExpressions().add(cb.equal(root.get("hot"), 1));
					}
				}
				return predicate;
			}
		});
		return count;
	}

	@Override
	public News findById(Integer id) {
		return newsRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		newsRepository.deleteById(id);
	}

	@Override
	public News getLast(Integer id) {
		return newsRepository.getLast(id);
	}

	@Override
	public News getNext(Integer id) {
		return newsRepository.getNext(id);
	}


}
