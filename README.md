# ShoppingCartWebApp
Prerequisite:
1. [Java 1.8](https://www.oracle.com/in/java/technologies/javase/javase8u211-later-archive-downloads.html)
2. [Eclipse IDE for Java EE Developers](https://www.eclipse.org/ide/)
3. [Tomcat server](https://tomcat.apache.org/download-90.cgi)

Reference:
[Step by Step Guide to Setup and Install Apache Tomcat Server in Eclipse Development Environment](https://crunchify.com/step-by-step-guide-to-setup-and-install-apache-tomcat-server-in-eclipse-development-environment-ide/)

Steps to install:
1. Create a dynamic web project in Eclipse IDE

   ![DynamicWebProject](https://github.com/gloop2000/ShoppingCartWebApp/blob/main/DynamicWebProject.png "DynamicWebProject.png")
2. Add project to Tomcat instance

   ![AddOrRemoveOption.png](https://github.com/gloop2000/ShoppingCartWebApp/blob/main/AddOrRemoveOption.png "AddOrRemoveOption.png")
   ![AddOrRemove.png](https://github.com/gloop2000/ShoppingCartWebApp/blob/main/AddOrRemove.png "AddOrRemove.png")
   
3. Edit Server.xml
   
   Edit the Server.xml file in Servers in Project Explorer
   
   ![ServerConfig.png](https://github.com/gloop2000/ShoppingCartWebApp/blob/main/ServerConfig.png "ServerConfig.png")
   
   Edit the path to "/"
   
   ![serverXML.png](https://github.com/gloop2000/ShoppingCartWebApp/blob/main/serverXML.png "serverXML.png")
   
   
4. Clone/Download the github repository files and replace the content in "src" with downloaded files

   ![ProjectRef.png](https://github.com/gloop2000/ShoppingCartWebApp/blob/main/ProjectRef.png "ProjectRef.png")
   
4.Run index.jsp
   ![RunAs.png](https://github.com/gloop2000/ShoppingCartWebApp/blob/main/RunAs.png "RunAs.png")
