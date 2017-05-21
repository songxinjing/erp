package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.AddSellingManagerProductCall;
import com.ebay.soap.eBLBaseComponents.SellingManagerProductDetailsType;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

public class AddSellingManagerProduct extends SDKTestCase{
	
	public void testAddSellingManagerProduct()throws Exception{
		AddSellingManagerProductCall api = new AddSellingManagerProductCall(apiContext);
		SellingManagerProductDetailsType details = new SellingManagerProductDetailsType();
		details.setProductName("Product for test");
		details.setQuantityAvailable(10);
		api.setSellingManagerProductDetails(details);
		api.setFolderID(TestData.folder_id1);
		api.addSellingManagerProduct();
		long productId = api.getReturnedSellingManagerProductDetails().getProductID();
		TestData.productId = productId;
	}
}
