package com.songxinjing.erp.constant;

public class Constant {

	/**
	 * 登录用户信息在Session中的Key
	 */
	public static final String SESSION_LOGIN_USER = "session_login_user";

	/**
	 * 分页组件：每页显示数目
	 */
	public static final int PAGE_SIZE = 15;

	public static final int EBAY = 1;
	public static final int WISH = 2;
	public static final int AMAZON = 3;
	public static final int ALIEXPRESS = 4;

	public static String getPlatformName(int platform) {
		switch (platform) {
		case EBAY:
			return "EBAY";
		case WISH:
			return "WISH";
		case AMAZON:
			return "AMAZON";
		case ALIEXPRESS:
			return "ALIEXPRESS";
		default:
			return "未知";
		}
	}

}
