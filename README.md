# 🚌 Paruvatha Bus-Ticket Booking Website

This is a full-stack **Bus Ticket Booking Website**, modeled after platforms like **MakeMyTrip** and **Redbus**. Users can search routes, view available buses, select seats, make payments, and see real-time seat availability.

---

## 🛠️ Tech Stack

- **Frontend:** HTML, CSS, JavaScript
- **Backend:** Java Spring Boot (REST API)
- **Database:** SQL
- **API Testing:** Postman
- **API Documentation:** Swagger

---

## 🔍 Key Features

- Route and destination search
- Real-time seat availability
- Seat selection and confirmation
- Payment integration (simulated)
- Instant booking and unavailable seat marking

---

## 🧱 Spring Boot Architecture

### 🧩 Model Layer
- Contains domain classes (e.g., `BusDetails.java`)
- Annotated with `@Entity`
- Maps to database tables

### 🌐 Controller Layer
- Handles HTTP requests (`GET`, `POST`, `PUT`, `DELETE`)
- Communicates with the service layer
- Returns JSON responses

### ⚙️ Service Layer
- Contains business logic
- Manages ticket pricing, seat checks, etc.
- Called by controllers

### 🗃️ Repository Layer
- Interfaces with the database
- Uses Spring Data JPA
- Extends `JpaRepository` or `CrudRepository`

---

## 📘 Documentation

- **ER Diagram:** [View ER Diagram](https://docs.google.com/document/d/1RpBsr0pv3KiRkdf03Gr6Rd56pEGutXepJpe0GJs-byk/edit?tab=t.0)  
- **Architecture Diagram:** [View Architecture](https://docs.google.com/document/d/1MamdkhSR0qnuDUgKV680q6bkyhC1UET_UeOqeYdtRto/edit?tab=t.0)  
- **JWT Authentication Notes:** [Learn JWT](https://docs.google.com/document/d/1KvNKW3z6GL02xK5p_KYD6dFMBrxj_-c-cDfdaLYo250/edit?tab=t.0#heading=h.9c832bot7uqg)

---

## 🖼️ Screenshots

### 📍 Home Page
![Home Page](https://github.com/user-attachments/assets/92b836e6-bd0e-402e-a983-3639e6ed72ba)

### 🧾 Booking Flow
![Booking Screenshot](https://github.com/user-attachments/assets/067f7dd9-55e3-465a-8b0a-302e75b50b9b)

---

## 🙌 What I Learned

- Spring Boot layered architecture
- Controller-Service-Repository pattern
- JWT Authentication
- API testing with Postman
- Swagger documentation

