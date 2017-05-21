package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.GetSellingManagerTemplatesCall;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

public class GetSellingManagerTemplates extends SDKTestCase {

	public void testGetSellingManagerTemplates() throws Exception {
		GetSellingManagerTemplatesCall api = new GetSellingManagerTemplatesCall(apiContext);
		api.setSaleTemplateID(new long[] { TestData.saleTemplateId });
		api.getSellingManagerTemplates();
	}
}
