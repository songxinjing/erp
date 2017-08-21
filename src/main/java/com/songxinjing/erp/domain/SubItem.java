package com.songxinjing.erp.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 子商品实体类
 * 
 * @author songxinjing
 *
 */
@Entity
@Table(indexes = { @Index(columnList = "sku") })
public class SubItem implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 流水ID
	 */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 子商品SKU
	 */
	@Column(length = 32)
	private String sku;

	/**
	 * 子商品价格
	 */
	@Column(precision = 12, scale = 2)
	private BigDecimal buyPrice;

	/**
	 * 价格币种
	 */
	@Column(length = 3)
	private String buyCurrencyCode;

	/**
	 * 剩余数量
	 */
	@Column
	private Integer quantity;

	/**
	 * 卖出数量
	 */
	@Column
	private Integer quantitySold;

	/**
	 *  子类属性取值 属性1-取值1|属性2-取值2|...
	 */
	@Column(length = 255)
	private String specifics;

	/**
	 *  子商品图片URL
	 */
	@Column(length = 128)
	private String pictureURL;

	/**
	 * 所属父商品
	 */
	@ManyToOne
	@JoinColumn
	private Item parentItem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public BigDecimal getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}

	public String getBuyCurrencyCode() {
		return buyCurrencyCode;
	}

	public void setBuyCurrencyCode(String buyCurrencyCode) {
		this.buyCurrencyCode = buyCurrencyCode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getQuantitySold() {
		return quantitySold;
	}

	public void setQuantitySold(Integer quantitySold) {
		this.quantitySold = quantitySold;
	}

	public String getSpecifics() {
		return specifics;
	}

	public void setSpecifics(String specifics) {
		this.specifics = specifics;
	}

	public String getPictureURL() {
		return pictureURL;
	}

	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}

	public Item getParentItem() {
		return parentItem;
	}

	public void setParentItem(Item parentItem) {
		this.parentItem = parentItem;
	}

}