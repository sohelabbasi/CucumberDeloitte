Feature: Employee search

  @smoke
  Scenario: Search an employee by employee id
    Given user is navigated to HRMS application
    When user enters valid admin username and password
    And user clicks on login button
    Then user should be able to see dashboard page
    When user clicks on PIM option
    And user clicks on employee list option
    When user enters employee id
    And user clicks on search button
    Then user should be able to see employee information

    @smoke1
    Scenario: Search an employee by name
      Given user is navigated to HRMS application
      When user enters valid admin username and password
      And user clicks on login button
      Then user should be able to see dashboard page
      When user clicks on PIM option
      And user clicks on employee list option
      When user enters name of the employee
      And user clicks on search button
      Then user should be able to see employee information