/*
Copyright (c) 2007 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.GetAllBiddersCall;
import com.ebay.soap.eBLBaseComponents.GetAllBiddersModeCodeType;
import com.ebay.soap.eBLBaseComponents.OfferType;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

/**
 *
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class GetAllBidders extends SDKTestCase {

  public void testGetAllBidders() throws Exception {


    GetAllBiddersCall api = new GetAllBiddersCall(this.apiContext);

    api.setItemID(TestData.NewItem.getItemID());
    api.setCallMode(GetAllBiddersModeCodeType.VIEW_ALL);

    // Make API call.
    OfferType[] bidders = api.getAllBidders();

    // No bidders for the new item.
  }
}
