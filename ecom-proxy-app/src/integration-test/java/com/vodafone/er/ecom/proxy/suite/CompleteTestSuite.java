package com.vodafone.er.ecom.proxy.suite;

import com.vodafone.er.ecom.proxy.*;
import com.vodafone.er.ecom.proxy.findpackageswithservice.*;
import com.vodafone.er.ecom.proxy.getpackage.GetPackage2IT_pt1;
import com.vodafone.er.ecom.proxy.getpackage.GetPackage2IT_pt2;
import com.vodafone.er.ecom.proxy.getsubscriptions.*;
import com.vodafone.er.ecom.proxy.gettransactions.*;
import com.vodafone.er.ecom.proxy.jira.GetSubscriptions2_ECP17_IT;
import com.vodafone.er.ecom.proxy.usageAuthRate.*;
import com.vodafone.er.ecom.proxy.usageauth.*;
import com.vodafone.er.ecom.proxy.usageauthratecharge.*;
import com.vodafone.er.ecom.proxy.usagecomplete.*;
import org.apache.log4j.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AllowSymLinkAliasChecker;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import java.io.File;
import java.io.OutputStreamWriter;

/**
 * Created by Ravi Aghera
 */
@RunWith(Suite.class)
@SuiteClasses({
        GetServiceIT.class,
        GetPackages_IT.class,
        GetBasePrices20IT_pt1.class,
        GetBasicAccount_IT.class,
        FindPackagesWithService7IT_pt1.class,
        FindPackagesWithService7IT_pt2.class,
        FindPackagesWithService7IT_pt3.class,
        FindPackagesWithService7IT_pt4.class,
        FindPackagesWithService8IT_pt1.class,
        FindPackagesWithService8IT_pt2.class,
        FindPackagesWithService8IT_pt3.class,
        FindPackagesWithService8IT_pt4.class,
        FindPackagesWithService9IT_pt1.class,
        FindPackagesWithService9IT_pt2.class,
        FindPackagesWithService9IT_pt3.class,
        GetPackage2IT_pt1.class,
        GetPackage2IT_pt2.class,
        GetSubscription10_IT.class,
        GetSubscription26_IT_pt1.class,
        GetSubscription26_IT_pt2.class,
        GetSubscription26_IT_pt3.class,
        GetSubscription26_IT_pt4.class,
        GetSubscription26_IT_pt5.class,
        GetSubscription26_IT_pt6.class,
        GetSubscription26_IT_pt7.class,
        GetSubscription26_IT_pt8.class,
        GetSubscription26_IT_pt9.class,
        GetSubscriptions18IT.class,
        GetSubscriptions2_modifyAndRefundTransactionIT.class,
        GetSubscriptions2IT.class,
        GetTransactions6_IT_pt1.class,
        GetTransactions6_IT_pt2.class,
        GetTransactions6_IT_pt3.class,
        GetTransactions6_IT_pt4.class,
        GetVersion_IT.class,
        InactivateSubscription6IT.class,
        GetSubscriptions2_ECP17_IT.class,
        ModifySubscriptionChargingMethodIT.class,
        PurchasePackageMsisdnIT.class,
        UpdateServiceStatusIT.class,
        UsageAuth1IT_no_valid_pack.class,
        UsageAuth1IT_pt1.class,
        UsageAuth1IT_pt10.class,
        UsageAuth1IT_pt2.class,
        UsageAuth1IT_pt3.class,
        UsageAuth1IT_pt4.class,
        UsageAuth1IT_pt5.class,
        UsageAuth1IT_pt6.class,
        UsageAuth1IT_pt7.class,
        UsageAuth1IT_pt8.class,
        UsageAuth1IT_pt9.class,
        UsageAuthRate2IT_pt1.class,
        UsageAuthRate2IT_pt10.class,
        UsageAuthRate2IT_pt11.class,
        UsageAuthRate2IT_pt2.class,
        UsageAuthRate2IT_pt3.class,
        UsageAuthRate2IT_pt4.class,
        UsageAuthRate2IT_pt5.class,
        UsageAuthRate2IT_pt6.class,
        UsageAuthRate2IT_pt7.class,
        UsageAuthRate2IT_pt8.class,
        UsageAuthRate2IT_pt9.class,
        UsageAuthRateCharge3IT_pt1.class,
        UsageAuthRateCharge3IT_pt2.class,
        UsageAuthRateCharge3IT_pt3.class,
        UsageAuthRateCharge3IT_pt4.class,
        UsageAuthRateCharge3IT_pt5.class,
        UsageAuthRateCharge3IT_pt6.class,
        UsageAuthRateCharge3IT_pt7.class,
        UsageAuthRateCharge3IT_pt8.class,
        UsageAuthRateCharge3IT_PurchaseOptions_pt1.class,
        UsageComplete4IT_pt1.class,
        UsageComplete4IT_pt2.class,
        UsageComplete4IT_pt3.class,
        UsageComplete4IT_pt4.class,
        UsageComplete4IT_pt5.class,
        UsageComplete4IT_pt6.class,
        UsageComplete4IT_pt7.class

})
public class CompleteTestSuite {

    private static final int JETTY_PORT = 8888;
    private static final String WAR_PATH = "./target/ecom-proxy-app.war";
    private static final String CONTEXT_PATH = "/delegates";

    private static Server server;

    @BeforeClass
    public static void setUpSuite() throws Exception {
        System.out.println("SET UP SUITE .... ");

        BasicConfigurator.configure();

//        Logger.getRootLogger().setLevel(Level.DEBUG);
//        Logger.getLogger("com.vodafone").setLevel(Level.DEBUG);

        ConsoleAppender ca = new ConsoleAppender(new PatternLayout("%-5p [%t]: %m%n"));
        ca.setWriter(new OutputStreamWriter(System.out));
        Logger.getLogger("com.vodafone").addAppender(ca);
        Logger.getRootLogger().addAppender(ca);
        Logger.getLogger("com.vodafone.config").setLevel(Level.OFF);
        Logger.getLogger("org.eclipse").setLevel(Level.ERROR);
        Logger.getLogger("org.springframework").setLevel(Level.OFF);
//        Logger.getLogger("org.springframework").addAppender(ca);

        server = new Server(JETTY_PORT);

        ContextHandler contextHandler = new ContextHandler();
        contextHandler.setContextPath("/delegates");

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath(CONTEXT_PATH);
        File warfile = new File(WAR_PATH);
        System.out.println("Warfile present: " + warfile.exists());
        System.out.println("Warfile path: " + warfile.getAbsolutePath());

        System.out.println(">>>>>" + System.getProperty("user.dir"));

//        setSystemProperties();

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

    @AfterClass
    public static void tearDownSuite() throws Exception {
        System.out.println("TEAR DOWN SUITE .... ");
        server.stop();
        server.join();
    }
}
