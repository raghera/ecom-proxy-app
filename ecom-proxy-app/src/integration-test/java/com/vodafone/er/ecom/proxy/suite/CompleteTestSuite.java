package com.vodafone.er.ecom.proxy.suite;

import com.vodafone.er.ecom.proxy.*;
import com.vodafone.er.ecom.proxy.findpackageswithservice.*;
import com.vodafone.er.ecom.proxy.getpackage.GetPackage2_pt1_IT;
import com.vodafone.er.ecom.proxy.getpackage.GetPackage2_pt2_IT;
import com.vodafone.er.ecom.proxy.getsubscriptions.*;
import com.vodafone.er.ecom.proxy.gettransactions.GetTransactions6_pt1_IT;
import com.vodafone.er.ecom.proxy.gettransactions.GetTransactions6_pt2_IT;
import com.vodafone.er.ecom.proxy.gettransactions.GetTransactions6_pt3_IT;
import com.vodafone.er.ecom.proxy.gettransactions.GetTransactions6_pt4_IT;
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
        GetService_IT.class,
        GetPackages_IT.class,
        GetBasePrices20_pt1_IT.class,
        GetBasicAccount_IT.class,
        FindPackagesWithService7_pt1_IT.class,
        FindPackagesWithService7_pt2_IT.class,
        FindPackagesWithService7_pt3_IT.class,
        FindPackagesWithService7_pt4_IT.class,
        FindPackagesWithService8_pt1_IT.class,
        FindPackagesWithService8_pt2_IT.class,
        FindPackagesWithService8_pt3_IT.class,
        FindPackagesWithService8_pt4_IT.class,
        FindPackagesWithService9_pt1_IT.class,
        FindPackagesWithService9_pt2_IT.class,
        FindPackagesWithService9_pt3_IT.class,
        GetPackage2_pt1_IT.class,
        GetPackage2_pt2_IT.class,
        GetSubscription10_IT.class,
        GetSubscription26_pt1_IT.class,
        GetSubscription26_pt2_IT.class,
        GetSubscription26_pt3_IT.class,
        GetSubscription26_pt4_IT.class,
        GetSubscription26_pt5_IT.class,
        GetSubscription26_pt6_IT.class,
        GetSubscription26_pt7_IT.class,
        GetSubscription26_pt8_IT.class,
        GetSubscription26_pt9_IT.class,
        GetSubscriptions18_IT.class,
        GetSubscriptions2_modifyAndRefundTransaction_IT.class,
        GetSubscriptions2_IT.class,
        GetTransactions6_pt1_IT.class,
        GetTransactions6_pt2_IT.class,
        GetTransactions6_pt3_IT.class,
        GetTransactions6_pt4_IT.class,
        GetVersion_IT.class,
        InactivateSubscription6_IT.class,
        GetSubscriptions2_ECP17_IT.class,
        ModifySubscriptionChargingMethod_IT.class,
        PurchasePackageMsisdn_IT.class,
        UpdateServiceStatus_IT.class,
        UsageAuth1_no_valid_pack_IT.class,
        UsageAuth1_pt1_IT.class,
        UsageAuth1_pt10_IT.class,
        UsageAuth1_pt2_IT.class,
        UsageAuth1_pt3_IT.class,
        UsageAuth1_pt4_IT.class,
        UsageAuth1_pt5_IT.class,
        UsageAuth1_pt6_IT.class,
        UsageAuth1_pt7_IT.class,
        UsageAuth1_pt8_IT.class,
        UsageAuth1_pt9_IT.class,
        UsageAuthRate2_pt1_IT.class,
        UsageAuthRate2_pt10_IT.class,
        UsageAuthRate2_pt11_IT.class,
        UsageAuthRate2_pt2_IT.class,
        UsageAuthRate2_pt3_IT.class,
        UsageAuthRate2_pt4_IT.class,
        UsageAuthRate2_pt5_IT.class,
        UsageAuthRate2_pt6_IT.class,
        UsageAuthRate2_pt7_IT.class,
        UsageAuthRate2_pt8_IT.class,
        UsageAuthRate2_pt9_IT.class,
        UsageAuthRateCharge3_pt1_IT.class,
        UsageAuthRateCharge3_pt2_IT.class,
        UsageAuthRateCharge3_pt3_IT.class,
        UsageAuthRateCharge3_pt4_IT.class,
        UsageAuthRateCharge3_pt5_IT.class,
        UsageAuthRateCharge3_pt6_IT.class,
        UsageAuthRateCharge3_pt7_IT.class,
        UsageAuthRateCharge3_pt8_IT.class,
        UsageAuthRateCharge3_PurchaseOptions_pt1_IT.class,
        UsageComplete4_pt1_IT.class,
//        UsageComplete4_pt2_IT.class,
//        UsageComplete4_pt3_IT.class,
//        UsageComplete4_pt4_IT.class,
//        UsageComplete4_pt5_IT.class,
//        UsageComplete4_pt6_IT.class,
        UsageComplete4_pt7_IT.class

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

        Logger.getRootLogger().setLevel(Level.DEBUG);
        Logger.getLogger("com.vodafone").setLevel(Level.DEBUG);

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
