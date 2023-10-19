
# Car Rental System

## Introduction

This is a Car Rental System built using Spring Boot for various services, Eureka for service discovery, 
and an API Gateway for routing. Each service and dependency is containerized using Docker for easy deployment 
and scalability.

## Pre-requisites
Docker
Docker Compose
JDK 11 or above (if you wish to run outside Docker)

## Project Structure

* ├── APIGateway/
* ├── CustomerManagement/
* ├── PaymentProcessing/
* ├── RentalManagement/
* ├── ReservationManagement/
* ├── VehicleManagement/
* ├── ServiceDiscovery/
* ├── docker-compose.yml
* └── README.md

Each folder contains a Spring Boot application with its respective Dockerfile for containerization.

## Getting Started

## Build and Run using Docker Composer

1. Open a terminal and navigate to the root directory where docker-compose.yml is located.
2. Run the following command to build and run all the services:

`docker-compose up --build`

3. Once all the services are up and running, you can access the API Gateway at http://localhost:8080

This will pull all the necessary images and run the containers as per the configuration in docker-compose.yml.

Access the Services
Once all services are up and running, you can access them at the following URLs:

* API Gateway: http://localhost:8080
* Customer Management Service: http://localhost:8081
* Payment Processing Service: http://localhost:8082
* Rental Management Service: http://localhost:8083
* Reservation Management Service: http://localhost:8084
* Vehicle Management Service: http://localhost:8085
* Eureka Dashboard: http://localhost:8761

Here is a link to the Postman collection for the project:
[PostMan Collections](https://grey-comet-167805.postman.co/workspace/New-Team-Workspace~0a2572fc-77be-4598-bf36-8010e20477cd/collection/30507162-aaea016f-e727-4915-8025-a73c89f81cbc?action=share&creator=30507162&active-environment=30507162-0f565e0d-40d7-4103-9ac1-2030e4154a76)

## Troubleshooting

If you encounter any issues, you can stop all services by running:

`docker-compose down`

And then rerun the services using `docker-compose up --build`.

# Software engineering distance course group members
### 1.	Alazar Anbesi		615161
### 2.	Genene Aga			615154
### 3.	Shamim Babirye		615196
