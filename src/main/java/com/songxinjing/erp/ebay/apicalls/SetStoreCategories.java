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
import com.ebay.sdk.call.SetStoreCategoriesCall;
import com.ebay.soap.eBLBaseComponents.StoreCategoryUpdateActionCodeType;
import com.ebay.soap.eBLBaseComponents.StoreCustomCategoryArrayType;
import com.ebay.soap.eBLBaseComponents.StoreCustomCategoryType;
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
 * @author Weian Deng
 * @version 1.0
 */
public class SetStoreCategories extends SDKTestCase {

	public void testSetStoreCategories() throws Exception {

		ApiException gotException = null;
		// Skip if the user is not store enabled.
		if (TestData.Store == null)
			return;

		SetStoreCategoriesCall api = new SetStoreCategoriesCall(this.apiContext);
		try {
			// Build the StoreType object.
			StoreType st = new StoreType();
			st.setDescription(TestData.Store.getDescription());
			st.setLogo(TestData.Store.getLogo());
			st.setMerchDisplay(TestData.Store.getMerchDisplay());
			st.setName(TestData.Store.getName());

			api.setAction(StoreCategoryUpdateActionCodeType.ADD);
			api.setDestinationParentCategoryID(new Long(1234));
			api.setItemDestinationCategoryID(new Long(4321));

			StoreCustomCategoryArrayType catArray = new StoreCustomCategoryArrayType();
			api.setStoreCategories(catArray);

			StoreCustomCategoryType[] cats = new StoreCustomCategoryType[1];
			catArray.setCustomCategory(cats);

			StoreCustomCategoryType cat = new StoreCustomCategoryType();
			cats[0] = cat;

			cat.setCategoryID(102);
			cat.setName("TestStoreCategory");

			// Make API call.
			api.setStoreCategories();
		} catch (ApiException ex) {
			gotException = ex;
		}

	}
}
