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
import com.ebay.sdk.call.LeaveFeedbackCall;
import com.ebay.soap.eBLBaseComponents.CommentTypeCodeType;
import com.ebay.soap.eBLBaseComponents.FeedbackDetailType;
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
public class LeaveFeedback extends SDKTestCase {

	public void testLeaveFeedback() throws Exception {


		//
		LeaveFeedbackCall api = new LeaveFeedbackCall(this.apiContext);

		FeedbackDetailType fb = new FeedbackDetailType();
		fb.setItemID(TestData.NewItem.getItemID());
		fb.setCommentText("SDK Sanity test feedback");
		fb.setCommentType(CommentTypeCodeType.POSITIVE);
		fb.setTransactionID("0");
		api.setFeedbackDetail(fb);

		api.setTargetUser("UID");

		// Make API call.
		ApiException gotException = null;

		try {
			api.leaveFeedback();
		} catch (ApiException ex) {
			gotException = ex;
		}
	}
}
