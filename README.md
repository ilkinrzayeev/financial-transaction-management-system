# Financial Transaction Management System

A layered, SOLID-compliant Spring Boot backend application for managing banking operations such as customer and account management, money transfers, daily interest calculation, and transaction logging. The project is dockerized and documented with Swagger.

## Features

- Customer management (add, update, view)
- Account management (create, view, balance inquiry)
- Money transfers between accounts with balance checks and transaction rollback
- Daily interest calculation and logging
- Error handling with meaningful messages and global exception handler
- Logging with SLF4J
- API documentation with Swagger/OpenAPI
- Unit testing with JUnit/Mockito
- Dockerized deployment

## Tech Stack

- Java 17+
- Spring Boot
- H2 or PostgreSQL
- SLF4J
- JUnit, Mockito
- Swagger/OpenAPI
- Docker

## Getting Started

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/financial-transaction-management-system.git
   ```
2. **Build and run the backend:**
   ```bash
   ./gradlew bootRun
   ```
3. **Access Swagger UI:**
   ```
   http://localhost:8080/swagger-ui.html
   ```
   

## Docker

To run the application with Docker:
```bash
docker build -t financial-backend .
docker run -p 8080:8080 financial-backend
```

Or use Docker Compose (recommended for multi-service setup):
```bash
docker-compose up --build
```

## API Endpoints

- `POST /customers` - Add new customer
- `GET /customers/{id}` - Get customer details
- `PUT /customers/{id}` - Update customer details
- `POST /accounts` - Create new account
- `GET /accounts/{customerId}` - List accounts for a customer
- `POST /transfers` - Transfer money between accounts
