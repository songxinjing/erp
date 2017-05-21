package com.songxinjing.erp.controller.auth;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ebay.sdk.ApiException;
import com.ebay.sdk.ApiLogging;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.call.FetchTokenCall;
import com.ebay.sdk.call.GetSessionIDCall;
import com.songxinjing.erp.controller.base.BaseController;
import com.songxinjing.erp.ebay.EbayApiUtil;
import com.songxinjing.erp.service.StoreService;

/**
 * Ebay店铺授权控制类
 * 
 * @author songxinjing
 * 
 */
@Controller
public class EbayAuthController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(EbayAuthController.class);

	@Autowired
	StoreService storeService;

	@RequestMapping(value = "ebay/auth", method = RequestMethod.POST)
	@ResponseBody
	public String auth(Model model, HttpServletRequest request) {
		logger.info("Ebay店铺授权");
		String signInURL;
		String runame;
		String ruParams;
		if ("Production".equals(EbayApiUtil.env)) {
			signInURL = EbayApiUtil.getProperty("ebaySignInUrl");
			runame = EbayApiUtil.getProperty("runame");
			ruParams = "params=" + runame + "-Production";
		} else {
			signInURL = EbayApiUtil.getProperty("sandboxSignInUrl");
			runame = EbayApiUtil.getProperty("sandboxruname");
			ruParams = "params=" + runame + "-Sandbox";
		}

		ApiLogging apiLogging = new ApiLogging();
		EbayApiUtil.api.setApiLogging(apiLogging);

		GetSessionIDCall api = new GetSessionIDCall(EbayApiUtil.api);
		api.setRuName(runame);

		try {
			String sessionID = api.getSessionID();
			String encodedSesssionIDString = URLEncoder.encode(sessionID, "UTF-8");
			request.getSession().setAttribute("sessionID", sessionID);
			String url = signInURL + "&RuName=" + runame + "&SessID=" + encodedSesssionIDString + "&ruparams="
					+ ruParams;
			return url;
		} catch (ApiException e) {
			e.printStackTrace();
			return "error";
		} catch (SdkException e) {
			e.printStackTrace();
			return "error";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}

	@RequestMapping(value = "ebay/authSuccess", method = RequestMethod.POST)
	@ResponseBody
	public boolean authSuccess(Model model, HttpServletRequest request, String storeName) {
		logger.info("Ebay店铺授权成功");

		// String username = request.getParameter("username");
		// String ruparams = request.getParameter("params");

		String sessionID = (String) request.getSession().getAttribute("sessionID");

		FetchTokenCall api = new FetchTokenCall(EbayApiUtil.api);
		api.setSessionID(sessionID);

		try {
			String eBayToken = api.fetchToken();
			logger.info("eBayToken: " + eBayToken);
			String tokenExp = api.getHardExpirationTime().getTime().toString();
			logger.info("tokenExp: " + tokenExp);
			storeService.saveStore(1, storeName, eBayToken, tokenExp);
		} catch (ApiException e) {
			e.printStackTrace();
			return false;
		} catch (SdkException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

}
