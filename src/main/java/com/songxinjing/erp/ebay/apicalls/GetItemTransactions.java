/*
Copyright (c) 2007 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.TimeFilter;
import com.ebay.sdk.call.GetItemTransactionsCall;
import com.ebay.soap.eBLBaseComponents.PaginationType;
import com.ebay.soap.eBLBaseComponents.TransactionType;
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
public class GetItemTransactions extends SDKTestCase {

	public void testGetSellerTransactions() throws Exception {


		GetItemTransactionsCall api = new GetItemTransactionsCall(this.apiContext);

		api.setItemID(TestData.NewItem.getItemID());

		// Time filter
		java.util.Calendar calTo = java.util.Calendar.getInstance();
		java.util.Calendar calFrom = (java.util.Calendar) calTo.clone();
		calFrom.add(java.util.Calendar.HOUR, -1);

		TimeFilter tf = new TimeFilter(calFrom, calTo);
		api.setModifiedTimeFilter(tf);

		// Pagination
		PaginationType pt = new PaginationType();
		pt.setEntriesPerPage(new Integer(100));
		pt.setPageNumber(new Integer(1));
		api.setPagination(pt);

		TransactionType[] trans = api.getItemTransactions();

		// NO transaction should be returned.
	}
}
