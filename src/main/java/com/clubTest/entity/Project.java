package com.clubTest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 新闻实体
 * @author Administrator
 *
 */
@Entity
@Table(name="t_project")
public class Project {

	@Id
	@GeneratedValue
	private Integer id; // 编号
	
	
	@Column(length=200)
	private String name; // 案例名称
	
	@Column(length=500)
	private String summary; // 摘要
	
	@Lob
	@Column(columnDefinition="TEXT")
	private String content; // 帖子内容
	
	@Column(length=300)
	private String imageName; // 新闻图片
	
	private Integer hot; // 是否热门新闻 1 热门 0 非热门
	
	private Date publishDate; // 发布日期

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Integer getHot() {
		return hot;
	}

	public void setHot(Integer hot) {
		this.hot = hot;
	}

	@JsonSerialize(using=CustomDateTimeSerializer.class)
	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	
}
