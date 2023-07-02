<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
</head>
<body>
  <h1>Bakery Management Project</h1>
  <h2>Database</h2>
  <p>The database is modeled using an Entity-Relationship (E-R) diagram. The diagram defines the following entities and their attributes:</p>
  <ul>
    <li>"store": represents the bakeries' locations and has attributes such as "store_id" (store identifier), "address" (store address), "has_cafeteria" (indicates if the store has a cafeteria), and "description" (store description).</li>
    <li>"employee": represents the bakery employees and has attributes such as "employee_id" (employee identifier), "name" (employee name), "last_name_1" (employee's first last name), and "last_name_2" (employee's second last name).</li>
    <li>"works": a relationship entity that represents the association between employees and the stores where they have worked. It includes attributes like "start_date" (employee's start date at the store) and "end_date" (employee's end date at the store).</li>
  </ul>
  <h2>Java Classes</h2>
  <p>The project is structured in a package called "bakery", which contains the necessary classes for implementing the application. These classes define attributes, constants, and methods to interact with the database and perform the required operations. Here are the main classes in the package:</p>
  <ul>
    <li>"Store" class: represents the "store" entity in the database. It includes attributes corresponding to the entity's properties and methods to access and modify those attributes.</li>
    <li>"Employee" class: represents the "employee" entity in the database. It includes attributes corresponding to the entity's properties and methods to access and modify those attributes.</li>
    <li>"Works" class: represents the "works" relationship entity in the database. It includes attributes corresponding to the relationship's properties and methods to access and modify those attributes.</li>
    <li>"Database" class: manages the database connection and executes SQL queries. It provides methods to perform simple and complex queries using the JDBC (Java Database Connectivity) connector.</li>
  </ul>
  <h2>Main Features</h2>
  <p>The application offers several functionalities related to bakery management. Here are the main implemented features:</p>
  <ul>
    <li>Database connection: the "Database" class handles the connection to the database using the JDBC connector.</li>
    <li>Data loading: an initial data loading program inserts content into the database from CSV files. These files contain example data to be loaded into the corresponding tables. Data loading is performed without integrity errors.</li>
    <li>SQL queries: the "Database" class provides methods to execute SQL queries from Java. Both simple and complex queries can be performed using the appropriate JDBC classes.</li>
    <li>Result handling: the application handles the results of SQL queries within the Java code. It implements an Object-Relational Mapping (ORM) system where each object of the "Store," "Employee," and "Works" classes corresponds to a row in the respective table. When modifying an attribute's value, it is automatically updated in the database. When requesting the value of an attribute from an object, it is updated from the database.</li>
    <li>Transaction management: the application implements a transaction system using Java code. This allows secure and consistent insertion, modification, and deletion of data in the database.</li>
  </ul>
  <h2>Conclusions</h2>
  <p>The bakery management project implements a Java application that interacts with a database using the JDBC connector. The application allows for SQL queries, data loading from CSV files, and management of information regarding bakery stores and employees. The implementation includes an ORM system for handling query results and a transaction mechanism to ensure data integrity.</p>
</body>
</html>
