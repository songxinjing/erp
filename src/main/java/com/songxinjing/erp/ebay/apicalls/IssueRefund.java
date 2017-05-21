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
import com.ebay.sdk.call.IssueRefundCall;
import com.ebay.soap.eBLBaseComponents.AckCodeType;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.IssueRefundResponseType;
import com.ebay.soap.eBLBaseComponents.RefundReasonCodeType;
import com.ebay.soap.eBLBaseComponents.RefundTypeCodeType;
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
 * @author Weian Deng
 * @version 1.0
 */
public class IssueRefund extends SDKTestCase {

	public void testIssueRefund() throws Exception {

		// Make API call.
		ApiException gotException = null;

		try {
			IssueRefundCall api = new IssueRefundCall(this.apiContext);

			api.setRefundType(RefundTypeCodeType.CUSTOM_OR_PARTIAL);
			AmountType at = new AmountType();
			at.setValue(0.10);
			api.setRefundAmount(at);
			api.setRefundReason(RefundReasonCodeType.ITEM_DAMAGED);
			/*
			 * Currently, we don't has a way to use api to create an item and a
			 * transaction that refund can be issued. So, put a negative test
			 * case here for now.
			 */
			api.setTransactionID("00000");
			api.setItemID("00000000000");

			api.issueRefund();
			IssueRefundResponseType responseType = (IssueRefundResponseType) api.getResponseObject();
		} catch (ApiException ex) {
			gotException = ex;
		}

	}
}
