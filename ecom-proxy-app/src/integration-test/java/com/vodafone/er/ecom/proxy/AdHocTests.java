package com.vodafone.er.ecom.proxy;

import com.vizzavi.ecommerce.business.catalog.CatalogApi;
import com.vizzavi.ecommerce.business.catalog.CatalogPackage;
import com.vizzavi.ecommerce.business.charging.AccountValidationAuthorization;
import com.vizzavi.ecommerce.business.charging.ChargingApi;
import com.vizzavi.ecommerce.business.charging.PurchaseApi;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vizzavi.ecommerce.business.common.ResponseStatus;
import com.vizzavi.ecommerce.business.selfcare.CustcareApi;
import com.vizzavi.ecommerce.business.selfcare.SelfcareApi;
import com.vizzavi.ecommerce.business.selfcare.UserGroup;
import com.vizzavi.ecommerce.business.selfcare.ValidateMsisdnAttributes;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


/**
 * Copy of the Core Head Ecom Regression Test
 */
public class AdHocTests {

    PurchaseApi mPurchaseApi = EcomApiFactory.getPurchaseApi(Locale.UK);
    SelfcareApi mSelfcareApi = EcomApiFactory.getSelfcareApi(Locale.UK);
    ChargingApi mChargingApi = EcomApiFactory.getChargingApi(Locale.UK);
    CustcareApi mCustcareApi = EcomApiFactory.getCustcareApi(Locale.UK);
    CatalogApi mCatalogApi = EcomApiFactory.getCatalogApi(Locale.UK);


    PurchaseApi purchaseApi = EcomApiFactory.getPurchaseApi(Locale.UK);
    SelfcareApi selfcareApi = EcomApiFactory.getSelfcareApi(Locale.UK);
    ChargingApi chargingApi = EcomApiFactory.getChargingApi(Locale.UK);
    CustcareApi custcareApi = EcomApiFactory.getCustcareApi(Locale.UK);
    CatalogApi catalogApi = EcomApiFactory.getCatalogApi(Locale.UK);

    String clientId = "AdhocTestClient";

    public AdHocTests() throws EcommerceException {
    }

    @Test
    public void simpleGetPackage2() {

        CatalogPackage pack = catalogApi.getPackage("pAlt");
        assertNotNull(pack);

    }

    @Test
    public void getServiceIdFromPricePointId() {
        String serviceId1 = "content:BP001_TAX_B001_999_999_*_999_999";
        String serviceId2 = "content:BP001_*_B001_999_999_*_999_999";

        getServiceIdFromPpId(serviceId1);
        getServiceIdFromPpId(serviceId2);

    }
    public void getServiceIdFromPpId(String ppId) {
        int index = ppId.indexOf("_");
        String result = ppId.substring(index+1);

        index = result.indexOf("_");
        result = result.substring(index+1);
        System.out.println(result);

        index = result.indexOf("_");
        result = result.substring(0, index);

        System.out.println(result);

    }

    @Test
    public void testValidateMsisdnAllUserGroupsAccepted() throws Exception
    {
        String msisdn = "88887772P" + System.currentTimeMillis();
        System.out.println("*************************************************************************************");
        System.out.println("********************************testValidateMsisdnAllUserGroupsAccepted************************************");
        System.out.println("********************************MUST BE RUN WITH DEMO VALIDATION HANDLER************************************");

        //Validate the account
        ValidateMsisdnAttributes validateAttributes = new ValidateMsisdnAttributes();
        validateAttributes.setServiceId("s1");
        validateAttributes.setPartnerId("partner1");
        validateAttributes.setVendorId("vendor1");

        AccountValidationAuthorization accountValidation = custcareApi.validateMsisdnAccount(msisdn, validateAttributes);
        assertNotNull(accountValidation);
        assertTrue(ResponseStatus.isAccepted(accountValidation.getStatus()));
        assertTrue(accountValidation.getBan().equals("BAN_"+msisdn));
        assertTrue(accountValidation.getUserGroups() != null);
        assertTrue(accountValidation.getUserGroups().length == 3);
        boolean vipFound = false;
        boolean directorFound = false;
        boolean adultFound = false;
        for (int i=0; i<3; i++) {
            if (accountValidation.getUserGroups()[i].equals("vip")) {
                vipFound = true;
            }
            if (accountValidation.getUserGroups()[i].equals("director")) {
                directorFound = true;
            }
            if (accountValidation.getUserGroups()[i].equals("adult")) {
                adultFound = true;
            }
        }
        assertTrue(vipFound);
        assertTrue(directorFound);
        assertTrue(adultFound);
        System.out.println("ACCOUNT VALIDATION ALL UGS= " + accountValidation);
    }

    @Test
    public void testUserGroup() throws Exception {
        UserGroup userGroup = new UserGroup();
        userGroup.setName("director");

        userGroup.hashCode();


    }

}
