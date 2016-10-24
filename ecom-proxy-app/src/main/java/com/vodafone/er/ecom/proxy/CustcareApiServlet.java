package com.vodafone.er.ecom.proxy;

import com.vizzavi.ecommerce.business.charging.AccountValidationAuthorization;
import com.vizzavi.ecommerce.business.charging.ModifyAuthorisation;
import com.vizzavi.ecommerce.business.charging.SubscriptionAttributes;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vizzavi.ecommerce.business.selfcare.*;
import com.vodafone.er.ecom.proxy.context.ApplicationContextHolder;
import com.vodafone.er.ecom.proxy.service.CustcareApiService;
import com.vodafone.er.ecom.proxy.service.EpaLogService;
import com.vodafone.er.ecom.proxy.service.SelfcareApiService;
import com.vodafone.global.er.data.ERLogDataImpl;
import com.vodafone.global.er.decoupling.client.DecouplingApiFactory;
import com.vodafone.global.er.subscriptionmanagement.SubscriptionFilterImpl;
import com.vodafone.global.er.util.ExceptionAdapter;
import org.apache.log4j.Logger;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static com.vodafone.er.ecom.proxy.enums.PropertiesConstantsEnum.*;
import static com.vodafone.er.ecom.proxy.properties.PropertyService.getPropertyAsBoolean;
import static com.vodafone.global.er.endpoint.ApiNamesEnum.CUSTCARE_API;

public class CustcareApiServlet extends AbstractEcomServlet {


    private static final long	serialVersionUID	= 7283816389304078194L;
    private static Logger log = Logger.getLogger(CustcareApiServlet.class);

    private CustcareApiService custcareApiService;
    private SelfcareApiService selfcareApiService;
    private EpaLogService epaLogService;

    public CustcareApiServlet() {
        custcareApiService = ApplicationContextHolder.getContext().getBean(CustcareApiService.class);
        selfcareApiService = ApplicationContextHolder.getContext().getBean(SelfcareApiService.class);
        epaLogService = ApplicationContextHolder.getContext().getBean(EpaLogService.class);
    }

    protected SelfcareApi getSelfcareApiDelegate(Locale locale) throws Exception {
        return EcomApiFactory.getSelfcareApi(locale);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        Locale locale;
        String methodName, clientId, msisdn;

        try {
            startTx();
            ServletInputStream is = req.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            HashMap<String, Serializable> requestPayload = (HashMap<String, Serializable>) ois.readObject();

            locale = (Locale) requestPayload.get("locale");
            methodName = (String) requestPayload.get("methodName");
            clientId = (String) requestPayload.get("clientId");
            msisdn = (String) requestPayload.get("msisdn");


            epaLogService.logRequestIn(new ERLogDataImpl(msisdn, clientId, methodName, locale.getCountry(), CUSTCARE_API.getValue()) );

            if (methodName.equals("inactivateAccount2")) {

                String csrId = (String) requestPayload.get("csrId");
                String reason = (String) requestPayload.get("reason");
                inactivateAccountHandler(locale, resp  ,clientId  ,msisdn  ,csrId  ,reason );
            }
            if (methodName.equals("inactivateAccount3")) {

                inactivateAccountHandler(locale, resp  ,clientId  ,msisdn );
            }
            if (methodName.equals("inactivateAccount4")) {

                boolean validateAccount =  ((Boolean) requestPayload.get("validateAccount")).booleanValue();
                String csrId = (String) requestPayload.get("csrId");
                String reason = (String) requestPayload.get("reason");
                inactivateAccountHandler(locale, resp  ,clientId  ,msisdn  ,validateAccount  ,csrId  ,reason );
            }
            if (methodName.equals("inactivateAccount5")) {

                boolean validateAccount =  ((Boolean) requestPayload.get("validateAccount")).booleanValue();
                inactivateAccountHandler(locale, resp  ,clientId  ,msisdn  ,validateAccount );
            }
            if (methodName.equals("inactivateSubscription6")) {

                String subscriptionId = (String) requestPayload.get("subscriptionId");
                String csrId = (String) requestPayload.get("csrId");
                String reason = (String) requestPayload.get("reason");
                inactivateSubscriptionHandler(locale, resp  ,clientId  ,msisdn  ,subscriptionId  ,csrId  ,reason );
            }
            if (methodName.equals("inactivateSubscription7")) {

                String subscriptionId = (String) requestPayload.get("subscriptionId");
                inactivateSubscriptionHandler(locale, resp  ,clientId  ,msisdn  ,subscriptionId );
            }
            if (methodName.equals("refundTransactionMonetary8")) {

                String transactionId = (String) requestPayload.get("transactionId");
                double amount =  ((Double) requestPayload.get("amount")).doubleValue();
                com.vizzavi.ecommerce.business.common.ChargingResource res = (com.vizzavi.ecommerce.business.common.ChargingResource) requestPayload.get("res");
                com.vizzavi.ecommerce.business.charging.RefundAttributes attributes = (com.vizzavi.ecommerce.business.charging.RefundAttributes) requestPayload.get("attributes");
                refundTransactionMonetaryHandler(locale, resp  ,clientId  ,msisdn  ,transactionId  ,amount  ,res  ,attributes );
            }
            if (methodName.equals("refundTransactionEnlargement9")) {

                String transactionId = (String) requestPayload.get("transactionId");
                long numberDaysToExtend =  ((Long) requestPayload.get("numberDaysToExtend")).longValue();
                com.vizzavi.ecommerce.business.charging.RefundAttributes attributes = (com.vizzavi.ecommerce.business.charging.RefundAttributes) requestPayload.get("attributes");
                refundTransactionEnlargementHandler(locale, resp  ,clientId  ,msisdn  ,transactionId  ,numberDaysToExtend  ,attributes );
            }
            if (methodName.equals("refundTransactionDiscount10")) {

                String transactionId = (String) requestPayload.get("transactionId");
                double discount =  ((Double) requestPayload.get("discount")).doubleValue();
                com.vizzavi.ecommerce.business.charging.RefundAttributes attributes = (com.vizzavi.ecommerce.business.charging.RefundAttributes) requestPayload.get("attributes");
                refundTransactionDiscountHandler(locale, resp  ,clientId  ,msisdn  ,transactionId  ,discount  ,attributes );
            }
            if (methodName.equals("modifyMsisdn11")) {

                String newMsisdn = (String) requestPayload.get("newMsisdn");
                String csrId = (String) requestPayload.get("csrId");
                String reason = (String) requestPayload.get("reason");
                modifyMsisdnHandler(locale, resp  ,clientId  ,msisdn  ,newMsisdn  ,csrId  ,reason );
            }
            if (methodName.equals("modifyMsisdn12")) {

                String newMsisdn = (String) requestPayload.get("newMsisdn");
                modifyMsisdnHandler(locale, resp  ,clientId  ,msisdn  ,newMsisdn );
            }
            if (methodName.equals("modifyBan13")) {

                String newBan = (String) requestPayload.get("newBan");
                String csrId = (String) requestPayload.get("csrId");
                String reason = (String) requestPayload.get("reason");
                modifyBanHandler(locale, resp  ,clientId  ,msisdn  ,newBan  ,csrId  ,reason );
            }
            if (methodName.equals("modifyBan14")) {

                String newBan = (String) requestPayload.get("newBan");
                modifyBanHandler(locale, resp  ,clientId  ,msisdn  ,newBan );
            }
            if (methodName.equals("getBasicAccount15")) {

                int accessDevice =  (requestPayload.get("accessDevice")!=null)?((Integer) requestPayload.get("accessDevice")).intValue():0;
                getBasicAccountHandler(locale, resp  ,clientId  ,msisdn  ,accessDevice );
            }
            if (methodName.equals("inactivateSubscription16")) {

                int device =  ((Integer) requestPayload.get("device")).intValue();
                CustcareAttributes custcareAttributes = (CustcareAttributes) requestPayload.get("custcareAttributes");
                inactivateSubscriptionHandler(locale, resp  ,clientId  ,msisdn  ,device  ,custcareAttributes );
            }
//           if (methodName.equals("notificationSubscribe17")) {               
//                 java.util.Locale locale1 = (java.util.Locale) requestPayload.get("locale1");
//                 String url = (String) requestPayload.get("url");
//                 String name = (String) requestPayload.get("name");
//                 notificationSubscribeHandler(locale, resp  ,locale1  ,url  ,name );
//           }
            if (methodName.equals("refundTransactionCredit18")) {
                com.vizzavi.ecommerce.business.charging.RefundAttributes refundAttr = (com.vizzavi.ecommerce.business.charging.RefundAttributes) requestPayload.get("refundAttr");
                refundTransactionCreditHandler(locale, resp  ,refundAttr );
            }
            if (methodName.equals("getSubscriptions17")) {

                int device =  ((Integer) requestPayload.get("device")).intValue();
                getSubscriptionsHandler(locale, resp  ,clientId  ,msisdn  ,device );
            }
            if (methodName.equals("getSubscriptions18")) {

                int device =  ((Integer) requestPayload.get("device")).intValue();
                SubscriptionFilter filter = (SubscriptionFilter) requestPayload.get("filter");
                getSubscriptionsHandler(locale, resp  ,clientId  ,msisdn  ,device  ,filter );
            }
            if (methodName.equals("modifySubscriptionChargingMethod19")) {

                int deviceType =  ((Integer) requestPayload.get("deviceType")).intValue();
                String packageSubId = (String) requestPayload.get("packageSubId");
                int chargingMethod =  ((Integer) requestPayload.get("chargingMethod")).intValue();
                modifySubscriptionChargingMethodHandler(locale, resp  ,clientId  ,msisdn  ,deviceType  ,packageSubId  ,chargingMethod );
            }
            if (methodName.equals("modifySubscriptionChargingMethod20")) {

                int deviceType =  ((Integer) requestPayload.get("deviceType")).intValue();
                String packageSubId = (String) requestPayload.get("packageSubId");
                int chargingMethod =  ((Integer) requestPayload.get("chargingMethod")).intValue();
                String csrId = (String) requestPayload.get("csrId");
                String reason = (String) requestPayload.get("reason");
                modifySubscriptionChargingMethodHandler(locale, resp  ,clientId  ,msisdn  ,deviceType  ,packageSubId  ,chargingMethod  ,csrId  ,reason );
            }
            if (methodName.equals("getTransactions21")) {

                int deviceType =  ((Integer) requestPayload.get("deviceType")).intValue();
                java.util.Date startDate = (java.util.Date) requestPayload.get("startDate");
                java.util.Date endDate = (java.util.Date) requestPayload.get("endDate");
                int maxNum =  ((Integer) requestPayload.get("maxNum")).intValue();
                getTransactionsHandler(locale, resp  ,clientId  ,msisdn  ,deviceType  ,startDate  ,endDate  ,maxNum );
            }
            if (methodName.equals("getTransactions22")) {

                int accessDevice =  ((Integer) requestPayload.get("accessDevice")).intValue();
                TransactionFilter filter = (TransactionFilter) requestPayload.get("filter");
                getTransactionsHandler(locale, resp  ,clientId  ,msisdn  ,accessDevice  ,filter );
            }
            if (methodName.equals("getTransaction23")) {

                String transId = (String) requestPayload.get("transId");
                getTransactionHandler(locale, resp  ,clientId  ,transId );
            }
            if (methodName.equals("getPaymentTransactions24")) {

                int deviceType =  ((Integer) requestPayload.get("deviceType")).intValue();
                TransactionFilter filter = (TransactionFilter) requestPayload.get("filter");
                getPaymentTransactionsHandler(locale, resp  ,clientId  ,msisdn  ,deviceType  ,filter );
            }
            if (methodName.equals("getBalances25")) {

                int device =  ((Integer) requestPayload.get("device")).intValue();
                getBalancesHandler(locale, resp  ,clientId  ,msisdn  ,device );
            }
            if (methodName.equals("getSubscription26")) {

                int deviceType =  ((Integer) requestPayload.get("deviceType")).intValue();
                String packageSubId = (String) requestPayload.get("packageSubId");
                getSubscriptionHandler(locale, resp  ,clientId  ,msisdn  ,deviceType  ,packageSubId );
            }
            if (methodName.equals("getNextPaymentAmount27")) {

                String subscriptionId = (String) requestPayload.get("subscriptionId");
                getNextPaymentAmountHandler(locale, resp  ,clientId  ,msisdn  ,subscriptionId );
            }
            if (methodName.equals("modifySubscriptionChargingMethod28")) {

                int deviceType =  ((Integer) requestPayload.get("deviceType")).intValue();
                CustcareAttributes attr = (CustcareAttributes) requestPayload.get("attr");
                modifySubscriptionChargingMethodHandler(locale, resp  ,clientId  ,msisdn  ,deviceType  ,attr );
            }
            if (methodName.equals("getSuperCreditBalances29")) {

                int device =  ((Integer) requestPayload.get("device")).intValue();
                log.error("super credits no longer supported");

//                 getSuperCreditBalancesHandler(locale, resp  ,clientId  ,msisdn  ,device );
            }
            if (methodName.equals("getBalances30")) {

                int deviceId =  ((Integer) requestPayload.get("deviceId")).intValue();
                com.vodafone.global.er.business.selfcare.BalanceFilter filter = (com.vodafone.global.er.business.selfcare.BalanceFilter) requestPayload.get("filter");
                getBalancesHandler(locale, resp  ,msisdn  ,clientId  ,deviceId  ,filter );
            }
            if (methodName.equals("getParentTransaction31")) {

                TransactionFilter transactionfilter = (TransactionFilter) requestPayload.get("transactionfilter");
                getParentTransactionHandler(locale, resp  ,clientId  ,msisdn  ,transactionfilter );
            }
            if (methodName.equals("getMicroServiceStatus32")) {

                MicroServiceFilter msfilter = (MicroServiceFilter) requestPayload.get("msfilter");
                getMicroServiceStatusHandler(locale, resp  ,clientId  ,msisdn  ,msfilter );
            }
            if (methodName.equals("getTransaction33")) {

                TransactionFilter filter = (TransactionFilter) requestPayload.get("filter");
                getTransactionHandler(locale, resp  ,clientId  ,filter );
            }


            if (methodName.equals("modifySubscription40"))
            {
                //MQC 6574 - get clientid from payload instead of clientApplicationId
                //WAS
                //String clientApplicationId = (String) requestPayload.get("clientApplicationId");
                String clientApplicationId = (String) requestPayload.get("clientId");
                String subscriptionId =  (String) requestPayload.get("subscriptionId");
                com.vizzavi.ecommerce.business.charging.SubscriptionAttributes subscriptionAttributes =                            (com.vizzavi.ecommerce.business.charging.SubscriptionAttributes) requestPayload.get("subscriptionAttributes");
                modifySubscriptionMethodHandler(locale, resp  ,clientApplicationId  ,msisdn  ,subscriptionId  ,subscriptionAttributes );

            }
            //CR2082 -add handler for validate msisdn call
            if (methodName.equals("validateMsisdnAccount42"))
            {
                ValidateMsisdnAttributes validateAttributes =  (ValidateMsisdnAttributes) requestPayload.get("validateAttributes");
                validateMsisdnAccountMethodHandler(locale, resp ,msisdn ,validateAttributes );

            }
            if (methodName.equals("modifySpendLimits43")) {

                SpendLimits spendLimits = (SpendLimits) requestPayload.get("spendLimits");
                String csrId = (String) requestPayload.get("csrId");
                modifySpendLimitsHandler(locale, resp  ,clientId  ,msisdn  ,spendLimits  ,csrId );
            }
            //ET-129 - ModifyUserGroups through Batch
            if (methodName.equals("modifyUserGroups38")) {

                log.debug("modifyUserGroups38 usergroups value: " + requestPayload.get("usergroup") );

                List<String> usergroups = (List<String>) requestPayload.get("usergroup");
                final String csrId = (String) requestPayload.get("csrId");
                final String reason = (String) requestPayload.get("reason");
                final String action = (String) requestPayload.get("action");

                modifyUserGroupsHandler(locale, resp, clientId, msisdn, csrId, reason, usergroups, action);

            }
        }
        catch (Exception e) {
            epaLogService.logResponseError(e);
            try
            {
                epaLogService.logResponseError(e);

                ObjectOutputStream oostream = new ObjectOutputStream (new BufferedOutputStream (resp.getOutputStream()));
                oostream.writeObject( new ExceptionAdapter(e));
                oostream.flush();
            } catch(IOException ioe)
            {
                log.error(ioe.getMessage(),ioe);
            }
        }
    }


    public void inactivateAccountHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,String csrId  ,String reason ) {
        ObjectOutputStream oos = null;
        try {
            boolean result = false;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCustcareApiDelegate(locale).inactivateAccount(clientId,msisdn,csrId,reason);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeBoolean(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void inactivateAccountHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn ) {
        ObjectOutputStream oos = null;
        try {
            boolean result = false;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCustcareApiDelegate(locale).inactivateAccount(clientId,msisdn, null, null);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeBoolean(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void inactivateAccountHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,boolean validateAccount  ,String csrId  ,String reason ) {
        ObjectOutputStream oos = null;
        try {
            boolean result = false;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCustcareApiDelegate(locale).inactivateAccount(clientId,msisdn,validateAccount,csrId,reason);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeBoolean(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void inactivateAccountHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,boolean validateAccount ) {
        ObjectOutputStream oos = null;
        try {
            boolean result = false;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCustcareApiDelegate(locale).inactivateAccount(clientId,msisdn,validateAccount, null, null);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeBoolean(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void inactivateSubscriptionHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,String subscriptionId  ,String csrId  ,String reason ) {
        ObjectOutputStream oos = null;
        try {
            boolean result = false;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                Optional<Boolean> shouldProxy = getPropertyAsBoolean( PROP_INACTIVATE_SUBSCRIPTION6.value(), true);
                if(shouldProxy.isPresent()) {
                    result = custcareApiService.inactivateSubscription(locale, clientId, msisdn, subscriptionId, csrId, reason);
                } else {
                    result = getCustcareApiDelegate(locale).inactivateSubscription(clientId, msisdn, subscriptionId, csrId, reason);
                }
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeBoolean(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void inactivateSubscriptionHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,String subscriptionId ) {
        ObjectOutputStream oos = null;
        try {
            boolean result = false;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCustcareApiDelegate(locale).inactivateSubscription(clientId,msisdn,subscriptionId, null, null);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeBoolean(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void refundTransactionMonetaryHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,String transactionId  ,double amount  ,com.vizzavi.ecommerce.business.common.ChargingResource res  ,com.vizzavi.ecommerce.business.charging.RefundAttributes attributes ) {
        ObjectOutputStream oos = null;
        try {
            com.vizzavi.ecommerce.business.charging.RefundAuthorization result = null;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCustcareApiDelegate(locale).refundTransactionMonetary(clientId,msisdn,transactionId,amount,res,attributes);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void refundTransactionEnlargementHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,String transactionId  ,long numberDaysToExtend  ,com.vizzavi.ecommerce.business.charging.RefundAttributes attributes ) {
        ObjectOutputStream oos = null;
        try {
            com.vizzavi.ecommerce.business.charging.RefundAuthorization result = null;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCustcareApiDelegate(locale).refundTransactionEnlargement(clientId,msisdn,transactionId,numberDaysToExtend,attributes);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void refundTransactionDiscountHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,String transactionId  ,double discount  ,com.vizzavi.ecommerce.business.charging.RefundAttributes attributes ) {
        ObjectOutputStream oos = null;
        try {
            com.vizzavi.ecommerce.business.charging.RefundAuthorization result = null;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCustcareApiDelegate(locale).refundTransactionDiscount(clientId,msisdn,transactionId,discount,attributes);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void modifyMsisdnHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,String newMsisdn  ,String csrId  ,String reason ) {
        ObjectOutputStream oos = null;
        try {
            boolean result = false;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCustcareApiDelegate(locale).modifyMsisdn(clientId,msisdn,newMsisdn,csrId,reason);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeBoolean(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void modifyMsisdnHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,String newMsisdn ) {
        ObjectOutputStream oos = null;
        try {
            boolean result = false;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCustcareApiDelegate(locale).modifyMsisdn(clientId,msisdn,newMsisdn, null, null);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeBoolean(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void modifyBanHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,String newBan  ,String csrId  ,String reason ) {
        ObjectOutputStream oos = null;
        try {
            boolean result = false;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCustcareApiDelegate(locale).modifyBan(clientId,msisdn,newBan,csrId,reason);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeBoolean(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void modifyBanHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,String newBan ) {
        ObjectOutputStream oos = null;
        try {
            boolean result = false;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCustcareApiDelegate(locale).modifyBan(clientId,msisdn,newBan, null, null);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeBoolean(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void getBasicAccountHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,int accessDevice ) {
        ObjectOutputStream oos = null;
        try {
            BasicAccount result;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {

                Optional<Boolean> shouldProxy = getPropertyAsBoolean(PROP_GET_BASIC_ACCOUNT15.value(), true);
                if(shouldProxy.isPresent()) {
                    result = custcareApiService.getBasicAccount(locale, clientId,msisdn,accessDevice);
                } else {
                    result = getCustcareApiDelegate(locale).getBasicAccount(clientId,msisdn,accessDevice);
                }


            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void inactivateSubscriptionHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,int device  ,CustcareAttributes custcareAttributes ) {
        ObjectOutputStream oos = null;
        try {
            boolean result = false;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCustcareApiDelegate(locale).inactivateSubscription(clientId,msisdn,device,custcareAttributes);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeBoolean(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

//    public void notificationSubscribeHandler(Locale locale, HttpServletResponse resp ,java.util.Locale locale1  ,String url  ,String name ) {
//        ObjectOutputStream oos = null;
//        try {            
//            boolean result = false;        
//            oos = new ObjectOutputStream (
//                               new BufferedOutputStream (resp.getOutputStream()));
//            try {
//                result = getCustcareApiDelegate(locale).notificationSubscribe(locale1,url,name);
//            }
//            catch (Exception e1) {                
//                 oos.writeObject( new ExceptionAdapter(e1));
//                oos.flush();
//                return;
//            }
//             //send response
//            resp.setStatus(HttpServletResponse.SC_OK);
//            oos.writeBoolean(result);      
//            oos.flush();
//        } catch (Exception e2) {
//            try{
//              log(e2.getMessage(), e2);
//              oos = new ObjectOutputStream (
//                   new BufferedOutputStream (resp.getOutputStream()));
//              oos.writeObject( new ExceptionAdapter(e2));
//              oos.flush();
//             }catch(IOException excep)
//             {
//              log.error(excep.getMessage(),excep);
//             }
//        }
//        finally {
//            if (oos != null) {
//                try{
//                   oos.close();
//                   }catch(IOException excep1)
//                    {
//                        log.error(excep1.getMessage(),excep1);
//                    }
//            }
//        }
//    }

    public void refundTransactionCreditHandler(Locale locale, HttpServletResponse resp ,com.vizzavi.ecommerce.business.charging.RefundAttributes refundAttr ) {
        ObjectOutputStream oos = null;
        try {
            com.vizzavi.ecommerce.business.charging.RefundAuthorization result = null;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCustcareApiDelegate(locale).refundTransactionCredit(refundAttr);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void getSubscriptionsHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,int device ) {
        ObjectOutputStream oos = null;
        try {
            Subscription[] result = null;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getSelfcareApiDelegate(locale).getSubscriptions(clientId,msisdn,device);
                //hydrateSubscriptions(result);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void getSubscriptionsHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,int device  ,SubscriptionFilter filter ) {
        ObjectOutputStream oos = null;
        try {
            Subscription[] result = null;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                Optional<Boolean> shouldProxy = getPropertyAsBoolean(PROP_GET_SUBSCRIPTIONS18.value(), true);
                if(shouldProxy.isPresent()) {
                    filter.setIncludeModifyTxns(true);
                    filter.setIncludePaymentTxns(true);
                    filter.setIncludeRefundTxns(true);
                    result = selfcareApiService.getSubscriptions(locale, clientId, msisdn, device, filter);
                } else {
                    result = getSelfcareApiDelegate(locale).getSubscriptions(clientId, msisdn, device, filter);
                }
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void modifySubscriptionChargingMethodHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,int deviceType  ,String packageSubId  ,int chargingMethod ) {
        ObjectOutputStream oos = null;
        try {
            boolean result;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                Optional<Boolean> shouldProxy = getPropertyAsBoolean(PROP_MODIFY_SUBSCRIPTION_CHARGING_METHOD19.value(), true);
                if(shouldProxy.isPresent() && shouldProxy.get()) {
                    //TODO Should go through a processor class
                    result = DecouplingApiFactory.getSelfcareApi(locale, clientId)
                            .modifySubscriptionChargingMethod(clientId, msisdn, 0, packageSubId, chargingMethod);
                } else {
                    result = getSelfcareApiDelegate(locale).modifySubscriptionChargingMethod(clientId, msisdn, deviceType, packageSubId, chargingMethod);
                }
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeBoolean(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void modifySubscriptionChargingMethodHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,int deviceType  ,String packageSubId  ,int chargingMethod  ,String csrId  ,String reason ) {
        ObjectOutputStream oos = null;
        try {
            boolean result = false;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getSelfcareApiDelegate(locale).modifySubscriptionChargingMethod(clientId,msisdn,deviceType,packageSubId,chargingMethod,csrId,reason);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeBoolean(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void getTransactionsHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,int deviceType  ,java.util.Date startDate  ,java.util.Date endDate  ,int maxNum ) {
        ObjectOutputStream oos = null;
        try {
            Transaction[] result = null;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getSelfcareApiDelegate(locale).getTransactions(clientId,msisdn,deviceType,startDate,endDate,maxNum);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void getTransactionsHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,int accessDevice  ,TransactionFilter filter ) {
        ObjectOutputStream oos = null;
        try {
            Transaction[] result = null;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getSelfcareApiDelegate(locale).getTransactions(clientId,msisdn,accessDevice,filter);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void getTransactionHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String transId ) {
        ObjectOutputStream oos = null;
        try {
            Transaction result = null;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getSelfcareApiDelegate(locale).getTransaction(clientId,transId);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void getPaymentTransactionsHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,int deviceType  ,TransactionFilter filter ) {
        ObjectOutputStream oos = null;
        try {
            Transaction[] result = null;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getSelfcareApiDelegate(locale).getPaymentTransactions(clientId,msisdn,deviceType,filter);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void getBalancesHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,int device ) {
        ObjectOutputStream oos = null;
        try {
            ResourceBalance[] result = null;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getSelfcareApiDelegate(locale).getBalances(clientId,msisdn,device);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void getSubscriptionHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,int deviceType  ,String packageSubId ) {
        ObjectOutputStream oos = null;
        try {
            Subscription result = null;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                Optional<Boolean> shouldProxy = getPropertyAsBoolean( PROP_GET_SUBSCRIPTION26.value(), true);
                if(shouldProxy.isPresent()) {
                    SubscriptionFilter filter = new SubscriptionFilterImpl();
                    filter.setSubscriptionId(packageSubId);
                    filter.setIncludeModifyTxns(true);
                    filter.setIncludePaymentTxns(true);
                    filter.setIncludeRefundTxns(true);
                    final Subscription [] subs = selfcareApiService.getSubscriptions(locale, clientId, msisdn, 0, filter);
                    result = subs[0];
                } else {
                    result = getSelfcareApiDelegate(locale).getSubscription(clientId, msisdn, deviceType, packageSubId);
                }
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void getNextPaymentAmountHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,String subscriptionId ) {
        ObjectOutputStream oos = null;
        try {
            com.vizzavi.ecommerce.business.charging.BaseAuthorization result = null;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getSelfcareApiDelegate(locale).getNextPaymentAmount(clientId,msisdn,subscriptionId);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void modifySubscriptionChargingMethodHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,int deviceType  ,CustcareAttributes attr ) {
        ObjectOutputStream oos = null;
        try {
            boolean result = false;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getSelfcareApiDelegate(locale).modifySubscriptionChargingMethod(clientId,msisdn,deviceType,attr);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeBoolean(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

//    public void getSuperCreditBalancesHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,int device ) {
//        ObjectOutputStream oos = null;
//        try {            
//            ResourceBalance[] result = null;
//            oos = new ObjectOutputStream (
//                               new BufferedOutputStream (resp.getOutputStream()));
//            try {
//                result = getSelfcareApiDelegate(locale).getSuperCreditBalances(clientId,msisdn,device);
//            }
//            catch (Exception e1) {                
//                 oos.writeObject( new ExceptionAdapter(e1));
//                oos.flush();
//                return;
//            }
//             //send response
//            resp.setStatus(HttpServletResponse.SC_OK);
//            oos.writeObject(result);
//            oos.flush();
//        } catch (Exception e2) {
//            try{
//              log(e2.getMessage(), e2);
//              oos = new ObjectOutputStream (
//                   new BufferedOutputStream (resp.getOutputStream()));
//              oos.writeObject( new ExceptionAdapter(e2));
//              oos.flush();
//             }catch(IOException excep)
//             {
//              log.error(excep.getMessage(),excep);
//             }
//        }
//        finally {
//            if (oos != null) {
//                try{
//                   oos.close();
//                   }catch(IOException excep1)
//                    {
//                        log.error(excep1.getMessage(),excep1);
//                    }
//            }
//        }
//    }

    public void getBalancesHandler(Locale locale, HttpServletResponse resp ,String msisdn  ,String clientId  ,int deviceId  ,com.vodafone.global.er.business.selfcare.BalanceFilter filter ) {
        ObjectOutputStream oos = null;
        try {
            ResourceBalance[] result = null;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getSelfcareApiDelegate(locale).getBalances(msisdn,clientId,deviceId,filter);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void getParentTransactionHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,TransactionFilter transactionfilter ) {
        ObjectOutputStream oos = null;
        try {
            com.vodafone.global.er.business.selfcare.ParentTransaction result = null;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getSelfcareApiDelegate(locale).getParentTransaction(clientId,msisdn,transactionfilter);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void getMicroServiceStatusHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,MicroServiceFilter msfilter ) {
        ObjectOutputStream oos = null;
        try {
            com.vodafone.global.er.business.selfcare.MicroServiceStatus[] result = null;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getSelfcareApiDelegate(locale).getMicroServiceStatus(clientId,msisdn,msfilter);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void getTransactionHandler(Locale locale, HttpServletResponse resp ,String clientId  ,TransactionFilter filter ) {
        ObjectOutputStream oos = null;
        try {
            Transaction result = null;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getSelfcareApiDelegate(locale).getTransaction(clientId,filter);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }


    public void modifySubscriptionMethodHandler
            (
                    Locale locale
                    , HttpServletResponse resp
                    , String clientApplicationId
                    , String msisdn
                    , String subscriptionId
                    , SubscriptionAttributes subscriptionAttributes
            )
    {
        ObjectOutputStream oos = null;
        ModifySubscriptionAuthorization result = null;
        try
        {
            oos = new ObjectOutputStream (new BufferedOutputStream (resp.getOutputStream()));
            try
            {
                result=	getCustcareApiDelegate(locale).modifySubscription(clientApplicationId,msisdn,subscriptionId,subscriptionAttributes);
            }
            catch (Exception e1)
            {
                epaLogService.logResponseError(e1);
                oos.writeObject(new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        }
        catch (Exception e2)
        {
            epaLogService.logResponseError(e2);
            try
            {
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }
            catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally
        {
            if (oos != null)
            {
                try
                {
                    oos.close();
                }
                catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    //CR2028 -add handler for validate msisdn call
    public void validateMsisdnAccountMethodHandler
    (
            Locale locale
            , HttpServletResponse resp
            , String msisdn
            , ValidateMsisdnAttributes validateAttributes
    )
    {
        ObjectOutputStream oos = null;
        AccountValidationAuthorization result = null;
        try
        {
            oos = new ObjectOutputStream (new BufferedOutputStream (resp.getOutputStream()));
            try
            {
                result=	getCustcareApiDelegate(locale).validateMsisdnAccount(msisdn, validateAttributes);
            }
            catch (Exception e1)
            {
                epaLogService.logResponseError(e1);
                oos.writeObject(new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        }
        catch (Exception e2)
        {
            epaLogService.logResponseError(e2);
            try
            {
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }
            catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally
        {
            if (oos != null)
            {
                try
                {
                    oos.close();
                }
                catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    public void modifySpendLimitsHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn, SpendLimits spendLimits, String csrId) {
        ObjectOutputStream oos = null;
        try {
            com.vizzavi.ecommerce.business.charging.ModifyAuthorisation result = null;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCustcareApiDelegate(locale).modifySpendLimits(clientId,msisdn,spendLimits,csrId);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            //send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
            epaLogService.logResponseError(e2);
            try{
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();
            }catch(IOException excep)
            {
                log.error(excep.getMessage(),excep);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }catch(IOException excep1)
                {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }

    //ET-129 ModifyUserGroup BPS
    public void modifyUserGroupsHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn, String csrId, String reason, List<String> usergroups, String action) {

        ObjectOutputStream oos = null;
        ModifyAuthorisation result = null;

        try {

            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));

            try {
                result = getCustcareApiDelegate(locale).modifyUserGroup(clientId, msisdn, usergroups, csrId, reason, action);
            }
            catch (Exception e1) {
                epaLogService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }

            // send response
            epaLogService.logResponseOut("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        }
        catch(Exception e2) {
            epaLogService.logResponseError(e2);
            try {
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream (
                        new BufferedOutputStream (resp.getOutputStream()));
                oos.writeObject( new ExceptionAdapter(e2));
                oos.flush();

            }
            catch(IOException ioEx) {
                log.error(ioEx.getMessage(),ioEx);
            }
        }
        finally {
            if (oos != null) {
                try{
                    oos.close();
                }
                catch(IOException excep1) {
                    log.error(excep1.getMessage(),excep1);
                }
            }
        }
    }


    private CustcareApi getCustcareApiDelegate(Locale locale) throws Exception {
        return EcomApiFactory.getCustcareApi(locale);
    }

}
