package com.thingingcao.jpa.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "tb_student")
public class Student {
	@Id
	@GeneratedValue()
	@Column(name = "id", length = 32)
	private Long id;

	@Column(name = "name", length = 50)
	private String name;

	@Column(name = "age", length = 3)
	private Integer age;

	@Column(name = "createTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	@Column(name = "editTime")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date editTime;

	public Student() {

	}

	public Student(Long id, String name, Integer age, Date createTime, Date editTime) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.createTime = createTime;
		this.editTime = editTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getEditTime() {
		return editTime;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

}