# Calculator Web Application - Complete Project Documentation

---

## 📋 Table of Contents
1. [Project Overview](#project-overview)
2. [Setup & Installation](#setup--installation)
3. [Project Structure](#project-structure)
4. [Architecture & Design](#architecture--design)
5. [Features & Functionality](#features--functionality)
6. [Configuration Guide](#configuration-guide)
7. [Build & Deployment](#build--deployment)
8. [API Reference](#api-reference)
9. [Testing Guide](#testing-guide)
10. [Troubleshooting](#troubleshooting)

---

## 🎯 Project Overview

### What is This Application?

The Calculator Web Application is a **full-stack enterprise-grade web application** built using modern Java technologies. It demonstrates best practices in Spring Boot development, including:

- **MVC Architecture** with clear separation of concerns
- **RESTful API** design for programmatic access
- **Database Persistence** using JPA/Hibernate
- **Modern UI/UX** with responsive design
- **Comprehensive Testing** with JUnit and Mockito
- **Production-Ready** deployment configurations

### Key Features

| Feature | Description |
|---------|-------------|
| ➕ **Basic Arithmetic** | Addition, Subtraction, Multiplication, Division |
| 📊 **History Tracking** | Persistent storage of all calculations |
| 🎨 **Modern UI** | Gradient design, animations, responsive layout |
| 🔌 **REST API** | JSON-based API for integration |
| 🗑️ **History Management** | View and clear calculation history |
| ⚡ **Real-time Feedback** | Instant calculation results |
| 🛡️ **Error Handling** | Division by zero protection, validation |
| 📱 **Mobile Responsive** | Works on all device sizes |

### Technology Stack Summary

```
┌─────────────────────────────────────────┐
│          Frontend Layer                  │
│  JSP • JSTL • HTML5 • CSS3 • JavaScript │
└─────────────────────────────────────────┘
                  ↓↑
┌─────────────────────────────────────────┐
│         Application Layer                │
│    Spring Boot 3.2.0 • Java 21          │
│    Spring MVC • Spring Data JPA          │
└─────────────────────────────────────────┘
                  ↓↑
┌─────────────────────────────────────────┐
│          Database Layer                  │
│        MySQL 8.0+ • Hibernate           │
└─────────────────────────────────────────┘
```

---

## 🚀 Setup & Installation

### Prerequisites Checklist

Before starting, ensure you have:

- [x] **Java 21 JDK** installed and configured
- [x] **Apache Maven 3.6+** installed
- [x] **MySQL 8.0+** installed and running
- [x] **Apache Tomcat 9** (optional, for WAR deployment)
- [x] **Git** (optional, for version control)

### Step-by-Step Installation

#### Step 1: Verify Prerequisites

```bash
# Check Java version
java -version
# Expected output: openjdk version "21.x.x"

# Check Maven
mvn -version
# Expected output: Apache Maven 3.6.x or higher

# Check MySQL
mysql --version
# Expected output: mysql Ver 8.0.x
```

#### Step 2: Project Setup

```bash
# Navigate to project directory
cd D:\Projects\GIT_Projects\catering

# Run the complete setup script
setup-complete.bat
```

This script will:
1. Create complete directory structure
2. Copy all source files to proper locations
3. Create configuration files
4. Set up test environment

#### Step 3: Database Configuration

**Option A: Automatic (Recommended)**

The application will automatically create the database on first run.

**Option B: Manual Setup**

```sql
-- Login to MySQL
mysql -u root -p

-- Create database
CREATE DATABASE calculator_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Verify
SHOW DATABASES;
```

**Configure Database Credentials**

Edit `src/main/resources/application.properties`:

```properties
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

#### Step 4: Build the Application

```bash
# Clean and build
mvn clean package

# Expected output:
# [INFO] BUILD SUCCESS
# [INFO] WAR file created: target/calculator-app.war
```

#### Step 5: Run the Application

**Development Mode (with hot reload)**:
```bash
mvn spring-boot:run
```

**Production Mode (standalone)**:
```bash
java -jar target/calculator-app.war
```

**Tomcat Deployment**:
```bash
copy target\calculator-app.war %CATALINA_HOME%\webapps\
%CATALINA_HOME%\bin\startup.bat
```

#### Step 6: Verify Installation

Open browser and navigate to:
- **Local**: http://localhost:8080/
- **Tomcat**: http://localhost:8080/calculator-app/

You should see the calculator interface.

---

## 📁 Project Structure

### Complete Directory Tree

```
calculator-app/
│
├── 📄 pom.xml                          # Maven configuration
├── 📄 .gitignore                       # Git ignore rules
├── 📄 setup-complete.bat               # Complete setup script
├── 📄 setup.bat                        # Basic setup script
├── 📄 setup-directories.bat            # Directory creation only
│
├── 📄 README.md                        # Main project readme
├── 📄 PROJECT_README.md                # Detailed overview
├── 📄 QUICKSTART.md                    # Quick start guide
├── 📄 COMPLETE_DOCUMENTATION.md        # This file
│
├── 📂 docs/                            # Documentation folder
│   └── 📄 DOCUMENTATION.md             # Technical documentation
│
├── 📂 scripts/                         # Utility scripts
│   ├── 📄 build.bat                    # Build script
│   ├── 📄 run-local.bat                # Run locally
│   ├── 📄 run-tests.bat                # Execute tests
│   └── 📄 database-setup.sql           # Database schema
│
├── 📂 src/
│   ├── 📂 main/
│   │   ├── 📂 java/com/calculator/
│   │   │   │
│   │   │   ├── 📄 CalculatorApplication.java      # Main Spring Boot class
│   │   │   │
│   │   │   ├── 📂 config/                         # Configuration
│   │   │   │   ├── 📄 DatabaseConfig.java         # DB configuration
│   │   │   │   └── 📄 WebConfig.java              # Web MVC configuration
│   │   │   │
│   │   │   ├── 📂 controller/                     # Controllers
│   │   │   │   ├── 📄 CalculatorController.java   # Web MVC controller
│   │   │   │   └── 📄 CalculatorRestController.java # REST API controller
│   │   │   │
│   │   │   ├── 📂 model/                          # Entity classes
│   │   │   │   └── 📄 CalculationHistory.java     # Calculation entity
│   │   │   │
│   │   │   ├── 📂 repository/                     # Data access
│   │   │   │   └── 📄 CalculationHistoryRepository.java
│   │   │   │
│   │   │   ├── 📂 service/                        # Business logic
│   │   │   │   └── 📄 CalculatorService.java      # Calculator service
│   │   │   │
│   │   │   ├── 📂 dto/                            # Data Transfer Objects
│   │   │   │   ├── 📄 CalculationRequest.java     # Request DTO
│   │   │   │   └── 📄 CalculationResponse.java    # Response DTO
│   │   │   │
│   │   │   └── 📂 exception/                      # Exceptions
│   │   │       └── 📄 CalculationException.java   # Custom exception
│   │   │
│   │   ├── 📂 resources/
│   │   │   ├── 📄 application.properties          # Main configuration
│   │   │   ├── 📄 application-dev.properties      # Dev profile
│   │   │   ├── 📄 application-prod.properties     # Production profile
│   │   │   │
│   │   │   └── 📂 static/                         # Static resources
│   │   │       ├── 📂 css/
│   │   │       │   ├── 📄 styles.css              # Global styles
│   │   │       │   └── 📄 calculator.css          # Calculator styles
│   │   │       ├── 📂 js/
│   │   │       │   ├── 📄 calculator.js           # Main JavaScript
│   │   │       │   └── 📄 api.js                  # API client
│   │   │       └── 📂 images/                     # Image assets
│   │   │
│   │   └── 📂 webapp/
│   │       └── 📂 WEB-INF/
│   │           └── 📂 views/
│   │               └── 📄 calculator.jsp          # Main JSP view
│   │
│   └── 📂 test/                                   # Test files
│       └── 📂 java/com/calculator/
│           ├── 📂 controller/
│           │   └── 📄 CalculatorControllerTest.java
│           └── 📂 service/
│               └── 📄 CalculatorServiceTest.java
│
└── 📂 target/                                     # Build output (generated)
    ├── 📂 classes/                                # Compiled classes
    ├── 📂 test-classes/                           # Test classes
    └── 📄 calculator-app.war                      # Final WAR file
```

### Directory Purposes

| Directory | Purpose |
|-----------|---------|
| `src/main/java/` | Java source code |
| `src/main/resources/` | Configuration files |
| `src/main/resources/static/` | CSS, JS, images |
| `src/main/webapp/WEB-INF/views/` | JSP view templates |
| `src/test/java/` | Unit and integration tests |
| `docs/` | Documentation files |
| `scripts/` | Build and utility scripts |
| `target/` | Build artifacts (auto-generated) |

---

## 🏗️ Architecture & Design

### Application Architecture

#### Layered Architecture

```
┌──────────────────────────────────────────────────┐
│                Presentation Layer                 │
│  ┌─────────────┐  ┌──────────────┐              │
│  │  Web UI     │  │  REST API    │              │
│  │  (JSP)      │  │  (JSON)      │              │
│  └─────────────┘  └──────────────┘              │
└──────────────────────────────────────────────────┘
                    ↓↑
┌──────────────────────────────────────────────────┐
│                Controller Layer                   │
│  ┌──────────────────────────────────────────┐   │
│  │  Request Handling & Response Formatting  │   │
│  │  - CalculatorController                  │   │
│  │  - CalculatorRestController              │   │
│  └──────────────────────────────────────────┘   │
└──────────────────────────────────────────────────┘
                    ↓↑
┌──────────────────────────────────────────────────┐
│                 Service Layer                     │
│  ┌──────────────────────────────────────────┐   │
│  │  Business Logic & Validation             │   │
│  │  - CalculatorService                     │   │
│  │  - Calculation logic                     │   │
│  │  - Error handling                        │   │
│  └──────────────────────────────────────────┘   │
└──────────────────────────────────────────────────┘
                    ↓↑
┌──────────────────────────────────────────────────┐
│                Repository Layer                   │
│  ┌──────────────────────────────────────────┐   │
│  │  Data Access & Persistence               │   │
│  │  - CalculationHistoryRepository          │   │
│  │  - Spring Data JPA                       │   │
│  └──────────────────────────────────────────┘   │
└──────────────────────────────────────────────────┘
                    ↓↑
┌──────────────────────────────────────────────────┐
│                  Data Layer                       │
│  ┌──────────────────────────────────────────┐   │
│  │  Database Storage                        │   │
│  │  - MySQL                                 │   │
│  │  - calculation_history table             │   │
│  └──────────────────────────────────────────┘   │
└──────────────────────────────────────────────────┘
```

### Design Patterns

#### 1. MVC (Model-View-Controller)

**Model**: `CalculationHistory.java`
- Represents data structure
- JPA entity with annotations
- Mapped to database table

**View**: `calculator.jsp`
- User interface
- Displays data from model
- Captures user input

**Controller**: `CalculatorController.java`
- Handles HTTP requests
- Processes user input
- Returns appropriate views

#### 2. Repository Pattern

```java
@Repository
public interface CalculationHistoryRepository 
    extends JpaRepository<CalculationHistory, Long> {
    // Abstraction of data access
    // Spring Data JPA provides implementation
}
```

#### 3. Service Layer Pattern

```java
@Service
public class CalculatorService {
    // Business logic encapsulation
    // Transaction management
    // Reusable across controllers
}
```

#### 4. DTO (Data Transfer Object)

```java
@Data
public class CalculationRequest {
    private Double operand1;
    private Double operand2;
    private String operator;
}
```

#### 5. Dependency Injection

```java
@Controller
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;
    // Spring manages dependencies
}
```

### Component Diagram

```
┌───────────────────────────────────────────────────┐
│                CalculatorApplication               │
│         (Main Spring Boot Application)            │
└───────────────────────────────────────────────────┘
        │
        ├─→ Controllers
        │   ├─→ CalculatorController (Web UI)
        │   └─→ CalculatorRestController (API)
        │
        ├─→ Services
        │   └─→ CalculatorService
        │       ├─→ calculate()
        │       ├─→ getRecentHistory()
        │       └─→ clearHistory()
        │
        ├─→ Repositories
        │   └─→ CalculationHistoryRepository
        │       └─→ Spring Data JPA Methods
        │
        ├─→ Models
        │   └─→ CalculationHistory (Entity)
        │
        ├─→ DTOs
        │   ├─→ CalculationRequest
        │   └─→ CalculationResponse
        │
        └─→ Configuration
            ├─→ WebConfig
            └─→ DatabaseConfig
```

---

## ⚙️ Features & Functionality

### Core Features

#### 1. **Arithmetic Operations**

**Addition**
- Operation: `operand1 + operand2`
- Example: `10 + 5 = 15`

**Subtraction**
- Operation: `operand1 - operand2`
- Example: `10 - 5 = 5`

**Multiplication**
- Operation: `operand1 × operand2`
- Example: `10 × 5 = 50`

**Division**
- Operation: `operand1 ÷ operand2`
- Example: `10 ÷ 5 = 2`
- Protection: Division by zero check

#### 2. **History Management**

- Stores all calculations in MySQL database
- Displays last 10 calculations
- Shows operands, operator, result, and timestamp
- Clear all history functionality

#### 3. **Error Handling**

- Division by zero protection
- Invalid operator detection
- Input validation
- User-friendly error messages

#### 4. **User Interface**

- Modern gradient design
- Smooth animations
- Responsive layout (mobile-friendly)
- Real-time feedback
- Form validation

#### 5. **REST API**

- JSON-based endpoints
- Programmatic access
- Integration-friendly
- Standard HTTP methods

---

## 🔧 Configuration Guide

### Application Properties

#### Main Configuration

**File**: `src/main/resources/application.properties`

```properties
# Application Name
spring.application.name=Calculator Web Application

# Server Configuration
server.port=8080
server.servlet.context-path=/

# JSP Configuration
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/calculator_db?createDatabaseIfNotExist=true&useSSL=false
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# HikariCP Configuration
spring.datasource.hikari.maximum-pool-size=10
spring.datasource.hikari.minimum-idle=5
spring.datasource.hikari.connection-timeout=30000

# JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.properties.hibernate.format_sql=true

# Logging Configuration
logging.level.com.calculator=DEBUG
logging.level.org.springframework.web=INFO
logging.level.org.hibernate.SQL=DEBUG
```

#### Development Profile

**File**: `src/main/resources/application-dev.properties`

```properties
# Development-specific settings
spring.datasource.url=jdbc:mysql://localhost:3306/calculator_db_dev
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.devtools.restart.enabled=true
logging.level.com.calculator=DEBUG
```

**Activate**: `mvn spring-boot:run -Dspring-boot.run.profiles=dev`

#### Production Profile

**File**: `src/main/resources/application-prod.properties`

```properties
# Production-specific settings
spring.datasource.url=jdbc:mysql://prod-server:3306/calculator_db
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=false
logging.level.com.calculator=INFO
```

**Activate**: `mvn spring-boot:run -Dspring-boot.run.profiles=prod`

### Database Configuration

#### Connection Properties

| Property | Description | Default |
|----------|-------------|---------|
| `spring.datasource.url` | Database URL | `localhost:3306/calculator_db` |
| `spring.datasource.username` | Database user | `root` |
| `spring.datasource.password` | Database password | `root` |
| `spring.datasource.driver-class-name` | JDBC driver | `com.mysql.cj.jdbc.Driver` |

#### Connection Pool (HikariCP)

| Property | Description | Default |
|----------|-------------|---------|
| `maximum-pool-size` | Max connections | `10` |
| `minimum-idle` | Min idle connections | `5` |
| `connection-timeout` | Timeout (ms) | `30000` |
| `idle-timeout` | Idle timeout (ms) | `600000` |
| `max-lifetime` | Max connection lifetime (ms) | `1800000` |

#### Hibernate Properties

| Property | Values | Description |
|----------|--------|-------------|
| `ddl-auto` | `none`, `validate`, `update`, `create`, `create-drop` | Schema generation |
| `show-sql` | `true`, `false` | Log SQL statements |
| `format_sql` | `true`, `false` | Format SQL output |

---

## 🔨 Build & Deployment

### Build Process

#### Development Build

```bash
# Clean previous builds
mvn clean

# Compile only
mvn compile

# Run tests
mvn test

# Package (creates WAR file)
mvn package

# Install to local repository
mvn install
```

#### Production Build

```bash
# Full build with tests
mvn clean package

# Build without tests (faster)
mvn clean package -DskipTests

# Build with production profile
mvn clean package -Pprod

# Build and install
mvn clean install
```

#### Build Output

```
target/
├── calculator-app.war          # Final WAR file
├── classes/                     # Compiled Java classes
├── generated-sources/           # Generated code
└── maven-status/                # Build metadata
```

### Deployment Options

#### Option 1: Standalone (Development)

```bash
# Run with embedded Tomcat
mvn spring-boot:run

# Or run JAR directly
java -jar target/calculator-app.war

# With profile
mvn spring-boot:run -Dspring-boot.run.profiles=dev

# Custom port
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8081
```

**Access**: http://localhost:8080/

#### Option 2: External Tomcat (Production)

**Step 1**: Build WAR file
```bash
mvn clean package
```

**Step 2**: Deploy to Tomcat
```bash
# Copy WAR to Tomcat webapps directory
copy target\calculator-app.war %CATALINA_HOME%\webapps\

# On Linux/Mac
cp target/calculator-app.war $CATALINA_HOME/webapps/
```

**Step 3**: Start Tomcat
```bash
# Windows
%CATALINA_HOME%\bin\startup.bat

# Linux/Mac
$CATALINA_HOME/bin/startup.sh
```

**Access**: http://localhost:8080/calculator-app/

#### Option 3: Docker (Future)

```dockerfile
FROM tomcat:9-jdk21
COPY target/calculator-app.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]
```

```bash
docker build -t calculator-app .
docker run -p 8080:8080 calculator-app
```

### Environment-Specific Deployment

#### Development

```bash
# Set active profile
export SPRING_PROFILES_ACTIVE=dev

# Run application
mvn spring-boot:run
```

#### Staging

```bash
export SPRING_PROFILES_ACTIVE=staging
java -jar target/calculator-app.war
```

#### Production

```bash
export SPRING_PROFILES_ACTIVE=prod
java -jar -Xmx512m -Xms256m target/calculator-app.war
```

---

## 📡 API Reference

### Web UI Endpoints

#### GET /
**Description**: Display calculator home page

**Method**: `GET`

**Response**: JSP page

**Example**:
```
http://localhost:8080/
```

---

#### POST /calculate
**Description**: Perform calculation

**Method**: `POST`

**Content-Type**: `application/x-www-form-urlencoded`

**Parameters**:
| Name | Type | Required | Description |
|------|------|----------|-------------|
| operand1 | double | Yes | First number |
| operand2 | double | Yes | Second number |
| operator | string | Yes | Operation (add, subtract, multiply, divide) |

**Example Request**:
```html
<form action="/calculate" method="post">
    <input type="number" name="operand1" value="10" step="any">
    <select name="operator">
        <option value="add">Addition</option>
    </select>
    <input type="number" name="operand2" value="5" step="any">
    <button type="submit">Calculate</button>
</form>
```

**Response**: JSP page with result

---

#### POST /clear-history
**Description**: Clear all calculation history

**Method**: `POST`

**Response**: Redirect to home page

**Example**:
```html
<form action="/clear-history" method="post">
    <button type="submit">Clear History</button>
</form>
```

---

### REST API Endpoints

Base URL: `/api/calculator`

#### POST /api/calculator/calculate
**Description**: Perform calculation via API

**Method**: `POST`

**Content-Type**: `application/x-www-form-urlencoded`

**Parameters**:
| Name | Type | Required | Description |
|------|------|----------|-------------|
| operand1 | double | Yes | First number |
| operand2 | double | Yes | Second number |
| operator | string | Yes | Operation type |

**Success Response** (200 OK):
```json
{
  "result": 15.0,
  "message": "Calculation successful",
  "success": true
}
```

**Error Response** (400 Bad Request):
```json
{
  "result": null,
  "message": "Cannot divide by zero",
  "success": false
}
```

**Example using cURL**:
```bash
curl -X POST http://localhost:8080/api/calculator/calculate \
  -d "operand1=10&operand2=5&operator=add"
```

**Example using JavaScript**:
```javascript
fetch('/api/calculator/calculate', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/x-www-form-urlencoded',
    },
    body: new URLSearchParams({
        operand1: 10,
        operand2: 5,
        operator: 'add'
    })
})
.then(response => response.json())
.then(data => console.log(data));
```

---

#### GET /api/calculator/history
**Description**: Get recent calculation history

**Method**: `GET`

**Response** (200 OK):
```json
[
  {
    "id": 1,
    "operand1": 10.0,
    "operand2": 5.0,
    "operator": "add",
    "result": 15.0,
    "calculatedAt": "2025-11-15T12:30:45"
  },
  {
    "id": 2,
    "operand1": 20.0,
    "operand2": 4.0,
    "operator": "subtract",
    "result": 16.0,
    "calculatedAt": "2025-11-15T12:31:10"
  }
]
```

**Example using cURL**:
```bash
curl http://localhost:8080/api/calculator/history
```

---

#### DELETE /api/calculator/history
**Description**: Clear calculation history

**Method**: `DELETE`

**Response** (204 No Content)

**Example using cURL**:
```bash
curl -X DELETE http://localhost:8080/api/calculator/history
```

---

### Operator Values

| Operator | Description | Example |
|----------|-------------|---------|
| `add` | Addition (+) | 10 + 5 = 15 |
| `subtract` | Subtraction (-) | 10 - 5 = 5 |
| `multiply` | Multiplication (×) | 10 × 5 = 50 |
| `divide` | Division (÷) | 10 ÷ 5 = 2 |

---

## 🧪 Testing Guide

### Running Tests

#### All Tests
```bash
# Run all tests
mvn test

# Run with coverage report
mvn test jacoco:report

# Run specific test class
mvn test -Dtest=CalculatorServiceTest

# Run specific test method
mvn test -Dtest=CalculatorServiceTest#testAddition
```

#### Skip Tests
```bash
mvn package -DskipTests
```

### Test Structure

#### Unit Tests

**CalculatorServiceTest.java**

```java
@Test
void testAddition() {
    double result = calculatorService.calculate(10, 5, "add");
    assertEquals(15, result);
}

@Test
void testDivisionByZero() {
    assertThrows(ArithmeticException.class, () -> {
        calculatorService.calculate(10, 0, "divide");
    });
}
```

#### Integration Tests

**CalculatorControllerTest.java**

```java
@Test
void testCalculate() throws Exception {
    mockMvc.perform(post("/calculate")
            .param("operand1", "10")
            .param("operand2", "5")
            .param("operator", "add"))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("result"));
}
```

### Test Coverage

Expected coverage:
- Service Layer: 90%+
- Controller Layer: 85%+
- Overall: 80%+

---

## 🔍 Troubleshooting

### Common Issues

#### Issue 1: MySQL Connection Refused

**Symptoms**:
```
com.mysql.cj.jdbc.exceptions.CommunicationsException: Communications link failure
```

**Solutions**:
1. Start MySQL service:
   ```bash
   net start MySQL80
   ```

2. Check MySQL is listening:
   ```bash
   netstat -an | find "3306"
   ```

3. Test connection:
   ```bash
   mysql -u root -p
   ```

4. Verify credentials in `application.properties`

---

#### Issue 2: Port 8080 Already in Use

**Symptoms**:
```
Web server failed to start. Port 8080 was already in use.
```

**Solutions**:

**Option A**: Kill process using port 8080
```bash
# Find process
netstat -ano | findstr :8080

# Kill process
taskkill /PID <PID> /F
```

**Option B**: Change port
```properties
# application.properties
server.port=8081
```

---

#### Issue 3: JSP Not Rendering

**Symptoms**:
- 404 error
- JSP source code displayed

**Solutions**:
1. Verify JSP location: `src/main/webapp/WEB-INF/views/calculator.jsp`

2. Check `application.properties`:
   ```properties
   spring.mvc.view.prefix=/WEB-INF/views/
   spring.mvc.view.suffix=.jsp
   ```

3. Ensure Tomcat Jasper dependency in `pom.xml`:
   ```xml
   <dependency>
       <groupId>org.apache.tomcat.embed</groupId>
       <artifactId>tomcat-embed-jasper</artifactId>
       <scope>provided</scope>
   </dependency>
   ```

---

#### Issue 4: Lombok Not Working

**Symptoms**:
```
Cannot resolve method 'getOperand1()'
```

**Solutions**:

**IntelliJ IDEA**:
1. File → Settings → Plugins
2. Install "Lombok" plugin
3. Settings → Build → Compiler → Annotation Processors
4. Enable annotation processing

**Eclipse**:
1. Download lombok.jar
2. Run: `java -jar lombok.jar`
3. Select Eclipse installation
4. Restart Eclipse

---

#### Issue 5: Build Failures

**Symptoms**:
```
[ERROR] Failed to execute goal
```

**Solutions**:

```bash
# Clean Maven cache
mvn clean

# Update dependencies
mvn dependency:resolve

# Force update
mvn clean install -U

# Clear local repository
mvn dependency:purge-local-repository
```

---

#### Issue 6: Database Schema Issues

**Symptoms**:
```
Table 'calculator_db.calculation_history' doesn't exist
```

**Solutions**:

1. Check Hibernate DDL setting:
   ```properties
   spring.jpa.hibernate.ddl-auto=update
   ```

2. Manually create database:
   ```sql
   mysql -u root -p < scripts/database-setup.sql
   ```

3. Verify database exists:
   ```sql
   SHOW DATABASES;
   USE calculator_db;
   SHOW TABLES;
   ```

---

## 📚 Additional Resources

### Documentation Files

- `README.md` - Project overview
- `PROJECT_README.md` - Detailed features and setup
- `QUICKSTART.md` - Quick start guide
- `COMPLETE_DOCUMENTATION.md` - This comprehensive guide
- `docs/DOCUMENTATION.md` - Technical documentation

### External Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [MySQL Documentation](https://dev.mysql.com/doc/)
- [Apache Maven](https://maven.apache.org/guides/)
- [Apache Tomcat 9](https://tomcat.apache.org/tomcat-9.0-doc/)

---

## 📄 License

This project is created for educational purposes. Feel free to use and modify.

---

## 👥 Support

For questions, issues, or contributions:
1. Review this documentation
2. Check existing documentation files
3. Examine source code comments
4. Create an issue in the repository

---

**Document Version**: 1.0.0  
**Last Updated**: November 15, 2025  
**Project Version**: 1.0.0  
**Spring Boot**: 3.2.0  
**Java**: 21  
**MySQL**: 8.0+  
**Tomcat**: 9.x

---

**END OF DOCUMENTATION**
