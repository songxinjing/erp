/*
Copyright (c) 2007 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.GetUserPreferencesCall;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.GetUserPreferencesResponseType;
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
public class GetUserPreferences extends SDKTestCase {

	public void testGetUserPreferences() throws Exception {

		GetUserPreferencesCall api = new GetUserPreferencesCall(this.apiContext);

		DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] { DetailLevelCodeType.RETURN_ALL };
		api.setDetailLevel(detailLevels);

		api.setShowBidderNoticePreferences(new Boolean(true));
		api.setShowCombinedPaymentPreferences(new Boolean(true));
		api.setShowCrossPromotionPreferences(new Boolean(true));
		api.setShowEndOfAuctionEmailPreferences(new Boolean(true));
		api.setShowSellerFavoriteItemPreferences(new Boolean(true));
		api.setShowSellerPaymentPreferences(new Boolean(true));

		// Make API call.
		api.getUserPreferences();


		TestData.UserPreferencesResponse = (GetUserPreferencesResponseType) api.getResponseObject();
	}
}
