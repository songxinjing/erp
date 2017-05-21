package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.DeleteSellingManagerItemAutomationRuleCall;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

public class DeleteSellingManagerItemAutomationRule extends SDKTestCase{

	public void testDeleteSellingManagerItemAutomationRule() throws Exception{
		DeleteSellingManagerItemAutomationRuleCall api = 
			new DeleteSellingManagerItemAutomationRuleCall(apiContext);
		api.setItemID(TestData.itemId);
		api.setDeleteAutomatedRelistingRule(true);
		api.deleteSellingManagerItemAutomationRule();
	}
}
