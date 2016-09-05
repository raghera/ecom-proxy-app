package com.vodafone.er.ecom.proxy;

import com.vodafone.global.er.data.ERLogDataImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import java.util.Locale;

public class AbstractEcomServlet extends HttpServlet {

	protected String clientId = "ecom-proxy";
	private static Logger LOG = LoggerFactory.getLogger(AbstractEcomServlet.class);


	void startTx(){}

	protected void logRequest(ERLogDataImpl erLogDataImpl) {
		// TODO Write this method!

	}

	protected void logResponse() {
		// TODO Write this method!

	}

	protected void log(String clientId, Locale locale, String methodName, String apiName) {
		LOG.info("Incoming apiName={} locale={} clientId={} methodName={}",
                apiName, locale, clientId, methodName );
	}
}
