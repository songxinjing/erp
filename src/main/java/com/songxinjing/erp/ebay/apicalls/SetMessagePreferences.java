package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.SetMessagePreferencesCall;
import com.ebay.soap.eBLBaseComponents.SetMessagePreferencesResponseType;
import com.songxinjing.erp.ebay.SDKTestCase;

public class SetMessagePreferences extends SDKTestCase {
	public void testSetMessagePreferences() throws Exception {
		SetMessagePreferencesCall messagePreferences = new SetMessagePreferencesCall(apiContext);
		messagePreferences.setMessagePreferences();
		SetMessagePreferencesResponseType resp = messagePreferences.getResponse();
	}
}
