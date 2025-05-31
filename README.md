# Car Rental System

A comprehensive Car Rental Management System built in Java using Maven. The system is designed for small to medium-sized rental companies, offering functionality to manage vehicles, customers, and rental transactions in a modular, scalable architecture.


## Overview

This project provides a Java-based solution for managing car rentals, built on a modular architecture using the Maven build system. It allows the administration of customer details, vehicle listings, and rental operations, supporting future extensions such as reporting and analytics.

---

## Features

- Customer registration and profile management
- Vehicle registration and availability tracking
- Rental and return operations with timestamp records
- License and identity verification
- Database-driven data persistence
- Clean separation using MVC architecture

---

## Technology Stack

- **Java 8+**
- **Maven 3+**
- **MySQL / JDBC** (for data persistence)
- **JavaFX** (if GUI-based)
- **JUnit** (if testing is integrated)
- **IDE:** IntelliJ IDEA

---

## Project Structure

```
Car-Rental-System/
├── .idea/                # IntelliJ project settings
├── .mvn/wrapper/         # Maven wrapper scripts
├── src/
│   └── main/
│       ├── java/         # Source code (controllers, models, views)
│       └── resources/    # Application configs or UI files
├── .gitignore
├── mvnw / mvnw.cmd       # Maven wrapper (Unix/Windows)
├── pom.xml               # Maven build file
