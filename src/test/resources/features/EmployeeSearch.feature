Feature: Employee search

  Background:
    #Given user is navigated to HRMS application
    * user enters valid admin username and password
    * user clicks on login button
    * user should be able to see dashboard page
    * user clicks on PIM option
    * user clicks on employee list option

  @smoke @background @regression
  Scenario: Search an employee by employee id
    * user enters employee id
    * user clicks on search button
    * user should be able to see employee information

    @smoke1 @background @regression
    Scenario: Search an employee by name
      When user enters name of the employee
      And user clicks on search button
      Then user should be able to see employee information