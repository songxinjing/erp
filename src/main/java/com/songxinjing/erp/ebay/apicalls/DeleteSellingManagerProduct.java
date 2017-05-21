package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.DeleteSellingManagerProductCall;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

public class DeleteSellingManagerProduct extends SDKTestCase{

	public void testDeleteSellingManagerProduct() throws Exception{
		DeleteSellingManagerProductCall api = 
			new DeleteSellingManagerProductCall(apiContext);
		api.setProductID(TestData.productId);
		api.deleteSellingManagerProduct();
	}
}
