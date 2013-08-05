ussd-java-sample
================
The ussd-java-sample application is web application that gives a glimpse on what can be done in the web development
community to get an application running on USSD technology. 

<h2>HowTo</h2>
<p>
To be able to run this application one needs to have the Eclipse Java EE installed because the project is an eclipse
project. The project name is UssdSample. S/He also needs to have at least Apache Tomcat Web container installed on her/his workstation. The only library
that is required to download is the google-gson library that does not have any particular dependency except the JDK.
</p>
<p>
Once these tools are set, you only need to download the source code from here and import it as project into your eclipse
workspace and add the google-gson jar file into your tomcat lib folder or your web container lib folder(it depends upon what you are using as a web container). When that is done just build and run it. Here you can build as a war file and deploy it in your web container or directly run from eclipse.
</p>
<p>
The source code contains only one servlet called UssdHandler that handles the ussd request. 
It is the only resource to expose as url to receive ussd request from the SMSGH USSD API. 
For instance when you run it to receive ussd request your application url may look like this:<strong>
http://localhost:8080/UssdSample/UssdHandler</strong> 
</p>


