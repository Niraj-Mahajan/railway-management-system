# Railway Management System

A backend REST API project built with Spring Boot.

During my 2.5+ years at TCS, I worked on Belgian Railway (NMBS-SNCB)
systems and gained deep understanding of how railway operations work.
I used that domain knowledge to build this project — focusing on real
business logic like seat availability and booking management rather
than just basic CRUD operations.

## Tech Stack
- Java 17
- Spring Boot 4
- Spring Data JPA + Hibernate
- MySQL
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

### Train
| Method | URL | Description |
|--------|-----|-------------|
| POST | /api/trains | Add a train |
| GET | /api/trains | Get all trains |
| GET | /api/trains/{id} | Get train by ID |
| PUT | /api/trains/{id} | Update train |
| DELETE | /api/trains/{id} | Delete train |

### Station
| Method | URL | Description |
|--------|-----|-------------|
| POST | /api/stations | Add a station |
| GET | /api/stations | Get all stations |
| GET | /api/stations/{id} | Get station by ID |
| PUT | /api/stations/{id} | Update station |
| DELETE | /api/stations/{id} | Delete station |

### Route
| Method | URL | Description |
|--------|-----|-------------|
| POST | /api/routes | Add a route |
| GET | /api/routes | Get all routes |
| GET | /api/routes/{id} | Get route by ID |
| PUT | /api/routes/{id} | Update route |
| DELETE | /api/routes/{id} | Delete route |

### Schedule
| Method | URL | Description |
|--------|-----|-------------|
| POST | /api/schedules | Add a schedule |
| GET | /api/schedules | Get all schedules |
| GET | /api/schedules/{id} | Get schedule by ID |
| PUT | /api/schedules/{id} | Update schedule |
| DELETE | /api/schedules/{id} | Delete schedule |

### Passenger
| Method | URL | Description |
|--------|-----|-------------|
| POST | /api/passengers | Add a passenger |
| GET | /api/passengers | Get all passengers |
| GET | /api/passengers/{id} | Get passenger by ID |
| PUT | /api/passengers/{id} | Update passenger |
| DELETE | /api/passengers/{id} | Delete passenger |

### Booking
| Method | URL | Description |
|--------|-----|-------------|
| POST | /api/bookings | Book a ticket |
| GET | /api/bookings | Get all bookings |
| GET | /api/bookings/{id} | Get booking by ID |
| PUT | /api/bookings/{id} | Update booking |
| PUT | /api/bookings/{id}/cancel | Cancel booking |
| DELETE | /api/bookings/{id} | Delete booking |