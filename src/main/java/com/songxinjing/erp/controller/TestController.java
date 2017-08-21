package com.songxinjing.erp.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.TimeFilter;
import com.ebay.sdk.call.GetItemCall;
import com.ebay.sdk.call.GetMyeBaySellingCall;
import com.ebay.sdk.call.GetSellerListCall;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.GetMyeBaySellingRequestType;
import com.ebay.soap.eBLBaseComponents.GetMyeBaySellingResponseType;
import com.ebay.soap.eBLBaseComponents.ItemListCustomizationType;
import com.ebay.soap.eBLBaseComponents.ItemSortTypeCodeType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.NameValueListArrayType;
import com.ebay.soap.eBLBaseComponents.NameValueListType;
import com.ebay.soap.eBLBaseComponents.PaginationType;
import com.ebay.soap.eBLBaseComponents.VariationType;
import com.ebay.soap.eBLBaseComponents.VariationsType;
import com.songxinjing.erp.controller.base.BaseController;
import com.songxinjing.erp.domain.Item;
import com.songxinjing.erp.domain.ItemSpecific;
import com.songxinjing.erp.domain.ItemSpecificValue;
import com.songxinjing.erp.domain.Store;
import com.songxinjing.erp.domain.SubItem;
import com.songxinjing.erp.ebay.EbayApiUtil;
import com.songxinjing.erp.service.ItemService;
import com.songxinjing.erp.service.StoreService;

/**
 * 主页控制类
 * 
 * @author songxinjing
 * 
 */
@Controller
public class TestController extends BaseController {

	@Autowired
	StoreService storeService;

	@Autowired
	ItemService itemService;

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public void test(Model model, HttpServletRequest request) {
		Store store = storeService.find(1);

		ApiContext api = EbayApiUtil.createApiContext();
		api.getApiCredential().seteBayToken(store.getStoreToken());
		
		GetSellerListCall gsl = new GetSellerListCall(api);

		DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] { DetailLevelCodeType.RETURN_ALL };
		gsl.setDetailLevel(detailLevels);

		// Time filter
		java.util.Calendar calTo = java.util.Calendar.getInstance();
		calTo.setTimeZone(TimeZone.getTimeZone("GMT"));
		java.util.Calendar calFrom = (java.util.Calendar) calTo.clone();
		calFrom.add(java.util.Calendar.DATE, -120);

		TimeFilter tf = new TimeFilter(calFrom, calTo);
		gsl.setStartTimeFilter(tf);

		// Pagination
		PaginationType pt = new PaginationType();
		pt.setEntriesPerPage(new Integer(100));
		pt.setPageNumber(new Integer(1));
		gsl.setPagination(pt);

		//
		try {
			ItemType[] items = gsl.getEntireSellerList();
		} catch (Exception e) {
			e.printStackTrace();
		}


		return;

	}

	@RequestMapping(value = "test11", method = RequestMethod.GET)
	public void test11(Model model, HttpServletRequest request) {

		Store store = storeService.find(1);

		ApiContext api = EbayApiUtil.createApiContext();
		api.getApiCredential().seteBayToken(store.getStoreToken());
		GetItemCall getItem = new GetItemCall(api);

		DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] { DetailLevelCodeType.RETURN_ALL };
		getItem.setDetailLevel(detailLevels);

		try {
			ItemType returnedItem = getItem.getItem("222130454999");
			logger.debug(returnedItem.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		api = EbayApiUtil.createApiContext();
		api.getApiCredential().seteBayToken(store.getStoreToken());
		GetMyeBaySellingCall call = new GetMyeBaySellingCall(api);

		GetMyeBaySellingRequestType req = new GetMyeBaySellingRequestType();
		call.setMyeBaySellingRequest(req);

		ItemListCustomizationType lc = new ItemListCustomizationType();
		lc.setInclude(true);
		// lc.setIncludeNotes(true);
		lc.setSort(ItemSortTypeCodeType.BID_COUNT);
		PaginationType pag = new PaginationType();
		pag.setEntriesPerPage(5);
		pag.setPageNumber(1);
		lc.setPagination(pag);
		req.setActiveList(lc);

		lc = new ItemListCustomizationType();
		lc.setInclude(new Boolean(false));
		req.setSoldList(lc);
		req.setUnsoldList(lc);
		req.setScheduledList(lc);
		req.setBidList(lc);
		req.setDeletedFromSoldList(lc);
		req.setDeletedFromUnsoldList(lc);

		// Make API call.
		try {
			call.getMyeBaySelling();
		} catch (Exception e) {
			e.printStackTrace();
		}

		GetMyeBaySellingResponseType resp = call.getReturnedMyeBaySellingResponse();

		ItemType[] activeList = resp.getActiveList().getItemArray().getItem();

		for (ItemType itemType : activeList) {
			Item item = new Item();
			item.setBuyItNowCurrencyCode(itemType.getBuyItNowPrice().getCurrencyID().value());
			item.setBuyItNowPrice(new BigDecimal(String.valueOf(itemType.getBuyItNowPrice().getValue())));
			item.setDescription(itemType.getDescription());
			item.setGalleryURL(itemType.getPictureDetails().getGalleryURL());
			item.setHitCount(itemType.getHitCount());
			item.setItemID(itemType.getItemID());
			item.setListingStartTime(new Timestamp(itemType.getListingDetails().getStartTime().getTimeInMillis()));
			// item.setPrimaryCategoryID(itemType.getPrimaryCategory().getCategoryID());
			// item.setPrimaryCategoryName(itemType.getPrimaryCategory().getCategoryName());
			item.setQuantity(itemType.getQuantity());
			// item.setSite(itemType.getSite().value());
			item.setSku(itemType.getSKU());
			item.setSynTime(new Timestamp(System.currentTimeMillis()));
			item.setTitle(itemType.getTitle());
			item.setViewItemURL(itemType.getListingDetails().getViewItemURL());

			VariationsType variationsType = itemType.getVariations();
			if (variationsType != null) {
				List<SubItem> subItems = new ArrayList<SubItem>();
				for (VariationType variationType : variationsType.getVariation()) {
					SubItem subItem = new SubItem();
					subItem.setBuyCurrencyCode(variationType.getStartPrice().getCurrencyID().value());
					subItem.setBuyPrice(new BigDecimal(String.valueOf(variationType.getStartPrice().getValue())));
					// subItem.setPictureURL(pictureURL);
					subItem.setQuantity(variationType.getQuantity());
					subItem.setQuantitySold(variationType.getSellingStatus().getQuantitySold());
					subItem.setSku(variationType.getSKU());
					String specifics = "";
					NameValueListArrayType nameValueListArrayType = variationType.getVariationSpecifics();
					if (nameValueListArrayType != null) {
						for (NameValueListType nameValueListType : nameValueListArrayType.getNameValueList()) {
							specifics += nameValueListType.getName() + "-" + nameValueListType.getValue()[0] + "|";
						}
					}
					subItem.setSpecifics(specifics);
					subItem.setParentItem(item);
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
						List<ItemSpecificValue> values = new ArrayList<ItemSpecificValue>();
						for (String value : nameValueListType.getValue()) {
							ItemSpecificValue specificValue = new ItemSpecificValue();
							specificValue.setSpeValue(value);
							specificValue.setValueSpecific(itemSpecific);
							values.add(specificValue);
						}
						itemSpecific.setValues(values);
						specifics.add(itemSpecific);
					}
					item.setSpecifics(specifics);
				}

			}

			itemService.save(item);

			// item.setPictures(pictures);
		}

		// model.addAttribute("scheduledList", resp.getScheduledList()); // 待售
		// model.addAttribute("activeList",
		// resp.getActiveList().getItemArray().getItem()); // 在售
		// model.addAttribute("soldList", resp.getSoldList()); // 已售
		// model.addAttribute("unsoldList", resp.getUnsoldList()); // 未售
	}

}
