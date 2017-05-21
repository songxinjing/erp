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
import com.ebay.sdk.call.CompleteSaleCall;
import com.ebay.soap.eBLBaseComponents.PaymentStatusCodeType;
import com.ebay.soap.eBLBaseComponents.TransactionType;
import com.songxinjing.erp.ebay.SDKTestCase;
import com.songxinjing.erp.ebay.TestData;

/**
 *
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class CompleteSale extends SDKTestCase {

  public void testCompleteSale() throws Exception {

    CompleteSaleCall api = new CompleteSaleCall(this.apiContext);

    TransactionType tran = null;
    if( TestData.SellerTransactions != null && TestData.SellerTransactions.length > 0 )
      tran = TestData.SellerTransactions[0];

    // Make API call.
    ApiException gotException = null;

    // Negative test.
    try
    {
      if( tran != null )
      {
        api.setItemID(tran.getItem().getItemID().toString());
        api.setTransactionID(tran.getTransactionID());

        PaymentStatusCodeType pStatus = tran.getStatus().getEBayPaymentStatus();
        boolean paid = pStatus.equals(PaymentStatusCodeType.NO_PAYMENT_FAILURE)
            && (tran.getPaidTime() != null);
        api.setPaid(new Boolean(paid));
      }
      else
        api.setItemID("TestID");

      api.completeSale();
    }
    catch(ApiException ex)
    {
      gotException = ex;
    }

  
  }
}
