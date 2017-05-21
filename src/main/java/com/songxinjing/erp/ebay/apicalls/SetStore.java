/*
Copyright (c) 2007 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.SetStoreCall;
import com.ebay.soap.eBLBaseComponents.StoreType;
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
public class SetStore extends SDKTestCase {

	public void testSetStore() throws Exception {
		// Skip if the user is not store enabled.
		if (TestData.Store == null)
			return;

		SetStoreCall api = new SetStoreCall(this.apiContext);

		// Build the StoreType object.
		StoreType st = new StoreType();
		st.setDescription(TestData.Store.getDescription());
		st.setLogo(TestData.Store.getLogo());
		st.setMerchDisplay(TestData.Store.getMerchDisplay());
		st.setName(TestData.Store.getName());

		api.setStoreType(st);

		// Make API call.
		api.setStore();
	}
}
