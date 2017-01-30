package com.vodafone.er.ecom.proxy.server;

import com.vodafone.er.ecom.proxy.CatalogApiServlet;
import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.handlers.PathHandler;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;
import io.undertow.util.Headers;

import javax.servlet.ServletException;

public class UndertowServer {
    public static void main(String [] args) throws ServletException {

//        startSimpleHelloWorld();

        DeploymentInfo servletBuilder = Servlets.deployment()
                .setClassLoader(UndertowServer.class.getClassLoader())
                .setContextPath("/delegates")
                .setDeploymentName("epa.war")
                .addServlets(Servlets.servlet("CatalogApiServlet", CatalogApiServlet.class)
                                .addMapping("/CatalogApi"));


        DeploymentManager manager = Servlets.defaultContainer().addDeployment(servletBuilder);
        manager.deploy();
        PathHandler path = Handlers.path(Handlers.redirect("/delegates"))
                .addPrefixPath("/delegates", manager.start());

        Undertow server = Undertow.builder()
                .addHttpListener(8888, "localhost")
                .setHandler(path)
                .build();
        server.start();

    }


    private static void startSimpleHelloWorld() {
        //Deploy a warfile and deploy
        Undertow server = Undertow.builder()
                .addHttpListener(8888, "localhost")
                .setHandler(httpServerExchange -> {
                    httpServerExchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                    httpServerExchange.getResponseSender().send("Hello World");
                }).build();
        server.start();
    }
}
