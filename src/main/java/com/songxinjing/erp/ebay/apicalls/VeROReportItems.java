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
import com.ebay.sdk.call.VeROReportItemsCall;
import com.ebay.soap.eBLBaseComponents.VeROReportItemType;
import com.ebay.soap.eBLBaseComponents.VeROReportItemsType;
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
public class VeROReportItems extends SDKTestCase {

	public void testVeROReportItems() throws Exception {

		//
		VeROReportItemsCall api = new VeROReportItemsCall(this.apiContext);

		// Make API call.
		ApiException gotException = null;

		VeROReportItemsType reportItems = new VeROReportItemsType();

		VeROReportItemType veroItem = new VeROReportItemType();
		veroItem.setItemID("");
		veroItem.setVeROReasonCodeID(new Long(9035));
		veroItem.setMessageToSeller("Testing the call VeROReportItems apiCall");

		VeROReportItemType[] veroItems = new VeROReportItemType[1];
		veroItems[0] = veroItem;
		reportItems.setReportItem(veroItems);

		try {
			api.veROReportItems();
		} catch (ApiException ex) {
			gotException = ex;
		}

	}

}
