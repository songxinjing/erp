package com.songxinjing.erp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 商品图片实体类
 * 
 * @author songxinjing
 *
 */
@Entity
public class ItemPicture implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 图片ID
	 */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long picId;

	/**
	 *  图片URL
	 */
	@Column(length = 128)
	private String pictureURL;

	/**
	 * 图片所属商品
	 */
	@ManyToOne
	@JoinColumn
	private Item picItem;

	public Long getPicId() {
		return picId;
	}

	public void setPicId(Long picId) {
		this.picId = picId;
	}

	public String getPictureURL() {
		return pictureURL;
	}

	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}

	public Item getPicItem() {
		return picItem;
	}

	public void setPicItem(Item picItem) {
		this.picItem = picItem;
	}

}