# SamuelEyasu_21456930_ISEReport

## Cover Page
- **Assessment Name:** Weather Insight Tool Development
- **Your Name:** Samuel Eyasu
- **Curtin Student ID:** 21456930
- **Practical Class:** 26/03/24

## Introduction

This report documents the program weather insight tool that was created using java to provide the user with information about the season and temperature based of there input. the project includes developing the main application, writing test units for both black box and white box and applying software engineering principles to ensure modularity(Coupling, redundancy and cohesion) of the program.

## Module Descriptions
The Weather Insight Tool comprises several key modules encapsulated in `weatherInsightProgram.java`:

- User Interaction
- Temperature Validation (`validateTemperature`)
- Season Determination (`determineSeason` and `determineSeasonAustralia`)
- Input Validation (`isValidCountry` and `getInputAsInt`)

Design decisions were focused on modularity, user-friendliness, and extendability. Assumptions include predefined temperature ranges for cities((Perth or Dubai) and the application of meteorological and Noongar calendars for Australia.

## Modularity

### How to Run
To run the Weather Insight Tool, use the following commands:

bash
javac weatherInsightProgram.java
java weatherInsightProgram

### Sample Output

[Insert screenshots or code snippets of your application's output here.]
![[Screenshot from 2024-03-26 12-06-26.png]]
### Explanation on Modularity

The program demonstrates high cohesion, loose coupling, less redundancy and extendable after the review check was evaluated and the program was refactored.

### Review Checklist and Refactoring

[Discuss the review checklist, code review outcomes, and any refactoring decisions.]

| Item | Checklist Question Related to Modularity                           | Yes/No | Description of the Issue if No is the Answer                                                                                       |
| ---- | ------------------------------------------------------------------ | ------ | ---------------------------------------------------------------------------------------------------------------------------------- |
| 1    | Does the code minimize coupling between modules?                   | No     | The code is contained within a single class, leading to high internal coupling without clear module separation.                    |
| 2    | Is there redundant code that could be abstracted?                  | Yes    | -                                                                                                                                  |
| 3    | Are logical structures repeated unnecessarily?                     | Yes    | -                                                                                                                                  |
| 4    | Does each class/module follow the Single Responsibility Principle? | No     | The `weatherInsightProgram` class handles UI, business logic, and data validation, which could be separated into distinct classes. |
| 5    | Is there functional cohesion within the modules?                   | No     | The `weatherInsightProgram` demonstrates mixed responsibilities, suggesting potential improvements in cohesion.                    |
refactoring decisions:

introduced switch cases for seasons in austrila to better switch between noongar and default calendar(refined methods)

introduced helper methods such as isCountryValidatoin() and userChoiceInt() to reduce redundancy and have higher cohesion.

added new input methods to add validation if the user enters enters countries out side the range and also numbers outside 1, 2 or 3.

remove repeated variables to reduce redundancy and and have an over all cleaner code.

## Black-box Test Cases

Test cases encompass validating country inputs, temperature validations, season determinations and user choose. Scenarios include valid inputs, boundary conditions, and invalid inputs.

## White-box Test Cases

### `validateTemperature` Method

- **City Within Valid Range**: Ensures that the specific cites (Perth or Dubai) are with in the normal range. if they are it will display "Temperature is within the normal range."
- 
- **Unrecognized City Handling**: used to verify if the city input are recognized of not it will return a "City not recognized" prompt.
### `determineSeason` Method

- **Valid Country and Month**: Checks the function returns the correct season for the selected country and month. if the user enter the correct country it give the expected output (e.g., "Summer" for Australia in January).
- 
- **Invalid Country Input**: Tests the function's ability to handle unrecognized country names. _Expected_: "Season data not available for this country."
- tests the ability of the method to handle unrecognized input countries names. if this is the case the program will display "Season data not available for this country."

### `isValidateCountry` Method

- **Valid Country**: Verifies the method correctly identifies a valid country as such. _Expected_: `true` for recognized countries.

- **Invalid Country**: Tests the method's response to an unrecognized country input. _Expected_: `false` for countries not in the recognized list.

### Objective

The objective of these test cases is to ensure the logical path is correctly executed. By validating key functionalities such as temperature validation, season determination, and Country validation, these tests aim to cover critical aspects of the application,  season determination even depending on which type of calendar you want such as noongar, ensuring it reliability in preventing exception errors and giving accurate weather insights based of the user input.
## Test Implementation and Test Execution

Test implementation using JUnit for functions like country validation (`isCountryValidationTest.java`), temperature validation (`validateTemperature.java`), and season determination (`seasonDetermineTest.java`). To execute these tests:

i execute this commands when i reach the Code directory.
bash

javac -cp "/usr/share/java/junit-jupiter-api-5.3.2.jar:/usr/share/java/junit-jupiter-engine-5.3.2.jar:/usr/share/java/junit-platform-commons-1.3.2.jar:/usr/share/java/junit-platform-console-standalone-1.3.2.jar:/usr/share/java/junit-platform-launcher-1.3.2.jar:/usr/share/java/junit-platform-engine-1.3.2.jar:." src/main/java/*.java src/test/java/*.java

java -jar /usr/share/java/junit-platform-console-standalone.jar -cp . --scan-classpath

mvn test 
### Results of Test Execution

there where three test Code in total.

isCountryValidationTest.java

there where two test they where successful the actual output matched the expected output.

seasonDetermineTest.java

there where 7 tests in total, out of that 2 failed  the actual result did not must the expected out put.

validateTemperature.java

there where 6 in total all where successful. the actual output is equal with the expected output.

for more better clarity(detail) this table demonstrates it better.

| Test Suite              | Test Case                                                  | Result | Expected Outcome                         | Actual Outcome                              |
| ----------------------- | ---------------------------------------------------------- | ------ | ---------------------------------------- | ------------------------------------------- |
| seasonDetermineTest     | testValidCountryWithMeteorologicalCalendar_AustraliaSummer | Passed | -                                        | -                                           |
|                         | testInvalidCountry_Atlantis                                | Failed | Invalid input or country not recognized. | Season data not available for this country. |
|                         | testCountryWithTwoCalendarTypes_AustraliaNoongarMakuru     | Passed | -                                        | -                                           |
|                         | testInvalidMonthHighBoundary                               | Passed | -                                        | -                                           |
|                         | testSingaporeWithInterMonsoon                              | Failed | Inter-monsoon                            | Southwest Monsoon                           |
|                         | testNonAustraliaCountryValidInput_UAESummer                | Passed | -                                        | -                                           |
|                         | testInvalidMonthLowBoundary                                | Passed | -                                        | -                                           |
| isCountryValidationTest | whenValidCountry_thenShouldReturnTrue                      | Passed | -                                        | -                                           |
|                         | whenInvalidCountry_thenShouldReturnFalse                   | Passed | -                                        | -                                           |
| validateTemperature     | testTemperatureNearAverageValid_Perth                      | Passed | -                                        | -                                           |
|                         | testTemperatureDifferenceGreaterThan6_Dubai                | Passed | -                                        | -                                           |
|                         | testValidTemperatureWithinRange_Perth                      | Passed | -                                        | -                                           |
|                         | testCityNotRecognized_Gotham                               | Passed | -                                        | -                                           |
|                         | testTemperatureBelowMinimum_Dubai                          | Passed | -                                        | -                                           |
|                         | testTemperatureAboveMaximum_Dubai                          | Passed | -                                        | -                                           |



## Summary of Your Work (Traceability Matrix)

| Module Name         | BB (EP) | BB (BVA) | WB   | Data Types          | Form of Input/Output          | EP   | BVA  | White-Box Details                                                     |
| ------------------- | ------- | -------- | ---- | ------------------- | ----------------------------- | ---- | ---- | --------------------------------------------------------------------- |
| validateTemperature | done    | done     | done | String, double      | City name, temperature value  | done | done | Tested logic for temp range validation; path coverage for all cities. |
| determineSeason     | done    | done     | done | String, String, int | Country name, calendar, month | done | -    | Evaluated conditional paths for month and calendar type checks.       |
| isValidCountry      | done    | -        | done | String              | Country name                  | done | -    | Examined string matching for country list; complete path coverage.    |


## Version Control

[Include a version control log screenshot or discussion.]

![[Screenshot from 2024-03-26 12-27-49.png]]
## Discussion

Reflecting on the project, it has showed me how to apply real word software engineering practices to my software development journey. For this project i have encountered many challenges specifically when testing the test cases that where made and helped me improve my software creation skills highlighting  the learning outcomes of this unit.