package com.vodafone.er.ecom.proxy;

import java.util.Locale;

import javax.servlet.http.HttpServlet;

import com.vizzavi.ecommerce.business.selfcare.SelfcareApi;
import com.vodafone.global.er.data.ERLogDataImpl;
import com.vodafone.global.er.decoupling.client.DecouplingApiFactory;

public class AbstractEcomServlet extends HttpServlet {

	protected String	clientId	= "ecom proxy";

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

	protected SelfcareApi getSelfcareApiDelegate(Locale locale) {
		return DecouplingApiFactory.getSelfcareApi(locale, clientId);
	}
}
