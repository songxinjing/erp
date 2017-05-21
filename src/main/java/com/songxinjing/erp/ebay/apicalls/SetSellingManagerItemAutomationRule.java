package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.SetSellingManagerItemAutomationRuleCall;
import com.ebay.soap.eBLBaseComponents.SellingManagerAutoRelistOptionCodeType;
import com.ebay.soap.eBLBaseComponents.SellingManagerAutoRelistType;
import com.ebay.soap.eBLBaseComponents.SellingManagerAutoRelistTypeCodeType;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

public class SetSellingManagerItemAutomationRule extends SDKTestCase {

	public void testSetSellingManagerItemAutomationRule() throws Exception {
		SetSellingManagerItemAutomationRuleCall api = new SetSellingManagerItemAutomationRuleCall(apiContext);
		api.setItemID(TestData.itemId);
		SellingManagerAutoRelistType automatedRelistingRule = new SellingManagerAutoRelistType();
		automatedRelistingRule.setType(SellingManagerAutoRelistTypeCodeType.RELIST_ONCE_IF_NOT_SOLD);
		automatedRelistingRule.setRelistCondition(SellingManagerAutoRelistOptionCodeType.RELIST_IMMEDIATELY);
		api.setAutomatedRelistingRule(automatedRelistingRule);
		api.setSellingManagerItemAutomationRule();
	}
}
