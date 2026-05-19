# Employee Management System

This project is a full-stack Employee Management system featuring a Spring Boot backend and a React (Vite) frontend.

## Project Structure

- `employee-backend/`: The Java Spring Boot application that provides RESTful APIs for managing employee data.
- `employee-react-frontend/`: A modern React application built with Vite, providing the user interface to interact with the backend APIs.
- `employee-frontend/`: An alternative/legacy Java-based frontend.

## 🚀 Backend (`employee-backend`)

A REST API built with Java and Spring Boot.

### Tech Stack
- **Java:** 17
- **Framework:** Spring Boot 3.3.5
- **Database:** MySQL
- **ORM:** Spring Data JPA

### Getting Started
1. Navigate to the backend directory:
   ```bash
   cd employee-backend
   ```
2. Configure your MySQL database settings in `src/main/resources/application.properties`.
3. Build and run the project using Maven:
   ```bash
   ./mvnw spring-boot:run
   ```
   Or on Windows:
   ```cmd
   mvnw.cmd spring-boot:run
   ```
4. The API will start on the default port (typically `http://localhost:8080`).

## 💻 Frontend (`employee-react-frontend`)

A dynamic user interface built with React.

### Tech Stack
- **Library:** React 19
- **Build Tool:** Vite
- **Routing:** React Router v7
- **HTTP Client:** Axios

### Getting Started
1. Navigate to the React frontend directory:
   ```bash
   cd employee-react-frontend
   ```
2. Install the required dependencies:
   ```bash
   npm install
   ```
3. Start the development server:
   ```bash
   npm run dev
   ```
4. The application will be accessible at `http://localhost:5173`. Make sure the backend is running so that network requests complete successfully.

## Additional Documentation
- See the [backend HELP.md](./employee-backend/HELP.md) for more details referencing Spring Boot workflows.
- Check the [frontend README.md](./employee-react-frontend/README.md) for Vite-specific frontend documentation.
