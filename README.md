# Hibernate CRUD Application

A simple Java CRUD (Create, Read, Update, Delete) application built using **Hibernate ORM**, **Maven**, and **MySQL**. This project demonstrates how to perform database operations using Hibernate instead of writing raw JDBC code.

---

## Features

- Add a new student
- View student details
- Update student information
- Delete a student record
- Hibernate ORM integration
- Maven project
- MySQL database connectivity
- Annotation-based entity mapping

---

## Technologies Used

- Java 17
- Hibernate ORM 7
- Maven
- MySQL
- Eclipse IDE
- JDBC

---

## Project Structure

```
Hibernate
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.Hibernate
│   │   │       ├── Student.java
│   │   │       ├── HibernateUtil.java
│   │   │       └── HibernateMain.java
│   │   │
│   │   └── resources
│   │       └── hibernate.cfg.xml
│
├── pom.xml
└── README.md
```

---

## Database Configuration

Create a MySQL database.

```sql
CREATE DATABASE studentdb;
```

Update the database credentials inside `hibernate.cfg.xml`.

```xml
<property name="hibernate.connection.url">
    jdbc:mysql://localhost:3306/studentdb
</property>

<property name="hibernate.connection.username">
    root
</property>

<property name="hibernate.connection.password">
    your_password
</property>
```

---

## Maven Dependencies

- Hibernate ORM
- MySQL Connector/J

Install dependencies using:

```bash
mvn clean install
```

---

## CRUD Operations

### Create

Insert a new student record into the database.

### Read

Retrieve a student using the Student ID.

### Update

Modify an existing student's details.

### Delete

Delete a student record using the Student ID.

---

## How to Run

1. Clone the repository

```bash
git clone https://github.com/your-username/Hibernate.git
```

2. Open the project in Eclipse or IntelliJ IDEA.

3. Configure MySQL.

4. Create the database:

```sql
CREATE DATABASE studentdb;
```

5. Update the username and password in `hibernate.cfg.xml`.

6. Update Maven dependencies.

7. Run:

```
HibernateMain.java
```

---

## Sample Output

```
1. Insert
2. Read
3. Update
4. Delete
5. Exit

Enter Choice: 1

Enter Id: 101
Enter Name: Chaitanya
Enter Marks: 95

Inserted Successfully
```

---

## Learning Objectives

This project demonstrates:

- Hibernate Configuration
- Entity Mapping
- SessionFactory
- Session
- Transaction Management
- CRUD Operations
- MySQL Integration
- Maven Project Structure

---

## Future Improvements

- Student Search
- Pagination
- HQL Queries
- Criteria API
- One-to-One Mapping
- One-to-Many Mapping
- Many-to-One Mapping
- Many-to-Many Mapping
- Spring Boot Integration
- Spring Data JPA

---

## License

This project is intended for learning Hibernate ORM and Java database programming.
