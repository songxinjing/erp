/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.songxinjing.erp.ebay;

import com.ebay.sdk.SdkException;
import com.ebay.sdk.helper.GetCategoryFeaturesHelper;
import com.ebay.soap.eBLBaseComponents.FeatureDefinitionsType;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;

public class GetCategoryFeaturesHelperTests extends SDKTestCase {
	public void testGetCategoryFeatures() throws SdkException, Exception {
		apiContext.setSite(SiteCodeType.AUSTRIA);
		GetCategoryFeaturesHelper helper1 = new GetCategoryFeaturesHelper(apiContext);
		apiContext.setSite(SiteCodeType.CHINA);
		helper1.loadCategoryFeatures(apiContext);
		helper1.loadCategoryFeatures(SiteCodeType.US);
		//
		FeatureDefinitionsType us_features = helper1.getSiteFeatures(SiteCodeType.US);
		FeatureDefinitionsType cn_features = helper1.getSiteFeatures(SiteCodeType.CHINA);
		//reset the site
		apiContext.setSite(SiteCodeType.US);
	}

}
