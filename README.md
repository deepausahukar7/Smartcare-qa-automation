# SmartCare – QA Automation Framework 🏥

A Selenium TestNG automation framework built using Java and Maven for a healthcare web application.  
The framework follows **Page Object Model (POM)** and supports **data-driven testing** using Excel.

---

## 📌 Project Overview

SmartCare is a healthcare management web application used by doctors and healthcare staff.  
This automation project validates critical workflows such as:

- Secure Login (Positive & Negative Scenarios)
- Catalog Search, Filters, and Pagination
- Regression Stability with Data-Driven Testing

---

## 🛠 Tech Stack

- **Programming Language:** Java  
- **Automation Tool:** Selenium WebDriver  
- **Test Framework:** TestNG  
- **Build Tool:** Maven  
- **Test Data:** Excel (Apache POI)  
- **Design Pattern:** Page Object Model (POM)  
- **IDE:** Eclipse  

---

## 🧪 Automation Scope

### ✔ Login Module
- Valid login scenario
- Invalid username
- Invalid password
- Data-driven execution using Excel

### ✔ Catalog Module
- Search functionality
- Filters validation
- Pagination handling

### ✔ Framework Features
- Page Object Model (POM)
- Data-driven testing using TestNG `@DataProvider`
- Config-driven execution (`config.properties`)
- Smoke & Regression test grouping
- Session handling to avoid flaky tests
- Clean test reporting (Pass / Skip handling)

---

## 🔄 Automation Flow

```mermaid
flowchart TD
    A[Start Test Execution] --> B[Read config.properties]
    B --> C[Launch Browser]
    C --> D[Execute TestNG Suite]
    D --> E[Login Test]
    E -->|Valid Credentials| F[Dashboard Validation]
    E -->|Invalid Credentials| G[Error Message Validation]
    F --> H[Catalog Tests]
    G --> H
    H --> I[Search / Filter / Pagination Validation]
    I --> J[Close Browser]
    J --> K[Generate Test Report]
    K --> L[End]
