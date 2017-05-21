/*
Copyright (c) 2010 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package com.songxinjing.erp.ebay.apicalls;

import java.io.File;

import com.ebay.sdk.call.ExtendSiteHostedPicturesCall;
import com.ebay.sdk.pictureservice.PictureInfo;
import com.ebay.sdk.pictureservice.eps.eBayPictureServiceXMLCall;
import com.ebay.soap.eBLBaseComponents.AckCodeType;
import com.ebay.soap.eBLBaseComponents.PictureWatermarkCodeType;
import com.ebay.soap.eBLBaseComponents.UploadSiteHostedPicturesRequestType;
import com.ebay.soap.eBLBaseComponents.UploadSiteHostedPicturesResponseType;
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
 * @author William Yang
 * @version 1.0
 */
public class SiteHostedPicturesTest extends SDKTestCase {

	public void testSiteHostedPictures() throws Exception {
		// test UploadSiteHostedPictures
		File currentDir = new File(".");
		String pictureFilePath = currentDir.getCanonicalPath() + "/eBayLogoTM.gif";

		eBayPictureServiceXMLCall epsCall = new eBayPictureServiceXMLCall(this.apiContext);
		PictureInfo picInfo = new PictureInfo();
		picInfo.setPictureFilePath(pictureFilePath);

		UploadSiteHostedPicturesRequestType request = new UploadSiteHostedPicturesRequestType();
		request.setPictureWatermark(new PictureWatermarkCodeType[] { PictureWatermarkCodeType.USER });

		epsCall.UpLoadSiteHostedPicture(picInfo, request);
		UploadSiteHostedPicturesResponseType response = picInfo.getReponse();
		String picUrl = picInfo.getURL();

		// test ExtendSiteHostedPictures
		ExtendSiteHostedPicturesCall eshpCall = new ExtendSiteHostedPicturesCall(this.apiContext);
		eshpCall.setPictureURL(new String[] { picUrl });
		eshpCall.setExtensionInDays(10);
		String[] returnedPicUrls = eshpCall.extendSiteHostedPictures();

		String returnedPicUrl = returnedPicUrls[0];
	}
}
