package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.ReviseSellingManagerInventoryFolderCall;
import com.ebay.soap.eBLBaseComponents.SellingManagerFolderDetailsType;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

public class ReviseSellingManagerInventoryFolder extends SDKTestCase {

	public void testReviseSellingManagerInventoryFolder() throws Exception {
		ReviseSellingManagerInventoryFolderCall api = new ReviseSellingManagerInventoryFolderCall(apiContext);
		SellingManagerFolderDetailsType folder = new SellingManagerFolderDetailsType();
		folder.setFolderID(TestData.folder_id2);
		folder.setFolderName("Revise folder by selling manager call");
		api.setFolder(folder);
		api.reviseSellingManagerInventoryFolder();
	}
}
