Feature: Add employees

  Background:
    When user enters valid admin username and password
    And user clicks on login button
    Then user should be able to see dashboard page
    When user clicks on PIM option
    And user clicks on add employee button

  @smoke @regression
  Scenario: Adding the employee
   # Given user is navigated to HRMS application
    When user enters firstname middlename and lastname
    And user clicks on save button
    Then employee added successfully

  @test
  Scenario: Adding one employee from feature file
    When user enters "anjali" , "MS" , "Singh"
    And user clicks on save button
    Then employee added successfully

 @examples
 Scenario Outline: Adding multiple employees using examples table
   When user enters "<firstName>" , "<middleName>" and "<lastName>"
   And user clicks on save button
   Then employee added successfully
   Examples:
   |firstName|middleName|lastName|
   |shubham  |MS        |shekhar |
   |rutik    |MS        |sansare |
   |Kanishq  |MS        |rajak   |
   |mili     |joint     |priti   |
   |anjali   |joint     |aparna  |


 @datatable
 Scenario: Adding multiple employees using data table
   When user add multiple employees and verify them that they are added
   |firstName|middleName|lastName|
   |kabika   |MS        |suman   |
   |Bhuvaneshwar|MS     |kumar   |
   |Ananya      |MS     |pandey  |
   |shivangi    |coffee |dwivedi |


 @excel
 Scenario: Adding multiple employees from excel file
   When user adds multiple employee fromm excel file using sheet "employeeData" and verify them



