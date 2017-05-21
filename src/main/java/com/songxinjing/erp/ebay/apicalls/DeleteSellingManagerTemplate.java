package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.DeleteSellingManagerTemplateCall;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

public class DeleteSellingManagerTemplate extends SDKTestCase{

	public void testDeleteSellingManagerTemplate() throws Exception{
		DeleteSellingManagerTemplateCall api = 
			new DeleteSellingManagerTemplateCall(apiContext);
		api.setSaleTemplateID(TestData.saleTemplateId);
		api.deleteSellingManagerTemplate();
	}
}
