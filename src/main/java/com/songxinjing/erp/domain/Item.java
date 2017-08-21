package com.songxinjing.erp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 商品信息表实体类
 * 
 * @author songxinjing
 *
 */
@Entity
@Table(indexes = { @Index(columnList = "itemID"), @Index(columnList = "sku"), @Index(columnList = "listingStartTime") })
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 流水ID
	 */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 商品ID
	 */
	@Column(length = 16)
	private String itemID;

	/**
	 * 商品SKU
	 */
	@Column(length = 32)
	private String sku;

	/**
	 * 站点
	 */
	@Column(length = 16)
	private String site;

	/**
	 * 标题
	 */
	@Column(length = 128)
	private String title;

	/**
	 * 访问量
	 */
	@Column
	private Long hitCount;

	/**
	 * 第一刊登分类ID
	 */
	@Column(length = 8)
	private String primaryCategoryID;

	/**
	 * 第一刊登分类名称
	 */
	@Column(length = 128)
	private String primaryCategoryName;

	/**
	 * 一口价价格
	 */
	@Column(precision = 12, scale = 2)
	private BigDecimal buyItNowPrice;

	/**
	 * 一口价币种
	 */
	@Column(length = 3)
	private String buyItNowCurrencyCode;
	
	/**
	 * 商品状态
	 */
	@Column
	private Integer conditionID;
	
	/**
	 * 商品出价类型
	 */
	@Column(length = 16)
	private String listingType;
	

	/**
	 * 商品描述
	 */
	@Column
	@Lob
	private String description;

	/**
	 * 商品URL
	 */
	@Column(length = 128)
	private String viewItemURL;

	/**
	 * 上架时间
	 */
	@Column
	private Timestamp listingStartTime;

	/**
	 * 商品剩余数量
	 */
	@Column
	private Integer quantity;

	/**
	 * 商品LOGO图
	 */
	@Column(length = 128)
	private String galleryURL;

	/**
	 * 同步时间
	 */
	@Column
	private Timestamp synTime;

	/**
	 * 图片列表
	 */
	@OneToMany(mappedBy = "picItem")
	private List<ItemPicture> pictures;

	/**
	 * 属性列表
	 */
	@OneToMany(mappedBy = "speItem")
	private List<ItemSpecific> specifics;

	/**
	 * 子商品列表
	 */
	@OneToMany(mappedBy = "parentItem")
	private List<SubItem> subItems;

	/**
	 * 商品所属店铺
	 */
	@ManyToOne
	@JoinColumn
	private Store itemStore;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getHitCount() {
		return hitCount;
	}

	public void setHitCount(Long hitCount) {
		this.hitCount = hitCount;
	}

	public String getPrimaryCategoryID() {
		return primaryCategoryID;
	}

	public void setPrimaryCategoryID(String primaryCategoryID) {
		this.primaryCategoryID = primaryCategoryID;
	}

	public String getPrimaryCategoryName() {
		return primaryCategoryName;
	}

	public void setPrimaryCategoryName(String primaryCategoryName) {
		this.primaryCategoryName = primaryCategoryName;
	}

	public BigDecimal getBuyItNowPrice() {
		return buyItNowPrice;
	}

	public void setBuyItNowPrice(BigDecimal buyItNowPrice) {
		this.buyItNowPrice = buyItNowPrice;
	}

	public String getBuyItNowCurrencyCode() {
		return buyItNowCurrencyCode;
	}

	public void setBuyItNowCurrencyCode(String buyItNowCurrencyCode) {
		this.buyItNowCurrencyCode = buyItNowCurrencyCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getViewItemURL() {
		return viewItemURL;
	}

	public void setViewItemURL(String viewItemURL) {
		this.viewItemURL = viewItemURL;
	}

	public Timestamp getListingStartTime() {
		return listingStartTime;
	}

	public void setListingStartTime(Timestamp listingStartTime) {
		this.listingStartTime = listingStartTime;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getGalleryURL() {
		return galleryURL;
	}

	public void setGalleryURL(String galleryURL) {
		this.galleryURL = galleryURL;
	}

	public Timestamp getSynTime() {
		return synTime;
	}

	public void setSynTime(Timestamp synTime) {
		this.synTime = synTime;
	}

	public List<ItemPicture> getPictures() {
		return pictures;
	}

	public void setPictures(List<ItemPicture> pictures) {
		this.pictures = pictures;
	}

	public List<ItemSpecific> getSpecifics() {
		return specifics;
	}

	public void setSpecifics(List<ItemSpecific> specifics) {
		this.specifics = specifics;
	}

	public List<SubItem> getSubItems() {
		return subItems;
	}

	public void setSubItems(List<SubItem> subItems) {
		this.subItems = subItems;
	}

	public Store getItemStore() {
		return itemStore;
	}

	public void setItemStore(Store itemStore) {
		this.itemStore = itemStore;
	}

}
