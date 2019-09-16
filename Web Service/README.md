
---------------------------------------------- Question ---------------------------------

### Web Service Engineering Challenge

Create a "RESTful" web services to create, read, update, delete and search
customers table. *Note: using mysql is optional. The schema is provided for
reference purposes only.*

```
ws/customers.sql
```

---------------------------------------------- Solution - README ---------------------------------

username: abdu
password: abdu

Note:

- This folder has the solution for a web service challenge.
- I developed the rest api's using Spring Boot (2.1.8) and H2 in memory database. 
- The data will be populaeted automatically from the data.sql file which is found in resource folder.
- I have tested the api's using insomina rest client and alla re working perfectly. 
- I used a tool called Intellij IDEA, by JetBrains to code this specific problem.

- Good Luck to me.




--------------Database and service properties --------------

spring.datasource.url=jdbc:h2:mem:people10
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=abdu
spring.datasource.password=abdu
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.path=/h2
spring.h2.console.enabled=true


server.port=8082