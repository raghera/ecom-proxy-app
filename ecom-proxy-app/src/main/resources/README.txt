EPA DEPLOYMENT TO WILDFLY 9 GUIDE

Below are brief steps on how to deploy this application as delivered as a Web Application Archive (WAR).

Easiest and recommended way:

This deploys an exploded deployment (Recommended)

- Get a war file delivery e.g. ecom-proxy-app.war
- Extract the war file to a folder called delegates.war/
    > mkdir delegates.war
    > cd delegates.war
    > jar -xvf ecom-proxy-app.war

- Copy the delegates.war/ directory to the standalone/deployments folder and create a marker file:
    > cd $JBOSS_HOME/standalone/deployments
    > cp -r $DIST_FOLDER/delegates.war .
    > touch delegates.war.dodeploy

The marker file signals to the server deployment scanner to deploy the application in the deployments folder called called delegates.war.  The runtime-name will be delegates.war
Once the deployment is complete the application server replaces delegates.war.dodeploy file with delegates.war.deployed

The above steps also work for deploying the ecom-proxy-app.war without being exploded.  Simply copy the .war file into the deployments folder mentioned.

Undeploy:

To undeploy the application having deployed it already simply remove the marker file delegates.war.deployed.
The scanner will undeploy the application and you should see a new marker file called delegates.war.undeployed

Verify Installation:

By default this should run on port 8080

Try going to http://<host><port>/delegates and you should see a Welcome page saying Ecom Proxy Application is running.

You can now try sending a request to the server.

Administration:

Can go to the console which is here:
http://localhost:9990/console

Configuration:
All application server configuration can be done in standalone.xml
