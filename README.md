# Architecture Scremplay to Automated Testing for NeoTechnicalTest
Test Exercise in Selenium and serenity following a ScreenPlay architecture


## Descripción
This project aims to automate the functional testing of the login to gail, and explorar etiquetas y descragara archivos. The tests will be written using Selenium, serenity, gradle,  and Java following the Screenplay architecture to ensure modularity, scalability, and reusability.

## Requirements
Before starting, make sure you have cucumber, gradle installed to generete to report

## Project Structure
The project follows the Screenplay architecture and is structured as follows:

## Estrucutra del proyecto
The project is structured as follows:

```bash
NeoTechniqueTest
├── resource
│   ├── document                  # Deliverable document
│   ├── driver                    # Driver = chrome   # you can change to firefox, edge, etc.
│   ├── features                  # Feature files for BDD (Gherkin format)
│   │   ├── example.feture
├── scr
│   ├── main
│   │   ├── exception             # Handling errors or unexpected situations
│   │   │   ├── exampleError.java
│   │   ├── interaction           # Action to perform  (Screenplay interaction)
│   │   │   ├── exampleClickOn.java
│   │   ├── model                 # Data models used for the tests (e.g., user data)
│   │   │   ├── exampleData.java
│   │   ├── question              # Assertions or validations (Screenplay questions)
│   │   │   ├── exampleAnswer.java
│   │   ├── tasks                 # Tasks to perform actions (Screenplay tasks)
│   │   │   ├── exampleToTask.java
│   │   ├── userInterface         # Page Tarhet representing the UI components
│   │   │   ├── examplePageUI.java
│   │   ├── util                  # Utility files (helper functions and common utilities)
│   │   │   ├── exampleContans.java
│   ├── tes
│   │   ├── runners               # To execute test case (Screenplay questions)
│   │   ├── stepDefinitions       # Step definitions for BDD scenarios (mapping steps code)
│   │   │   ├── exampleStep.java
│   ├── target                    # Report of test case (Screenplay report)
│   │   ├── site                  # Tasks to perform actions (Screenplay tasks)
│   │   │   ├── serenity          # Imagen resources
│   │   │   │   ├── Example.index # Report
builGradle                        # Project dependencies and scripts 
settingGradle                     # proyect root configuration
README.md                         # Project documentation
```
## 🚀 Instalación
```execute test case
:test --tests "co.technical.automation.runners.EmailProcessingAutomation"
```
## Generate Report :
```bash
./gradlew aggregate

```
