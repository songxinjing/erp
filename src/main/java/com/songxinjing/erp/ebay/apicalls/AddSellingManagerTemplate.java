package com.songxinjing.erp.ebay.apicalls;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ebay.sdk.call.AddSellingManagerTemplateCall;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

public class AddSellingManagerTemplate extends SDKTestCase{
	
	public void testAddSellingManagerTemplate()throws Exception{
		AddSellingManagerTemplateCall api = new AddSellingManagerTemplateCall(apiContext);
		api.setProductID(TestData.productId);
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		String id_from_time = df.format(date);
		api.setSaleTemplateName("template group"+id_from_time);
		ItemType item = AddItem.buildItem();
		api.setItem(item);
		api.addSellingManagerTemplate();
		Long templateId = api.getReturnedSaleTemplateID();
		Long groupId = api.getReturnedSaleTemplateGroupID();
		Long productId = api.getReturnedSellingManagerProductDetails().getProductID();
		TestData.saleTemplateId = templateId;
	}
}
