package com.vodafone.er.ecom.proxy;

import com.vizzavi.ecommerce.business.catalog.CatalogPackage;
import com.vizzavi.ecommerce.business.charging.*;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vodafone.er.ecom.proxy.context.ApplicationContextHolder;
import com.vodafone.er.ecom.proxy.service.PurchaseApiService;
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

import static com.vodafone.er.ecom.proxy.enums.PropertiesConstantsEnum.PROP_PURCHASE_PACKAGE_MSISDN1;
import static com.vodafone.er.ecom.proxy.enums.PropertiesConstantsEnum.PROP_RENEW_PURCHASE_PACKAGE_MSISDN3;
import static com.vodafone.er.ecom.proxy.properties.PropertyService.getPropertyAsBoolean;
import static com.vodafone.global.er.endpoint.ApiNamesEnum.PURCHASE_API;

public class PurchaseApiServlet extends AbstractEcomServlet {

    private static final long	serialVersionUID	= -5298650083905760799L;
    //CR1231
    //private static LWLogger log = LWSupportFactoryImpl.getInstance().getLogger(PurchaseApiServlet.class);
    private static Logger log = Logger.getLogger(PurchaseApiServlet.class);

    private PurchaseApiService purchaseApiService;

    public PurchaseApiServlet() {
        purchaseApiService = ApplicationContextHolder.getContext().getBean(PurchaseApiService.class);
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
            String clientId = (String) requestPayload.get("clientId");
            log(clientId, locale, methodName, PURCHASE_API.getValue());
            //CR 2199 Add msisdn to context
            final String msisdn = (String) requestPayload.get("msisdn");
            logRequest(new ERLogDataImpl(msisdn, clientId, methodName, locale.getCountry()) );
            if (methodName.equals("purchasePackageMsisdn1")) {
                String clientApplicationId = (String) requestPayload.get("clientApplicationId");
                //String msisdn = (String) requestPayload.get("msisdn");
                String packageId = (String) requestPayload.get("packageId");
                PurchaseAttributes purchaseAttributes = (PurchaseAttributes) requestPayload.get("purchaseAttributes");
                purchasePackageMsisdnHandler(locale, resp  ,clientApplicationId  ,msisdn  ,packageId  ,purchaseAttributes );
            }
            if (methodName.equals("ratePackage2")) {
                String clientApplicationId = (String) requestPayload.get("clientApplicationId");
                //String msisdn = (String) requestPayload.get("msisdn");
                String packageId = (String) requestPayload.get("packageId");
                PurchaseAttributes purchaseAttributes = (PurchaseAttributes) requestPayload.get("purchaseAttributes");
                ratePackageHandler(locale, resp  ,clientApplicationId  ,msisdn  ,packageId  ,purchaseAttributes );
            }
            if (methodName.equals("renewPurchasePackageMsisdn3")) {
                String clientApplicationId = (String) requestPayload.get("clientApplicationId");
                //String msisdn = (String) requestPayload.get("msisdn");
                String packageSubscriptionId = (String) requestPayload.get("packageSubscriptionId");
                PurchaseAttributes purchaseAttributes = (PurchaseAttributes) requestPayload.get("purchaseAttributes");
                renewPurchasePackageMsisdnHandler(locale, resp  ,clientApplicationId  ,msisdn  ,packageSubscriptionId  ,purchaseAttributes );
            }
            if (methodName.equals("confirmPurchasePackagePending4")) {
                String clientApplicationId = (String) requestPayload.get("clientApplicationId");
                //String msisdn = (String) requestPayload.get("msisdn");
                String paymentId = (String) requestPayload.get("paymentId");
                int authResult =  ((Integer) requestPayload.get("authResult")).intValue();
                String authCode = (String) requestPayload.get("authCode");
                confirmPurchasePackagePendingHandler(locale, resp  ,clientApplicationId  ,msisdn  ,paymentId  ,authResult  ,authCode );
            }
            if (methodName.equals("checkUserHasPackageWithPromoCode5")) {
                String clientApplicationId = (String) requestPayload.get("clientApplicationId");
                //String msisdn = (String) requestPayload.get("msisdn");
                String packageId = (String) requestPayload.get("packageId");
                String promoCode = (String) requestPayload.get("promoCode");
                checkUserHasPackageWithPromoCodeHandler(locale, resp  ,clientApplicationId  ,msisdn  ,packageId  ,promoCode );
            }
            if (methodName.equals("validatePromoCode6")) {
                ValidatePromoParam vpParam = (ValidatePromoParam) requestPayload.get("vpParam");
                validatePromoCodeHandler(locale, resp  ,vpParam );
            }
            //CR-0978 Location Services
            if (methodName.equals("modifyTariff7")) {
                //String msisdn = (String) requestPayload.get("msisdn");
                ModifyTariffAttributes modifyTariffAttributes = (ModifyTariffAttributes) requestPayload.get("modifyTariffAttributes");
                modifyTariffHandler(locale, resp  ,msisdn  ,modifyTariffAttributes );
            }
//           if (methodName.equals("goodwillCredit9")) {
//        	   String msisdn = (String) requestPayload.get("msisdn");
//        	   String partnerId = (String) requestPayload.get("partnerId");
//        	   String merchantId = (String) requestPayload.get("merchantId");
//        	   String packageId = (String) requestPayload.get("packageId");
//        	   double preRate =  ((Double) requestPayload.get("preRate")).doubleValue();
//        	   goodwillCreditHandler(locale, resp  ,clientId  ,msisdn  ,partnerId  ,merchantId  ,packageId  ,preRate );
//           }
        }
        catch (Exception e) {
            try
            {
                ObjectOutputStream oostream = new ObjectOutputStream (new BufferedOutputStream (resp.getOutputStream()));
                oostream.writeObject( new ExceptionAdapter(e));
                oostream.flush();
            } catch(IOException  ioe)
            {
                log.error(ioe.getMessage(),ioe);
            }
        }	finally	{
            logResponse();
        }
    }

    public void purchasePackageMsisdnHandler(Locale locale, HttpServletResponse resp ,String clientApplicationId  ,String msisdn  ,String packageId  ,PurchaseAttributes purchaseAttributes ) {
        ObjectOutputStream oos = null;
        try {
            PurchaseAuthorization result = null;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));

            try {
                final Optional<Boolean> shouldProxy =
                        getPropertyAsBoolean(PROP_PURCHASE_PACKAGE_MSISDN1.value(), true);
                if(shouldProxy.isPresent() && shouldProxy.get()) {
                    result = purchaseApiService.purchasePackageMsisdn(locale, clientApplicationId, msisdn, packageId, purchaseAttributes);
                } else {
                    result = EcomApiFactory.getPurchaseApi(locale).purchasePackageMsisdn(clientApplicationId,msisdn,packageId,purchaseAttributes);
                }
            }
            catch (Exception e1) {
                // Commit the transaction here as it will be committed in doPost anyway but we need to commit
                // before sending a response.

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

    public void ratePackageHandler(Locale locale, HttpServletResponse resp ,String clientApplicationId  ,String msisdn  ,String packageId  ,PurchaseAttributes purchaseAttributes ) {
        ObjectOutputStream oos = null;
        try {
            CatalogPackage result = null;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getPurchaseApiDelegate(locale).ratePackage(clientApplicationId,msisdn,packageId,purchaseAttributes);

            }
            catch (Exception e1) {
                // Commit the transaction here as it will be committed in doPost anyway but we need to commit
                // before sending a response.

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

    public void renewPurchasePackageMsisdnHandler(Locale locale, HttpServletResponse resp ,String clientApplicationId  ,String msisdn  ,String packageSubscriptionId  ,PurchaseAttributes purchaseAttributes ) {
        ObjectOutputStream oos = null;
        try {
            PurchaseAuthorization result = null;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                final Optional<Boolean> shouldProxy =
                        getPropertyAsBoolean(PROP_RENEW_PURCHASE_PACKAGE_MSISDN3.value(), true);
                if(shouldProxy.isPresent() && shouldProxy.get()) {
                    result = purchaseApiService.renewPurchasePackageMsisdn(locale, clientApplicationId, msisdn, packageSubscriptionId, purchaseAttributes);

                } else {
                    result = getPurchaseApiDelegate(locale).renewPurchasePackageMsisdn(clientApplicationId,msisdn,packageSubscriptionId,purchaseAttributes);
                }
            }
            catch (Exception e1) {
                // Commit the transaction here as it will be committed in doPost anyway but we need to commit
                // before sending a response.

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

    public void confirmPurchasePackagePendingHandler(Locale locale, HttpServletResponse resp ,String clientApplicationId  ,String msisdn  ,String paymentId  ,int authResult  ,String authCode ) {
        ObjectOutputStream oos = null;
        try {
            PurchaseAuthorization result = null;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getPurchaseApiDelegate(locale).confirmPurchasePackagePending(clientApplicationId,msisdn,paymentId,authResult,authCode);

            }
            catch (Exception e1) {
                // Commit the transaction here as it will be committed in doPost anyway but we need to commit
                // before sending a response.

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
    public void checkUserHasPackageWithPromoCodeHandler(Locale locale, HttpServletResponse resp ,String clientApplicationId  ,String msisdn  ,String packageId  ,String promoCode ) {
        ObjectOutputStream oos = null;
        try {
            boolean result = false;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getPurchaseApiDelegate(locale).checkUserHasPackageWithPromoCode(clientApplicationId,msisdn,packageId,promoCode);

            }
            catch (Exception e1) {
                // Commit the transaction here as it will be committed in doPost anyway but we need to commit
                // before sending a response.

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

    public void validatePromoCodeHandler(Locale locale, HttpServletResponse resp ,ValidatePromoParam vpParam ) {
        ObjectOutputStream oos = null;
        try {
            ValidatePromoStatus result = null;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getPurchaseApiDelegate(locale).validatePromoCode(vpParam);

            }
            catch (Exception e1) {
                // Commit the transaction here as it will be committed in doPost anyway but we need to commit
                // before sending a response.

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

    //CR-0978 Location Services
    public void modifyTariffHandler(Locale locale, HttpServletResponse resp ,String msisdn, ModifyTariffAttributes modifyTariffAttributes ) {
        ObjectOutputStream oos = null;
        try {
            ModifyTariffAuthorization result = null;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getPurchaseApiDelegate(locale).modifyTariff(msisdn, modifyTariffAttributes);

            }
            catch (Exception e1) {
                // Commit the transaction here as it will be committed in doPost anyway but we need to commit
                // before sending a response.

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

    private PurchaseApi getPurchaseApiDelegate(Locale locale) throws EcommerceException {
        return EcomApiFactory.getPurchaseApi(locale);
    }

}
