package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.GetSellingManagerAlertsCall;
import com.songxinjing.erp.ebay.SDKTestCase;

public class GetSellingManagerAlerts extends SDKTestCase {
	public void testGetSellingManagerAlerts() throws Exception {
		GetSellingManagerAlertsCall api = new GetSellingManagerAlertsCall(apiContext);
		api.getSellingManagerAlerts();
	}
}
