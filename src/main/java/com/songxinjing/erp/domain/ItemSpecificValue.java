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
 * 商品属性取值实体类
 * 
 * @author songxinjing
 *
 */
@Entity
public class ItemSpecificValue implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 属性取值ID
	 */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long speValueId;

	/**
	 *  属性取值
	 */
	@Column(length = 32)
	private String speValue;

	/**
	 * 所属属性
	 */
	@ManyToOne
	@JoinColumn
	private ItemSpecific valueSpecific;

	public Long getSpeValueId() {
		return speValueId;
	}

	public void setSpeValueId(Long speValueId) {
		this.speValueId = speValueId;
	}

	public String getSpeValue() {
		return speValue;
	}

	public void setSpeValue(String speValue) {
		this.speValue = speValue;
	}

	public ItemSpecific getValueSpecific() {
		return valueSpecific;
	}

	public void setValueSpecific(ItemSpecific valueSpecific) {
		this.valueSpecific = valueSpecific;
	}

}