package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.MoveSellingManagerInventoryFolderCall;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

public class MoveSellingManagerInventoryFolder extends SDKTestCase {

	public void testMoveSellingManagerInventoryFolder() throws Exception {
		MoveSellingManagerInventoryFolderCall api = new MoveSellingManagerInventoryFolderCall(apiContext);
		api.setFolderID(TestData.folder_id2);
		api.setNewParentFolderID(TestData.folder_id1);
		api.moveSellingManagerInventoryFolder();
	}
}
