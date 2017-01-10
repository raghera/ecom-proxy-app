package com.vodafone.er.ecom.proxy.server;

import org.apache.catalina.Context;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

public class TomcatServer {

    private static final String WAR_PATH = "./ecom-proxy-app/target/ecom-proxy-app.war";

    public static void main(String [] args) throws Exception {

        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8888);

        System.out.println("configuring app with basedir: " + new File("./" + WAR_PATH).getAbsolutePath());
//        StandardContext ctx = (StandardContext) tomcat.addWebapp("/delegates", new File(WAR_PATH).getAbsolutePath());
//
//        WebResourceRoot resources = new StandardRoot(ctx);
//        ctx.setResources(resources);
        File warfile = new File(WAR_PATH);
        if(!warfile.exists()) {
            System.out.println("WAR file does not exist");
        }

        Context ctx = tomcat.addWebapp("/delegates", new File(WAR_PATH).getAbsolutePath());
        WebResourceRoot resources = new StandardRoot(ctx);
        ctx.setResources(resources);

        tomcat.start();
        tomcat.getServer().await();



    }

}
