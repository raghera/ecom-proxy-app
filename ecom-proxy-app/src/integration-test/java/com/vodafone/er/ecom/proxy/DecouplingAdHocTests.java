package com.vodafone.er.ecom.proxy;

import com.google.common.collect.Lists;
import com.vizzavi.ecommerce.business.catalog.CatalogApi;
import com.vizzavi.ecommerce.business.charging.ChargingApi;
import com.vizzavi.ecommerce.business.charging.PurchaseApi;
import com.vizzavi.ecommerce.business.charging.PurchaseAttributes;
import com.vizzavi.ecommerce.business.charging.PurchaseAuthorization;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import com.vizzavi.ecommerce.business.selfcare.CustcareApi;
import com.vizzavi.ecommerce.business.selfcare.SelfcareApi;
import com.vodafone.global.er.decoupling.client.DecouplingApiFactory;
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

import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertNotNull;

public class DecouplingAdHocTests {


    String clientId = "AdhocTestClient";

    PurchaseApi purchaseApi = DecouplingApiFactory.getPurchaseApi(Locale.UK, clientId);
    SelfcareApi selfcareApi = DecouplingApiFactory.getSelfcareApi(Locale.UK, clientId);
    ChargingApi chargingApi = DecouplingApiFactory.getChargingApi(Locale.UK, clientId);
    CustcareApi custcareApi = DecouplingApiFactory.getCustcareApi(Locale.UK, clientId);
    CatalogApi catalogApi = DecouplingApiFactory.getCatalogApi(Locale.UK, clientId);

    private static final int JETTY_PORT = 8888;
    //    private static final String WAR_PATH = "./ecom-proxy-app/target/ecom-proxy-app.war";
    private static final String WAR_PATH = "./target/ecom-proxy-app.war";
    private static final String CONTEXT_PATH = "/delegates";

    private Server server;

    @Before
    public void startJetty() throws Exception {
        BasicConfigurator.configure();

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


        System.out.println("SERVER STATUS " + server.getState());

    }

    @After
    public void tearDownJetty() throws Exception {
        System.out.println("STOPPING SERVER " + server.getState());
        server.stop();
//        server.join();
        System.out.println("STOPPED SERVER " + server.getState());
    }

    @Test
    public void purchaseDecoupling() throws Exception {

        System.out.println("HELLO THIS TEST IS RUNNING ....");

        ExecutorService executor = Executors.newFixedThreadPool(5);

        List<String> msisdns = Lists.newArrayList();

        for (int i = 0; i < 1000; i++) {
            msisdns.add("" + new Random().nextInt());
        }

        List<Callable<PurchaseAuthorization>> callables = Lists.newArrayList();

        for (int i = 0; i < 10; i++) {
            for (String msisdn : msisdns) {

                callables.add(createCallable(msisdn));
            }
        }

        executor.invokeAll(callables).stream()
                .map(tFuture -> {
                    try {
                        return tFuture.get();
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                }).forEach(auth -> {
            System.out.println("Result= " + auth.toString());
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

        return () -> {
            String packageId = "BP001__X__package:BP001_TAX_3_4_10010_999_999_*_*_*_false_false";


            PurchaseAuthorization auth = null;
            try {
                System.out.println("Purchase being called  . . . . . . ");
                auth = EcomApiFactory.getPurchaseApi(Locale.UK).purchasePackageMsisdn("epa-test", msisdn, packageId, new PurchaseAttributes());
            } catch (EcommerceException e) {
                e.printStackTrace();
            }
            assertNotNull(auth);
//            assertTrue("Auth response is false", auth.isSuccess());
            return auth;
        };
    }


    //Set system properties programatically§
    private static void setSystemProperties() {
        System.setProperty("DEBUG", "true");
        System.setProperty("org.eclipse.jetty.LEVEL", "DEBUG");
//        System.setProperty("javax.net.debug", "ALL");

//        System.setProperty("javax.net.ssl.keyStore", keyStore);
//        System.setProperty("javax.net.ssl.keyStorePassword", keyStorePassword);
//        System.setProperty("javax.net.ssl.trustStore", trustStore);
//        System.setProperty("javax.net.ssl.trustStorePassword", trustStorePassword);
    }

}
