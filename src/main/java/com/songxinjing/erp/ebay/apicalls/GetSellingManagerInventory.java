package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.GetSellingManagerInventoryCall;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

public class GetSellingManagerInventory extends SDKTestCase {

	public void testGetSellingManagerInventory() throws Exception {
		GetSellingManagerInventoryCall api = new GetSellingManagerInventoryCall(apiContext);
		api.setFolderID(TestData.folder_id1);
		api.getSellingManagerInventory();
	}
}
