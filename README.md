# Java-Project

Paruvatha Bus-Ticket Booking Website:

The website uses modern frontend technologies 💻 for the user interface and Spring Boot ⚙️ as the backend framework to manage business logic and data handling. It leverages a SQL database 🗃️ for persistent storage of user and booking information.
The functionality is modeled after platforms like MakeMyTrip and Redbus 🌐. Users can search for routes and destinations 🔍, and upon selection, view a list of available buses 🚍. After seat selection and successful payment 💳, the booked seats are marked as unavailable ❌ in real time, ensuring accuracy in seat availability ✅.

Throughout the development process, I gained hands-on experience with the Spring Boot architecture 🧱, particularly the Controller, Service, and Repository layers. I used Postman 📬 for API testing and Swagger 📘 for generating interactive API documentation.

SPRING BOOT LAYERS:

📦 Spring Boot Layered Architecture Explanation
This document explains the core layers of a Spring Boot application, commonly used in full-stack web projects like the Paruvatha Bus Booking Website. The architecture is divided into four main layers: Model, Controller, Service, and Repository.

🧩 Model Layer
Represents the domain or data of the application.

In Spring Boot with JPA, a model is typically annotated with @Entity.

Directly maps to a database table.

Each instance of the model corresponds to a row in the table.

Example Use:
BusDetails.java → Represents a bus and its attributes like name, type, available seats, etc.

🌐 Controller Layer
Handles HTTP requests from the client (e.g., browser, mobile app).

Listens for methods such as GET, POST, PUT, and DELETE.

Acts as a bridge between the frontend and the backend services.

Should remain thin by delegating logic to the Service layer.

Responsibilities:

Receive and map web requests.

Validate and forward data to the service layer.

Return responses (usually as JSON or HTML).

⚙️ Service Layer
Contains the business logic of the application.

Serves as the middle layer between the Controller and the Repository.

Keeps the Controller clean and focused on routing.

Responsibilities:

Implement business rules (e.g., ticket pricing, seat availability).

Perform logic-heavy operations.

Reuse logic across multiple controllers or background jobs.

Advantages:

Code Separation: Business logic isn't mixed with request-handling code.

Reusability: Easily reused in multiple parts of the application.

Security & Transactions: Good place for @Transactional logic and security checks.

🗃️ Repository Layer
Handles data persistence and database communication.

Uses Spring Data JPA to avoid writing SQL or boilerplate DAO code.

Interfaces typically extend JpaRepository or CrudRepository.

## ER DIAGRAM 

https://docs.google.com/document/d/1RpBsr0pv3KiRkdf03Gr6Rd56pEGutXepJpe0GJs-byk/edit?tab=t.0

## Architecture Diagram

https://docs.google.com/document/d/1MamdkhSR0qnuDUgKV680q6bkyhC1UET_UeOqeYdtRto/edit?tab=t.0

## JWT AUTHENTICATION - Learning

https://docs.google.com/document/d/1KvNKW3z6GL02xK5p_KYD6dFMBrxj_-c-cDfdaLYo250/edit?tab=t.0#heading=h.9c832bot7uqg

