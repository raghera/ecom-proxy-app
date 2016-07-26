package com.vodafone.er.ecom.proxy;

import com.vizzavi.ecommerce.business.charging.BaseAuthorization;
import com.vizzavi.ecommerce.business.selfcare.*;
import com.vodafone.er.ecom.proxy.service.SelfcareApiResultProcessor;
import com.vodafone.global.er.business.selfcare.BalanceFilter;
import com.vodafone.global.er.business.selfcare.MicroServiceStatus;
import com.vodafone.global.er.business.selfcare.ParentTransaction;
import com.vodafone.global.er.data.ERLogDataImpl;
import com.vodafone.global.er.decoupling.client.DecouplingApiFactory;
import com.vodafone.global.er.util.ExceptionAdapter;
import org.apache.log4j.Logger;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Locale;

public class SelfcareApiServlet extends AbstractEcomServlet {

	private static final long	serialVersionUID	= 4741658240141614716L;
	//CR1231
    //private static LWLogger log = LWSupportFactoryImpl.getInstance().getLogger(SelfcareApiServlet.class);
	private static Logger log = Logger.getLogger(SelfcareApiServlet.class);
	
  
    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
    	String methodName = null;
    	try {
    		startTx();
           ServletInputStream is = req.getInputStream();
           ObjectInputStream ois = new ObjectInputStream(is);
           @SuppressWarnings("unchecked")
           HashMap<String, Serializable> requestPayload = (HashMap<String, Serializable>) ois.readObject();
           Locale locale = (Locale)requestPayload.get("locale");
           methodName = (String) requestPayload.get("methodName");
           String clientId = (String) requestPayload.get("clientId");
           log(clientId, locale, methodName, "SelfcareApi");
           //CR 2199 - Add msisdn to context
           String msisdn = (String) requestPayload.get("msisdn");
           logRequest(new ERLogDataImpl(msisdn, clientId, methodName, locale.getCountry()) );
           if (methodName.equals("getSubscriptions1")) {               
                 
                int device =  ((Integer) requestPayload.get("device")).intValue();
                 getSubscriptionsHandler(locale, resp  ,clientId  ,msisdn  ,device );
           }
           if (methodName.equals("getSubscriptions2")) {               
                 
                int device =  ((Integer) requestPayload.get("device")).intValue();
                 SubscriptionFilter filter = (SubscriptionFilter) requestPayload.get("filter");
                 getSubscriptionsHandler(locale, resp  ,clientId  ,msisdn  ,device  ,filter );
           }
           if (methodName.equals("modifySubscriptionChargingMethod3")) {               
                 
                int deviceType =  ((Integer) requestPayload.get("deviceType")).intValue();
                 String packageSubId = (String) requestPayload.get("packageSubId");
                int chargingMethod =  ((Integer) requestPayload.get("chargingMethod")).intValue();
                 modifySubscriptionChargingMethodHandler(locale, resp  ,clientId  ,msisdn  ,deviceType  ,packageSubId  ,chargingMethod );
           }
           if (methodName.equals("modifySubscriptionChargingMethod4")) {               
                 
                int deviceType =  ((Integer) requestPayload.get("deviceType")).intValue();
                 String packageSubId = (String) requestPayload.get("packageSubId");
                int chargingMethod =  ((Integer) requestPayload.get("chargingMethod")).intValue();
                 String csrId = (String) requestPayload.get("csrId");
                 String reason = (String) requestPayload.get("reason");
                 modifySubscriptionChargingMethodHandler(locale, resp  ,clientId  ,msisdn  ,deviceType  ,packageSubId  ,chargingMethod  ,csrId  ,reason );
           }
           if (methodName.equals("getTransactions5")) {               
                 
                 
                int deviceType =  ((Integer) requestPayload.get("deviceType")).intValue();
                 java.util.Date startDate = (java.util.Date) requestPayload.get("startDate");
                 java.util.Date endDate = (java.util.Date) requestPayload.get("endDate");
                int maxNum =  ((Integer) requestPayload.get("maxNum")).intValue();
                 getTransactionsHandler(locale, resp  ,clientId  ,msisdn  ,deviceType  ,startDate  ,endDate  ,maxNum );
           }
           if (methodName.equals("getTransactions6")) {               
                 
                 
                int accessDevice =  ((Integer) requestPayload.get("accessDevice")).intValue();
                 TransactionFilter filter = (TransactionFilter) requestPayload.get("filter");
                 getTransactionsHandler(locale, resp  ,clientId  ,msisdn  ,accessDevice  ,filter );
           }
           if (methodName.equals("getTransaction7")) {               
                 
                 String transId = (String) requestPayload.get("transId");
                 getTransactionHandler(locale, resp  ,clientId  ,transId );
           }
           if (methodName.equals("getPaymentTransactions8")) {               
                 
                 
                int deviceType =  ((Integer) requestPayload.get("deviceType")).intValue();
                 TransactionFilter filter = (TransactionFilter) requestPayload.get("filter");
                 getPaymentTransactionsHandler(locale, resp  ,clientId  ,msisdn  ,deviceType  ,filter );
           }
           if (methodName.equals("getBalances9")) {               
                 
                 
                int device =  ((Integer) requestPayload.get("device")).intValue();
                 getBalancesHandler(locale, resp  ,clientId  ,msisdn  ,device );
           }
           if (methodName.equals("getSubscription10")) {               
                 
                 
                int deviceType =  ((Integer) requestPayload.get("deviceType")).intValue();
                 String packageSubId = (String) requestPayload.get("packageSubId");
                 getSubscriptionHandler(locale, resp  ,clientId  ,msisdn  ,deviceType  ,packageSubId );
           }
           if (methodName.equals("getNextPaymentAmount11")) {               
                 
                 
                 String subscriptionId = (String) requestPayload.get("subscriptionId");
                 getNextPaymentAmountHandler(locale, resp  ,clientId  ,msisdn  ,subscriptionId );
           }
           if (methodName.equals("modifySubscriptionChargingMethod12")) {               
                 
                 
                int deviceType =  ((Integer) requestPayload.get("deviceType")).intValue();
                 CustcareAttributes attr = (CustcareAttributes) requestPayload.get("attr");
                 modifySubscriptionChargingMethodHandler(locale, resp  ,clientId  ,msisdn  ,deviceType  ,attr );
           }
           if (methodName.equals("getSuperCreditBalances13")) {               
                 
                 
                int device =  ((Integer) requestPayload.get("device")).intValue();
                log.error("unsupported supercredits call from "+clientId+" in "+locale.getDisplayCountry());
                 getSuperCreditBalancesHandler(locale, resp  ,clientId  ,msisdn  ,device );
           }
           if (methodName.equals("getBalances14")) {               
                 
                 
                int deviceId =  ((Integer) requestPayload.get("deviceId")).intValue();
                 BalanceFilter filter = (BalanceFilter) requestPayload.get("filter");
                 getBalancesHandler(locale, resp  ,msisdn  ,clientId  ,deviceId  ,filter );
           }
           if (methodName.equals("getParentTransaction15")) {               
                 
                 
                 TransactionFilter transactionfilter = (TransactionFilter) requestPayload.get("transactionfilter");
                 getParentTransactionHandler(locale, resp  ,clientId  ,msisdn  ,transactionfilter );
           }
           if (methodName.equals("getMicroServiceStatus16")) {               
                 
                 
                 MicroServiceFilter msfilter = (MicroServiceFilter) requestPayload.get("msfilter");
                 getMicroServiceStatusHandler(locale, resp  ,clientId  ,msisdn  ,msfilter );
           }
           if (methodName.equals("getTransaction17")) {               
                 
                 TransactionFilter filter = (TransactionFilter) requestPayload.get("filter");
                 getTransactionHandler(locale, resp  ,clientId  ,filter );
           }
           
       }
       catch (Exception e) {         
          try
           {
        	  
            ObjectOutputStream oostream = new ObjectOutputStream (new BufferedOutputStream (resp.getOutputStream()));
            oostream.writeObject( new ExceptionAdapter(e));
            oostream.flush();
           } catch(IOException ioe)
             {
               log.error(ioe.getMessage(),ioe);
             }
       }	finally	{
    	   logResponse();
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
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            // send response
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
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
//                result = getSelfcareApiDelegate(locale).getSubscriptions(clientId,msisdn,device,filter);
                result = DecouplingApiFactory.getSelfcareApi(locale, "ecom-proxy").getSubscriptions(clientId,msisdn,device,filter);
                result = new SelfcareApiResultProcessor(locale).process(result);
               //hydrateSubscriptions(result);
            }
            catch (Exception e1) {                
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            // send response
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
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
            boolean result = false;        
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getSelfcareApiDelegate(locale).modifySubscriptionChargingMethod(clientId,msisdn,deviceType,packageSubId,chargingMethod);
            }
            catch (Exception e1) {                
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            // send response
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeBoolean(result);      
            oos.flush();
        } catch (Exception e2) {
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
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            // send response
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeBoolean(result);      
            oos.flush();
        } catch (Exception e2) {
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
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            // send response
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
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
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            // send response
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
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
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            // send response
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
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
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            // send response
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
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
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            // send response
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
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
                result = getSelfcareApiDelegate(locale).getSubscription(clientId,msisdn,deviceType,packageSubId);
                //hydrateSubscription(result);
            }
            catch (Exception e1) {                
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            // send response
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
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
            BaseAuthorization result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getSelfcareApiDelegate(locale).getNextPaymentAmount(clientId,msisdn,subscriptionId);
            }
            catch (Exception e1) {                
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            // send response
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
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
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            // send response
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeBoolean(result);      
            oos.flush();
        } catch (Exception e2) {
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

    @Deprecated
    public void getSuperCreditBalancesHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,int device ) {
        ObjectOutputStream oos = null;
        try {            
            ResourceBalance[] result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                //result = getSelfcareApiDelegate(locale).getSuperCreditBalances(clientId,msisdn,device);
            	result = new ResourceBalance[]{};
            }
            catch (Exception e1) {                
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            // send response
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
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

    public void getBalancesHandler(Locale locale, HttpServletResponse resp ,String msisdn  ,String clientId  ,int deviceId  ,BalanceFilter filter ) {
        ObjectOutputStream oos = null;
        try {            
            ResourceBalance[] result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getSelfcareApiDelegate(locale).getBalances(msisdn,clientId,deviceId,filter);
            }
            catch (Exception e1) {                
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            // send response
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
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
            ParentTransaction result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getSelfcareApiDelegate(locale).getParentTransaction(clientId,msisdn,transactionfilter);
            }
            catch (Exception e1) {                
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            // send response
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
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
            MicroServiceStatus[] result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getSelfcareApiDelegate(locale).getMicroServiceStatus(clientId,msisdn,msfilter);
            }
            catch (Exception e1) {                
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            // send response
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
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
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            // send response
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
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

}
