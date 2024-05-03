# Flow - a learning project.

## Purpose
This project was created to facilitate learning Java SpringBoot. I will be trying out Package By Feature instead of Package By Layer in this project, as it will be easier to migrate into microservices using this architecture. Let's gooo :)

## Tools Used
* PostgreSQL via Aiven (Cloud Data Platform)
* Java
* Spring Boot 3.2.5

## Notes
### Connecting to PostgreSQL database
* Required dependencies are JDBC API and PostgreSQL Driver in the pom.xml
* Add db properties into application.yml or application.properties file

### MVC Framework
MVC stands for Model, View, Controller.
1. Model - handles the application's data and business logic
2. View - handles the presentation layer, displaying data to users
3. Controller - intermediary between Model and View, handles the user input, processes it and manages the flow of data between Model and View.

### MVC in Java Spring Boot
1. Model in Spring Boot is represented by Java Objects, also known as Beans or Entities. These objects encapsulate data and business logic. 
Spring Data JPA and Hibernate are commonly used for data persistence.
2. View is the user interface. ThymeLeaf, JSP or other templating engine can be used. However, we will be using JavaScript and React.
3. Controller is the handler for user requests and manages the interaction between M and V.
Controllers are annotated with @Controller. They handle the REST API portion.
![img_1.png](img_1.png)

### Best Practices
1. Keep Controllers Thin
    * Controllers should focus on handling requests and managing the interactions between the Model and View. Do not place business logic in controllers.
2. Use DTOs
    * DTOs or Data Transfer Objects are used to ensure that only necessary data is exposed to the View.
3. RESTful Controllers
    * @RestController and @RequestMapping annotations
4. Validation
    * Implement input validation to ensure that data is accurate and secure.
# javaflow
