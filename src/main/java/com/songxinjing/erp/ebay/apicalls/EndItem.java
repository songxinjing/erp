/*
Copyright (c) 2007 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.EndItemCall;
import com.ebay.soap.eBLBaseComponents.EndReasonCodeType;
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
public class EndItem extends SDKTestCase {

  public void testEndItem() throws Exception {


    //
    EndItemCall api = new EndItemCall(this.apiContext);

    // Set the item to be ended.
    api.setItemID(TestData.NewItem.getItemID());
    api.setEndingReason(EndReasonCodeType.NOT_AVAILABLE);

    api.endItem();
    
    TestData.EndedItem = TestData.NewItem;
  }
  
  public void testEndFixedPriceItem() throws Exception {


	    //
	    EndItemCall api = new EndItemCall(this.apiContext);

	    // Set the item to be ended.
	    api.setItemID(TestData.NewFixedPriceItem.getItemID());
	    api.setEndingReason(EndReasonCodeType.NOT_AVAILABLE);

	    api.endItem();
	    
	    TestData.EndedFixedPriceItem = TestData.NewFixedPriceItem;
   }
  
}
