/*
Copyright (c) 2007 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.GetOrdersCall;
import com.ebay.soap.eBLBaseComponents.OrderStatusCodeType;
import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.TradingRoleCodeType;
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
public class GetOrders extends SDKTestCase {

	public void testGetOrders() throws Exception {


		//
		GetOrdersCall api = new GetOrdersCall(this.apiContext);

		api.setOrderRole(TradingRoleCodeType.SELLER);
		api.setOrderStatus(OrderStatusCodeType.ACTIVE);

		java.util.Calendar calTo = java.util.Calendar.getInstance();
		java.util.Calendar calFrom = (java.util.Calendar) calTo.clone();
		calFrom.add(java.util.Calendar.DATE, -1);

		api.setCreateTimeFrom(calFrom);
		api.setCreateTimeTo(calTo);

		// Make API call.
		OrderType[] orders = api.getOrders();
	}
}
