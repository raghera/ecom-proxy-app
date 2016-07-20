package com.vodafone.er.ecom.proxy;

import com.vizzavi.ecommerce.business.catalog.CatalogApi;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.Locale;

public class GetServiceIT {


    private SoftAssertions softly = new SoftAssertions();

    private CatalogApi catalogApi;


    private CatalogApi getCatalogApi() throws EcommerceException {
        if (catalogApi==null)
            catalogApi = EcomApiFactory.getCatalogApi(Locale.UK);
        return catalogApi;
    }


    @Test
    public void testGetService1() throws Exception {

        

    }

}
