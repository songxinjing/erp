/*
Copyright (c) 2007 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.ApiException;
import com.ebay.sdk.call.ReviseMyMessagesFoldersCall;
import com.ebay.soap.eBLBaseComponents.MyMessagesFolderOperationCodeType;
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
public class ReviseMyMessagesFolders extends SDKTestCase {

	public void testReviseMyMessagesFolders() throws Exception {

		ReviseMyMessagesFoldersCall api = new ReviseMyMessagesFoldersCall(this.apiContext);

		api.setFolderID(new long[] { -1 });
		api.setFolderName(new String[] { "Test SDK name" });
		api.setOperation(MyMessagesFolderOperationCodeType.DISPLAY);

		// Make API call.
		ApiException gotException = null;

		try {
			api.reviseMyMessagesFolders();
		} catch (ApiException ex) {
			gotException = ex;
		}

	}
}
