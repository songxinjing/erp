/*
Copyright (c) 2007 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.GetCategoryMappingsCall;
import com.ebay.soap.eBLBaseComponents.CategoryMappingType;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
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
public class GetCategoryMappings extends SDKTestCase {

	public void testGetCategoryMappings() throws Exception {

		GetCategoryMappingsCall api = new GetCategoryMappingsCall(this.apiContext);

		DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] { DetailLevelCodeType.RETURN_ALL };
		api.setDetailLevel(detailLevels);

		// Make API call.
		api.getCategoryMappings();

		CategoryMappingType[] mappings = api.getReturnedCategoryMapping();
	}
}
