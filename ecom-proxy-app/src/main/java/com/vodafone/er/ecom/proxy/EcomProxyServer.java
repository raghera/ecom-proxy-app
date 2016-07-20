package com.vodafone.er.ecom.proxy;

public class EcomProxyServer {

	public static void main(String[] args) throws Exception {
//		BasicConfigurator.configure();
//
//		Logger.getRootLogger().setLevel(Level.DEBUG);
//		Logger.getLogger("com.vodafone").setLevel(Level.DEBUG);
//		ConsoleAppender ca = new ConsoleAppender(new PatternLayout("%-5p [%t]: %m%n"));
//		ca.setWriter(new OutputStreamWriter(System.out));
//		Logger.getLogger("com.vodafone").addAppender(ca);
//		Logger.getRootLogger().addAppender(ca);
//		Logger.getLogger("com.vodafone.config").setLevel(Level.OFF);
//
//		Logger.getLogger("org.mortbay").setLevel(Level.ERROR);
//
//
//		// Create server and root context
//		Server server = new Server();
//
//		Connector connector = new SocketConnector();
//		connector.setPort(8888);
//		server.addConnector(connector);
//		Context context = new Context(server, "/delegates", Context.SESSIONS);
//
//
//		context.addServlet(ChargingApiServlet.class, "/ChargingApi");
//		context.addServlet(PurchaseApiServlet.class, "/PurchaseApi");
//		context.addServlet(CatalogApiServlet.class, "/CatalogApi");
//		String url = "/*";
////		FilterHolder ccWebAppFilter = new FilterHolder(WicketFilter.class);
////		ccWebAppFilter.setInitParameter("applicationClassName", CCWebApp.class.getCanonicalName());
////		ccWebAppFilter.setInitParameter(WicketFilter.FILTER_MAPPING_PARAM, url);
////		ccWebAppFilter.setInitParameter("configuration", "development");
//
////		adminWebApp.setInitParameter("configuration", "deployment");
////		FilterHolder authFilter = new FilterHolder(CCAuthFilter.class);
////		authFilter.setInitParameter("exclude-regex", "([^\\s]+(\\.(?i)(jpg|png|gif|bmp|css|js))$)");
////
////		authFilter.setInitParameter("name", CCWebApp.appName);
////		authFilter.setInitParameter("permissions", getPermissions());
////		if (!CustCareConfig.aaaIsStubbed)	//TODO fix java.lang.SecurityException: class "com.sun.xml.bind.DatatypeConverterImpl"
////			context.addFilter(authFilter, "/*", org.mortbay.jetty.Handler.DEFAULT);
//		//CustCareConfig.aaaIsStubbed=true;	//required since jaxb libraries clash with decoupling client libs
////		CustCareConfig.developmentMode=true;
////		String adminPermissions = "[\"View roles\",\"Create role\",\"Edit role\",\"Delete role\",\"Manage users in role\",\"View audit log\",\"View user list\"]";
////		authFilter.setInitParameter("admin-permissions", adminPermissions);
//
//
////		context.addFilter(ccWebAppFilter, url, org.mortbay.jetty.Handler.DEFAULT);
//
//		context.addServlet(DefaultServlet.class, "/");
//
//		ResourceHandler fileHandler = new ResourceHandler();
//		fileHandler.setResourceBase("/");
//
//		server.addHandler(fileHandler);
//
//		// Start server
//		server.start();
//		server.join();
	}


//	private static String getPermissions() {
//		Gson gson = new Gson();
//		return gson.toJson(AuthUtils.getConstraintMap());
//	}

}
