package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.ReviseSellingManagerTemplateCall;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

public class ReviseSellingManagerTemplate extends SDKTestCase {

	public void testReviseSellingManagerTemplate() throws Exception {
		ReviseSellingManagerTemplateCall api = new ReviseSellingManagerTemplateCall(apiContext);
		ItemType item = new ItemType();
		item.setItemID(TestData.itemId);
		item.setDescription("Modified by selling manager call.");
		api.setItem(item);
		api.setSaleTemplateID(TestData.saleTemplateId);
		// api.reviseSellingManagerTemplate();
	}
}
