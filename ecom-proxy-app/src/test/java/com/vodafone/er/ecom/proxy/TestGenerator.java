package com.vodafone.er.ecom.proxy;

import com.vizzavi.ecommerce.business.catalog.CatalogApi;
import com.vizzavi.ecommerce.business.catalog.CatalogService;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import org.assertj.core.api.SoftAssertions;

import java.util.Locale;

public class TestGenerator {

    private SoftAssertions softly = new SoftAssertions();

    private CatalogApi catalogApi;


	private CatalogApi getCatalogApi() throws EcommerceException	{
		if (catalogApi==null)
			catalogApi = EcomApiFactory.getCatalogApi(Locale.UK);
		return catalogApi;
	}

    //Make sure ER Core 15-12-2 is running with Java7 and JBOSS 5
    // and run against this to generate assert statements requried.
	public static void main (String args[]) throws Exception	{

//		CatalogPackage pack = EcomApiFactory.getCatalogApi(Locale.UK).getPackage("pAlt");
        CatalogService catalogService = EcomApiFactory.getCatalogApi(Locale.UK).getService("sAlt");

//        TestHelper.generateAssertJTestCode(pack, "pack");
        TestHelper.generateAssertJTestCode(catalogService, "catalogService");

//		CatalogService catalogService = EcomApiFactory.getCatalogApi(Locale.UK).getService("sAlt");
//        TestHelper.generateTestCode(catalogService, "catalogService");˙

	}
}
