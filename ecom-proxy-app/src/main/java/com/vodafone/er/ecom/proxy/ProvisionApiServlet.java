package com.vodafone.er.ecom.proxy;

import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vizzavi.ecommerce.business.provision.ProvisionApi;
import com.vodafone.er.ecom.proxy.context.ApplicationContextHolder;
import com.vodafone.er.ecom.proxy.properties.PropertyService;
import com.vodafone.er.ecom.proxy.service.LogService;
import com.vodafone.er.ecom.proxy.service.ProvisionApiService;
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

import static com.vodafone.er.ecom.proxy.enums.PropertiesConstantsEnum.PROP_UPDATE_SERVICE_STATUS1;
import static com.vodafone.global.er.endpoint.ApiNamesEnum.PROVISION_API;

public class ProvisionApiServlet extends AbstractEcomServlet {

    private static final long	serialVersionUID	= 7730131820760083128L;
    private static Logger log = Logger.getLogger(ProvisionApiServlet.class);

    private ProvisionApiService provisionApiService;
    private LogService logService;

    public ProvisionApiServlet() {
        provisionApiService = ApplicationContextHolder.getContext().getBean(ProvisionApiService.class);
        logService = ApplicationContextHolder.getContext().getBean(LogService.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        Locale locale;
        String methodName, clientId, msisdn;
        try {
            startTx();
            ServletInputStream is = req.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            @SuppressWarnings("unchecked")
            HashMap<String, Serializable> requestPayload = (HashMap<String, Serializable>) ois.readObject();
            locale = (Locale)requestPayload.get("locale");
            methodName = (String) requestPayload.get("methodName");
            clientId = (String) requestPayload.get("clientId");
            msisdn = (String) requestPayload.get("msisdn");
            logService.logRequestIn(new ERLogDataImpl(msisdn, clientId, methodName, locale.getCountry(), PROVISION_API.getValue()));

            if (methodName.equals("updateServiceStatus1")) {
                String provisioningId = (String) requestPayload.get("provisioningId");
                int serviceStatus =  ((Integer) requestPayload.get("serviceStatus")).intValue();
                int provisioningStatus =  ((Integer) requestPayload.get("provisioningStatus")).intValue();
                updateServiceStatusHandler(locale, resp  ,provisioningId  ,serviceStatus  ,provisioningStatus );
            }
            if (methodName.equals("updateServiceStatus2")) {
                String provisioningId = (String) requestPayload.get("provisioningId");
                int serviceStatus =  ((Integer) requestPayload.get("serviceStatus")).intValue();
                int provisioningStatus =  ((Integer) requestPayload.get("provisioningStatus")).intValue();
                String provisioningTag = (String) requestPayload.get("provisioningTag");
                updateServiceStatusHandler(locale, resp  ,provisioningId  ,serviceStatus  ,provisioningStatus  ,provisioningTag );
            }
            if (methodName.equals("updateProvisioningTag3")) {
                String subscriptionId = (String) requestPayload.get("subscriptionId");
                String serviceId = (String) requestPayload.get("serviceId");
                String newProvisioningTag = (String) requestPayload.get("newProvisioningTag");
                updateProvisioningTagHandler(locale, resp  ,clientId  ,msisdn  ,subscriptionId  ,serviceId  ,newProvisioningTag );
            }

        }
        catch (Exception e) {
            logService.logResponseError(e);
            try {
                ObjectOutputStream oostream = new ObjectOutputStream (new BufferedOutputStream (resp.getOutputStream()));
                oostream.writeObject( new ExceptionAdapter(e));
                oostream.flush();
            } catch(IOException ioe)
            {
                log.error(ioe.getMessage(),ioe);
            }
        }
    }

    public void updateServiceStatusHandler(Locale locale, HttpServletResponse resp ,String provisioningId  ,int serviceStatus  ,int provisioningStatus ) {
        ObjectOutputStream oos = null;
        try {
            boolean result = false;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));

            final Optional<Boolean> shouldProxy =
                    PropertyService.getPropertyAsBoolean(PROP_UPDATE_SERVICE_STATUS1.value(), true);
            try {

                if (shouldProxy.isPresent() && shouldProxy.get()) {
                    result = provisionApiService.updateServiceStatus(locale, provisioningId, serviceStatus, provisioningStatus);
                } else {
                    result = EcomApiFactory.getProvisionApi(locale).updateServiceStatus(provisioningId,serviceStatus,provisioningStatus);

                }
            }
            catch (Exception e1) {
                logService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            // send response
            logService.logResponseOut("SUCCESS");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeBoolean(result);
            oos.flush();
        } catch (Exception e2) {
            logService.logResponseError(e2);
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

    private ProvisionApi getProvisionApiDelegate(Locale locale) throws EcommerceException {
        return EcomApiFactory.getProvisionApi(locale);
    }

    public void updateServiceStatusHandler(Locale locale, HttpServletResponse resp ,String provisioningId  ,int serviceStatus  ,int provisioningStatus  ,String provisioningTag ) {
        ObjectOutputStream oos = null;
        try {
            boolean result = false;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getProvisionApiDelegate(locale).updateServiceStatus(provisioningId,serviceStatus,provisioningStatus,provisioningTag);
            }
            catch (Exception e1) {
                logService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            // send response
            logService.logResponseOut("SUCCESS");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeBoolean(result);
            oos.flush();
        } catch (Exception e2) {
            logService.logResponseError(e2);
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

    public void updateProvisioningTagHandler(Locale locale, HttpServletResponse resp ,String clientId  ,String msisdn  ,String subscriptionId  ,String serviceId  ,String newProvisioningTag ) {
        ObjectOutputStream oos = null;
        try {
            com.vizzavi.ecommerce.business.provision.ProvisionAuthorization result = null;
            oos = new ObjectOutputStream (
                    new BufferedOutputStream (resp.getOutputStream()));
            try {
                result = getProvisionApiDelegate(locale).updateProvisioningTag(clientId,msisdn,subscriptionId,serviceId,newProvisioningTag);
            }
            catch (Exception e1) {
                logService.logResponseError(e1);
                oos.writeObject( new ExceptionAdapter(e1));
                oos.flush();
                return;
            }
            // send response
            logService.logResponseOut("SUCCESS");
            resp.setStatus(HttpServletResponse.SC_OK);
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e2) {
            logService.logResponseError(e2);
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
