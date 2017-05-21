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
import com.ebay.sdk.call.SendInvoiceCall;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.InsuranceOptionCodeType;
import com.ebay.soap.eBLBaseComponents.SendInvoiceRequestType;
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
public class SendInvoice extends SDKTestCase {

	public void testSendInvoice() throws Exception {


		//
		SendInvoiceCall api = new SendInvoiceCall(this.apiContext);

		SendInvoiceRequestType req = new SendInvoiceRequestType();
		req.setCheckoutInstructions("SDK checkout instruction.");
		req.setEmailCopyToSeller(new Boolean(true));
		AmountType at = new AmountType();
		at.setValue(2.0);
		req.setInsuranceFee(at);
		req.setInsuranceOption(InsuranceOptionCodeType.REQUIRED);
		req.setItemID(TestData.NewItem.getItemID());
		req.setPayPalEmailAddress("test@ebay.com");
		req.setTransactionID("0");

		api.setSendInvoiceRequest(req);

		// Make API call.
		ApiException gotException = null;

		try {
			api.sendInvoice();
		} catch (ApiException ex) {
			gotException = ex;
		}

	}
}
