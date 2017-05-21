package com.songxinjing.erp.controller.store;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ebay.sdk.call.GetMyeBaySellingCall;
import com.ebay.soap.eBLBaseComponents.GetMyeBaySellingRequestType;
import com.ebay.soap.eBLBaseComponents.GetMyeBaySellingResponseType;
import com.ebay.soap.eBLBaseComponents.ItemListCustomizationType;
import com.ebay.soap.eBLBaseComponents.ItemSortTypeCodeType;
import com.songxinjing.erp.controller.base.BaseController;
import com.songxinjing.erp.domain.Store;
import com.songxinjing.erp.ebay.EbayApiUtil;
import com.songxinjing.erp.service.StoreService;

/**
 * 主页控制类
 * 
 * @author songxinjing
 * 
 */
@Controller
public class StoreController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(StoreController.class);

	@Autowired
	StoreService storeService;

	@RequestMapping(value = "store", method = RequestMethod.GET)
	public String ebay(Model model, HttpServletRequest request) {
		logger.info("进入主页面");
		List<Store> stores = storeService.find();
		model.addAttribute("stores", stores);
		return "store/list";
	}

	@RequestMapping(value = "store/detail", method = RequestMethod.GET)
	public String ebay(Model model, HttpServletRequest request, Integer storeId) {
		logger.info("进入主页面");
		Store store = storeService.find(storeId);
		model.addAttribute("store", store);

		EbayApiUtil.api.getApiCredential().seteBayToken(store.getStoreToken());
		GetMyeBaySellingCall api = new GetMyeBaySellingCall(EbayApiUtil.api);

		GetMyeBaySellingRequestType req = new GetMyeBaySellingRequestType();
		api.setMyeBaySellingRequest(req);

		ItemListCustomizationType lc = new ItemListCustomizationType();
		lc.setInclude(new Boolean(true));
		lc.setIncludeNotes(new Boolean(true));
		lc.setSort(ItemSortTypeCodeType.BID_COUNT);
		req.setActiveList(lc);

		lc = new ItemListCustomizationType();
		lc.setInclude(new Boolean(true));
		lc.setIncludeNotes(new Boolean(true));
		lc.setSort(ItemSortTypeCodeType.PRICE);
		req.setSoldList(lc);

		lc = new ItemListCustomizationType();
		lc.setInclude(new Boolean(true));
		lc.setIncludeNotes(new Boolean(true));
		lc.setSort(ItemSortTypeCodeType.END_TIME);
		req.setUnsoldList(lc);

		lc = new ItemListCustomizationType();
		lc.setInclude(new Boolean(true));
		lc.setIncludeNotes(new Boolean(true));
		lc.setSort(ItemSortTypeCodeType.START_TIME);
		req.setScheduledList(lc);

		// Make API call.
		try {
			api.getMyeBaySelling();
		} catch (Exception e) {
			e.printStackTrace();
		}

		GetMyeBaySellingResponseType resp = api.getReturnedMyeBaySellingResponse();
		model.addAttribute("scheduledList", resp.getScheduledList()); // 待售
		model.addAttribute("activeList", resp.getActiveList().getItemArray().getItem()); // 在售
		model.addAttribute("soldList", resp.getSoldList()); // 已售
		model.addAttribute("unsoldList", resp.getUnsoldList()); // 未售
		model.addAttribute("bidList", resp.getBidList()); // 竞拍
		
		

		return "store/detail";
	}

}
