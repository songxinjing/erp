/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.songxinjing.erp.ebay;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.EndItemCall;
import com.ebay.sdk.call.EndItemsCall;
import com.ebay.soap.eBLBaseComponents.EndItemRequestContainerType;
import com.ebay.soap.eBLBaseComponents.EndReasonCodeType;


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
public abstract class SDKTestCase {

	protected ApiContext apiContext = null;
	private static final Logger log = LoggerFactory.getLogger(SDKTestCase.class);



	
	static final String DATE_FORMAT = "yy-MM-dd HH:mm:ss";

	protected static String getTimeString() {
		java.util.Calendar calTo = java.util.Calendar.getInstance();
		java.util.Date dt = calTo.getTime();

		java.text.SimpleDateFormat dateFormatterAPI = new java.text.SimpleDateFormat(DATE_FORMAT);
		return dateFormatterAPI.format(dt);
	}

	protected static java.util.Date getTime() {
		java.util.Calendar calTo = java.util.Calendar.getInstance();
		return calTo.getTime();
	}

	protected static String prependTimeString(String t) {
		return MessageFormat.format("[{0}] {1}\n", new Object[] { getTimeString(), t });
	}




	public void endItem(String itemID) throws Exception {
		EndItemCall endItem = new EndItemCall(this.apiContext);

		// Set the item to be ended.
		endItem.setItemID(itemID);
		endItem.setEndingReason(EndReasonCodeType.NOT_AVAILABLE);

		endItem.endItem();
	}

	public void endItems(String[] itemIDs) throws Exception {
		EndItemsCall endItems = new EndItemsCall(this.apiContext);

		EndItemRequestContainerType[] container = new EndItemRequestContainerType[itemIDs.length];

		for (int i = 0; i < itemIDs.length; i++) {
			container[i] = new EndItemRequestContainerType();
			container[i].setItemID(itemIDs[i]);
			container[i].setEndingReason(EndReasonCodeType.LOST_OR_BROKEN);
		}
		endItems.setEndItemRequestContainer(container);
		endItems.endItems();
	}
}
