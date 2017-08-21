package com.songxinjing.erp.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 店铺信息表实体类
 * 
 * @author songxinjing
 *
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "platform", "authUserId" }) })
public class Store implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 店铺ID
	 */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer storeId;

	/**
	 * 店铺名称
	 */
	@Column(length = 32)
	private String storeName;

	/**
	 * 所属平台
	 */
	@Column
	private Integer platform;

	/**
	 * 授权用户ID
	 */

	@Column(length = 64)
	private String authUserId;

	/**
	 * 店铺Token
	 */
	@Column
	@Lob
	private String storeToken;

	/**
	 * Token过期时间
	 */
	@Column
	private Timestamp tokenExp;

	/**
	 * 店铺所属用户
	 */
	@ManyToOne
	@JoinColumn
	private User storeHolder;

	/**
	 * 商品列表
	 */
	@OneToMany(mappedBy = "itemStore")
	private List<Item> items;

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Integer getPlatform() {
		return platform;
	}

	public void setPlatform(Integer platform) {
		this.platform = platform;
	}

	public String getAuthUserId() {
		return authUserId;
	}

	public void setAuthUserId(String authUserId) {
		this.authUserId = authUserId;
	}

	public String getStoreToken() {
		return storeToken;
	}

	public void setStoreToken(String storeToken) {
		this.storeToken = storeToken;
	}

	public Timestamp getTokenExp() {
		return tokenExp;
	}

	public void setTokenExp(Timestamp tokenExp) {
		this.tokenExp = tokenExp;
	}

	public User getStoreHolder() {
		return storeHolder;
	}

	public void setStoreHolder(User storeHolder) {
		this.storeHolder = storeHolder;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}