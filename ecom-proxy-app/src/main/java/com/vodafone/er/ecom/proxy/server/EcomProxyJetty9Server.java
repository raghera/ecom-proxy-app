package com.vodafone.er.ecom.proxy.server;

import com.vodafone.er.ecom.proxy.properties.PropertyService;
import org.apache.log4j.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AllowSymLinkAliasChecker;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Optional;
import java.util.Properties;

public class EcomProxyJetty9Server {

    private static final int JETTY_PORT = 8888;
    private static final String JETTY_HOST = "localhost";
    private static final String WAR_PATH = "./ecom-proxy-app/target/ecom-proxy-app.war";
    private static final String CONTEXT_PATH = "/delegates";

    public static void main(String[] args) throws Exception {
        BasicConfigurator.configure();

        Properties props = new Properties();
        InputStream in = EcomProxyJetty9Server.class.getClassLoader().getResourceAsStream("env.properties");

        System.out.println("Input stream " + in);
        props.load(in);

        System.out.println("ER host " + props.getProperty("er.server.host"));
        System.out.println("ER port " + props.getProperty("er.server.port"));


        final Optional<String> host = PropertyService.getProperty("ecom.server.host", "127.0.0.1");
        final Optional<String> port = PropertyService.getProperty("ecom.server.host", "8094");

        Logger.getRootLogger().setLevel(Level.DEBUG);
        Logger.getLogger("com.vodafone").setLevel(Level.DEBUG);
        ConsoleAppender ca = new ConsoleAppender(new PatternLayout("%-5p [%t]: %m%n"));
        ca.setWriter(new OutputStreamWriter(System.out));
        Logger.getLogger("com.vodafone").addAppender(ca);
        Logger.getRootLogger().addAppender(ca);
        Logger.getLogger("com.vodafone.config").setLevel(Level.OFF);

        Logger.getLogger("org.eclipse").setLevel(Level.ERROR);

        Server server = new Server(JETTY_PORT);

        ContextHandler contextHandler = new ContextHandler();
        contextHandler.setContextPath("/delegates");

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath(CONTEXT_PATH);
        File warfile = new File(WAR_PATH);
        System.out.println("Warfile present: " + warfile.exists());
        System.out.println("Warfile path: " + warfile.getAbsolutePath());

        System.out.println(System.getProperty("user.dir"));

        webAppContext.setWar(warfile.getAbsolutePath());

        webAppContext.addAliasCheck(new AllowSymLinkAliasChecker());
        server.setHandler(webAppContext);

        server.start();
        server.join();
    }

}


