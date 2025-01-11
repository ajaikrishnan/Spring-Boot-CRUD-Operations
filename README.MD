# Spring Boot CRUD Operations - Registration System

This is a Spring Boot CRUD operations application that allows you to manage user registrations. It supports creating, retrieving, updating, deleting, and counting registration records through a set of RESTful APIs. 

## Features
- **Create**: Add a new registration record.
- **Read**: Retrieve all registrations or a specific registration by ID.
- **Update**: Update an existing registration.
- **Delete**: Remove a specific registration by ID.
- **Count**: Get the total number of registered users.

## Technologies Used
- **Spring Boot**: Backend framework for creating RESTful APIs.
- **Java 21**: Programming language.
- **JPA (Java Persistence API)**: Used to interact with the database.
- **H2 Database**: In-memory database for quick testing (you can switch to another database easily).
- **Validation**: Input validation with annotations.
- **Lombok**


## Database Setup

Before running the application, you need to set up a MySQL database. Here's how:

### 1. **Create a MySQL Database**
   - Open **MySQL Workbench**.
   - Run the following SQL command to create a database named `registration`:

     ```sql
     CREATE DATABASE registration;
     ```

### 2. **Configure Database Connection in `application.properties`**
   - Open the `src/main/resources/application.properties` file.
   - Add your MySQL database credentials (username, password) and the database name. Update the following properties:

     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/registration
     spring.datasource.username=your-username
     spring.datasource.password=your-password
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
     spring.jpa.show-sql=true
     ```

   Replace `your-username` and `your-password` with your actual MySQL credentials.

### 3. **Ensure the MySQL Server is Running**
   - Make sure your MySQL server is up and running before starting the application.

---

## API Endpoints

### 1. Create a Registration
- **URL**: `/api/add`
- **Method**: `POST`
- **Description**: Create a new registration record.
- **Request Body**:
  ```json
  {
    "name": "John Doe",
    "email": "john.doe@example.com",
    "age": 30
  }
  ```
- **Response** :
 ```
 {
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com",
  "age": 30
}
```
### 2. Get All Registrations
- **URL** /api/get_all
- **Method**: GET
- **Description**: Retrieve all registration records.
- **Response** :
```
[
  {
    "id": 1,
    "name": "John Doe",
    "email": "john.doe@example.com",
    "age": 30
  },
  {
    "id": 2,
    "name": "Jane Smith",
    "email": "jane.smith@example.com",
    "age": 25
  }
]
```
### 3. Get a Registration by ID 

- **URL** /api/get/{id}
- **Method**: GET
- **Description**: Retrieve a specific registration by ID.
- **Response** :
```
{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com",
  "age": 30
}

```
### 4. Delete a Registration by ID 

- **URL** /api/delete/{id}
- **Method**: DELETE
- **Description**: Delete a specific registration by ID.
- **Response** :
```
"User with ID 1 deleted successfully."


```
### 5. Update a Registration

- **URL** /api/update/{id}
- **Method**: PUT
- **Description**: Update an existing registration record.
- **Request Body** :
```
{
  "name": "John Doe Updated",
  "email": "john.doe.updated@example.com",
  "age": 31
}

```
- **Response** :
```
{
  "id": 1,
  "name": "John Doe Updated",
  "email": "john.doe.updated@example.com",
  "age": 31
}
```

### 3. Get User Count

- **URL** /api/count
- **Method**: GET
- **Description**: Retrieve the total number of registered users.
- **Response** :
```
"Total registered users: 3"
```

## How to Run

# Prerequisites
Java 21 
Maven
Your favorite IDE (e.g., IntelliJ IDEA, Eclipse)

## Steps to Run
1. Clone the repository:
```
git clone https://github.com/ajaikrishnan/spring-boot-crud-operations.git
```

2. Navigate to the project directory:
```
cd spring-boot-crud-operations
```
3. Run the application:
```
./mvnw spring-boot:run

````

## Contribution
Feel free to fork the repository, contribute by submitting issues and pull requests, and improve the project!

## License
This project is licensed under the MIT License - see the LICENSE file for details.


