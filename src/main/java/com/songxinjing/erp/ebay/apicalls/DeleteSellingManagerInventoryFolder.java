package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.DeleteSellingManagerInventoryFolderCall;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

public class DeleteSellingManagerInventoryFolder extends SDKTestCase{

	public void testDeleteSellingManagerInventoryFolder() throws Exception{
		DeleteSellingManagerInventoryFolderCall api =
			new DeleteSellingManagerInventoryFolderCall(apiContext);
		api.setFolderID(TestData.folder_id1);
		api.deleteSellingManagerInventoryFolder();
	}
}
