package com.vodafone.er.ecom.proxy;

import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import org.junit.Test;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Ravi Aghera
 *
 */
public class GetVersion_IT {

    @Test
    public void shouldGetVersion() throws Exception {
        String result = EcomApiFactory.getCatalogApi(Locale.UK).getVersion();
        assertNotNull(result);
        assertThat(result).as("Checking priceplan version").isNotEmpty();
    }
}
