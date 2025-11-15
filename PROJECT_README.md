# Calculator Web Application

A modern calculator web application built with Java Spring Boot, JSP, and MySQL database. Compatible with Tomcat 9 and Java 21.

## Features

- ✨ Modern, responsive UI with gradient design
- ➕ Basic arithmetic operations (Addition, Subtraction, Multiplication, Division)
- 📊 Calculation history stored in MySQL database
- 🗑️ Clear history functionality
- ⚡ Real-time calculation with error handling
- 🎨 Beautiful animations and transitions
- 📱 Mobile-responsive design

## Technology Stack

- **Backend**: Java 21, Spring Boot 3.2.0
- **Frontend**: JSP, JSTL, HTML5, CSS3
- **Database**: MySQL 8.0+
- **Build Tool**: Maven
- **Application Server**: Tomcat 9

## Prerequisites

- Java 21 JDK
- Apache Maven 3.6+
- MySQL 8.0+ (running on localhost:3306)
- Apache Tomcat 9 (for WAR deployment)

## Setup Instructions

### 1. Clone and Setup

```bash
cd D:\Projects\GIT_Projects\catering
setup.bat
```

### 2. Configure Database

Update `src/main/resources/application.properties` with your MySQL credentials:

```properties
spring.datasource.username=root
spring.datasource.password=your_password
```

The application will automatically create the database `calculator_db` if it doesn't exist.

### 3. Build the Application

```bash
mvn clean package
```

This will create a WAR file at `target/calculator-app.war`

### 4. Deploy to Tomcat 9

#### Option A: Copy WAR file
1. Copy `target/calculator-app.war` to Tomcat's `webapps` folder
2. Start Tomcat
3. Access: http://localhost:8080/calculator-app/

#### Option B: Run with Spring Boot (Development)
```bash
mvn spring-boot:run
```
Access: http://localhost:8080/

## Project Structure

```
calculator-app/
├── src/
│   ├── main/
│   │   ├── java/com/calculator/
│   │   │   ├── CalculatorApplication.java
│   │   │   ├── controller/
│   │   │   │   └── CalculatorController.java
│   │   │   ├── model/
│   │   │   │   └── CalculationHistory.java
│   │   │   ├── repository/
│   │   │   │   └── CalculationHistoryRepository.java
│   │   │   └── service/
│   │   │       └── CalculatorService.java
│   │   ├── resources/
│   │   │   └── application.properties
│   │   └── webapp/
│   │       └── WEB-INF/
│   │           └── views/
│   │               └── calculator.jsp
│   └── test/
│       └── java/com/calculator/
└── pom.xml
```

## Database Schema

The application automatically creates the following table:

```sql
CREATE TABLE calculation_history (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    operand1 DOUBLE NOT NULL,
    operand2 DOUBLE NOT NULL,
    operator VARCHAR(10) NOT NULL,
    result DOUBLE NOT NULL,
    calculated_at DATETIME NOT NULL
);
```

## API Endpoints

- `GET /` - Display calculator home page
- `POST /calculate` - Perform calculation
- `POST /clear-history` - Clear calculation history

## Features in Detail

### Calculator Operations
- **Addition**: Add two numbers
- **Subtraction**: Subtract second number from first
- **Multiplication**: Multiply two numbers
- **Division**: Divide first number by second (with zero-division protection)

### History Management
- Stores last 10 calculations
- Displays operation, result, and timestamp
- One-click history clearing

### Error Handling
- Division by zero protection
- Invalid operation detection
- User-friendly error messages

## Building for Production

```bash
# Clean and package
mvn clean package -DskipTests

# The WAR file will be created at:
# target/calculator-app.war
```

## Troubleshooting

### MySQL Connection Issues
- Ensure MySQL is running: `mysql -u root -p`
- Check credentials in application.properties
- Verify port 3306 is not blocked

### JSP Not Rendering
- Ensure Tomcat Jasper dependency is included
- Check JSP files are in `src/main/webapp/WEB-INF/views/`
- Verify spring.mvc.view settings in application.properties

### Port Already in Use
- Change server.port in application.properties
- Or stop the process using port 8080

## License

This project is created for educational purposes.

## Author

Created with Java Spring Boot, JSP, and MySQL
