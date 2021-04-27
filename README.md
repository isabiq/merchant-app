# Merchant app demo

A simple merchant application using soap protocol to expose merchant and product CRUD services 

### Environment

* Linux
* java "1.8.0_242"
* apache-tomcat "9.0.45"
* maven "3.6.3"
* Postgresql "10.16"

### Configuration and Compilation

Create a database in postgresql, then execute the **merchant-app-schema.sql** script to load the application schema. The script is in **src/main/resources**.
 
Open the file **connection.properties** in **src/main/resources** directory and put in the correct database properties.

Generate the war file by executing the following command :

```
mvn clean verify
```

### Deployment

Take the generated war in the "target" directory and place it in **webapps** directory in tomcat then start the tomcat server.

### Test the application

if the application is started correctly you should have three soap endpoints. There wsdl can be accessed using the following links :

* http://{host}:{port}/{context}/merchant-service?wsdl
* http://{host}:{port}/{context}/product-service?wsdl
* http://{host}:{port}/{context}/merchant-product-service?wsdl