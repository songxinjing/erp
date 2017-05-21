/*
Copyright (c) 2007 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.ApiSchemaBasedXmlPoster;
import com.songxinjing.erp.ebay.SDKTestCase;

/**
 *
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company: eBay Inc.
 * </p>
 * 
 * @author Weijun Li
 * @version 1.0
 */
public class GeteBayOfficialTimeXMLSchemaPoster extends SDKTestCase {

	public void testGeteBayOfficialTime() throws Exception {
		ApiSchemaBasedXmlPoster axp = new ApiSchemaBasedXmlPoster();

		axp.setApiContext(this.apiContext);

		String reqText = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
				+ "<GeteBayOfficialTimeRequest xmlns=\"urn:ebay:apis:eBLBaseComponents\">" + "  <Version>"
				+ this.apiContext.getWSDLVersion() + "</Version>" + "  <RequesterCredentials>"
				+ "    <Username>tuser1</Username>" + "    <Password>ebay</Password>" + "  </RequesterCredentials>"
				+ "</GeteBayOfficialTimeRequest>";

		String respText = null;

		try {
			respText = axp.postXmlText(201, reqText);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
