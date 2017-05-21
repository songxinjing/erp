/*
Copyright (c) 2007 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.GetMyeBayBuyingCall;
import com.ebay.soap.eBLBaseComponents.GetMyeBayBuyingRequestType;
import com.ebay.soap.eBLBaseComponents.GetMyeBayBuyingResponseType;
import com.ebay.soap.eBLBaseComponents.ItemListCustomizationType;
import com.ebay.soap.eBLBaseComponents.ItemSortTypeCodeType;
import com.ebay.soap.eBLBaseComponents.MyeBaySelectionType;
import com.ebay.soap.eBLBaseComponents.SortOrderCodeType;
import com.songxinjing.erp.ebay.SDKTestCase;

/**
 *
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company: eBay Inc.
 * </p>
 * 
 * @author Weijun Li
 * @version 1.0
 */
public class GetMyeBayBuying extends SDKTestCase {

	public void testGetMyeBayBuying() throws Exception {

		GetMyeBayBuyingCall api = new GetMyeBayBuyingCall(this.apiContext);

		if (this.apiContext.getApiServerUrl().indexOf("sandbox") != -1)
			return;

		GetMyeBayBuyingRequestType req = new GetMyeBayBuyingRequestType();
		api.setMyeBayBuyingRequest(req);

		ItemListCustomizationType lc = new ItemListCustomizationType();
		lc.setInclude(new Boolean(true));
		lc.setIncludeNotes(new Boolean(true));
		lc.setSort(ItemSortTypeCodeType.END_TIME);
		req.setBestOfferList(lc);

		lc = new ItemListCustomizationType();
		lc.setInclude(new Boolean(true));
		lc.setIncludeNotes(new Boolean(true));
		lc.setSort(ItemSortTypeCodeType.BID_COUNT);
		req.setBidList(lc);

		lc = new ItemListCustomizationType();
		lc.setInclude(new Boolean(true));
		lc.setIncludeNotes(new Boolean(true));
		lc.setSort(ItemSortTypeCodeType.END_TIME);
		req.setLostList(lc);

		lc = new ItemListCustomizationType();
		lc.setInclude(new Boolean(true));
		lc.setIncludeNotes(new Boolean(true));
		lc.setSort(ItemSortTypeCodeType.PRICE);
		req.setWonList(lc);

		MyeBaySelectionType selection = new MyeBaySelectionType();
		selection.setInclude(new Boolean(true));
		selection.setSort(SortOrderCodeType.ASCENDING);
		req.setFavoriteSearches(selection);

		MyeBaySelectionType sellerSel = new MyeBaySelectionType();
		sellerSel.setInclude(new Boolean(true));
		sellerSel.setSort(SortOrderCodeType.ASCENDING);
		req.setFavoriteSellers(sellerSel);

		// Make API call.
		api.getMyeBayBuying();

		GetMyeBayBuyingResponseType resp = api.getReturnedGetMyeBayBuyingResponse();
	}
}
