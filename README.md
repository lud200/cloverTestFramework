### Clover Sample Test

A sample framework based on Page Object Model, Selenium, TestNG using Java.

This framework is based in Page Object Model (POM) and supports parallel execution of test cases.

The framework uses:

* Java
* Selenium
* TestNG
* ExtentReport
* Log4j

Dependencies and SDK's:
* JDK: Oracle OpenJDK 14.0.2
* Java(TM) SE Runtime Environment (build 14.0.2+12-46)
* Maven: Apache Maven 3.9.4
* Selenium 4.12.1
* TestNG 7.7.0
* Browser: Chrome


### Running tests
* Run the test case from testng.xml 
* Run the test cases from /tests folder 
* SearchTest is the actual test case that does the basic test mentioned in email
* Framework supports parallel execution of tests

### Reporting
The framework gives report in two ways,
* Log - In file logfile.log.
* A html report - Which is generated using extent reports, under the folder ExtentReports.

### Key Points:
* **WebDriverContext** is responsible for maintaining the same WebDriver instance throughout the test.
* Constants are defined in Constants.java
* So whenever you require a webdriver instance which has been using for current test (In current thread) always call WebDriverContext.getDriver().
* Always use PageInstancesFactory.getInstance(type) to get the instance of particular Page Object.
