package com.vodafone.er.ecom.proxy.server;

import org.apache.log4j.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AllowSymLinkAliasChecker;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;

public class EcomProxyJetty9Server {

    private int JETTY_PORT = 8888;
    private String JETTY_HOST = "localhost";
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
        System.out.println("EPA host " + props.getProperty("ecom.proxy.host"));
        System.out.println("EPA port " + props.getProperty("ecom.proxy.port"));


        String host = props.getProperty("ecom.proxy.host");
        int port = Integer.valueOf(props.getProperty("ecom.proxy.port"));

        Logger.getRootLogger().setLevel(Level.DEBUG);
        Logger.getLogger("com.vodafone").setLevel(Level.DEBUG);
        ConsoleAppender ca = new ConsoleAppender(new PatternLayout("%-5p [%t]: %m%n"));
        ca.setWriter(new OutputStreamWriter(System.out));
        Logger.getLogger("com.vodafone").addAppender(ca);
        Logger.getRootLogger().addAppender(ca);
        Logger.getLogger("com.vodafone.config").setLevel(Level.OFF);

        Logger.getLogger("org.eclipse").setLevel(Level.ERROR);

        Server server = new Server(8888);

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


