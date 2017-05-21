package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.GetSellingManagerItemAutomationRuleCall;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

public class GetSellingManagerItemAutomationRule extends SDKTestCase {

	public void testGetSellingManagerItemAutomationRule() throws Exception {
		GetSellingManagerItemAutomationRuleCall api = new GetSellingManagerItemAutomationRuleCall(apiContext);
		api.setItemID(TestData.itemId);
		api.getSellingManagerItemAutomationRule();
	}
}
