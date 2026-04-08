# Railway Management System

A backend REST API project built with Spring Boot.

I built this project while transitioning into a Java developer role.
Having worked on Belgian Railway (NMBS-SNCB) systems at TCS for 3 years,
I understood the railway domain well — so I used that knowledge to build
something meaningful rather than a generic todo app.

## Tech Stack
- Java 17
- Spring Boot 4
- Spring Data JPA + Hibernate
- MySQL
- Spring Security
- Lombok

## What This System Does
- Manage trains, stations and routes
- Schedule train runs
- Passengers can book tickets
- Checks seat availability before confirming booking
- Cancelling a booking automatically restores the seat count

## Project Structure
- Entity → Repository → Service → Controller pattern
- DTO pattern for clean API responses
- Global Exception Handling with custom exceptions
- ResponseEntity with proper HTTP status codes
- JPA Relationships (OneToMany, ManyToOne)

## How to Run
1. Clone this repo
2. Create a MySQL database named `railway_db`
3. Add your DB credentials in `application.properties`
4. Run the Spring Boot application
5. Test APIs using Postman on `http://localhost:8080`

## API Endpoints
| Method | URL | Description |
|--------|-----|-------------|
| POST | /api/trains | Add a train |
| GET | /api/trains | Get all trains |
| POST | /api/bookings | Book a ticket |
| PUT | /api/bookings/{id}/cancel | Cancel booking |