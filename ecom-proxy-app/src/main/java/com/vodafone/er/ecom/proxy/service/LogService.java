package com.vodafone.er.ecom.proxy.service;

import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vodafone.application.logging.ULFEntry;
import com.vodafone.er.ecom.proxy.properties.PropertyService;
import com.vodafone.global.er.PerfLogger;
import com.vodafone.global.er.data.ERLogData;
import com.vodafone.global.er.data.ERLogDataImpl;
import com.vodafone.global.er.translog.TransLogConstants;
import com.vodafone.global.er.translog.TransLogManager;
import com.vodafone.global.er.translog.TransLogManagerFactory;
import com.vodafone.global.er.ulf.service.impl.ERULFLogDataManagerImpl;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static com.vodafone.global.er.translog.TransLogManager.Attr;

/**
 * Created by Ravi Aghera
 */
@Service
public class LogService {

    private static Logger LOG = LoggerFactory.getLogger(LogService.class);
    private final TransLogManager transLogManager = TransLogManagerFactory.getInstance();

    private void logEcomRequest(final ERLogData requestData) {
        LOG.info("\nEcomRequest TX_LOG_ID={}, apiName={} locale={} clientId={} requestName={}\n",
                getCurrentTransactionId(), requestData.getApiName(), requestData.getCountryCode(), requestData.getClientId(), requestData.getRequestName());
    }

    private void logEcomResponse(final ERLogData requestData, boolean operationComplete) {
        LOG.info("\nEcomResponse TX_LOG_ID={} apiName={} locale={} clientId={} requestName={}, operationComplete={}\n",
                getCurrentTransactionId(), requestData.getApiName(), requestData.getCountryCode(), requestData.getClientId(), requestData.getRequestName(), operationComplete);
        clearTranslog();
    }

    private void logEcomError(final ERLogData requestData, Exception ex) {
        LOG.info("\nEcomError TX_LOG_ID={} apiName={} locale={} clientId={} requestName={}, exceptionType={}, exceptionMessage={}\n",
                getCurrentTransactionId(),requestData.getApiName(), requestData.getCountryCode(), requestData.getClientId(), requestData.getRequestName(), ex.getClass(), ex.getMessage());

    }

    public void logRequestIn(final ERLogData requestData) {
        //Always generate a TX_LOG_ID
        transLogManager.addAttributeContext(Attr.ER_TX_LOG_ID, generateId());
        //TODO Format the time for readable output
        long startTime = new Date().getTime();
        final Optional<Boolean> transLogging =
                PropertyService.getPropertyAsBoolean(TransLogConstants.PROPERTY_TRANSLOG_LOGGING_ON, false);
        transLogging.ifPresent(x -> transLogManager.setIsTransLoggingOn(x));

        if(transLogManager.isTransLoggingOn()) {
            //Always generate a new transaction id for each request.
            transLogManager.addAttributeContext(Attr.ER_TX_LOG_ID, generateId());
            transLogManager.addAttributeOnce(Attr.LOG_POINT, ULFEntry.Logpoint.REQUEST_IN.name());

            transLogManager.addAttributeContext(Attr.START_TS, Long.toString(startTime));

            if (StringUtils.isNotBlank(requestData.getRequestName())) {
                transLogManager.addAttributeContext(Attr.REQUEST_NAME, requestData.getRequestName());
                transLogManager.addAttributeOnce(Attr.ULF_SERVICE_NAME, requestData.getRequestName());
            }

            if (StringUtils.isNotBlank(requestData.getApiName())) {
                transLogManager.addAttributeContext(Attr.ER_API_NAME, requestData.getApiName());
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
            transLogManager.logRequest(false);
            ERULFLogDataManagerImpl ulf = new ERULFLogDataManagerImpl();
//            ulf.logULFRequestIn(transLogManager, ULFEntry.Logpoint.REQUEST_IN);
        }
        logEcomRequest(requestData);
    }

    public void logResponseOut(String status) {
        transLogManager.addAttributeOnce(Attr.STATUS, status);
        transLogManager.addAttributeOnce(Attr.LOG_POINT, ULFEntry.Logpoint.RESPONSE_OUT.name());
        long startTime = Long.valueOf(transLogManager.getAttribute(Attr.START_TS));
        long endTime = new Date().getTime();
        long duration = endTime - startTime;
        transLogManager.addAttributeContext(Attr.COMPLETE_TS, Long.toString(endTime));
        transLogManager.addAttributeContext(Attr.DURATION, Long.toString(duration));
        transLogManager.logResponse(true);

        logEcomResponse(new ERLogDataImpl(transLogManager.getAttribute(Attr.CUSTOMER_ID),
                        transLogManager.getAttribute(Attr.VF_INT_CALLER_ID),
                        transLogManager.getAttribute(Attr.REQUEST_NAME),
                        transLogManager.getAttribute(Attr.COUNTRY_CODE),
                        transLogManager.getAttribute(Attr.ER_API_NAME)),
                true);
        //        ulf.logULFRequestIn(transLogManager, ULFEntry.Logpoint.REQUEST_OUT);
    }
    public void logResponseError(Exception e) {
        if(transLogManager.isTransLoggingOn()) {
            transLogManager.addAttributeOnce(Attr.ERROR, e.getMessage());
            transLogManager.addAttributeOnce(Attr.STATUS, "ERROR");

            if (e instanceof EcommerceException) {
                EcommerceException ecom = (EcommerceException) e;
                transLogManager.addAttributeOnce(Attr.ERROR_CODE, Integer.toString(ecom.getErrorId()));
                transLogManager.addAttributeOnce(Attr.ERROR, ecom.getErrorDescription());
            }
            transLogManager.addAttributeOnce(Attr.LOG_POINT, ULFEntry.Logpoint.REQUEST_OUT.name());

            transLogManager.logResponse(true);
        }

        logEcomError(new ERLogDataImpl(transLogManager.getAttribute(Attr.CUSTOMER_ID),
                        transLogManager.getAttribute(Attr.VF_INT_CALLER_ID),
                        transLogManager.getAttribute(Attr.REQUEST_NAME),
                        transLogManager.getAttribute(Attr.COUNTRY_CODE),
                        transLogManager.getAttribute(Attr.ER_API_NAME)),
                e);

//      ulf.logULFRequestIn(transLogManager, ULFEntry.Logpoint.REQUEST_OUT);
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

    public String getCurrentTransactionId() {
        return transLogManager.getAttribute(Attr.ER_TX_LOG_ID);
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }

}
