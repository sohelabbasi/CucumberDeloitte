Feature: Login functionality

  @regression @sprint15
  Scenario: Valid admin login
    Given user is navigated to HRMS application
    When user enters valid admin username and password
    And user clicks on login button
    Then user should be able to see dashboard page

  @smoke  @sprint14 @scrummaster @migration
  Scenario: Invalid login
    Given user is navigated to HRMS application
    When user enters invalid admin username and password
    And user clicks on login button
    Then user should be able to see error message