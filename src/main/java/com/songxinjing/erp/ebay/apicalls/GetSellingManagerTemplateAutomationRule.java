package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.GetSellingManagerTemplateAutomationRuleCall;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

public class GetSellingManagerTemplateAutomationRule extends SDKTestCase {

	public void testGetSellingManagerTemplateAutomationRule() throws Exception {
		GetSellingManagerTemplateAutomationRuleCall api = new GetSellingManagerTemplateAutomationRuleCall(apiContext);
		api.setSaleTemplateID(TestData.saleTemplateId);
		api.getSellingManagerTemplateAutomationRule();
	}
}
