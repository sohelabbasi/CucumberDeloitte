Feature: Dashboard functionality

  @regression @dashboard
  Scenario: verify dashboard tabs
    When user enters valid admin username and password
    And user clicks on login button
    Then user should be able to see dashboard page
    And user verify all dashboard tabs
    |Admin|PIM|Leave|Time|Recruitment|Performance|Dashboard|Directory|

