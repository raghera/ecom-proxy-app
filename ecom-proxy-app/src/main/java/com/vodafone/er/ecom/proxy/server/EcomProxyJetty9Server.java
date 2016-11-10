package com.vodafone.er.ecom.proxy.server;

import com.vodafone.er.ecom.proxy.properties.PropertyService;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AllowSymLinkAliasChecker;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;
import java.io.OutputStreamWriter;
import java.util.Optional;

public class EcomProxyJetty9Server {

    private static final int JETTY_PORT = 8888;
    private static final String JETTY_HOST = "localhost";
    private static final int ER_CORE_PORT = 8094;
    private static final String ER_CORE_HOST = "127.0.0.1";
    private static final String WAR_PATH = "./ecom-proxy-app/target/ecom-proxy-app.war";
//    private static final String WAR_PATH = "./ecom-proxy-app/target/epa-integration-test-build.war";
    private static final String CONTEXT_PATH = "/delegates";

    private static final String keyStore = "./ecom-proxy-app/src/main/resources/certs/DIT_Client_Cert_v4.jks";
    private static final String keyStorePassword = "gig-dit-4";
//    private static final String trustStore = keyStore;
//    private static final String trustStorePassword = keyStorePassword;

    private static Server server;

    public static void main(String[] args) throws Exception {
        startServer();
    }

    public static void startServer() throws Exception {
        BasicConfigurator.configure();
        overrideProperties();

        Logger.getRootLogger().setLevel(Level.DEBUG);
        Logger.getLogger("com.vodafone").setLevel(Level.DEBUG);

        ConsoleAppender ca = new ConsoleAppender();
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

        setSystemProperties();

        webAppContext.setWar(warfile.getAbsolutePath());

        webAppContext.addAliasCheck(new AllowSymLinkAliasChecker());
        server.setHandler(webAppContext);

        server.start();
        server.join();

        System.out.println( "SERVER STATUS " + server.getState() );
    }

    public static void stopServer() throws Exception {
        server.stop();
        server.join();
    }

    //Set system properties programatically
    private static void setSystemProperties() {
        System.setProperty("DEBUG", "true");
        System.setProperty("org.eclipse.jetty.LEVEL", "DEBUG");
//        System.setProperty("javax.net.debug", "ALL");

        System.setProperty("javax.net.ssl.keyStore", keyStore);
        System.setProperty("javax.net.ssl.keyStorePassword", keyStorePassword);
//        System.setProperty("javax.net.ssl.trustStore", trustStore);
//        System.setProperty("javax.net.ssl.trustStorePassword", trustStorePassword);
    }

    private static void overrideProperties() {

        final Optional<String> host = PropertyService.getProperty("er.server.host", "127.0.0.1");
        final Optional<String> port = PropertyService.getProperty("er.server.port", "8094");

        System.out.println("ER host " + host);
        System.out.println("ER port " + port);

        PropertyService.setProperty("er.server.host", "127.0.0.1");
        PropertyService.setProperty("er.server.port", String.valueOf(ER_CORE_PORT));

        System.out.println("Overridden ER host " + PropertyService.getProperty("er.server.host", "127.0.0.1"));
        System.out.println("Overridden port " + PropertyService.getProperty("er.server.port", "8094"));

    }

}


