## Task Description

The goal of this task was to design and implement automated UI tests for the login functionality of the SauceDemo web application using Java and Selenium WebDriver.

The task required creating a maintainable and scalable test solution based on the Page Object Model (POM) design pattern, including proper test structure, browser management, and reporting.

### Tested application
https://www.saucedemo.com/

### Test scenarios

The following functional scenarios were covered:

- **UC-1: Successful login**
    - Login with valid credentials (standard_user / secret_sauce)
    - Verify successful redirection to the inventory page
    - Verify that the product list is displayed
    - Perform logout and verify redirection to the login page

- **UC-2: Locked out user**
    - Login with locked_out_user
    - Verify error message:
      > "Epic sadface: Sorry, this user has been locked out."

- **UC-3: Empty username**
    - Attempt login without entering username
    - Verify error message:
      > "Epic sadface: Username is required"

- **UC-4: Empty password**
    - Attempt login without entering password
    - Verify error message:
      > "Epic sadface: Password is required"

- **UC-5: Invalid credentials**
    - Login with incorrect username/password
    - Verify error message:
      > "Epic sadface: Username and password do not match any user in this service"

### Requirements and assumptions

- Tests are implemented in Java using Selenium WebDriver
- Page Object Model (POM) is used to separate test logic from page structure
- Browser initialization is handled by a dedicated factory class (`BrowserManager`)
- WebDriverManager is used to automatically manage browser drivers
- Tests are executed using TestNG
- Allure is used for test reporting
- The solution is designed to be easily extendable for additional test cases and browsers

### Scope

The scope of this task includes only the login functionality of the application. Other features (e.g. cart, checkout) are out of scope.

## Technologies
- Java 17
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager
- Allure Report

## Project structure
- `factory` - browser setup
- `pages` - page object classes
- `tests` - test classes
- `testng.xml` - TestNG suite configuration

## Browsers
Tests run on:
- Chrome
- Edge

Tests are configured to run in parallel.

## How to run tests
Run all tests with Maven:

```bash
mvn clean test
```

## Test cases
- UC-1: Login/Logout flow under valid user
- UC-2: Login under locked out user
- UC-3: Empty login test
- UC-4: Empty password test
- UC-5: Invalid credentials test

## How to generate Allure report
After running the tests, you can generate and view the Allure report with:
```bash
allure serve allure-results
```


