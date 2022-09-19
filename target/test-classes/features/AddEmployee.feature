Feature: Add employees

  @smoke
  Scenario: Adding the employee
    Given user is navigated to HRMS application
    When user enters valid admin username and password
    And user clicks on login button
    Then user should be able to see dashboard page
    When user clicks on PIM option
    And user clicks on add employee button
    When user enters firstname middlename and lastname
    And user clicks on save button
    Then employee added successfully
