/*
Copyright (c) 2007 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.GetMyeBayRemindersCall;
import com.ebay.soap.eBLBaseComponents.ReminderCustomizationType;
import com.ebay.soap.eBLBaseComponents.RemindersType;
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
public class GetMyeBayReminders extends SDKTestCase {

	public void testGetMyeBayReminders() throws Exception {

		GetMyeBayRemindersCall api = new GetMyeBayRemindersCall(this.apiContext);

		ReminderCustomizationType rc = new ReminderCustomizationType();
		rc.setInclude(new Boolean(true));
		rc.setDurationInDays(new Integer(7));
		api.setBuyingReminders(rc);

		rc = new ReminderCustomizationType();
		rc.setInclude(new Boolean(true));
		rc.setDurationInDays(new Integer(7));
		api.setSellingReminders(rc);

		// Make API call.
		api.getMyeBayReminders();

		RemindersType buying = api.getReturnedBuyingReminders();
		RemindersType selling = api.getReturnedSellingReminders();
	}
}
