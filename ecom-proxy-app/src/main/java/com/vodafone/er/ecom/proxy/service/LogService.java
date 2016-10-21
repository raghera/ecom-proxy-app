package com.vodafone.er.ecom.proxy.service;

import com.vodafone.er.ecom.proxy.properties.PropertyService;
import com.vodafone.global.er.PerfLogger;
import com.vodafone.global.er.data.ERLogData;
import com.vodafone.global.er.translog.TransLogConstants;
import com.vodafone.global.er.translog.TransLogManager;
import com.vodafone.global.er.translog.TransLogManagerFactory;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

import static com.vodafone.global.er.translog.TransLogManager.Attr;

/**
 * Created by Ravi Aghera
 */
@Service
public class LogService {

    protected String clientId = "ecom-proxy-app";
    private static Logger LOG = LoggerFactory.getLogger(LogService.class);

    final TransLogManager transLogManager = TransLogManagerFactory.getInstance();

    public void logEcomRequest(String clientId, Locale locale, String methodName, String apiName) {
        LOG.info("\nEcomRequest TX_LOG_ID={}, apiName={} locale={} clientId={} methodName={}\n",
                getCurrentTransactionId(), apiName, locale, clientId, methodName);
    }

    public void logEcomResponse(String clientId, Locale locale, String methodName, String apiName, boolean operationComplete) {
        LOG.info("\nEcomResponse TX_LOG_ID={} apiName={} locale={} clientId={} methodName={}, operationComplete={}\n",
                getCurrentTransactionId(), apiName, locale, clientId, methodName, operationComplete);
        clearTranslog();
    }

    public void logEcomError(String clientId, Locale locale, String methodName, String apiName, Exception exception) {
        LOG.info("\nEcomError TX_LOG_ID={} apiName={} locale={} clientId={} methodName={}, exceptionType={}, exceptionMessage={}\n",
                getCurrentTransactionId(), apiName, locale, clientId, methodName, exception.getClass(), exception.getMessage());
        clearTranslog();
    }

    private void clearTranslog() {
        TransLogManagerFactory.getInstance().emptyTranslogMDC();
    }

    public void startPerformanceLog(String apiName, String transactionId ) {
        PerfLogger.start(PerfLogger.Type.DI, apiName, transactionId);
    }
    public void stopPerformanceLog(String apiName, String transactionId ) {
        PerfLogger.stop();
    }

    public void logRequest(final ERLogData requestData) {
        //Always generate a TX_LOG_ID
        transLogManager.addAttributeContext(Attr.ER_TX_LOG_ID, generateId());

        final Optional<Boolean> transLogging = PropertyService.getPropertyAsBoolean(TransLogConstants.PROPERTY_TRANSLOG_LOGGING_ON, false);
        transLogging.ifPresent(x -> transLogManager.setIsTransLoggingOn(x));

        if(transLogManager.isTransLoggingOn()) {
            //Always generate a new transaction id for each request.
            transLogManager.addAttributeContext(Attr.ER_TX_LOG_ID, generateId());

            if (StringUtils.isNotBlank(requestData.getRequestName())) {
                transLogManager.addAttributeContext(Attr.REQUEST_NAME, requestData.getRequestName());
                transLogManager.addAttributeOnce(Attr.ULF_SERVICE_NAME, requestData.getRequestName());
            }

            if (StringUtils.isBlank(transLogManager.getAttribute(Attr.VF_INT_CALLER_ID))
                    && StringUtils.isNotBlank(requestData.getClientId())) {
                //will always be true since this is an ecom call, with no http headers
                transLogManager.addAttributeContext(Attr.VF_INT_CALLER_ID, requestData.getClientId());
            }

            //Add ULF specific values if it's an EcomRequest
            //The Id will need to be generated if its an ecom request as there are no headers
            if (StringUtils.isBlank(transLogManager.getAttribute(Attr.VF_TRACE_TRANSACTION_ID))) {
                transLogManager.addAttributeContext(Attr.VF_TRACE_TRANSACTION_ID, generateId());
            }
            if (StringUtils.isNotBlank(requestData.getMsisdn())) {
                transLogManager.addAttributeContext(Attr.CUSTOMER_ID, requestData.getMsisdn());
            }
            if (StringUtils.isNotBlank(requestData.getCountryCode())) {
                transLogManager.addAttributeContext(Attr.COUNTRY_CODE, requestData.getCountryCode());
            }
        }
    }

    public String getCurrentTransactionId() {
        return transLogManager.getAttribute(Attr.ER_TX_LOG_ID);
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }

}
