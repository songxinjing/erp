package com.songxinjing.erp.ebay.apicalls;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.songxinjing.erp.ebay.SDKTestCase;

public class HTTPSProtocolTester extends SDKTestCase {
	public void test_https_with_sys_property() {
		try {
			// System.setProperty("java.protocol.handler.pkgs",
			// "com.sun.net.ssl.internal.www.protocol");
			// Security.addProvider(new
			// com.sun.net.ssl.internal.ssl.Provider());
			URL url = new URL("https://www.microsoft.com");
			URLConnection con = url.openConnection();
			InputStream istream = con.getInputStream();
		} catch (MalformedURLException mfe) {
		} catch (IOException ioe) {
		}
	}

	public void test_https_no_sys_property() {
		try {
			URL url = new URL("https://www.microsoft.com");
			URLConnection con = url.openConnection();
			InputStream istream = con.getInputStream();
		} catch (MalformedURLException mfe) {
		} catch (IOException ioe) {
		}
	}
}
