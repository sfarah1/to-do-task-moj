HMCTS Task Manager

Submission for HMCTS Technical Test

A task management system for HMCTS caseworkers to create, view, update, and delete tasks. The system consists of a Spring Boot backend, a React frontend, and a PostgreSQL database.

Table of Contents

Project Overview

Technologies Used

Setup Instructions

Running the Application

Running with Docker

Testing

API Endpoints

Future Work

Project Overview

The application allows caseworkers to efficiently track and manage their tasks. Core features include:

Creating tasks with a title, optional description, status, and due date/time

Viewing all tasks or a specific task by ID

Updating the status of a task

Deleting tasks

A browser-based interface for interacting with the API

Technologies Used

Backend: Java 17, Spring Boot, Hibernate/JPA, Flyway

Frontend: React (Vite, JSX, CSS)

Database: PostgreSQL

Testing: JUnit 5, Spring Boot Test, MockMvc, Testcontainers

Build Tool: Maven (with wrapper)

Containerisation: Docker, Docker Compose

Continuous Integration: GitHub Actions

Setup Instructions

Clone the repository

git clone https://github.com/sfarah1/to-do-task-moj.git
cd to-do-task-moj


Backend setup

./mvnw clean install
./mvnw spring-boot:run


Backend will be available at:
http://localhost:8080/api/tasks

Frontend setup

cd todo-ui
npm install
npm run dev


Frontend will be available at:
http://localhost:5173

Database setup
Update PostgreSQL credentials in application.yml.
Flyway will handle schema creation and migrations.

Running with Docker
docker-compose up --build


Backend: http://localhost:8080/api/tasks

Frontend: http://localhost:5173

Testing

Run the full test suite with:

./mvnw test


Tests cover:

Task creation with validation

Retrieval of all tasks and tasks by ID

Status updates

Deletion with error handling for missing tasks

Continuous Integration:
This repository includes a GitHub Actions workflow (.github/workflows/maven.yml).
On each push or pull request to main, the workflow:

Checks out the code

Sets up JDK 17

Runs ./mvnw clean install to build the project and execute tests

You can view workflow runs in the repository’s Actions tab.

API Endpoints
Method	Route	Description
POST	/api/tasks	Create a new task
GET	/api/tasks	Retrieve all tasks
GET	/api/tasks/{id}	Retrieve a task by ID
PATCH	/api/tasks/{id}/status	Update task status
DELETE	/api/tasks/{id}	Delete a task
Future Work

Update task title and description

Sorting and filtering by due date or status

Improved UI design and accessibility

Authentication and role-based permissions

Deployment pipeline for cloud environments