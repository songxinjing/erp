package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.GetSellingManagerSoldListingsCall;
import com.ebay.soap.eBLBaseComponents.PaginationType;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

public class GetSellingManagerSoldListings extends SDKTestCase {

	public void testGetSellingManagerSoldListings() throws Exception {
		GetSellingManagerSoldListingsCall api = new GetSellingManagerSoldListingsCall(apiContext);
		PaginationType pagination = new PaginationType();
		pagination.setEntriesPerPage(5);
		pagination.setPageNumber(0);
		api.setPagination(pagination);
		api.getSellingManagerSoldListings();
		TestData.soldItemId = api.getReturnedSaleRecord()[0].getSellingManagerSoldTransaction()[0].getItemID();
	}
}
