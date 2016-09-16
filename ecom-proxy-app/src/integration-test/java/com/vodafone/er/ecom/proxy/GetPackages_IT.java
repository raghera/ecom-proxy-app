package com.vodafone.er.ecom.proxy;

import com.vizzavi.ecommerce.business.catalog.CatalogPackage;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Ravi Aghera
 *
 *
 * Note that this is just a pass through to decoupling so no individual attributes are tested.
 * GetPackages simply gets the entire catalog with no filtering.
 *
 */

public class GetPackages_IT {

    private SoftAssertions softly = new SoftAssertions();

    @Test
    public void getPackages() throws Exception {
        final CatalogPackage[] results = EcomApiFactory.getCatalogApi(Locale.UK).getPackages();
        assertNotNull(results);
        assertEquals(575, results.length);

        softly.assertAll();

    }


}
