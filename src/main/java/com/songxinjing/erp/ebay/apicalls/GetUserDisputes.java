/*
Copyright (c) 2007 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.GetUserDisputesCall;
import com.ebay.soap.eBLBaseComponents.DisputeFilterTypeCodeType;
import com.ebay.soap.eBLBaseComponents.DisputeSortTypeCodeType;
import com.ebay.soap.eBLBaseComponents.GetUserDisputesResponseType;
import com.ebay.soap.eBLBaseComponents.PaginationType;
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
public class GetUserDisputes extends SDKTestCase {

	public void testGetUserDisputes() throws Exception {

		GetUserDisputesCall api = new GetUserDisputesCall(this.apiContext);

		api.setDisputeFilterType(DisputeFilterTypeCodeType.ALL_INVOLVED_DISPUTES);
		api.setDisputeSortType(DisputeSortTypeCodeType.DISPUTE_CREATED_TIME_ASCENDING);

		// Pagination
		PaginationType pt = new PaginationType();
		pt.setEntriesPerPage(new Integer(10));
		pt.setPageNumber(new Integer(1));
		api.setPagination(pt);

		// Make API call.
		GetUserDisputesResponseType resp = api.getUserDisputes();
	}
}
