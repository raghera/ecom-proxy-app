package com.vodafone.er.ecom.proxy;

import com.vizzavi.ecommerce.business.catalog.CatalogApi;
import com.vizzavi.ecommerce.business.charging.*;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vizzavi.ecommerce.business.common.ResponseStatus;
import com.vizzavi.ecommerce.business.selfcare.*;
import com.vodafone.global.er.subscriptionmanagement.SubscriptionFilterImpl;
import org.junit.Test;

import javax.net.ssl.*;
import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.vizzavi.ecommerce.business.common.EcomApiFactory.getCustcareApi;
import static com.vizzavi.ecommerce.business.common.EcomApiFactory.getSelfcareApi;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class AdHocTests {

    PurchaseApi mPurchaseApi = EcomApiFactory.getPurchaseApi(Locale.UK);
    SelfcareApi mSelfcareApi = getSelfcareApi(Locale.UK);
    ChargingApi mChargingApi = EcomApiFactory.getChargingApi(Locale.UK);
    CustcareApi mCustcareApi = getCustcareApi(Locale.UK);
    CatalogApi mCatalogApi = EcomApiFactory.getCatalogApi(Locale.UK);


    PurchaseApi purchaseApi = EcomApiFactory.getPurchaseApi(Locale.UK);
    SelfcareApi selfcareApi = getSelfcareApi(Locale.UK);
    ChargingApi chargingApi = EcomApiFactory.getChargingApi(Locale.UK);
    CustcareApi custcareApi = getCustcareApi(Locale.UK);
    CatalogApi catalogApi = EcomApiFactory.getCatalogApi(Locale.UK);

    String clientId = "AdhocTestClient";

    public AdHocTests() throws EcommerceException {
    }

    @Test
    public void createDynamicPredicate() throws Exception {

        List<String> values = new ArrayList<>();
        values.add("A");
        values.add("B");
        values.add("C");
        List<String> toFilter = new ArrayList<>();
        toFilter.add("A");
        toFilter.add("B");
        toFilter.add("C");
        toFilter.add("D");
        toFilter.add("E");
        toFilter.add("F");
        toFilter.add("G");

        Predicate<String> predicate = createCombinedPredicate(values);

        List<String> filtered = toFilter.stream().filter(predicate).collect(Collectors.toList());
        filtered.forEach(System.out::println);

    }

    private Predicate<String> createCombinedPredicate(List<String> values) {
        List<Predicate<String>> predicates = new ArrayList<>();
        values.forEach(value -> predicates.add(createPredicate(value)));

        return x -> predicates.stream().anyMatch(stringPredicate -> stringPredicate.test(x));
    }

    private Predicate<String> createPredicate(String value) {

        Predicate<String> predicate = x -> x.equals(value);
        return predicate;

    }

    @Test
    public void testHttpsConnection() throws Exception {
        //https://dgig-dit-rsd-o-de.sp.vodafone.com:20500/er-fep/frontendproxy
        //        String host = "85.205.207.43";
        String protocol = "https://";
        String host = "dgig-dit-rsd-o-de.sp.vodafone.com";

        String port = ":20500";
        String path = "/er-fep/frontendproxy";

        String payload =
                "<?xml version='1.0' encoding='UTF-8'?>" +
                "<er-request id=\"100029\" client-application-id=\"ecom-proxy-application\" purchase_locale=\"en_GB\" language_locale=\"en_GB\" client-domain=\"GB.ecom-proxy-application\">" +
                "  <payload>" +
                "    <get-version-request xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:nil=\"true\"/>" +
                "  </payload>" +
                "</er-request>";

        URL url = new URL(protocol + host + port + path);
//        URL url = new URL(protocol + host + port );

//        String trustStore = "/Users/raghera/working/development/erdev/us/dev/EcomProxyApp/ecom-proxy-app/src/main/resources/certs/DIT_Client_Cert_v4.jks";
//        String password = "gig-dit-4";
//        String trustStore = "/Library/Java/JavaVirtualMachines/jdk1.8.0_60.jdk/Contents/Home/jre/lib/security";
//        String password = "changeit";

        System.setProperty("javax.net.debug", "ALL");

        System.out.println("url: " + url.toString());
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setSSLSocketFactory(getSSLFactory());
        connection.setRequestMethod("POST");

        connection.setRequestProperty("Content-Type","application/xml");
        connection.setDoOutput(true);
        connection.setDoInput(true);

        connection.connect();

        OutputStream os = connection.getOutputStream();
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
        pw.write(payload);
        pw.close();

        InputStream in = connection.getInputStream();
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));

        assertEquals(200, connection.getResponseCode());
        bf.lines().forEach(System.out::println);

//        StringBuffer sb = new StringBuffer();
//        bf.lines().forEach(sb::append);
//
//        String xml = sb.toString();
//        System.out.println(xml);

//        StringEntity reqEntity = new StringEntity(requestBody, XmlUtils.getCharacterEncoding());
//        reqEntity.setContentType("application/xml");

    }

    private SSLSocketFactory getSSLFactory() throws Exception {

        //Set up the trust manager (re-use ER one)
        EpaX509TrustManager trustManager = new EpaX509TrustManager();

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(new KeyManager[]{trustManager.getDefaultKeyManager()}, new TrustManager[] { trustManager.getDefaultTrustManager() }, null);

        SSLSocketFactory sslFactory = sslContext.getSocketFactory();
        return  sslFactory;

    }

    @Test
    public void simpleGetPackage2() throws Exception {

        //Refund Transaction test
        final String msisdn = String.valueOf(new Random().nextInt());
        String refundTransactionId = "";

        String packageId = "CM004";  // one of the few packages that is refundable
        String packagePricepointId = "CM004__X__package:CM004_TAX_2_2_10010_999_*_*";
        PurchaseAttributes purchaseAttributes = new PurchaseAttributes();
        Calendar cal = Calendar.getInstance(Locale.UK);

        // purchase - create first payment transaction
        PurchaseAuthorization purchaseAuth = purchaseApi.purchasePackage(clientId, msisdn, packagePricepointId, purchaseAttributes);
        assertNotNull(purchaseAuth);
        assertTrue("Asserted purchaseAuth is success but wasn't: MSISDN: " + msisdn + "; purchaseAuth: " + purchaseAuth, purchaseAuth.isSuccess());

        // renew - create second payment transaction for same package
        PurchaseAuthorization renewAuth = purchaseApi.renewPurchasePackageMsisdn(clientId, msisdn, purchaseAuth.getSubscriptionIds()[0], purchaseAttributes);
        assertNotNull(renewAuth);
        assertTrue("Asserted renewAuth is success but wasn't: MSISDN: " + msisdn + "; renewAuth: " + renewAuth, renewAuth.isSuccess());

        refundTransactionId = renewAuth.getTransactionId();

        RefundAuthorization refundAuth = getCustcareApi(Locale.UK)
                .refundTransactionMonetary("test", msisdn, refundTransactionId, 1.0, null, new RefundAttributes());

        assertNotNull(refundAuth);
        assertTrue(refundAuth.isSuccess());
        System.out.println("TransactionId: " + refundAuth.getTransactionId());

        final Subscription[] subscriptions = getSelfcareApi(Locale.UK).getSubscriptions("test", msisdn, 0, new SubscriptionFilterImpl());
        assertNotNull(subscriptions);

        System.out.println("SubscriptionId: " + subscriptions[0].getRefundTransactions());

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
