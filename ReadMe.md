# Automation Challenge

## Overview
The project consists of two modules.
API module refers to API tests using RestAssured framework.
UI module refers to UI tests using Selenium WebDriver.

## Setup guide
1. Install Intelij IDEA
2. Install brew
3. Install Java 8
4. Install Maven
5. Verify installation running mvn -version and java -version.


## Running tests
In order to run the API tests, please navigate to API directory via terminal:
'cd API'
'mvn clean test'

In order to run the UI tests, please navigate to UI directory via terminal from the root directory:
'cd UI'
'mvn clean test'

## Reports
The project is using custom testNG reports which can be found under test-output directory for each of the modules as index.html file.
