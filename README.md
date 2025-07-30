# Spring Boot User Management REST API

### A secure and role-based User Management REST API built using Spring Boot, JWT, Spring Security, and MySQL.

# Features
- User Registration and Login  
- JWT Authentication (Token-based login)  
- Role-based Authorization (ROLE_USER, ROLE_ADMIN)  
- Secure API access using Spring Security  
- Global Exception Handling using @ControllerAdvice  
- Compatible with MySQL database  
- Clean code, DTO-based, and scalable architecture

#  Tech Stack
- Java 17+
- Spring Boot 3.x
- Spring Security
- Spring Data JPA
- JWT
- MySQL Database
- Maven
- Postman (for testing)
- Lombok

# Configure MySQL
- Make sure MySQL is installed and running
 
### Create a database:
- CREATE DATABASE user_management_service;

# application.properties
- spring.datasource.url=jdbc:mysql://localhost:3306/user_management_service
- spring.datasource.username=root
- spring.datasource.password=root
- spring.jpa.hibernate.ddl-auto=update
- spring.jpa.show-sql=true
- spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

## Make sure your pom.xml includes:
- Spring Web
- Security
- JPA
- Lombok
- MySQL
- JWT
- JAXB

