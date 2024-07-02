#  Waste Sorting Application

This is a Spring Boot application that provides RESTful APIs for managing waste categories, disposal guidelines, 
and recycling tips. The application uses an in-memory H2 database to store data and follows best practices for 
implementing REST APIs.

### **Table of Contents**

* Features
* Requirements
* Setup
* Running the Application

* Author

### Features

* Manage waste categories

* Manage disposal guidelines

* Manage recycling tips

* Input validation

* Global error handling

### **Requirements**

* Java 17

* Maven
* Browser or postman to test the endpoints

Run the application:
* Navigate to src/main/java/com/enviro/assessment/grad001/PreciousMotloung/WasteSortingApplication.java.
* Right-click on WasteSortingApplication.java.
* Select "Run WasteSortingApplication".

HTTPS URLs to Use
When running your Spring Boot application locally, assuming it's running on the default port 8080, you can access the endpoints using HTTPS URLs:

Waste Categories:

* http://localhost:8080/api/waste-categories

Disposal Guidelines:
* http://localhost:8080/api/disposal-guidelines

Recycling Tips:

* http://localhost:8080/api/recycling-tips

Once the application is running, you can access the H2 database console at:

http://localhost:8080/h2-console

Use the following settings to log in:

* JDBC URL: jdbc:h2:mem:testdb

* Username: sa

* Password: 12345678

**Project Author** 

Precious Motloung