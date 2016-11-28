package com.vodafone.er.ecom.proxy.jira;

import com.vizzavi.ecommerce.business.catalog.CatalogApi;
import com.vizzavi.ecommerce.business.catalog.CatalogService;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vodafone.er.ecom.proxy.properties.PropertyService;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Ravi Aghera
 */
public class GetService1Ecom_ECP26_IT {

    @Before
    public void setUpProperty() {
        String propertyName = "proxy.getService1";
        PropertyService.setProperty(propertyName, "false");
    }

    @Test
    public void shouldCallEcomWithoughError() throws Exception {
        CatalogApi catalogApi = EcomApiFactory.getCatalogApi(Locale.UK);
        CatalogService service = catalogApi.getService("sAlt");
        assertNotNull(service);
        assertEquals(service.getId(), "sAlt");
    }

}
