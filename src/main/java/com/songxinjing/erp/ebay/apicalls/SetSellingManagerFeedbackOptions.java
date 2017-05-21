package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.SetSellingManagerFeedbackOptionsCall;
import com.ebay.soap.eBLBaseComponents.AutomatedLeaveFeedbackEventCodeType;
import com.ebay.soap.eBLBaseComponents.FeedbackCommentArrayType;
import com.songxinjing.erp.ebay.SDKTestCase;

public class SetSellingManagerFeedbackOptions extends SDKTestCase {

	public void testSetSellingManagerFeedbackOptions() throws Exception {
		SetSellingManagerFeedbackOptionsCall api = new SetSellingManagerFeedbackOptionsCall(apiContext);
		api.setAutomatedLeaveFeedbackEvent(AutomatedLeaveFeedbackEventCodeType.PAYMENT_RECEIVED);
		FeedbackCommentArrayType storedComments = new FeedbackCommentArrayType();
		storedComments.setStoredCommentText(
				new String[] { "Paid quickly! Thank you for choosing to buy from Sales-a-lot. " });
		api.setStoredComments(storedComments);
		api.setSellingManagerFeedbackOptions();
	}
}
