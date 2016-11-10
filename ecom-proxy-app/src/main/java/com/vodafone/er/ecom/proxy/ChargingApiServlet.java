package com.vodafone.er.ecom.proxy;

import com.vizzavi.ecommerce.business.charging.*;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vodafone.er.ecom.proxy.context.ApplicationContextHolder;
import com.vodafone.er.ecom.proxy.properties.PropertyService;
import com.vodafone.er.ecom.proxy.service.ChargingApiService;
import com.vodafone.global.er.data.ERLogDataImpl;
import com.vodafone.global.er.util.ExceptionAdapter;
import org.apache.log4j.Logger;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Optional;

import static com.vodafone.er.ecom.proxy.enums.PropertiesConstantsEnum.*;
import static com.vodafone.er.ecom.proxy.properties.PropertyService.getPropertyAsBoolean;
import static com.vodafone.global.er.endpoint.ApiNamesEnum.CHARGING_API;

public class ChargingApiServlet extends AbstractEcomServlet {

	private static final long	serialVersionUID	= -3163007763179445975L;

	private static Logger log = Logger.getLogger(ChargingApiServlet.class);

    private ChargingApiService chargingApiService;

    public ChargingApiServlet() {
        chargingApiService = ApplicationContextHolder.getContext().getBean(ChargingApiService.class);
    }

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
       try {
    	   startTx();
           ServletInputStream is = req.getInputStream();
           ObjectInputStream ois = new ObjectInputStream(is);
           @SuppressWarnings("unchecked")
           HashMap<String, Serializable> requestPayload = (HashMap<String, Serializable>) ois.readObject();
           Locale locale = (Locale)requestPayload.get("locale");
           String methodName = (String) requestPayload.get("methodName");
           //for some reason this API uses clientApplicationId and the others use clientId
           String clientApplicationId = (String) requestPayload.get("clientApplicationId");
           String msisdn = (String) requestPayload.get("msisdn");
           logRequest(new ERLogDataImpl(msisdn, clientApplicationId, methodName, locale.getCountry()) );
           logEcomRequest(clientApplicationId, locale, methodName, CHARGING_API.getValue());
           if (methodName.equals("usageAuth1")) {
                 //String msisdn = (String) requestPayload.get("msisdn");
                 String serviceId = (String) requestPayload.get("serviceId");
                 UsageAttributes usageAttributes = (UsageAttributes) requestPayload.get("usageAttributes");
                 usageAuthHandler(locale, resp  ,clientApplicationId  ,msisdn  ,serviceId  ,usageAttributes );
           }
           if (methodName.equals("usageAuthRate2")) {               
                 //String msisdn = (String) requestPayload.get("msisdn");
                 String serviceId = (String) requestPayload.get("serviceId");
                 UsageAttributes usageAttributes = (UsageAttributes) requestPayload.get("usageAttributes");
                 usageAuthRateHandler(locale, resp  ,clientApplicationId  ,msisdn  ,serviceId  ,usageAttributes );
           }
           if (methodName.equals("usageAuthRateCharge3")) {               
                 //String msisdn = (String) requestPayload.get("msisdn");
                 String serviceId = (String) requestPayload.get("serviceId");
                 UsageAttributes usageAttributes = (UsageAttributes) requestPayload.get("usageAttributes");
                 usageAuthRateChargeHandler(locale, resp  ,clientApplicationId  ,msisdn  ,serviceId  ,usageAttributes );
           }
           if (methodName.equals("usageComplete4")) {               
                 String eventReservationId = (String) requestPayload.get("eventReservationId");
                int deliveryStatus =  ((Integer) requestPayload.get("deliveryStatus")).intValue();
                 usageCompleteHandler(locale, resp  ,clientApplicationId  ,eventReservationId  ,deliveryStatus );
           }
           if (methodName.equals("rateService5")) {               
                 String serviceId = (String) requestPayload.get("serviceId");
                 UsageAttributes usageAttributes = (UsageAttributes) requestPayload.get("usageAttributes");
                 rateServiceHandler(locale, resp  ,clientApplicationId  ,serviceId  ,usageAttributes );
           }
           if (methodName.equals("usageAuthRateCharge6")) {               
                 //String msisdn = (String) requestPayload.get("msisdn");
                 String serviceId = (String) requestPayload.get("serviceId");
                 UsageAttributes usageAttributes = (UsageAttributes) requestPayload.get("usageAttributes");
//                 ServiceUsageInstance serviceUsageInstance = (ServiceUsageInstance) requestPayload.get("serviceUsageInstance");
                 usageAuthRateChargeHandler(locale, resp  ,clientApplicationId  ,msisdn  ,serviceId  ,usageAttributes   );
           }
           if (methodName.equals("usageAuthRate7")) {               
                 //String msisdn = (String) requestPayload.get("msisdn");
                 String serviceId = (String) requestPayload.get("serviceId");
                 UsageAttributes usageAttributes = (UsageAttributes) requestPayload.get("usageAttributes");
//                 ServiceUsageInstance serviceUsageInstance = (ServiceUsageInstance) requestPayload.get("serviceUsageInstance");
                 usageAuthRateHandler(locale, resp  ,clientApplicationId  ,msisdn  ,serviceId  ,usageAttributes   );
           }
           if (methodName.equals("usageComplete8")) {               
                 String reservationId = (String) requestPayload.get("reservationId");
                 com.vodafone.global.er.business.charging.UsageCompleteAttributes att = (com.vodafone.global.er.business.charging.UsageCompleteAttributes) requestPayload.get("att");
                 usageCompleteHandler(locale, resp  ,clientApplicationId  ,reservationId  ,att );
           }
           if (methodName.equals("validatePromoCode9")) {               
                 PromoCodeAttributes promoCodeAttrs = (PromoCodeAttributes) requestPayload.get("promoCodeAttrs");
                 validatePromoCodeHandler(locale, resp  ,promoCodeAttrs );
           }
           logEcomResponse(clientApplicationId, locale, methodName, CHARGING_API.getValue(), true);
       }
       catch (Exception e) {         
          try
           {
               //TODO log exception to the application logs here
            ObjectOutputStream oostream = new ObjectOutputStream (new BufferedOutputStream (resp.getOutputStream()));
            oostream.writeObject( new ExceptionAdapter(e));
            oostream.flush();
           } catch(IOException  ioe)
             {
               log.error(ioe.getMessage(),ioe);
             }
       }
    }

    public void usageAuthHandler(Locale locale, HttpServletResponse resp ,String clientApplicationId  ,String msisdn  ,String serviceId  ,UsageAttributes usageAttributes ) {
        ObjectOutputStream oos = null;
        try {            
            UsageAuthorization result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {

                final Optional<Boolean> shouldProxy = getPropertyAsBoolean(PROP_USAGE_AUTH1.value(), true);
                if(shouldProxy.isPresent() && shouldProxy.get()) {
                    result = chargingApiService.usageAuth(locale, clientApplicationId,msisdn,serviceId,usageAttributes);
                } else {
                    result = getChargingApiDelegate(locale).usageAuth(clientApplicationId, msisdn, serviceId, usageAttributes);
                }
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

    public void usageAuthRateHandler(Locale locale, HttpServletResponse resp ,String clientApplicationId  ,String msisdn  ,String serviceId  ,UsageAttributes usageAttributes ) {
        ObjectOutputStream oos = null;
        try {            
            UsageAuthorization result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                Optional<Boolean> shouldProxy = PropertyService.getPropertyAsBoolean(PROP_USAGE_AUTH_RATE2.value(), true);
                if(shouldProxy.isPresent() && shouldProxy.get()) {
                    result = chargingApiService.usageAuthRate(locale, clientApplicationId,msisdn,serviceId,usageAttributes);
                } else {
                    result = getChargingApiDelegate(locale)
                            .usageAuthRate(clientApplicationId, msisdn, serviceId, usageAttributes);
                }
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

    public void usageAuthRateChargeHandler(Locale locale, HttpServletResponse resp ,String clientApplicationId  ,String msisdn  ,String serviceId  ,UsageAttributes usageAttributes ) {
        ObjectOutputStream oos = null;
        try {            
            UsageAuthorization result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                Optional<Boolean> shouldProxy = PropertyService.getPropertyAsBoolean(PROP_USAGE_AUTH_RATE_CHARGE3.value(), true);
                if(shouldProxy.isPresent() && shouldProxy.get()) {
                    result = chargingApiService.usageAuthRateCharge(locale, clientApplicationId, msisdn, serviceId, usageAttributes);
                } else {
                    result = getChargingApiDelegate(locale).usageAuthRateCharge(clientApplicationId, msisdn, serviceId, usageAttributes);
                }
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

    public void usageCompleteHandler(Locale locale, HttpServletResponse resp ,String clientApplicationId  ,String eventReservationId  ,int deliveryStatus ) {
        ObjectOutputStream oos = null;
        try {            
            UsageAuthorization result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                Optional<Boolean> shouldProxy = getPropertyAsBoolean(PROP_USAGE_COMPLETE4.value(), true);
                if(shouldProxy.isPresent() && shouldProxy.get()) {
                    result = chargingApiService.usageComplete(locale, eventReservationId, deliveryStatus);
                } else {
                    result = getChargingApiDelegate(locale).usageComplete(clientApplicationId, eventReservationId, deliveryStatus);
                }
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

    @SuppressWarnings("deprecation")
	public void rateServiceHandler(Locale locale, HttpServletResponse resp ,String clientApplicationId  ,String serviceId  ,UsageAttributes usageAttributes ) {
        ObjectOutputStream oos = null;
        try {            
            com.vizzavi.ecommerce.business.catalog.CatalogService result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getChargingApiDelegate(locale).rateService(clientApplicationId,serviceId,usageAttributes);
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

    public void usageCompleteHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String reservationId  ,com.vodafone.global.er.business.charging.UsageCompleteAttributes att ) {
        ObjectOutputStream oos = null;
        try {            
            UsageAuthorization result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getChargingApiDelegate(locale).usageComplete(clientId,reservationId,att);
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

    public void validatePromoCodeHandler(Locale locale, HttpServletResponse resp ,PromoCodeAttributes promoCodeAttrs ) {
        ObjectOutputStream oos = null;
        try {            
            PromoCodeValidation result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getChargingApiDelegate(locale).validatePromoCode(promoCodeAttrs);
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

	private ChargingApi getChargingApiDelegate(Locale locale) throws EcommerceException {
        return EcomApiFactory.getChargingApi(locale);
	}
}
