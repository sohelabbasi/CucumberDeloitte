package APISteps;

import APISteps.GenerateTokenSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.APIConstants;
import utils.APIPayloadConstants;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class APIWorkflowSteps {

    RequestSpecification request;
    Response response;
    public static String employee_id;

    @Given("a request is prepared to create an employee")
    public void a_request_is_prepared_to_create_an_employee() {
        request  = given().header(APIConstants.Header_Content_Type, APIConstants.Content_Type).
                header(APIConstants.Header_Authorization, GenerateTokenSteps.token).
                body(APIPayloadConstants.createEmployeePayload());
    }

    @When("a POST call is made to create an employee")
    public void a_post_call_is_made_to_create_an_employee() {
        response = request.when().post(APIConstants.CREATE_EMPLOYEE_URI);
    }

    @Then("the status code for creating an employee should be {int}")
    public void the_status_code_for_creating_an_employee_should_be(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    @Then("the employee created contains key {string} and Value {string}")
    public void the_employee_created_contains_key_and_value(String message, String valueOfMessage) {
        response.then().assertThat().body(message, equalTo(valueOfMessage));
    }

    @Then("the employee id {string} is stored as a global variable to used for other calls")
    public void the_employee_id_is_stored_as_a_global_variable_to_used_for_other_calls(String empId) {
       employee_id = response.jsonPath().getString(empId);
        System.out.println(employee_id);
    }

    //__________________________________________________________________________________

    @Given("a request is prepared to get an employee from the DB")
    public void a_request_is_prepared_to_get_an_employee_from_the_db() {
        request = given().header(APIConstants.Header_Authorization, GenerateTokenSteps.token).
                header(APIConstants.Header_Content_Type, APIConstants.Content_Type).
                queryParam("employee_id", employee_id);
    }

    @When("a GET call is made to retrieve the employee data")
    public void a_get_call_is_made_to_retrieve_the_employee_data() {
        response = request.when().get(APIConstants.GET_ONE_EMPLOYEE_URI);
    }

    @Then("the status code for this request is {int}")
    public void the_status_code_for_this_request_is(int statusCode) {
       response.then().assertThat().statusCode(statusCode);
    }

    @Then("the employee is having {string} must match with the globally stored employee id")
    public void the_employee_is_having_must_match_with_the_globally_stored_employee_id(String empIdTemp) {
      String tempEmpID =  response.jsonPath().getString(empIdTemp);
        Assert.assertEquals(tempEmpID, employee_id);
    }

    @Then("the retrieved data at {string} object must match with the data used to create an employee")
    public void the_retrieved_data_at_object_must_match_with_the_data_used_to_create_an_employee
            (String empObject, DataTable dataTable) {
       List<Map<String, String>> expectedData = dataTable.asMaps();
       Map<String, String> actualData = response.body().jsonPath().get(empObject);

        for (Map<String, String> map:
             expectedData) {
            Set<String> keys = map.keySet();
            for (String key:keys
                 ) {
                String expectedValue = map.get(key);
                String actualValue = actualData.get(key);
                Assert.assertEquals(expectedValue, actualValue);
            }
        }
    }

    @Given("a request is prepared to create an employee using json payload")
    public void a_request_is_prepared_to_create_an_employee_using_json_payload() {
        request = given().header(APIConstants.Header_Content_Type, APIConstants.Content_Type).
                header(APIConstants.Header_Authorization, GenerateTokenSteps.token).
                body(APIPayloadConstants.createJsonEmployeePayload());
    }

    @Given("a request is prepared for creating an employee with dynamic data {string} , {string} , {string} , {string} , {string} , {string} , {string}")
    public void a_request_is_prepared_for_creating_an_employee_with_dynamic_data
            (String emp_firstname, String emp_lastname,
             String emp_middlename, String emp_gender,
             String emp_birthday, String emp_status,
             String emp_job_title) {
        request = given().header(APIConstants.Header_Content_Type, APIConstants.Content_Type).
                header(APIConstants.Header_Authorization, GenerateTokenSteps.token).
                body(APIPayloadConstants.payloadDynamic(emp_firstname, emp_lastname,
                        emp_middlename, emp_gender,
                        emp_birthday, emp_status,
                        emp_job_title));
    }

}
