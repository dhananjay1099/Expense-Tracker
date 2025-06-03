# Expense Tracker API

A simple Expense Tracker REST API built with Spring Boot, H2 Database, and JPA.

## Features
- Manage users, expenses, and categories
- CRUD operations for expenses and categories
- Filter expenses by date and category
- H2 in-memory database for easy setup

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Lombok (optional)

## Getting Started

1. **Clone the repository**
2. **Build the project**
   ```bash
   mvn clean install
   ```
3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```
4. **Access H2 Console**
   - Visit [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
   - JDBC URL: `jdbc:h2:mem:expensetracker`

## API Endpoints
- `/api/users` - Manage users
- `/api/expenses` - Manage expenses
- `/api/categories` - Manage categories

## Example cURL
```bash
curl -X POST http://localhost:8080/api/categories -H "Content-Type: application/json" -d '{"name":"Food"}'
```

---

MIT License 