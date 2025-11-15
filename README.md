# Calculator Web Application

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0+-blue.svg)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-Educational-yellow.svg)]()

A full-stack calculator web application built with **Java 21**, **Spring Boot**, **JSP**, and **MySQL**. Features a modern UI, calculation history, REST API, and complete Tomcat 9 WAR deployment support.

---

## ✨ Features

- ➕ **Arithmetic Operations**: Addition, Subtraction, Multiplication, Division
- 📊 **Persistent History**: All calculations saved to MySQL database
- 🎨 **Modern UI**: Gradient design with smooth animations
- 🔌 **REST API**: JSON-based API for programmatic access
- 📱 **Responsive**: Works perfectly on desktop and mobile
- 🛡️ **Error Handling**: Division by zero protection and validation
- ⚡ **Real-time**: Instant calculation results
- 🗑️ **History Management**: View and clear calculation history

---

## 🚀 Quick Start

### 1. Prerequisites

- Java 21 JDK
- Apache Maven 3.6+
- MySQL 8.0+
- Apache Tomcat 9 (optional)

### 2. Setup

```bash
# Run setup script
setup-complete.bat

# Configure database credentials
# Edit: src\main\resources\application.properties
```

### 3. Build & Run

```bash
# Build
mvn clean package

# Run locally
mvn spring-boot:run

# Access at: http://localhost:8080/
```

### 4. Deploy to Tomcat (Optional)

```bash
# Copy WAR file
copy target\calculator-app.war %CATALINA_HOME%\webapps\

# Start Tomcat
%CATALINA_HOME%\bin\startup.bat

# Access at: http://localhost:8080/calculator-app/
```

---

## 📁 Project Structure

```
calculator-app/
├── src/main/java/com/calculator/
│   ├── config/              # Configuration classes
│   ├── controller/          # Web & REST controllers
│   ├── model/               # JPA entities
│   ├── repository/          # Data access layer
│   ├── service/             # Business logic
│   ├── dto/                 # Data transfer objects
│   └── exception/           # Custom exceptions
├── src/main/resources/
│   ├── static/              # CSS, JavaScript, Images
│   └── application.properties
├── src/main/webapp/WEB-INF/views/
│   └── calculator.jsp       # Main UI
├── scripts/                 # Build & utility scripts
├── docs/                    # Documentation
└── pom.xml                  # Maven configuration
```

---

## 🔧 Technology Stack

| Component | Technology |
|-----------|------------|
| **Backend** | Java 21, Spring Boot 3.2.0 |
| **Frontend** | JSP, JSTL, HTML5, CSS3, JavaScript |
| **Database** | MySQL 8.0+ |
| **ORM** | Hibernate/JPA |
| **Build** | Maven 3.6+ |
| **Server** | Apache Tomcat 9 |
| **Testing** | JUnit 5, Mockito |

---

## 📡 API Endpoints

### Web UI
- `GET /` - Calculator interface
- `POST /calculate` - Perform calculation
- `POST /clear-history` - Clear history

### REST API
- `POST /api/calculator/calculate` - Calculate (JSON)
- `GET /api/calculator/history` - Get history
- `DELETE /api/calculator/history` - Clear history

**Example API Call**:
```bash
curl -X POST http://localhost:8080/api/calculator/calculate \
  -d "operand1=10&operand2=5&operator=add"
```

**Response**:
```json
{
  "result": 15.0,
  "message": "Calculation successful",
  "success": true
}
```

---

## 🗄️ Database Schema

```sql
CREATE TABLE calculation_history (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    operand1 DOUBLE NOT NULL,
    operand2 DOUBLE NOT NULL,
    operator VARCHAR(10) NOT NULL,
    result DOUBLE NOT NULL,
    calculated_at DATETIME NOT NULL,
    INDEX idx_calculated_at (calculated_at DESC)
);
```

---

## 📸 Screenshots

### Calculator Interface
Modern, responsive design with gradient background and smooth animations.

### Calculation History
Persistent storage of all calculations with timestamps.

---

## 🔨 Build Commands

```bash
# Development build
mvn spring-boot:run

# Production build
mvn clean package

# Run tests
mvn test

# Skip tests
mvn package -DskipTests

# Clean build
mvn clean install
```

---

## 📚 Documentation

| Document | Description |
|----------|-------------|
| **README.md** | This file - Quick overview |
| **QUICKSTART.md** | Fast setup guide (5 minutes) |
| **PROJECT_README.md** | Detailed project overview |
| **COMPLETE_DOCUMENTATION.md** | Comprehensive technical guide |
| **docs/DOCUMENTATION.md** | API and architecture details |

---

## 🧪 Testing

```bash
# Run all tests
mvn test

# Run specific test
mvn test -Dtest=CalculatorServiceTest

# With coverage report
mvn test jacoco:report
```

**Test Coverage**:
- Service Layer: 90%+
- Controller Layer: 85%+
- Overall: 80%+

---

## 🐛 Troubleshooting

### MySQL Connection Issues
```bash
# Start MySQL
net start MySQL80

# Test connection
mysql -u root -p
```

### Port Already in Use
```properties
# Change port in application.properties
server.port=8081
```

### Build Failures
```bash
# Clean and rebuild
mvn clean install -U
```

**More troubleshooting**: See `COMPLETE_DOCUMENTATION.md`

---

## 🎯 Architecture

```
Presentation Layer (JSP/REST)
        ↓
Controller Layer (Spring MVC)
        ↓
Service Layer (Business Logic)
        ↓
Repository Layer (Spring Data JPA)
        ↓
Database Layer (MySQL)
```

**Design Patterns**:
- MVC (Model-View-Controller)
- Repository Pattern
- Service Layer Pattern
- Dependency Injection
- DTO (Data Transfer Object)

---

## 📦 Deployment Options

### Option 1: Standalone (Development)
```bash
mvn spring-boot:run
# Access: http://localhost:8080/
```

### Option 2: External Tomcat (Production)
```bash
copy target\calculator-app.war %CATALINA_HOME%\webapps\
# Access: http://localhost:8080/calculator-app/
```

### Option 3: Docker (Future)
```bash
docker build -t calculator-app .
docker run -p 8080:8080 calculator-app
```

---

## 🔮 Future Enhancements

- [ ] Advanced operations (√, ^, %, trigonometry)
- [ ] User authentication (Spring Security)
- [ ] Calculation history export (CSV, PDF)
- [ ] Dark mode toggle
- [ ] Keyboard shortcuts
- [ ] GraphQL API
- [ ] Docker containerization
- [ ] CI/CD pipeline
- [ ] Monitoring dashboard

---

## 📖 Learning Objectives

This project demonstrates:

✅ Spring Boot application development  
✅ RESTful API design  
✅ JPA/Hibernate ORM  
✅ MySQL database integration  
✅ JSP view rendering  
✅ Maven build configuration  
✅ WAR deployment  
✅ Unit and integration testing  
✅ Layered architecture  
✅ Design patterns implementation  

---

## 🤝 Contributing

This is an educational project. Feel free to:
1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Submit a pull request

---

## 📄 License

This project is created for **educational purposes**. Free to use and modify.

---

## 📞 Support

**Having issues?**
1. Check `COMPLETE_DOCUMENTATION.md`
2. Review `QUICKSTART.md`
3. Examine source code comments
4. Search existing issues

---

## 📊 Project Status

- ✅ Core functionality complete
- ✅ REST API implemented
- ✅ Database integration working
- ✅ Tests passing
- ✅ Documentation complete
- ✅ WAR deployment supported

---

## 🙏 Acknowledgments

Built with:
- Spring Framework
- Spring Boot
- Hibernate
- MySQL
- Apache Tomcat
- Maven

---

## 📝 Version History

**v1.0.0** (November 15, 2025)
- Initial release
- Basic arithmetic operations
- Calculation history
- REST API
- Complete documentation

---

**Made with ☕ and Java 21**

---

## Quick Links

- 📘 [Quick Start Guide](QUICKSTART.md)
- 📗 [Project Overview](PROJECT_README.md)
- 📕 [Complete Documentation](COMPLETE_DOCUMENTATION.md)
- 🔧 [Build Scripts](scripts/)
- 📊 [Database Setup](scripts/database-setup.sql)

---

**⭐ If you find this project helpful, please star it!**
Product for catering business
