# Calculator Web Application - Quick Start Guide

## Overview
A complete Java Spring Boot calculator application with MySQL database, JSP frontend, and REST API.

---

## Quick Setup (5 minutes)

### 1. Run Setup
```bash
setup-complete.bat
```

### 2. Configure Database
Edit `src\main\resources\application.properties`:
```properties
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

### 3. Build & Run
```bash
# Build
mvn clean package

# Run locally
mvn spring-boot:run
```

### 4. Access Application
- Web UI: http://localhost:8080/
- API: http://localhost:8080/api/calculator/

---

## Project Structure

```
calculator-app/
├── src/main/java/com/calculator/
│   ├── config/          # Configuration classes
│   ├── controller/      # Web & REST controllers
│   ├── model/           # Entity classes
│   ├── repository/      # Data access
│   ├── service/         # Business logic
│   ├── dto/             # Data transfer objects
│   └── exception/       # Custom exceptions
├── src/main/resources/
│   ├── static/          # CSS, JS, Images
│   └── application.properties
├── src/main/webapp/WEB-INF/views/
│   └── calculator.jsp   # Main view
└── src/test/            # Unit tests
```

---

## Key Features

✨ **User Interface**
- Modern gradient design
- Responsive layout
- Real-time calculations
- Calculation history

🔧 **Technical Features**
- Spring Boot 3.2.0
- Java 21
- MySQL persistence
- RESTful API
- Tomcat 9 compatible
- WAR deployment ready

📊 **Operations**
- Addition
- Subtraction
- Multiplication
- Division (with zero-check)

---

## Build Commands

```bash
# Development
mvn spring-boot:run

# Production Build
mvn clean package

# Run Tests
mvn test

# Skip Tests
mvn package -DskipTests
```

---

## Deployment

### Local Development
```bash
mvn spring-boot:run
```
Access: http://localhost:8080/

### Tomcat Deployment
```bash
# Build WAR
mvn clean package

# Copy to Tomcat
copy target\calculator-app.war %CATALINA_HOME%\webapps\

# Start Tomcat
%CATALINA_HOME%\bin\startup.bat
```
Access: http://localhost:8080/calculator-app/

---

## API Endpoints

### Web UI
- `GET /` - Calculator page
- `POST /calculate` - Perform calculation
- `POST /clear-history` - Clear history

### REST API
- `POST /api/calculator/calculate` - Calculate (JSON)
- `GET /api/calculator/history` - Get history
- `DELETE /api/calculator/history` - Clear history

---

## Database Setup

### Automatic (Recommended)
Application creates database automatically on first run.

### Manual Setup
```sql
CREATE DATABASE calculator_db;
USE calculator_db;
-- Tables created automatically by Hibernate
```

---

## Technology Stack

| Component | Technology |
|-----------|------------|
| Backend | Java 21, Spring Boot 3.2.0 |
| Frontend | JSP, JSTL, HTML5, CSS3, JavaScript |
| Database | MySQL 8.0+ |
| Build Tool | Maven 3.6+ |
| Server | Apache Tomcat 9 |
| ORM | Hibernate/JPA |
| Testing | JUnit 5, Mockito |

---

## Directory Structure Details

### `/src/main/java/com/calculator/`
- **config/** - Web and database configuration
- **controller/** - MVC and REST controllers
- **model/** - JPA entities
- **repository/** - Spring Data repositories
- **service/** - Business logic layer
- **dto/** - Data transfer objects
- **exception/** - Custom exception classes

### `/src/main/resources/`
- **static/** - CSS, JavaScript, images
- **application.properties** - Configuration
- **application-dev.properties** - Dev profile
- **application-prod.properties** - Prod profile

### `/src/main/webapp/WEB-INF/views/`
- **calculator.jsp** - Main calculator interface

### `/src/test/`
- Unit and integration tests

---

## Configuration Profiles

### Development
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

### Production
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```

---

## Troubleshooting

### MySQL Connection Issues
```bash
# Check if MySQL is running
net start MySQL80

# Test connection
mysql -u root -p
```

### Port Already in Use
Change port in `application.properties`:
```properties
server.port=8081
```

### Build Failures
```bash
# Clean and rebuild
mvn clean install

# Update dependencies
mvn dependency:resolve
```

---

## Support

For detailed documentation, see:
- `PROJECT_README.md` - Complete overview
- `docs/DOCUMENTATION.md` - Detailed technical docs (after first run)
- Comments in source code

---

## Requirements

- ✅ Java 21 JDK
- ✅ Maven 3.6+
- ✅ MySQL 8.0+
- ✅ Tomcat 9 (for WAR deployment)

---

## License

Educational project - Free to use and modify

---

**Version**: 1.0.0  
**Last Updated**: November 15, 2025  
**Compatible**: Java 21, Spring Boot 3.2.0, Tomcat 9
