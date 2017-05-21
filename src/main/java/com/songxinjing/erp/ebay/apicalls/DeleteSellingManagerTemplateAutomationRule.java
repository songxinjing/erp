package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.DeleteSellingManagerTemplateAutomationRuleCall;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

public class DeleteSellingManagerTemplateAutomationRule extends SDKTestCase{

	public void testDeleteSellingManagerTemplateAutomationRule() throws Exception{
		DeleteSellingManagerTemplateAutomationRuleCall api =
			new DeleteSellingManagerTemplateAutomationRuleCall(apiContext);
		api.setSaleTemplateID(TestData.saleTemplateId);
		api.setDeleteAutomatedRelistingRule(true);
		api.deleteSellingManagerTemplateAutomationRule();
	}
}
