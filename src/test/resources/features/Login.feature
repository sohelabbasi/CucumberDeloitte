Feature: Login functionality

  Background:
    #Given user is navigated to HRMS application

  @regression @sprint15
  Scenario: Valid admin login
    When user enters valid admin username and password
    And user clicks on login button
    Then user should be able to see dashboard page

  @smoke  @sprint14 @scrummaster @migration @regression
  Scenario: Invalid login
    When user enters invalid admin username and password
    And user clicks on login button
    Then user should be able to see error message