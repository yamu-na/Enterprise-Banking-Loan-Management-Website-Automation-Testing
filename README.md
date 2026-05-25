## Enterprise Banking & Loan Management Automation Framework

## Project Overview

This project is a Hybrid Test Automation Framework developed for banking application testing using Selenium WebDriver, REST Assured, TestNG, and Maven.  
The framework supports UI Testing, API Testing, UI + API Integration Testing, Parallel Execution, Reporting, and Logging.

The framework is designed using the Page Object Model (POM) architecture with reusable components, dynamic test data handling, and industry-standard automation practices.

---

# Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- REST Assured
- Apache POI
- Log4j2
- Extent Reports
- JSON Schema Validator
- WebDriverManager

---

# Framework Features

## UI Automation
- User Registration
- Login Validation
- Open Account
- Transfer Funds
- Transaction History
- Negative Scenarios

## API Automation
- Authentication API
- Create User API
- Fetch User API
- Dynamic Payload Handling
- Schema Validation
- Response Time Validation

## Integration Testing
- UI + API Integration Testing

## Framework Utilities
- Explicit Waits
- Screenshot Capture
- Retry Mechanism
- Logging
- Reporting
- Excel Data Handling
- Parallel Execution

---

# Framework Architecture

The framework follows:
- Page Object Model (POM)
- Reusable Utility Design
- Layered API Architecture
- Modular Test Structure

Main modules:
- Base Classes
- Page Classes
- API Classes
- Utilities
- Listeners
- Reports
- Test Classes

---

# Test Coverage

## UI Test Cases
- RegistrationTest
- LoginTest
- OpenAccountTest
- TransferFundsTest
- TransactionHistoryTest
- NegativeTransferTest

## API Test Cases
- AuthApiTest
- CreateUserApiTest
- FetchUserApiTest

## Integration Test Cases
- UiApiIntegrationTest

---

# Reporting and Logging

The framework automatically generates:
- Extent Reports
- TestNG Reports
- Log Files
- Failure Screenshots

Folders:
- `/reports`
- `/logs`
- `/screenshots`

---

# Test Data Management

Test data is maintained externally using:
- Excel Files
- JSON Payload Files
- Properties Files

This avoids hardcoded test data and improves framework maintainability.

---

# Standards Followed

- No Thread.sleep()
- Explicit Waits Only
- Relative XPath/CSS Selectors
- Meaningful Assertions
- Reusable Methods
- Dynamic Data Handling
- Proper Exception Handling
- Logging and Reporting Standards

---

# Maven Commands

## Execute All Tests

```bash
mvn test
