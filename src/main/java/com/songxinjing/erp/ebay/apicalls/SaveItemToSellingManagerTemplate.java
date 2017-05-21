package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.SaveItemToSellingManagerTemplateCall;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

public class SaveItemToSellingManagerTemplate extends SDKTestCase {

	public void testSaveItemToSellingManagerTemplate() throws Exception {
		SaveItemToSellingManagerTemplateCall api = new SaveItemToSellingManagerTemplateCall(apiContext);
		api.setItemID(TestData.itemId);
		api.setProductID(TestData.productId);
		api.saveItemToSellingManagerTemplate();
	}
}
