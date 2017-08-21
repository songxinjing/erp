package com.songxinjing.erp.controller.store;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetMyeBaySellingCall;
import com.ebay.soap.eBLBaseComponents.GetMyeBaySellingRequestType;
import com.ebay.soap.eBLBaseComponents.GetMyeBaySellingResponseType;
import com.ebay.soap.eBLBaseComponents.ItemListCustomizationType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.NameValueListArrayType;
import com.ebay.soap.eBLBaseComponents.NameValueListType;
import com.ebay.soap.eBLBaseComponents.PaginationType;
import com.ebay.soap.eBLBaseComponents.VariationType;
import com.ebay.soap.eBLBaseComponents.VariationsType;
import com.songxinjing.erp.cache.Cache;
import com.songxinjing.erp.controller.base.BaseController;
import com.songxinjing.erp.domain.Item;
import com.songxinjing.erp.domain.ItemSpecific;
import com.songxinjing.erp.domain.ItemSpecificValue;
import com.songxinjing.erp.domain.Store;
import com.songxinjing.erp.domain.SubItem;
import com.songxinjing.erp.ebay.EbayApiUtil;
import com.songxinjing.erp.form.SimpleRspBody;
import com.songxinjing.erp.plugin.page.PageModel;
import com.songxinjing.erp.service.ItemPictureService;
import com.songxinjing.erp.service.ItemService;
import com.songxinjing.erp.service.ItemSpecificService;
import com.songxinjing.erp.service.ItemSpecificValueService;
import com.songxinjing.erp.service.StoreService;
import com.songxinjing.erp.service.SubItemService;

/**
 * 主页控制类
 * 
 * @author songxinjing
 * 
 */
@Controller
public class StoreController extends BaseController {

	@Autowired
	StoreService storeService;

	@Autowired
	ItemService itemService;

	@Autowired
	SubItemService subItemService;

	@Autowired
	ItemPictureService itemPictureService;

	@Autowired
	ItemSpecificService itemSpecificService;

	@Autowired
	ItemSpecificValueService itemSpecificValueService;

	@RequestMapping(value = "store", method = RequestMethod.GET)
	public String list(Model model, HttpServletRequest request) {
		logger.info("进入店铺列表面");
		List<Store> stores = storeService.find();
		model.addAttribute("stores", stores);
		return "store/list";
	}

	@RequestMapping(value = "store/detail", method = RequestMethod.GET)
	public String detail(Model model, HttpServletRequest request, Integer storeId, Integer page) {
		logger.info("进入店铺详情页面");
		Store store = storeService.find(storeId);
		model.addAttribute("store", store);

		String hql = "from Store";
		List<Store> stores = storeService.findPage(hql, 0, 5);
		model.addAttribute("stores", stores);

		if (page == null) {
			page = 1;
		}

		int total = itemService.find().size();

		// 分页代码
		PageModel<Item> pageModel = new PageModel<Item>();
		pageModel.init(page, total);
		pageModel.setUrl("store/detail.html");
		pageModel.setPara("?storeId=" + storeId + "&");
		hql = "from Item order by listingStartTime desc";
		List<Item> items = itemService.findPage(hql, pageModel.getRecFrom(), pageModel.getPageSize());
		pageModel.setRecList(items);

		model.addAttribute("pageModel", pageModel);

		return "store/detail";
	}

	@RequestMapping(value = "store/sync", method = RequestMethod.POST)
	@ResponseBody
	public SimpleRspBody sync(Model model, HttpServletRequest request, Integer storeId) {
		logger.info("进行店铺商品同步");

		Calendar now = Calendar.getInstance();
		Calendar lastSync = Cache.storeSyncMap.get(storeId);
		if (lastSync != null) {
			lastSync.add(Calendar.HOUR, 1);
			if (now.before(lastSync)) {
				return new SimpleRspBody(true, "同步任务正在执行，请稍后查看结果！", null);
			}
		}

		new Thread() {
			public void run() {

				Cache.storeSyncMap.put(storeId, now);

				Store store = storeService.find(storeId);

				ApiContext api = EbayApiUtil.createApiContext();
				api.getApiCredential().seteBayToken(store.getStoreToken());

				GetMyeBaySellingCall call = new GetMyeBaySellingCall(api);

				GetMyeBaySellingRequestType req = new GetMyeBaySellingRequestType();
				call.setMyeBaySellingRequest(req);

				ItemListCustomizationType lc = new ItemListCustomizationType();
				lc.setInclude(new Boolean(true));
				lc.setIncludeNotes(new Boolean(true));

				// Pagination
				PaginationType pt = new PaginationType();
				pt.setEntriesPerPage(new Integer(100));
				pt.setPageNumber(new Integer(1));
				lc.setPagination(pt);

				req.setActiveList(lc);

				// Make API call.
				try {
					call.getMyeBaySelling();
				} catch (Exception e) {
					logger.error("操作失败！", e);
				}

				GetMyeBaySellingResponseType resp = call.getReturnedMyeBaySellingResponse();
				ItemType[] activeList = resp.getActiveList().getItemArray().getItem();
				int pageNumber = resp.getActiveList().getPaginationResult().getTotalNumberOfPages();
				int currPage = 1;
				do {
					for (ItemType itemType : activeList) {
						Item item = new Item();
						item.setItemStore(store);
						item.setBuyItNowCurrencyCode(itemType.getBuyItNowPrice().getCurrencyID().value());
						item.setBuyItNowPrice(new BigDecimal(String.valueOf(itemType.getBuyItNowPrice().getValue())));
						item.setDescription(itemType.getDescription());
						item.setGalleryURL(itemType.getPictureDetails().getGalleryURL());
						item.setHitCount(itemType.getHitCount());
						item.setItemID(itemType.getItemID());
						item.setListingStartTime(
								new Timestamp(itemType.getListingDetails().getStartTime().getTimeInMillis()));
						// item.setPrimaryCategoryID(itemType.getPrimaryCategory().getCategoryID());
						// item.setPrimaryCategoryName(itemType.getPrimaryCategory().getCategoryName());
						item.setQuantity(itemType.getQuantity());
						// item.setSite(itemType.getSite().value());
						item.setSku(itemType.getSKU());
						item.setSynTime(new Timestamp(System.currentTimeMillis()));
						item.setTitle(itemType.getTitle());
						item.setViewItemURL(itemType.getListingDetails().getViewItemURL());

						//itemService.save(item);

						VariationsType variationsType = itemType.getVariations();
						if (variationsType != null) {
							List<SubItem> subItems = new ArrayList<SubItem>();
							for (VariationType variationType : variationsType.getVariation()) {
								SubItem subItem = new SubItem();
								subItem.setBuyCurrencyCode(variationType.getStartPrice().getCurrencyID().value());
								subItem.setBuyPrice(
										new BigDecimal(String.valueOf(variationType.getStartPrice().getValue())));
								//subItem.setPictureURL(variationsType.get);
								subItem.setQuantity(variationType.getQuantity());
								subItem.setQuantitySold(variationType.getSellingStatus().getQuantitySold());
								subItem.setSku(variationType.getSKU());
								String specifics = "";
								NameValueListArrayType nameValueListArrayType = variationType.getVariationSpecifics();
								if (nameValueListArrayType != null) {
									for (NameValueListType nameValueListType : nameValueListArrayType
											.getNameValueList()) {
										specifics += nameValueListType.getName() + "-" + nameValueListType.getValue()[0]
												+ "|";
									}
								}
								subItem.setSpecifics(specifics);
								subItem.setParentItem(item);
								//subItemService.save(subItem);
								subItems.add(subItem);
							}
							item.setSubItems(subItems);

							NameValueListArrayType nameValueListArrayType = variationsType.getVariationSpecificsSet();
							if (nameValueListArrayType != null) {
								List<ItemSpecific> specifics = new ArrayList<ItemSpecific>();
								for (NameValueListType nameValueListType : nameValueListArrayType.getNameValueList()) {
									ItemSpecific itemSpecific = new ItemSpecific();
									itemSpecific.setSpeItem(item);
									itemSpecific.setSpeName(nameValueListType.getName());
									//itemSpecificService.save(itemSpecific);
									List<ItemSpecificValue> values = new ArrayList<ItemSpecificValue>();
									for (String value : nameValueListType.getValue()) {
										ItemSpecificValue specificValue = new ItemSpecificValue();
										specificValue.setSpeValue(value);
										specificValue.setValueSpecific(itemSpecific);
										//itemSpecificValueService.save(specificValue);
										values.add(specificValue);
									}
									itemSpecific.setValues(values);
									specifics.add(itemSpecific);
								}
								item.setSpecifics(specifics);
							}
							
							variationsType.getPictures();
							
							// item.setPictures(pictures);

						}

					}
					
					currPage++;

					// Pagination
					req.getActiveList().getPagination().setPageNumber(currPage);

					// Make API call.
					try {
						call.getMyeBaySelling();
					} catch (Exception e) {
						logger.error("操作失败！", e);
					}

					resp = call.getReturnedMyeBaySellingResponse();
					activeList = resp.getActiveList().getItemArray().getItem();

				} while (currPage <= pageNumber);

			}
		}.start();

		return new SimpleRspBody(true, "同步任务正在执行，请稍后查看结果！", null);

	}

}
