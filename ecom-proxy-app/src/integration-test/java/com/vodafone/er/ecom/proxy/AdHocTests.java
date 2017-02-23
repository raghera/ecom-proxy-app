package com.vodafone.er.ecom.proxy;

import com.google.common.collect.Lists;
import com.vizzavi.ecommerce.business.catalog.CatalogApi;
import com.vizzavi.ecommerce.business.charging.*;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vizzavi.ecommerce.business.common.ResponseStatus;
import com.vizzavi.ecommerce.business.selfcare.*;
import com.vodafone.global.er.subscriptionmanagement.SubscriptionFilterImpl;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AllowSymLinkAliasChecker;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.vizzavi.ecommerce.business.common.EcomApiFactory.getCustcareApi;
import static com.vizzavi.ecommerce.business.common.EcomApiFactory.getSelfcareApi;
import static org.junit.Assert.*;


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

    private static final int JETTY_PORT = 8888;
    //    private static final String WAR_PATH = "./ecom-proxy-app/target/ecom-proxy-app.war";
    private static final String WAR_PATH = "./target/ecom-proxy-app.war";
    private static final String CONTEXT_PATH = "/delegates";

    private Server server;

    String clientId = "AdhocTestClient";

    public AdHocTests() throws EcommerceException {
    }


    @Before
    public void startJetty() throws Exception {
        BasicConfigurator.configure();
//        overrideProperties();
//        setLog(new Slf4jLog());

//        Logger.getRootLogger().setLevel(Level.DEBUG);
//        Logger.getLogger("com.vodafone").setLevel(Level.DEBUG);

        Logger logger = Logger.getLogger("com.vodafone");

//        ConsoleAppender ca = new ConsoleAppender(new PatternLayout("%-5p [%t]: %m%n"));
//        ca.setWriter(new OutputStreamWriter(System.out));
//        Logger.getLogger("com.vodafone").addAppender(ca);
//        Logger.getRootLogger().addAppender(ca);
        Logger.getLogger("com.vodafone.config").setLevel(Level.OFF);
        Logger.getLogger("org.eclipse").setLevel(Level.ERROR);
        Logger.getLogger("org.springframework").setLevel(Level.OFF);
//        Logger.getLogger("org.springframework").addAppender(ca);

        try {
            server = new Server(JETTY_PORT);
        } catch (Throwable thr) {
            thr.printStackTrace();
        }

//        MBeanContainer mbContainer = new MBeanContainer(
//                ManagementFactory.getPlatformMBeanServer());
//        server.addBean(mbContainer);


        ContextHandler contextHandler = new ContextHandler();
        contextHandler.setContextPath("/delegates");

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath(CONTEXT_PATH);
        File warfile = new File(WAR_PATH);
        System.out.println("Warfile present: " + warfile.exists());
        System.out.println("Warfile path: " + warfile.getAbsolutePath());

        System.out.println(">>>>>" + System.getProperty("user.dir"));

        setSystemProperties();

        webAppContext.setWar(warfile.getAbsolutePath());

        webAppContext.addAliasCheck(new AllowSymLinkAliasChecker());
        server.setHandler(webAppContext);

//        startServer();
        System.out.println("STATE=" + server.getState());
        server.start();
//        server.join();
        System.out.println("STATE=" + server.getState());


        System.out.println( "SERVER STATUS " + server.getState() );

    }

    @After
    public void tearDownJetty() throws Exception {
        System.out.println( "STOPPING SERVER " + server.getState() );
        server.stop();
//        server.join();
        System.out.println( "STOPPED SERVER " + server.getState() );
    }

    @Test
    public void runImbeddedServer() throws Exception {

        System.out.println("HELLO THIS TEST IS RUNNING ....");

        ExecutorService executor = Executors.newFixedThreadPool(8);

        List<String> msisdns =  Lists.newArrayList();

        for (int i =0; i < 8; i++) {
            msisdns.add("" + new Random().nextInt());
        }

        List<Callable<PurchaseAuthorization>> callables = Lists.newArrayList();

        for (String msisdn : msisdns) {

            callables.add(createCallable(msisdn));
        }

        executor.invokeAll(callables).stream()
                .map(tFuture -> {
                    try {
                        return tFuture.get();
                    }
                    catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                }).forEach(auth -> {
            System.out.println(auth.toString());
        });






        System.out.println("TEST IS COMPLETE ....");

//        System.out.println("Shutting down Executor");
//        executorService.shutdown();
//        if(!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
//            System.out.println("Killing Executor");
//            executorService.shutdownNow();
//        }
    }


    public Callable<PurchaseAuthorization> createCallable(String msisdn) {

        Callable<PurchaseAuthorization> callable = () -> {
            String packageId = "BP001__X__package:BP001_TAX_3_4_10010_999_999_*_*_*_false_false";


            PurchaseAuthorization auth = null;
            try {
                auth = EcomApiFactory.getPurchaseApi(Locale.UK).purchasePackageMsisdn("epa-test", msisdn, packageId, new PurchaseAttributes());
            } catch (EcommerceException e) {
                e.printStackTrace();
            }
            assertNotNull(auth);
            assertTrue("Auth response is false", auth.isSuccess());
            return auth;
        };

        return callable;

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
//        EpaX509TrustManager trustManager = new EpaX509TrustManager();
//
//        SSLContext sslContext = SSLContext.getInstance("TLS");
//        sslContext.init(new KeyManager[]{trustManager.getDefaultKeyManager()}, new TrustManager[] { trustManager.getDefaultTrustManager() }, null);
//
//        SSLSocketFactory sslFactory = sslContext.getSocketFactory();
//        return  sslFactory;
        return null;

    }

    //Set system properties programatically
    private static void setSystemProperties() {
        System.setProperty("DEBUG", "true");
        System.setProperty("org.eclipse.jetty.LEVEL", "DEBUG");
//        System.setProperty("javax.net.debug", "ALL");

//        System.setProperty("javax.net.ssl.keyStore", keyStore);
//        System.setProperty("javax.net.ssl.keyStorePassword", keyStorePassword);
//        System.setProperty("javax.net.ssl.trustStore", trustStore);
//        System.setProperty("javax.net.ssl.trustStorePassword", trustStorePassword);
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
