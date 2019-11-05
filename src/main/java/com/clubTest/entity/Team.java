package com.clubTest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;
/**
 * 工作室成员实体
 * @author Lenovo
 *
 */
@Entity
@Table(name="t_team")
public class Team {
	
	@Id
	@GeneratedValue
	private Integer id; //成员编号
	
	@Column(length=300)
	private String imageFile; // 成员图片

	
	@Column(length=200)
	private String name; //成员姓名
	
	@Column(length=100)
	private String position;  //职位
	
	@Column(length=300)
	private String charge;  //负责方面
	
	@Column(length=500)
	private String content; //个人简介

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

}