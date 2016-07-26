package com.vodafone.er.ecom.proxy;

import com.vizzavi.ecommerce.business.catalog.CatalogApi;
import com.vizzavi.ecommerce.business.charging.PurchaseApi;
import com.vizzavi.ecommerce.business.charging.PurchaseAttributes;
import com.vizzavi.ecommerce.business.charging.PurchaseAuthorization;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vizzavi.ecommerce.business.selfcare.SelfcareApi;
import org.assertj.core.api.SoftAssertions;

import java.util.Locale;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class TestGenerator {

    private SoftAssertions softly = new SoftAssertions();

    private CatalogApi catalogApi;
    private PurchaseApi purchaseApi;
    private SelfcareApi selfcareApi;

	private CatalogApi getCatalogApi() throws EcommerceException	{
		if (catalogApi==null)
			catalogApi = EcomApiFactory.getCatalogApi(Locale.UK);
		return catalogApi;
	}
	private PurchaseApi getPurchaseApi() throws EcommerceException	{
		if (purchaseApi==null)
			purchaseApi = EcomApiFactory.getPurchaseApi(Locale.UK);
		return purchaseApi;
	}
	private SelfcareApi getSelfcareApi() throws EcommerceException	{
		if (selfcareApi==null)
			selfcareApi = EcomApiFactory.getSelfcareApi(Locale.UK);
		return selfcareApi;
	}

    //Make sure ER Core 15-12-2 is running with Java7 and JBOSS 5
    // and run against this to generate assert statements requried.
    //Also change the port for the server to 8094 (E.g. CatalogApiStub) - want to call ER through decoupling client
	public static void main (String args[]) throws Exception	{

	    String msisdn = String.valueOf(new Random().nextInt());
        String packageId = "";
        String provisionalPackageId = "pPROV02__X__package:pPROV02_TAX_3_1002_10010_999_*";


        final PurchaseApi purchaseApi = EcomApiFactory.getPurchaseApi(Locale.UK);
        final PurchaseAuthorization auth = purchaseApi.purchasePackageMsisdn("test,", msisdn, provisionalPackageId, new PurchaseAttributes());
        assertThat(auth).as("PurchaseAuth is null ").isNotNull();
        assertThat(auth.getSubscriptions().length).isEqualTo(1);
        assertThat(auth.getSubscriptions()[0]).as("PurchaseAuth subscriptions are null ").isNotNull();
        assertThat(auth.getSubscriptions()[0].getServiceIds()).as("ServiceIds are null ").isNotNull();

        //[serviceId]/[subscriptionId] = provisionId

//        long subId = auth.getSubscriptions()[0].getSubscriptionIdLong();
//        final String [] serviceIds = auth.getSubscriptions()[0].getServiceIds();
//        CatalogService catService = EcomApiFactory.getCatalogApi(Locale.UK).getService(serviceIds[0]);
//
//        catService.getProvisioningSystem();
//        catService.getProvisioningTag();
//
//        String provisionId = "";

//        final ProvisionApi provisionApi = EcomApiFactory.getProvisionApi(Locale.UK);
//        boolean result = provisionApi.updateServiceStatus(provisionId, 1, 1);



//        Assertions.assertThat(catalogService).as("catalogService is null test").isNotNull();

//        TestHelper.generateAssertJTestCode(pack, "pack");
//        TestHelper.generateAssertJTestCode(catalogService, "catalogService");


//		CatalogService catalogService = EcomApiFactory.getCatalogApi(Locale.UK).getService("sAlt");
//        TestHelper.generateTestCode(catalogService, "catalogService");˙

	}
}
