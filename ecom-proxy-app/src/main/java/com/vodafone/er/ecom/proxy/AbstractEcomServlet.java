package com.vodafone.er.ecom.proxy;

import com.vodafone.global.er.data.ERLogDataImpl;

import javax.servlet.http.HttpServlet;
import java.util.Locale;

public class AbstractEcomServlet extends HttpServlet {

	protected String clientId = "ecom-proxy";

	void startTx(){}

	protected void logRequest(ERLogDataImpl erLogDataImpl) {
		// TODO Write this method!

	}

	protected void logResponse() {
		// TODO Write this method!

	}

	protected void log(String clientId, Locale locale, String methodName, String string) {
		// TODO Write this method!

	}
}
