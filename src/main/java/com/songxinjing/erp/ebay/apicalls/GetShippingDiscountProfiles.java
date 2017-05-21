package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.GetShippingDiscountProfilesCall;
import com.ebay.soap.eBLBaseComponents.AckCodeType;
import com.ebay.soap.eBLBaseComponents.CurrencyCodeType;
import com.songxinjing.erp.ebay.SDKTestCase;

public class GetShippingDiscountProfiles extends SDKTestCase {
	public void testGetShippingDiscountProfiles() throws Exception {
		GetShippingDiscountProfilesCall shippingDiscountDetails = new GetShippingDiscountProfilesCall(apiContext);
		CurrencyCodeType currencyCodeType = shippingDiscountDetails.getShippingDiscountProfiles();
	}
}
