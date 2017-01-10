####### TOMCAT #######

This is a branch that demostrates an embedded Tomcat server to run EPA.
Currently we use Jetty for development and Wildfly in production.  However there is no reason why we cannot move to either.

Notes:
For running Tomcat simply run the main method in TomcatServer.java
You make have to manually create a webapps directory here e.g.
    mkdir <EcomProxyApp>/tomcat.8888/webapps
This removes an error about folder permissions and allows it to start properly.  (You can alternatively start Tomcat as root but not advised).
