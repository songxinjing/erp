package com.songxinjing.erp.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * 商品属性实体类
 * 
 * @author songxinjing
 *
 */
@Entity
public class ItemSpecific implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 属性ID
	 */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long speId;

	/**
	 *  属性名称
	 */
	@Column(length = 32)
	private String speName;

	/**
	 * 属性所属商品
	 */
	@ManyToOne
	@JoinColumn
	private Item speItem;

	/**
	 * 取值列表
	 */
	@OneToMany(mappedBy = "valueSpecific")
	private List<ItemSpecificValue> values;

	public Long getSpeId() {
		return speId;
	}

	public void setSpeId(Long speId) {
		this.speId = speId;
	}

	public String getSpeName() {
		return speName;
	}

	public void setSpeName(String speName) {
		this.speName = speName;
	}

	public Item getSpeItem() {
		return speItem;
	}

	public void setSpeItem(Item speItem) {
		this.speItem = speItem;
	}

	public List<ItemSpecificValue> getValues() {
		return values;
	}

	public void setValues(List<ItemSpecificValue> values) {
		this.values = values;
	}

}