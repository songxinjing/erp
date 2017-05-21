package com.songxinjing.erp.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * 角色信息表实体类
 * 
 * @author songxinjing
 *
 */
@Entity
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 角色码
	 */
	@Id
	@Column(length = 4)
	private String code;

	/**
	 * 角色名称
	 */
	@Column(length = 64)
	private String name;

	/**
	 * 角色描述
	 */
	@Column(length = 255)
	private String descp;

	/**
	 * 包含权限列表
	 */
	@ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Privilege> privileges;

	/**
	 * 包含用户列表
	 */
	@ManyToMany
	private List<User> users;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescp() {
		return descp;
	}

	public void setDescp(String descp) {
		this.descp = descp;
	}

	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}