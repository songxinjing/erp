package com.songxinjing.erp.controller.auth;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiException;
import com.ebay.sdk.ApiLogging;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.call.ConfirmIdentityCall;
import com.ebay.sdk.call.FetchTokenCall;
import com.ebay.sdk.call.GetSessionIDCall;
import com.songxinjing.erp.constant.Constant;
import com.songxinjing.erp.controller.base.BaseController;
import com.songxinjing.erp.ebay.EbayApiUtil;
import com.songxinjing.erp.form.SimpleRspBody;
import com.songxinjing.erp.service.StoreService;

/**
 * Ebay店铺授权控制类
 * 
 * @author songxinjing
 * 
 */
@Controller
public class EbayAuthController extends BaseController {

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
		ApiContext api = EbayApiUtil.createApiContext();
		api.setApiLogging(apiLogging);
		request.getSession().setAttribute("auth_api", api);

		GetSessionIDCall call = new GetSessionIDCall(api);
		call.setRuName(runame);

		try {
			String sessionID = call.getSessionID();
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
	public SimpleRspBody authSuccess(Model model, HttpServletRequest request, String storeName) {
		logger.info("Ebay店铺授权成功");

		// String username = request.getParameter("username");
		// String ruparams = request.getParameter("params");

		String sessionID = (String) request.getSession().getAttribute("sessionID");

		ApiContext api = (ApiContext) request.getSession().getAttribute("auth_api");

		FetchTokenCall fetchCall = new FetchTokenCall(api);
		fetchCall.setSessionID(sessionID);
		ConfirmIdentityCall confirmCall = new ConfirmIdentityCall(api);
		confirmCall.setSessionID(sessionID);
		try {
			String eBayToken = fetchCall.fetchToken();
			logger.info("eBayToken: " + eBayToken);
			String tokenExp = fetchCall.getHardExpirationTime().getTime().toString();
			logger.info("tokenExp: " + tokenExp);
			String ebayUserId = confirmCall.confirmIdentity();
			logger.info("ebayUserId: " + ebayUserId);
			if (storeService.isExist(Constant.EBAY, ebayUserId)) {
				String msg = "授权失败！该店铺【" + Constant.getPlatformName(Constant.EBAY) + "-" + ebayUserId + "】已经在本平台授权！";
				return new SimpleRspBody(false, msg, null);
			}
			storeService.saveStore(Constant.EBAY, storeName, ebayUserId, eBayToken, tokenExp);
		} catch (Exception e) {
			logger.error("授权失败", e);
			return new SimpleRspBody(false, "授权失败！请重试！", null);
		}
		return new SimpleRspBody(false, "授权成功！", null);
	}

}
