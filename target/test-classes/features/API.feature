Feature: Syntax api scenarios validation

  Background:
    Given a JWT is generated

  @api
  Scenario: create an employee
    Given a request is prepared to create an employee
    When a POST call is made to create an employee
    Then the status code for creating an employee should be 201
    And the employee created contains key "Message" and Value "Employee Created"
    And the employee id "Employee.employee_id" is stored as a global variable to used for other calls

  @api
  Scenario: get the newly created employee
    Given a request is prepared to get an employee from the DB
    When a GET call is made to retrieve the employee data
    Then the status code for this request is 200
    And the employee is having "employee.employee_id" must match with the globally stored employee id
    And the retrieved data at "employee" object must match with the data used to create an employee
    |emp_firstname|emp_lastname|emp_middle_name|emp_gender|emp_birthday|emp_status|emp_job_title|
    |selda        |ms          |niche          |Female    |2018-09-21  |Probation |QA Engineer  |

   @json
  Scenario: Creating the employee using json
     Given a request is prepared to create an employee using json payload
     When a POST call is made to create an employee
     Then the status code for creating an employee should be 201
     And the employee created contains key "Message" and Value "Employee Created"
     And the employee id "Employee.employee_id" is stored as a global variable to used for other calls

  @dynamic
  Scenario: Creating an employee using highly dynamic payload
    Given a request is prepared for creating an employee with dynamic data "selda" , "ms" , "niche" , "F" , "2018-09-21" , "Probation" , "QA Engineer"
    When a POST call is made to create an employee
    Then the status code for creating an employee should be 201
    And the employee created contains key "Message" and Value "Employee Created"
    And the employee id "Employee.employee_id" is stored as a global variable to used for other calls