package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.ReviseSellingManagerProductCall;
import com.ebay.soap.eBLBaseComponents.SellingManagerProductDetailsType;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

public class ReviseSellingManagerProduct extends SDKTestCase {

	public void testReviseSellingManagerProduct() throws Exception {
		ReviseSellingManagerProductCall api = new ReviseSellingManagerProductCall(apiContext);
		SellingManagerProductDetailsType sellingManagerProductDetails = new SellingManagerProductDetailsType();
		sellingManagerProductDetails.setProductID(TestData.productId);
		sellingManagerProductDetails.setProductName("Revise product by selling manager call");
		api.setSellingManagerProductDetails(sellingManagerProductDetails);
		api.reviseSellingManagerProduct();
	}
}
