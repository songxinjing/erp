/*
Copyright (c) 2007 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
 */

package com.songxinjing.erp.ebay.apicalls;

import com.ebay.sdk.call.GeteBayDetailsCall;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.DetailNameCodeType;
import com.ebay.soap.eBLBaseComponents.GeteBayDetailsResponseType;
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
public class GeteBayDetails extends SDKTestCase {

	public void testGeteBayDetails() throws Exception {

		GeteBayDetailsCall api = new GeteBayDetailsCall(this.apiContext);

		DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] { DetailLevelCodeType.RETURN_HEADERS };

		/*
		 * DetailNameCodeType.PAYMENT_OPTION_DETAILS,
		 * DetailNameCodeType.REGION_DETAILS, and
		 * DetailNameCodeType.REGION_OF_ORIGIN_DETAILS are not functional as per
		 * API documentation.
		 */
		DetailNameCodeType[] detailName = new DetailNameCodeType[] { DetailNameCodeType.COUNTRY_DETAILS,
				DetailNameCodeType.CURRENCY_DETAILS, DetailNameCodeType.SITE_DETAILS, DetailNameCodeType.URL_DETAILS,
				DetailNameCodeType.DISPATCH_TIME_MAX_DETAILS, DetailNameCodeType.ITEM_SPECIFIC_DETAILS,
				DetailNameCodeType.SHIPPING_CARRIER_DETAILS, DetailNameCodeType.SHIPPING_LOCATION_DETAILS,
				DetailNameCodeType.SHIPPING_PACKAGE_DETAILS, DetailNameCodeType.SHIPPING_SERVICE_DETAILS,
				DetailNameCodeType.TAX_JURISDICTION, DetailNameCodeType.TIME_ZONE_DETAILS,
				DetailNameCodeType.UNIT_OF_MEASUREMENT_DETAILS, DetailNameCodeType.RETURN_POLICY_DETAILS, };

		api.setDetailLevel(detailLevels);
		api.setDetailName(detailName);

		// Call API.
		api.geteBayDetails();

		GeteBayDetailsResponseType resp = api.getReturnedeBayDetails();

	}
}
