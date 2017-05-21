package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.SetSellingManagerTemplateAutomationRuleCall;
import com.ebay.soap.eBLBaseComponents.SellingManagerAutoRelistOptionCodeType;
import com.ebay.soap.eBLBaseComponents.SellingManagerAutoRelistType;
import com.ebay.soap.eBLBaseComponents.SellingManagerAutoRelistTypeCodeType;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

public class SetSellingManagerTemplateAutomationRule extends SDKTestCase {

	public void testSetSellingManagerTemplateAutomationRule() throws Exception {
		SetSellingManagerTemplateAutomationRuleCall api = new SetSellingManagerTemplateAutomationRuleCall(apiContext);
		SellingManagerAutoRelistType automatedRelistingRule = new SellingManagerAutoRelistType();
		automatedRelistingRule.setType(SellingManagerAutoRelistTypeCodeType.RELIST_ONCE_IF_NOT_SOLD);
		automatedRelistingRule.setRelistCondition(SellingManagerAutoRelistOptionCodeType.RELIST_IMMEDIATELY);
		api.setAutomatedRelistingRule(automatedRelistingRule);
		api.setSaleTemplateID(TestData.saleTemplateId);
		api.setSellingManagerTemplateAutomationRule();
	}
}