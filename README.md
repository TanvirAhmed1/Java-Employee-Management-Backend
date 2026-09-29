# Employee Management System - Backend

REST API for the Employee Management System, built with **Spring Boot 4**, **Spring Data JPA**, and **MySQL**. It provides the CRUD endpoints consumed by the [React frontend](https://github.com/TanvirAhmed1/React-Employee-Management-Frontend).

## Tech Stack

- Java 26 (as configured in `pom.xml`)
- Spring Boot 4.2.0-M1
- Spring Web MVC (`spring-boot-starter-webmvc`)
- Spring Data JPA (Hibernate)
- MySQL 8+ (`mysql-connector-j`)
- Lombok
- Maven (wrapper included)

## Prerequisites

| Tool | Version |
|------|---------|
| JDK | 26 (or change `java.version` in `pom.xml` to the JDK you use) |
| MySQL | 8.0+ |
| Maven | Not required, `mvnw` is included |
| IDE | IntelliJ IDEA (recommended) |
| API testing | Postman |

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/TanvirAhmed1/Java-Employee-Management-Backend.git
cd Java-Employee-Management-Backend
```

### 2. Create the database

```sql
CREATE DATABASE ems;
```

Use any database name you like, as long as it matches the URL in the next step.

### 3. Configure the application

Edit `src/main/resources/application.properties`:

```properties
spring.application.name=ems-backend

spring.datasource.url=jdbc:mysql://localhost:3306/ems
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080
```

> `ddl-auto=update` creates and updates tables automatically. It is fine for learning, but not recommended for production.
> Never commit your real database password. Use environment variables or a local, git-ignored properties file.

### 4. Run the application

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

You can also run the main application class from IntelliJ IDEA. The API starts at `http://localhost:8080`.

## API Endpoints

Base URL: `http://localhost:8080/api/employees`

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/employees` | Create a new employee |
| GET | `/api/employees` | Get all employees |
| GET | `/api/employees/{id}` | Get an employee by ID |
| PUT | `/api/employees/{id}` | Update an employee |
| DELETE | `/api/employees/{id}` | Delete an employee |

### Sample request body

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com"
}
```

### Sample response

```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com"
}
```

## Project Structure

```
.
├── .mvn/wrapper/          # Maven wrapper
├── src/
│   ├── main/
│   │   ├── java/net/tanvirahmed/...   # controller, service, repository, entity, dto
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── mvnw / mvnw.cmd
└── pom.xml
```

## CORS

The React app runs on a different origin (`http://localhost:3000`), so the backend must allow it, for example:

```java
@CrossOrigin("http://localhost:3000")
```

## Testing with Postman

1. Start MySQL and the Spring Boot application.
2. Send requests to the endpoints above.
3. For POST and PUT, set the header `Content-Type: application/json` and use a raw JSON body.

## Related Repository

- Frontend (React JS): https://github.com/TanvirAhmed1/React-Employee-Management-Frontend

## License

This project is for learning purposes.
