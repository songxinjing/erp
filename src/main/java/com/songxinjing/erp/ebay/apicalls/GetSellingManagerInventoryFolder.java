package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.GetSellingManagerInventoryFolderCall;
import com.ebay.soap.eBLBaseComponents.SellingManagerFolderDetailsType;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

public class GetSellingManagerInventoryFolder extends SDKTestCase {

	public void testGetSellingManagerInventoryFolder() throws Exception {
		GetSellingManagerInventoryFolderCall api = new GetSellingManagerInventoryFolderCall(apiContext);
		api.getSellingManagerInventoryFolder();
	}

	private boolean contains(Long folder_id1, SellingManagerFolderDetailsType returnedFolder) {
		SellingManagerFolderDetailsType[] folders = returnedFolder.getChildFolder();
		for (int i = 0; i < folders.length; i++) {
			if (folders[i].getFolderID().compareTo(folder_id1) == 0) {
				return true;
			}
		}
		return false;
	}
}
