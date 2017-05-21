package com.songxinjing.erp.ebay.apicalls;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ebay.sdk.call.AddSellingManagerInventoryFolderCall;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

public class AddSellingManagerInventoryFolder extends SDKTestCase{
	public void testAddSellingManagerInventoryFolder() throws Exception {
		//create a parent folder
		apiContext.setSite(SiteCodeType.US);
		AddSellingManagerInventoryFolderCall api = new AddSellingManagerInventoryFolderCall(apiContext);
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		String id_from_time = df.format(date);
		api.setFolderName("Folder1"+id_from_time);
		api.setComment("Folder1 for api test.");
		api.addSellingManagerInventoryFolder();
		long folderId = api.getReturnedFolderID();
		TestData.folder_id1 = folderId;
		//create a sub folder
		date = new Date(System.currentTimeMillis());
		id_from_time = df.format(date);
		api.setFolderName("Folder2"+id_from_time);
		api.setComment("Folder2 for api test.");
		api.addSellingManagerInventoryFolder();
		folderId = api.getReturnedFolderID();
		TestData.folder_id2 = folderId;
	}
}
