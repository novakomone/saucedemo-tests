# SauceDemo Login Tests

This project contains automated UI tests for the login flow on SauceDemo.

## Tested application
https://www.saucedemo.com/

## Scope
The project covers the following login scenarios:

- valid login and logout
- locked out user login
- empty username
- empty password
- invalid credentials

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


