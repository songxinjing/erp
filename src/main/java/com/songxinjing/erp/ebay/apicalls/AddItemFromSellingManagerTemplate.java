package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.AddItemFromSellingManagerTemplateCall;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

public class AddItemFromSellingManagerTemplate extends SDKTestCase{
	
	public void testAddItemFromSellingManagerTemplate()throws Exception{
		Long templateId = TestData.saleTemplateId;
		ItemType item = new ItemType();
		AddItemFromSellingManagerTemplateCall api = new AddItemFromSellingManagerTemplateCall(apiContext);
		item.setTitle("Selling Manager Item");
		api.setItem(item);
		api.setSaleTemplateID(templateId);
		api.addItemFromSellingManagerTemplate();
		TestData.itemId = api.getReturnedItemID();
	}
}
