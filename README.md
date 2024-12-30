# Playwright Automation Project

A robust automation framework using Playwright and Java.

---

## Table of Contents
1. [Setup](#setup)
2. [Running Tests](#running-tests)
3. [Working with Test Data](#working-with-test-data)
   - [Adding New Data](#adding-new-data)
   - [JSON Reader Overview](#json-reader-overview)
4. [Output](#output)
5. [Folder Structure](#folder-structure)

---

## Setup

1. **Install Java**: Ensure you have Java 11 or higher installed on your machine.  
2. **Install Maven**: Install Maven from [Maven's official site](https://maven.apache.org/).
3. **Clone the Repository**: Run the following command:
   ```
   git clone < repository-url >
   ```
4. **Install Dependencies**: Navigate to the project directory and execute:
   ```
   mvn clean install
   ```

---

## Running Tests

1. **Test Data**: Ensure your test data is correctly formatted and placed in:
   ```
   src/test/resources/testData.json
   ```
2. **Execute Tests**: Run the following command to execute all test cases:
   ```
   mvn test
   ```

---

## Working with Test Data

### Adding New Data
The test framework reads input from a JSON file located at:
```
src/test/resources/testData.json
   ```

---

The structure of the JSON file matches the `TestDataModel` class and includes the following fields:
- `postalCode` (String): The postal code being tested.
- `streetName` (String): The name of the street.

To add new test cases:
1. Open the `testData.json` file.
2. Add new entries using the following format:
   ```json
   [
       {
           "postalCode": "12345",
           "streetName": "Main Street"
       },
       {
           "postalCode": "67890",
           "streetName": "Second Avenue"
       }
   ]
   ```

---

### JSON Reader Overview
The **JSON Reader** is implemented in the `TestDataProvider` class:
- **File Location**: Reads the `testData.json` file from the `src/test/resources` directory.
- **Deserialization**: The reader uses Gson to convert JSON into an array of `TestDataModel` objects.
- **Usage**: Each test case uses these objects to retrieve the test data.


## Output

- Test results will be saved in:
  ```
  src/test/resources/results.json
  ```

The structure of the results JSON file maps postal codes to their respective messages. Example format:
```json
{
    "2530-125": "Lamentamos, mas a internet de fibra óptica ainda não está disponível na tua morada.",
    "4050-481": "Lamentamos, mas a internet de fibra óptica ainda não está disponível na tua morada."
}
```

Each postal code is a key, and the value is the corresponding message indicating the status of fiber optic internet availability.

Results are generated dynamically using the `FileUtils.saveToJsonFile` method, which serializes the `results` map into a JSON file.
   ```

---

## Folder Structure

```plaintext
my-playwright-project/
│
├── pom.xml                           # Maven configuration
├── README.md                         # Project documentation
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com.automation/
│   │           ├── config/           # Playwright configuration
│   │           ├── models/           # Data models
│   │           ├── pages/            # Page Object Models
│   │           └── utils/            # Utility classes
│   ├── test/
│       ├── java/
│       │   └── com.automation/
│       │       ├── base/             # Test base class
│       │       ├── tests/            # Test cases
│       │       └── utils/            # Test data provider
│       └── resources/
│           ├── testData.json         # Input test data
│           └── results.json          # Test results
└── target/                           # Build output directory
```

---
