/*
Copyright (c) 2007 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package com.songxinjing.erp.ebay.apicalls;

import java.io.File;

import com.ebay.sdk.call.GetItemCall;
import com.ebay.sdk.call.RelistFixedPriceItemCall;
import com.ebay.sdk.call.RelistItemCall;
import com.ebay.sdk.call.VerifyRelistItemCall;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.FeesType;
import com.ebay.soap.eBLBaseComponents.GalleryTypeCodeType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.PhotoDisplayCodeType;
import com.ebay.soap.eBLBaseComponents.PictureDetailsType;
import com.ebay.soap.eBLBaseComponents.PictureSourceCodeType;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

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
public class RelistItem extends SDKTestCase {

	public void testRelistItem() throws Exception {
		//
		RelistItemCall rviCall = new RelistItemCall(this.apiContext);
		ItemType item = new ItemType();
		item.setItemID(TestData.EndedItem.getItemID());
		AmountType at = new AmountType();
		at.setValue(1.98);
		item.setStartPrice(at);

		rviCall.setItemToBeRelisted(item);
		// Revise the picture
		PictureDetailsType pictureDetails = new PictureDetailsType();
		pictureDetails.setGalleryType(GalleryTypeCodeType.FEATURED);
		pictureDetails.setPhotoDisplay(PhotoDisplayCodeType.NONE);
		pictureDetails.setPictureSource(PictureSourceCodeType.EPS);

		File currentDir = new File(".");
		String[] pictureFiles = { currentDir.getCanonicalPath() + "/eBayLogoTM.gif" };
		rviCall.uploadPictures(pictureFiles, pictureDetails);
		String picURL = item.getPictureDetails().getPictureURL(0);

		// verify relist item before relisting
		VerifyRelistItemCall vriCall = new VerifyRelistItemCall(this.apiContext);
		vriCall.setItem(item);
		vriCall.verifyRelistItem();
		FeesType fees = vriCall.getReturnedFees();

		rviCall.relistItem();

		// Let's wait for the server to "digest" the data.
		java.lang.Thread.sleep(1000);

		// Call GetItem and then compare the startPrice.
		GetItemCall getItem = new GetItemCall(this.apiContext);

		DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] { DetailLevelCodeType.RETURN_ALL };
		getItem.setDetailLevel(detailLevels);

		ItemType returnedItem = getItem.getItem(item.getItemID());

		PictureDetailsType picDetails = returnedItem.getPictureDetails();
		String returnedPicURL = picDetails.getPictureURL(0);

		// End the new created item.
		this.endItem(returnedItem.getItemID());
	}

	public void testRelistFixedPriceItem() throws Exception {
		//
		RelistFixedPriceItemCall rviCall = new RelistFixedPriceItemCall(this.apiContext);
		ItemType item = new ItemType();
		item.setItemID(TestData.EndedFixedPriceItem.getItemID());
		AmountType at = new AmountType();
		at.setValue(1.98);
		item.setStartPrice(at);

		rviCall.setItemToBeRelisted(item);
		// Revise the picture
		PictureDetailsType pictureDetails = new PictureDetailsType();
		pictureDetails.setGalleryType(GalleryTypeCodeType.FEATURED);
		pictureDetails.setPhotoDisplay(PhotoDisplayCodeType.NONE);
		pictureDetails.setPictureSource(PictureSourceCodeType.EPS);

		File currentDir = new File(".");
		String[] pictureFiles = { currentDir.getCanonicalPath() + "/eBayLogoTM.gif" };
		rviCall.uploadPictures(pictureFiles, pictureDetails);
		String picURL = item.getPictureDetails().getPictureURL(0);

		rviCall.relistFixedPriceItem();

		// Let's wait for the server to "digest" the data.
		java.lang.Thread.sleep(1000);

		// Call GetItem and then compare the startPrice.
		GetItemCall getItem = new GetItemCall(this.apiContext);

		DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] { DetailLevelCodeType.RETURN_ALL };
		getItem.setDetailLevel(detailLevels);

		ItemType returnedItem = getItem.getItem(item.getItemID());

		PictureDetailsType picDetails = returnedItem.getPictureDetails();
		String returnedPicURL = picDetails.getPictureURL(0);

		// End the new created item.
		this.endItem(returnedItem.getItemID());
	}
}
