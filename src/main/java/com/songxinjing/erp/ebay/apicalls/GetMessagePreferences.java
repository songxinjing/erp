package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.GetMessagePreferencesCall;
import com.ebay.soap.eBLBaseComponents.ASQPreferencesType;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

public class GetMessagePreferences extends SDKTestCase {
	public void testGetMessagePreferences() throws Exception {
		GetMessagePreferencesCall api = new GetMessagePreferencesCall(this.apiContext);
		api.setSellerID(TestData.UserID);
		api.setIncludeASQPreferences(new Boolean(true));
		api.setSite(SiteCodeType.US);
		//
		ASQPreferencesType resp = api.getMessagePreferences();
	}
}
