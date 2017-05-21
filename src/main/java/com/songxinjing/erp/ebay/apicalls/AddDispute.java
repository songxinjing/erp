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
import com.ebay.sdk.call.AddDisputeCall;
import com.ebay.soap.eBLBaseComponents.DisputeReasonCodeType;
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
 * @author songxinjing
 * @version 1.0
 */
public class AddDispute extends SDKTestCase {

	public void testAddDispute() throws Exception {

		//
		AddDisputeCall api = new AddDisputeCall(this.apiContext);

		// api.setDisputeExplanation(DisputeExplanationCodeType.BuyerHasNotResponded);
		api.setDisputeReason(DisputeReasonCodeType.BUYER_HAS_NOT_PAID);
		api.setItemID(TestData.NewItem.getItemID());
		api.setTransactionID("0");

		// Make API call.
		ApiException gotException = null;

		try {
			String disputeId = api.addDispute();
		} catch (ApiException ex) {
			gotException = ex;
		}

	}
}
