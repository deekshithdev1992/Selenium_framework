# Selenium Java TestNG Automation Framework

Enterprise-level test automation framework for Salesforce login testing.

## Technology Stack
- **Selenium WebDriver** 4.16.1
- **Java** 11
- **Maven** - Build & dependency management
- **TestNG** 7.8.0 - Testing framework
- **Page Object Model** with PageFactory

## Framework Features
- ✅ Page Object Model (POM) design pattern
- ✅ XPath-only locators for stability
- ✅ WebDriverWait for explicit waits
- ✅ TestNG annotations and test management
- ✅ Modular and maintainable code structure
- ✅ Comprehensive test coverage (valid/invalid scenarios)

## Project Structure
```
Selenium_framework/
├── pom.xml
├── testng.xml
└── src/
    ├── main/java/pages/
    │   └── LoginPage.java
    └── test/java/tests/
        ├── BaseTest.java
        ├── ValidLoginTest.java
        └── InvalidLoginTest.java
```

## Prerequisites
- Java 11 or higher
- Maven 3.6+
- Chrome browser

## Installation
```bash
git clone https://github.com/deekshithdev1992/python.git
cd Playwright_2026/AI/Selenium_framework
mvn clean install
```

## Running Tests
```bash
mvn clean test
```

## Test Coverage
### Valid Login Tests (3)
- Login page elements verification
- Valid login with Remember Me
- Valid login without Remember Me

### Invalid Login Tests (7)
- Invalid credentials
- Empty username
- Empty password
- Empty both fields
- Invalid email format
- Special characters
- SQL injection prevention

## Configuration
Update credentials in test files:
- `ValidLoginTest.java` - Replace with valid Salesforce credentials
- `InvalidLoginTest.java` - Customize invalid test data as needed

## Reports
Test reports are generated in: `target/surefire-reports/`
