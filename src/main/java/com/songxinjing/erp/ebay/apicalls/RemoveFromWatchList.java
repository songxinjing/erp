/*
Copyright (c) 2007 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.ApiException;
import com.ebay.sdk.call.RemoveFromWatchListCall;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

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
public class RemoveFromWatchList extends SDKTestCase {

	public void testRemoveFromWatchList() throws Exception {


		RemoveFromWatchListCall api = new RemoveFromWatchListCall(this.apiContext);

		// Remove first one.
		String[] ids = new String[] { TestData.NewItem.getItemID() };
		api.setItemIDs(ids);

		// Make API call.
		try {
			api.removeFromWatchList();
		} catch (ApiException e) {
			System.out.println("testRemoveFromWatchList: " + e.getMessage());
		}
	}
}
