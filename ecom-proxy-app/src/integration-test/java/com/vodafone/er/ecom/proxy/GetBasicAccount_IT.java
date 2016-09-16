package com.vodafone.er.ecom.proxy;

import com.vizzavi.ecommerce.business.charging.PurchaseAttributes;
import com.vizzavi.ecommerce.business.charging.PurchaseAuthorization;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vizzavi.ecommerce.business.selfcare.BasicAccount;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.Locale;
import java.util.Random;

import static com.vodafone.er.ecom.proxy.constants.EcomAppEnum.CLIENT_ID;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ravi Aghera
 */
public class GetBasicAccount_IT {

    //TODO test generation did not work for the lists since they were hibernate ones being returned.

    private SoftAssertions softly = new SoftAssertions();

    @Test
    public void getBasesPrices() throws Exception {
        final String msisdn = String.valueOf(new Random().nextInt());


        PurchaseAuthorization auth = EcomApiFactory.getPurchaseApi(Locale.UK).purchasePackageMsisdn("test", msisdn, "pAlt__X__package:pAlt_TAX_3_2_999_999_999_*_*", new PurchaseAttributes());
        assertNotNull(auth);
        assertTrue("Auth response is false", auth.isSuccess());

         BasicAccount result = EcomApiFactory.getCustcareApi(Locale.UK)
                .getBasicAccount(CLIENT_ID.getValue(), msisdn, 0);
        assertNotNull(result);
//
//        assertThat(result.getMsisdn()).isEqualTo(msisdn);
//        assertThat(result.getAccountStatus()).isNotNull();
//        assertThat(result.getAccountStatus().getName()).isEqualTo("OK");

        softly.assertThat(result.getName() ).as(" result.getName()" ).isNull();
        softly.assertThat(result.getCountry() ).as(" result.getCountry()" ).isEqualTo("GB");
        softly.assertThat(result.getSpId() ).as(" result.getSpId()" ).isNull();
        softly.assertThat(result.getCountryId() ).as(" result.getCountryId()" ).isEqualTo(5) ;
        softly.assertThat(result.getErrorId() ).as(" result.getErrorId()" ).isNull();
        softly.assertThat(result.getErrorDescription() ).as(" result.getErrorDescription()" ).isNull();
        softly.assertThat(result.getUserGroups() ).as(" result.getUserGroups()" ).isNull();
        softly.assertThat(result.getMsisdn() ).as(" result.getMsisdn()" ).isEqualTo("116672411");
        softly.assertThat(result.getPaymentCardDetails() ).as(" result.getPaymentCardDetails()" ).isNull();
        softly.assertThat(result.getStatus() ).as(" result.getStatus()" ).isEqualTo(401) ;
        softly.assertThat(result.getSpendLimits() ).as(" result.getSpendLimits()" ).isNull();
        softly.assertThat(result.getAccountObjId() ).as(" result.getAccountObjId()" ).isEqualTo(new Long(3964)) ;
        softly.assertThat(result.getBan() ).as(" result.getBan()" ).isNull();
        softly.assertThat(result.getHomeTimezone() ).as(" result.getHomeTimezone()" ).isNull();
        softly.assertThat(result.getBillingCycleDate() ).as(" result.getBillingCycleDate()" ).isEqualTo(16) ;
        softly.assertThat(result.getUtcTimezoneOffset() ).as(" result.getUtcTimezoneOffset()" ).isNullOrEmpty();
        softly.assertThat(result.getIsPrepay() ).as(" result.getIsPrepay()" ).isNull();
        softly.assertThat(result.getOriginalMsisdn() ).as(" result.getOriginalMsisdn()" ).isNull();
        softly.assertThat(result.getValidateResponseStatus() ).as(" result.getValidateResponseStatus()" ).isNull();
        softly.assertThat(result.getAccountValidationAuthorization() ).as(" result.getAccountValidationAuthorization()" ).isNull();
        softly.assertThat(result.getChildSpId() ).as(" result.getChildSpId()" ).isNull();
        softly.assertThat(result.getSpType() ).as(" result.getSpType()" ).isNull();
        softly.assertThat(result.getUserGroupList() ).as(" result.getUserGroupList()" ).isNull();
        softly.assertThat(result.getSuppressCourtesyNotifications() ).as(" result.getSuppressCourtesyNotifications()" ).isFalse() ;
// com.vizzavi.ecommerce.business.common.ReasonCode
        softly.assertThat(result.getAccountStatus().getName() ).as(" result.getAccountStatus().getName()" ).isEqualTo("OK");
        softly.assertThat(result.getAccountStatus().getCode() ).as(" result.getAccountStatus().getCode()" ).isEqualTo(0) ;
        softly.assertThat(result.getAccountStatus().getSubCode() ).as(" result.getAccountStatus().getSubCode()" ).isEqualTo(0) ;
        softly.assertThat(result.getAccountStatus().getResourceName() ).as(" result.getAccountStatus().getResourceName()" ).isEqualTo("ReasonCode_0");
        softly.assertThat(result.getUserGroupNames() ).as(" result.getUserGroupNames()" ).isNull();
// java.util.Locale
        softly.assertThat(result.getLocale().getLanguage() ).as(" result.getLocale().getLanguage()" ).isEqualTo("en");
        softly.assertThat(result.getLocale().getScript() ).as(" result.getLocale().getScript()" ).isNullOrEmpty();
        softly.assertThat(result.getLocale().getCountry() ).as(" result.getLocale().getCountry()" ).isEqualTo("GB");
        softly.assertThat(result.getLocale().getVariant() ).as(" result.getLocale().getVariant()" ).isNullOrEmpty();
// java.util.Collections$EmptySet
// java.util.Collections$EmptySet
// java.util.Collections$EmptySet
        softly.assertThat(result.getLocale().getISO3Language() ).as(" result.getLocale().getISO3Language()" ).isEqualTo("eng");
        softly.assertThat(result.getLocale().getISO3Country() ).as(" result.getLocale().getISO3Country()" ).isEqualTo("GBR");
        softly.assertThat(result.getLocale().getDisplayLanguage() ).as(" result.getLocale().getDisplayLanguage()" ).isEqualTo("English");
        softly.assertThat(result.getLocale().getDisplayScript() ).as(" result.getLocale().getDisplayScript()" ).isNullOrEmpty();
        softly.assertThat(result.getLocale().getDisplayCountry() ).as(" result.getLocale().getDisplayCountry()" ).isEqualTo("United Kingdom");
        softly.assertThat(result.getLocale().getDisplayVariant() ).as(" result.getLocale().getDisplayVariant()" ).isNullOrEmpty();
        softly.assertThat(result.getLocale().getDisplayName() ).as(" result.getLocale().getDisplayName()" ).isEqualTo("English (United Kingdom)");


        softly.assertAll();

    }


}
