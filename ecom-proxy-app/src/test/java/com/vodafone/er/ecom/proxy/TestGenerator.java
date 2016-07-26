package com.vodafone.er.ecom.proxy;

import com.vizzavi.ecommerce.business.catalog.CatalogApi;
import com.vizzavi.ecommerce.business.catalog.PricePoint;
import com.vizzavi.ecommerce.business.charging.PurchaseApi;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vizzavi.ecommerce.business.selfcare.SelfcareApi;
import org.assertj.core.api.SoftAssertions;

import java.util.Locale;

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


    /*
    Pass in a service pricepoint id and get the package id returned.
    If you pass in 'content:pAlt_TAX_sAlt_1_999_999_999' and get pAlt back
     */
    public static String getPackageIdFromServicePricepoint(String pricePoint) {
        if(pricePoint.indexOf(PricePoint.CONTENT_PRICEPOINT_ID_PREFIX)==0) {
            int underScore = pricePoint.indexOf("_", PricePoint.CONTENT_PRICEPOINT_ID_PREFIX.length());
            String substr = pricePoint.substring(PricePoint.CONTENT_PRICEPOINT_ID_PREFIX.length(), underScore);
            return substr;
        }
        return pricePoint;
    }
    //Make sure ER Core 15-12-2 is running with Java7 and JBOSS 5
    // and run against this to generate assert statements requried.
    //Also change the port for the server to 8094 (E.g. CatalogApiStub) - want to call ER through decoupling client
	public static void main (String args[]) throws Exception	{

        final String servicePP = "content:pAlt_TAX_sAlt_1_999_999_999";
        String packageId = getPackageIdFromServicePricepoint(servicePP);

        System.out.println("RESULT: " + packageId);



    }
}
