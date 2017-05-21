/*
Copyright (c) 2007 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.GetMyMessagesCall;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.MyMessagesAlertType;
import com.ebay.soap.eBLBaseComponents.MyMessagesMessageType;
import com.ebay.soap.eBLBaseComponents.MyMessagesSummaryType;
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
public class GetMyMessages extends SDKTestCase {

	public void testGetMyMessages() throws Exception {

		GetMyMessagesCall api = new GetMyMessagesCall(this.apiContext);

		api.setDetailLevel(new DetailLevelCodeType[] { DetailLevelCodeType.RETURN_SUMMARY });

		// Make API call.
		api.getMyMessages();

		MyMessagesAlertType[] alerts = api.getReturnedAlerts();
		MyMessagesMessageType[] msgs = api.getReturnedMyMessages();
		MyMessagesSummaryType summary = api.getReturnedSummary();
	}
}
