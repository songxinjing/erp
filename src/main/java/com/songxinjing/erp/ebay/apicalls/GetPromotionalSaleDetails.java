package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.ApiException;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.call.GetPromotionalSaleDetailsCall;
import com.ebay.soap.eBLBaseComponents.PromotionalSaleArrayType;
import com.songxinjing.erp.ebay.SDKTestCase;

public class GetPromotionalSaleDetails extends SDKTestCase {
	public void testGetPromotionalSaleDetails() throws Exception {
		GetPromotionalSaleDetailsCall promoSaleDetails = new GetPromotionalSaleDetailsCall(apiContext);
		promoSaleDetails.setPromotionalSaleID(new Long(1234567890L));
		try {
			PromotionalSaleArrayType retval = promoSaleDetails.getPromotionalSaleDetails();
		} catch (ApiException ae) {
			// Not found, passed the test
		} catch (SdkException sdke) {
		}
	}
}
