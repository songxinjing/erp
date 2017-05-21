/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.songxinjing.erp.ebay;

import java.util.PropertyResourceBundle;
import java.util.Locale;

import com.ebay.sdk.ApiAccount;
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;

public class EbayApiUtil {

	private static PropertyResourceBundle bundle;

	private static String ApiServerUrl;
	private static String devId;
	private static String certId;
	private static String appId;

	public static ApiContext api;
	
	public static String env;

	static {
		env = getProperty("env");
		if ("Production".equals(env)) {
			ApiServerUrl = getProperty("ebayAPIUrl");
			devId = getProperty("devId");
			certId = getProperty("certId");
			appId = getProperty("appId");
		} else {
			ApiServerUrl = getProperty("sandboxAPIUrl");
			devId = getProperty("sandboxdevId");
			certId = getProperty("sandboxcertId");
			appId = getProperty("sandboxappId");
		}
		api = createApiContext();
	}

	public static String getProperty(String propertyName) {
		String value = "";
		if (bundle == null) {
			bundle = (PropertyResourceBundle) PropertyResourceBundle.getBundle("authtool", Locale.US);
		}
		if (bundle != null) {
			value = bundle.getString(propertyName);
		}
		return value;
	}

	public static ApiContext createApiContext() {
		ApiAccount ac = new ApiAccount();
		ac.setDeveloper(devId);
		ac.setApplication(appId);
		ac.setCertificate(certId);

		ApiCredential apiCred = new ApiCredential();
		apiCred.setApiAccount(ac);

		ApiContext apiContext = new ApiContext();
		apiContext.setApiCredential(apiCred);
		apiContext.setApiServerUrl(ApiServerUrl);

		return apiContext;
	}
}
