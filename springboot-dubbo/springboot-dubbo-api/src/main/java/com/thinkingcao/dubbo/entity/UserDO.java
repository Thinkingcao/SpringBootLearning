package com.thinkingcao.dubbo.entity;

import java.io.Serializable;

/**
 * <p>
 * @类名称：UserDO
 * @类描述：TODO 
 * @日期：2018年12月20日 
 * @版本：V1.0
 * </p>
 */
public class UserDO implements Serializable {

	/**
	 * @字段名：serialVersionUID
	 * @字段描述：{todo}
	 */
	private static final long serialVersionUID = 5438739092677089251L;

	private Long id;
	private String name;
	private String passwrod;

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

	public String getPasswrod() {
		return passwrod;
	}

	public void setPasswrod(String passwrod) {
		this.passwrod = passwrod;
	}

	public UserDO() {
		super();
// TODO Auto-generated constructor stub
	}

	public UserDO(Long id, String name, String passwrod) {
		super();
		this.id = id;
		this.name = name;
		this.passwrod = passwrod;
	}

}