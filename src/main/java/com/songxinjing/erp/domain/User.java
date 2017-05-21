package com.songxinjing.erp.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * 账户信息表实体类
 * 
 * @author songxinjing
 *
 */
@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	@Id
	@Column(length = 16)
	private String userId;

	/**
	 * 邮箱
	 */
	@Column(length = 64, unique = true)
	private String email;

	/**
	 * 手机号码
	 */
	@Column(length = 16, unique = true)
	private String phone;

	/**
	 * 密码密文
	 */
	@Column(length = 64)
	private String password;

	/**
	 * 用户状态：0-正常；1-冻结；2-删除
	 */
	@Column
	private Byte state;

	/**
	 * 用户所属角色列表
	 */
	@ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Role> roles;

	/**
	 * 店铺列表
	 */
	@OneToMany(mappedBy = "storeHolder")
	private List<Store> stores;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Byte getState() {
		return state;
	}

	public void setState(Byte state) {
		this.state = state;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

}