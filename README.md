
# Automation Test Framework

An automated testing framework for Web UI and REST API testing using Java, Gradle, Cucumber, Selenium WebDriver, and Rest Assured.

## Project Overview

This project provides automated test scenarios for:
- Web UI testing on DemoBlaze.
- REST API testing on DummyAPI.
- Automated test execution using Gradle.
- Cucumber HTML and JSON test reports.
- Continuous integration through GitHub Actions.

## Technology Stack

- Java 21
- Gradle
- Cucumber and Gherkin
- Selenium WebDriver
- Rest Assured
- JUnit 4
- GitHub Actions

## Project Structure

```text
automation-test-framework/
├── .github/
│   └── workflows/
│       ├── api-tests.yml
│       └── web-ui-tests.yml
├── gradle/
│   └── wrapper/
├── src/
│   └── test/
│       ├── java/
│       │   ├── api/
│       │   │   └── stepdefinitions/
│       │   ├── runners/
│       │   │   ├── ApiTestRunner.java
│       │   │   └── WebTestRunner.java
│       │   └── web/
│       │       ├── pages/
│       │       │   └── HomePage.java
│       │       └── stepdefinitions/
│       │           └── DemoBlazeSteps.java
│       └── resources/
│           └── features/
│               ├── api/
│               │   ├── tag.feature
│               │   └── user.feature
│               └── web/
│                   └── demoblaze.feature
├── build.gradle
├── gradlew
├── gradlew.bat
└── settings.gradle
```


## Automated Test Scenarios

### API Testing

The API automation tests cover five scenarios:

1. Get list of tags — verifies the tags endpoint and response.
2. Get user by ID — verifies retrieval of an existing user.
3. Create a new user — verifies user creation and the returned user ID.
4. Update an existing user — verifies updating user information.
5. Get user with invalid ID — negative test case that verifies the API rejects an invalid user ID.

API tests use Cucumber, Gherkin, and Rest Assured.

### Web UI Testing

The Web UI automation tests cover five scenarios:

1. Open the DemoBlaze homepage — verifies the homepage title.
2. View product categories — verifies that the Phones category is displayed.
3. View product details — verifies that product details can be opened.
4. Add a product to the cart — verifies that a product can be added to the shopping cart.
5. Complete checkout end-to-end — selects a product, adds it to the cart, enters purchase information, and verifies the purchase confirmation.

Web UI tests use Selenium WebDriver and Cucumber. The Page Object Model (POM) separates page interactions from Cucumber step definitions.

## Prerequisites

- Java Development Kit (JDK) compatible with the project configuration.
- Git.
- Internet access to reach DemoBlaze and DummyAPI.
- Google Chrome for local Web UI testing.

## Running Tests Locally

### Run API tests

On Windows:

```powershell
.\gradlew.bat apiTest
```

On Linux or macOS:

```bash
./gradlew apiTest
```

### Run Web UI tests

On Windows:

```powershell
.\gradlew.bat webTest
```

On Linux or macOS:

```bash
./gradlew webTest
```

## Test Reports

Cucumber generates HTML and JSON reports in the following directory:

```text
build/reports/cucumber/
├── api-report.html
├── api-report.json
├── web-report.html
└── web-report.json
```

Open the HTML files in a browser to review the test results. The JSON files contain structured test results.

## GitHub Actions

This project contains two GitHub Actions workflows:

- **API Automation Tests** — runs the `apiTest` Gradle task.
- **Web UI Automation Tests** — runs the `webTest` Gradle task.

Both workflows support manual execution and Pull Requests targeting the `main` branch. Test reports are uploaded as workflow artifacts.

To run a workflow manually:
1. Open the repository on GitHub.
2. Select the **Actions** tab.
3. Select the desired workflow.
4. Click **Run workflow** and choose the `main` branch.

Download the generated report artifacts from the workflow run details.

## Repository

GitHub: https://github.com/msnurfatih/automation-test-framework
