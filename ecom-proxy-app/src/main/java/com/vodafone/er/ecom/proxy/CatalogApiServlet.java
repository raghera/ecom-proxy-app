package com.vodafone.er.ecom.proxy;

import com.vizzavi.ecommerce.business.catalog.*;
import com.vizzavi.ecommerce.business.charging.PurchaseAttributes;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vodafone.er.ecom.proxy.properties.PropertyService;
import com.vodafone.er.ecom.proxy.service.CatalogApiService;
import com.vodafone.global.er.data.ERLogDataImpl;
import com.vodafone.global.er.translog.TransLogManagerFactory;
import com.vodafone.global.er.util.ExceptionAdapter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

import static com.vodafone.er.ecom.proxy.enums.PropertiesConstantsEnum.*;
import static com.vodafone.er.ecom.proxy.properties.PropertyService.getPropertyAsBoolean;
import static com.vodafone.global.er.endpoint.ApiNamesEnum.CATALOG_API;

@Component
public class CatalogApiServlet extends AbstractEcomServlet {

	private static final long	serialVersionUID	= -6442503512252653351L;
    private static Logger log = Logger.getLogger(CatalogApiServlet.class);

    @Autowired //TODO get Spring DI to work
    private CatalogApiService catalogApiService = new CatalogApiService();

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
           String msisdn = (String) requestPayload.get("msisdn");

            log(clientId, locale, methodName, CATALOG_API.getValue());
           logRequest(new ERLogDataImpl(msisdn, clientId, methodName, locale.getCountry()) );


           if (methodName.equals("getService1")) {
                 String id = (String) requestPayload.get("id");
                 getServiceHandler(locale, resp  ,id );
           }
           if (methodName.equals("getPackage2")) {
                 String id = (String) requestPayload.get("id");
                 getPackageHandler(locale, resp  ,id );
           }
           if (methodName.equals("getPackage3")) {
                 String packageId = (String) requestPayload.get("packageId");
                 String rateIdentifier = (String) requestPayload.get("rateIdentifier");
                 getPackageHandler(locale, resp  ,packageId  ,rateIdentifier );
           }
           if (methodName.equals("getPackage4")) {
                 String packageId = (String) requestPayload.get("packageId");
                 String pricePointId = (String) requestPayload.get("pricePointId");
                 String tierId = (String) requestPayload.get("tierId");
                 getPackageHandler(locale, resp  ,packageId  ,pricePointId  ,tierId );
           }
           if (methodName.equals("getPackages5")) {
                 getPackagesHandler(locale, resp );
           }
           if (methodName.equals("getServices6")) {
                 getServicesHandler(locale, resp );
           }
           if (methodName.equals("findPackagesWithService7")) {
                 CatalogService catalogService = (CatalogService) requestPayload.get("catalogService");
                 findPackagesWithServiceHandler(locale, resp  ,catalogService );
           }
           if (methodName.equals("findPackagesWithService8")) {
                 CatalogService serv = (CatalogService) requestPayload.get("serv");
                 com.vizzavi.ecommerce.business.charging.PurchaseAttributes purchaseAttributes = (com.vizzavi.ecommerce.business.charging.PurchaseAttributes) requestPayload.get("purchaseAttributes");
                 findPackagesWithServiceHandler(locale, resp  ,serv  ,purchaseAttributes );
           }
           if (methodName.equals("findPackagesWithService9")) {
                 //String msisdn = (String) requestPayload.get("msisdn");
                 CatalogService serv = (CatalogService) requestPayload.get("serv");
                 com.vizzavi.ecommerce.business.charging.PurchaseAttributes purchaseAttributes = (com.vizzavi.ecommerce.business.charging.PurchaseAttributes) requestPayload.get("purchaseAttributes");
                 findPackagesWithServiceHandler(locale, resp  ,msisdn  ,serv  ,purchaseAttributes );
           }
           if (methodName.equals("getVersion10")) {
                 getVersionHandler(locale, resp );
           }
           if (methodName.equals("getPricePoint11")) {
                 String pricePointId = (String) requestPayload.get("pricePointId");
                 getPricePointHandler(locale, resp  ,pricePointId );
           }
           if (methodName.equals("getLocale12")) {
                 getLocaleHandler(locale, resp );
           }
           if (methodName.equals("getTax13")) {
                 String name = (String) requestPayload.get("name");
                 getTaxHandler(locale, resp  ,name );
           }
           if (methodName.equals("checkPromotions14")) {
                 //String msisdn = (String) requestPayload.get("msisdn");
                 CatalogService service = (CatalogService) requestPayload.get("service");
                 checkPromotionsHandler(locale, resp  ,msisdn  ,service );
           }
//           if (methodName.equals("getDRMObject15")) {
//                 String drmid = (String) requestPayload.get("drmid");
//                 getDRMObjectHandler(locale, resp  ,drmid );
//           }
//           if (methodName.equals("getDRMObjects16")) {
//                 getDRMObjectsHandler(locale, resp );
//           }
           if (methodName.equals("findExpressPackagesByServiceId17")) {
                 String[] serviceId = (String[]) requestPayload.get("serviceId");
                boolean headline =  ((Boolean) requestPayload.get("headline")).booleanValue();
                 findExpressPackagesByServiceIdHandler(locale, resp  ,serviceId  ,headline );
           }
//           if (methodName.equals("getLocaleKey18")) {
//                 getLocaleKeyHandler(locale, resp );
//           }
           if (methodName.equals("findExpressPackagesByServiceId19")) {
                 String[] serviceId = (String[]) requestPayload.get("serviceId");
                 //String msisdn = (String) requestPayload.get("msisdn");
                 ExpressDisplayAttribute expressAttribute = (ExpressDisplayAttribute) requestPayload.get("expressAttribute");
                 findExpressPackagesByServiceIdHandler(locale, resp  ,serviceId  ,msisdn  ,expressAttribute );
           }
           if (methodName.equals("getBasePrices20")) {
                 String[] serviceId = (String[]) requestPayload.get("serviceId");
                 getBasePricesHandler(locale, resp  ,serviceId );
           }
           if (methodName.equals("validateService21")) {
                 String id = (String) requestPayload.get("id");
                 validateServiceHandler(locale, resp  ,id );
           }
           if (methodName.equals("translatePricingText22")) {
                 PricePoint[] pricePoints = (PricePoint[]) requestPayload.get("pricePoints");
                 String templateName = (String) requestPayload.get("templateName");
                 translatePricingTextHandler(locale, resp  ,pricePoints  ,templateName );
           }
           if (methodName.equals("translatePricingText23")) {
                 PricePoint[] pricePoints = (PricePoint[]) requestPayload.get("pricePoints");
                 String templateName = (String) requestPayload.get("templateName");
                 String languageCode = (String) requestPayload.get("languageCode");
                int RoamingType =  ((Integer) requestPayload.get("RoamingType")).intValue();
                 translatePricingTextHandler(locale, resp  ,pricePoints  ,templateName  ,languageCode  ,RoamingType );
           }
           if (methodName.equals("isUniquePromoPrecode24")) {
                 String precode = (String) requestPayload.get("precode");
                 isUniquePromoPrecodeHandler(locale, resp  ,precode );
           }
           if (methodName.equals("getTariff25")) {
               String tariffName = (String) requestPayload.get("tariffName");
               getTariffHandler(locale, resp  ,tariffName );
           }
           //MQC 5843
           if (methodName.equals("findPackagesWithServiceEx26")) {
               //String msisdn = (String) requestPayload.get("msisdn");
               CatalogService serv = (CatalogService) requestPayload.get("serv");
               com.vizzavi.ecommerce.business.charging.PurchaseAttributes purchaseAttributes = (com.vizzavi.ecommerce.business.charging.PurchaseAttributes) requestPayload.get("purchaseAttributes");
                findPackagesWithServiceExHandler(locale, resp, msisdn, serv, purchaseAttributes);
            }
           //CR1923 Partner Trading Limit
           if (methodName.equals("getPartnerTradingLimits27")) {
               getPartnerTradingLimitsHandler(locale, resp );
           }
           if (methodName.equals("getPartnerTradingLimit28")) {
               String partnerId = (String) requestPayload.get("partnerId");
               getPartnerTradingLimitHandler(locale, resp  ,partnerId );
           }
           if (methodName.equals("findPackagesByServiceIdOneStep29")) {
               String[] serviceId = (String[]) requestPayload.get("serviceId");
               //String msisdn = (String) requestPayload.get("msisdn");
                findPackagesByServiceIdOneStepHandler(locale, resp, serviceId, msisdn);
            }
           if (methodName.equals("getOverallGoodwillCreditLimits35")) {
                 getOverallGoodwillCreditLimitsHandler(locale, resp );
           }
       } catch (Exception e) {
    		try	{
    			ObjectOutputStream oostream = new ObjectOutputStream (new BufferedOutputStream (resp.getOutputStream()));
    			oostream.writeObject( new ExceptionAdapter(e));
    			oostream.flush();
    		} catch(IOException ioe)	{
    			log.error(ioe.getMessage(),ioe);
    		}
    	}	finally	{
    		logResponse();

    		TransLogManagerFactory.getInstance().andFinally();
    	}
    }


    public void getServiceHandler(Locale locale, HttpServletResponse resp ,String id ) {
        ObjectOutputStream oos = null;
        try {
            CatalogService result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));

            final Optional<Boolean> shouldProxy = getPropertyAsBoolean(PROP_GET_SERVICE1.value(), true);
            try {
                if(shouldProxy.isPresent() && shouldProxy.get()) {
                    result = catalogApiService.getCatalogService(locale, id);
                } else {
                    result = EcomApiFactory.getCatalogApi(locale).getService(id);
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

    public CatalogApi getCatalogEcomClient(Locale locale) throws EcommerceException {
        return EcomApiFactory.getCatalogApi(locale);
    }

    //Actually calls decoupling api and not the Ecom
	public void getPackageHandler(final Locale locale, final HttpServletResponse resp, String id) {
        ObjectOutputStream oos = null;
        try {
            CatalogPackage result;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));

            final Optional<Boolean> shouldProxy =
                    getPropertyAsBoolean(PROP_GET_PACKAGE2.value(), true);
            try {
                if(shouldProxy.isPresent() && shouldProxy.get()) {
                    result = catalogApiService.getCatalogPackage(locale, id);
                } else {
                    result = EcomApiFactory.getCatalogApi(locale).getPackage(id);
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


	/**
	 *
	 * @param locale
	 * @param resp
	 * @param packageId
	 * @param rateIdentifier (not used)
	 */
	public void getPackageHandler(Locale locale, HttpServletResponse resp ,String packageId  ,String rateIdentifier ) {
        ObjectOutputStream oos = null;
        try {
            CatalogPackage result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCatalogEcomClient(locale).getPackage(packageId);
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
	public void getPackageHandler(Locale locale, HttpServletResponse resp ,String packageId  ,String pricePointId  ,String tierId ) {
        ObjectOutputStream oos = null;
        try {
            CatalogPackage result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCatalogEcomClient(locale).getPackage(packageId,pricePointId,tierId);
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

    public void getPackagesHandler(Locale locale, HttpServletResponse resp) {
        ObjectOutputStream oos = null;
        try {
            CatalogPackage[] result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                Optional<Boolean> shouldProxy = PropertyService.getPropertyAsBoolean(PROP_GET_PACKAGES5.value(), true);
                if(shouldProxy.isPresent() && shouldProxy.get()) {
                    result = catalogApiService.getPackages(locale);
                } else {
                    result = getCatalogEcomClient(locale).getPackages();
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

    public void getServicesHandler(Locale locale, HttpServletResponse resp) {
        ObjectOutputStream oos = null;
        try {
            CatalogService[] result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCatalogEcomClient(locale).getServices();
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

    public void findPackagesWithServiceHandler(Locale locale, HttpServletResponse resp ,CatalogService catalogService ) {
        ObjectOutputStream oos = null;
        try {
            CatalogPackage[] result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {

                Optional<Boolean> shouldProxy = PropertyService.getPropertyAsBoolean(PROP_FIND_PACKAGES_WITH_SERVICE7.value(), true);
                if(shouldProxy.isPresent() && shouldProxy.get()) {
                    result = catalogApiService.processFindPackagesWithService(locale, null, catalogService, new PurchaseAttributes());
                } else {
                    result = getCatalogEcomClient(locale).findPackagesWithService(catalogService);
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

    public void findPackagesWithServiceHandler(Locale locale, HttpServletResponse resp ,CatalogService serv  ,com.vizzavi.ecommerce.business.charging.PurchaseAttributes purchaseAttributes ) {
        ObjectOutputStream oos = null;
        try {
            CatalogPackage[] result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                //Actually calls exactly the same api underneath as FPWS9
                Optional<Boolean> shouldProxy = PropertyService.getPropertyAsBoolean(PROP_FIND_PACKAGES_WITH_SERVICE8.value(), true);
                if(shouldProxy.isPresent() && shouldProxy.get()) {
                    result = catalogApiService.processFindPackagesWithService(locale, null, serv, purchaseAttributes);
                } else {
                    result = getCatalogEcomClient(locale).findPackagesWithService(null, serv, purchaseAttributes);
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

    public void findPackagesWithServiceHandler(Locale locale, HttpServletResponse resp ,String msisdn  ,CatalogService serv  ,com.vizzavi.ecommerce.business.charging.PurchaseAttributes purchaseAttributes ) {
        ObjectOutputStream oos = null;
        try {
            CatalogPackage[] result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                Optional<Boolean> shouldProxy = PropertyService.getPropertyAsBoolean(PROP_FIND_PACKAGES_WITH_SERVICE9.value(), true);
                if(shouldProxy.isPresent() && shouldProxy.get()) {
                    result = catalogApiService.processFindPackagesWithService(locale, msisdn,serv,purchaseAttributes);
                } else {
                    result = getCatalogEcomClient(locale).findPackagesWithService(msisdn,serv,purchaseAttributes);
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

    public void getVersionHandler(Locale locale, HttpServletResponse resp) {
        ObjectOutputStream oos = null;
        try {
            String result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                Optional<Boolean> shouldProxy = getPropertyAsBoolean(PROP_GET_VERSION10.value(), true);
                if(shouldProxy.isPresent() && shouldProxy.get()) {
                    result = catalogApiService.getVersion(locale);
                } else {
                    result = getCatalogEcomClient(locale).getVersion();
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

	public void getPricePointHandler(Locale locale, HttpServletResponse resp ,String pricePointId ) {
        ObjectOutputStream oos = null;
        try {
            PricePoint result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCatalogEcomClient(locale).getPricePoint(pricePointId);
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

    public void getLocaleHandler(Locale locale, HttpServletResponse resp) {
        ObjectOutputStream oos = null;
        try {
            java.util.Locale result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCatalogEcomClient(locale).getLocale();
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

    public void getTaxHandler(Locale locale, HttpServletResponse resp ,String name ) {
        ObjectOutputStream oos = null;
        try {
            Tax result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCatalogEcomClient(locale).getTax(name);
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

    public void checkPromotionsHandler(Locale locale, HttpServletResponse resp ,String msisdn  ,CatalogService service ) {
        ObjectOutputStream oos = null;
        try {
            PromotionsResult result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCatalogEcomClient(locale).checkPromotions(msisdn,service);
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



	public void findExpressPackagesByServiceIdHandler(Locale locale, HttpServletResponse resp ,String[] serviceId  ,boolean headline ) {
        ObjectOutputStream oos = null;
        try {
            Map<String, ExpressData> result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCatalogEcomClient(locale).findExpressPackagesByServiceId(serviceId,headline);
            }
            catch (Exception e1) {
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            // send response
            resp.setStatus(HttpServletResponse.SC_OK);
            //APIs refactored to produce Maps - so wrap it in a Hashtable here for ecom clients
            oos.writeObject(new Hashtable<String, ExpressData>(result));
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

//    public void getLocaleKeyHandler(Locale locale, HttpServletResponse resp) {
//        ObjectOutputStream oos = null;
//        try {
//            long result = 0;
//            oos = new ObjectOutputStream (
//                               new BufferedOutputStream (resp.getOutputStream()));
//            try {
//                result = getCatalogEcomClient(locale).getLocaleKey();
//            }
//            catch (Exception e1) {
//                oos.writeObject( new ExceptionAdapter(e1));
//                oos.flush();
//                return;
//            }
//            // send response
//            resp.setStatus(HttpServletResponse.SC_OK);
//            oos.writeLong(result);
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

    public void findExpressPackagesByServiceIdHandler(Locale locale, HttpServletResponse resp ,String[] serviceId  ,String msisdn  ,ExpressDisplayAttribute expressAttribute ) {
        ObjectOutputStream oos = null;
        try {
            Map<String, ExpressData> result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCatalogEcomClient(locale).findExpressPackagesByServiceId(serviceId,msisdn,expressAttribute);
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

    public void getBasePricesHandler(Locale locale, HttpServletResponse resp ,String[] serviceId ) {
        ObjectOutputStream oos = null;
        try {
            com.vodafone.global.er.business.catalog.BasePrice[] result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                Optional<Boolean> shouldProxy = PropertyService.getPropertyAsBoolean(PROP_GET_BASE_PRICES20.value(), true);
                if(shouldProxy.isPresent() && shouldProxy.get()) {
                    result = catalogApiService.getBasePrices(locale, serviceId);
                } else {
                    result = getCatalogEcomClient(locale).getBasePrices(serviceId);
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

    public void validateServiceHandler(Locale locale, HttpServletResponse resp ,String id ) {
        ObjectOutputStream oos = null;
        try {
            boolean result = false;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCatalogEcomClient(locale).validateService(id);
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

    public void translatePricingTextHandler(Locale locale, HttpServletResponse resp ,PricePoint[] pricePoints  ,String templateName ) {
        ObjectOutputStream oos = null;
        try {
            String result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
//                result = getCatalogEcomClient(locale).translatePricingText(pricePoints,templateName);
//                result = new PricingToolCatalogApiFacade(locale, false).translatePricingText(pricePoints,templateName);
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

    public void translatePricingTextHandler(Locale locale, HttpServletResponse resp ,PricePoint[] pricePoints  ,String templateName  ,String languageCode  ,int RoamingType ) {
        ObjectOutputStream oos = null;
        try {
            String result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCatalogEcomClient(locale).translatePricingText(pricePoints,templateName,languageCode,RoamingType);
                //result = new PricingToolCatalogApiFacade(locale, false).translatePricingText(pricePoints,templateName,languageCode,RoamingType);

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

    public void isUniquePromoPrecodeHandler(Locale locale, HttpServletResponse resp ,String precode ) {
        ObjectOutputStream oos = null;
        try {
            boolean result = false;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCatalogEcomClient(locale).isUniquePromoPrecode(precode);
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

    public void getTariffHandler(Locale locale, HttpServletResponse resp ,String tariffName ) {
        ObjectOutputStream oos = null;
        try {
            Tariff result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCatalogEcomClient(locale).getTariff(tariffName);
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

    //MQC 5843
    public void findPackagesWithServiceExHandler(Locale locale, HttpServletResponse resp ,String msisdn  ,CatalogService serv  ,com.vizzavi.ecommerce.business.charging.PurchaseAttributes purchaseAttributes ) {
        ObjectOutputStream oos = null;
        try {
            PurchaseOptionsAuthorization result = null;
            oos = new ObjectOutputStream(new BufferedOutputStream(resp.getOutputStream()));
            try {
                result = getCatalogEcomClient(locale).findPackagesWithServiceEx(msisdn, serv, purchaseAttributes);
            } catch (Exception e1) {
                oos.writeObject(new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            // send response
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
            try {
                log(e2.getMessage(), e2);
                oos = new ObjectOutputStream(new BufferedOutputStream(resp.getOutputStream()));
                oos.writeObject(new ExceptionAdapter(e2));
                oos.flush();
            } catch (IOException excep) {
                log.error(excep.getMessage(), excep);
            }
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException excep1) {
                    log.error(excep1.getMessage(), excep1);
                }
            }
        }
    }

    //CR1923 Partner Trading Limit
    public void getPartnerTradingLimitsHandler(Locale locale, HttpServletResponse resp) {
        ObjectOutputStream oos = null;
        try {
            PartnerTradingLimit[] result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCatalogEcomClient(locale).getPartnerTradingLimits();
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

    //CR1923 Partner Trading Limit
    public void getPartnerTradingLimitHandler(Locale locale, HttpServletResponse resp ,String partnerId ) {
        ObjectOutputStream oos = null;
        try {
            PartnerTradingLimit result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCatalogEcomClient(locale).getPartnerTradingLimit(partnerId);
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

    public void findPackagesByServiceIdOneStepHandler(Locale locale, HttpServletResponse resp ,String[] serviceId  ,String msisdn  ) {

        ObjectOutputStream oos = null;
        try {
            Map<String, OneStepData> result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getCatalogEcomClient(locale).findPackagesByServiceIdOneStep(serviceId,msisdn);
            }
            catch (Exception e1) {
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            // send response
            resp.setStatus(HttpServletResponse.SC_OK);
            //APIs refactored to produce Maps - so wrap it in a Hashtable here for ecom clients
            oos.writeObject(new Hashtable<String, OneStepData>(result));
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

    public void getOverallGoodwillCreditLimitsHandler(Locale locale, HttpServletResponse resp) {
        ObjectOutputStream oos = null;
        try {
            OverallGoodwillCreditLimits result = null;
            oos = new ObjectOutputStream (
                               new BufferedOutputStream (resp.getOutputStream()));
            try {
				result = getCatalogEcomClient(locale).getOverallGoodwillCreditLimits();
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
