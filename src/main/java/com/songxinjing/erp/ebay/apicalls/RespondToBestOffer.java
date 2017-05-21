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
import com.ebay.sdk.call.RespondToBestOfferCall;
import com.ebay.soap.eBLBaseComponents.BestOfferActionCodeType;
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
public class RespondToBestOffer extends SDKTestCase {

	public void testRespondToBestOffer() throws Exception {


		//
		RespondToBestOfferCall api = new RespondToBestOfferCall(this.apiContext);

		// Make API call.
		ApiException gotException = null;

		try {
			api.setBestOfferAction(BestOfferActionCodeType.ACCEPT);
			api.setBestOfferIDs(new String[] { "0" });
			api.setItemID(TestData.NewItem.getItemID());
			api.setSellerResponse("Hello SDK user!");

			api.respondToBestOffer();
		} catch (ApiException ex) {
			gotException = ex;
		}

	}
}
