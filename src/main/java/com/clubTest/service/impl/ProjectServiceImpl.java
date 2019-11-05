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

import com.clubTest.entity.Project;
import com.clubTest.repository.ProjectRepository;
import com.clubTest.service.ProjectService;
import com.clubTest.util.StringUtil;



@Service("projectService")
public class ProjectServiceImpl implements ProjectService{

	@Resource
	private ProjectRepository projectRepository;
	
	@Override
	public void save(Project project) {
		
		projectRepository.save(project);
	}

	@Override
	public List<Project> list(Project project, Integer page, Integer pageSize) {
		Pageable pageable=new PageRequest(page, pageSize,Sort.Direction.DESC,"publishDate");
		Page<Project> pageWebSite=projectRepository.findAll(new Specification<Project>() {
			
			@Override
			public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate=cb.conjunction();
				if(project!=null){
					if(StringUtil.isNotEmpty(project.getName())){
						predicate.getExpressions().add(cb.like(root.get("name"), "%"+project.getName().trim()+"%"));
					}
					if(project.getHot()!=null && project.getHot()==1){
						predicate.getExpressions().add(cb.equal(root.get("hot"), 1));
					}
				}
				return predicate;
			}
		}, pageable);
		return pageWebSite.getContent();
	}

	@Override
	public Long getCount(Project project) {
		Long count=projectRepository.count(new Specification<Project>() {

			@Override
			public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate=cb.conjunction();
				if(project!=null){
					if(StringUtil.isNotEmpty(project.getName())){
						predicate.getExpressions().add(cb.like(root.get("name"), "%"+project.getName().trim()+"%"));
					}
					if(project.getHot()!=null && project.getHot()==1){
						predicate.getExpressions().add(cb.equal(root.get("hot"), 1));
					}
				}
				return predicate;
			}
		});
		return count;
	}

	@Override
	public Project findById(Integer id) {
		return projectRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		projectRepository.deleteById(id);
	}

	@Override
	public Project getLast(Integer id) {
		return projectRepository.getLast(id);
	}

	@Override
	public Project getNext(Integer id) {
		return projectRepository.getNext(id);
	}


}
