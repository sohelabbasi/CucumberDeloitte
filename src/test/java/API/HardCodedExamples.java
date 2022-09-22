package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    String uri =  RestAssured.baseURI =  "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NjM4MjEyMTgsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY2Mzg2NDQxOCwidXNlcklkIjoiNDMzNyJ9.hWVGQlxCe9_exgz0Fej-HsIqfBJ9kX6ISR-iFp4SGs8";
    static String employee_id;

    @Test
    public void getCreatedEmployee(){
        //store the uri
        //to prepare the request
       RequestSpecification preparedRequest = given().header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);

      Response response = preparedRequest.when().get("/getOneEmployee.php");
      response.prettyPrint();

      response.then().assertThat().statusCode(200);
      String middleName = response.jsonPath().getString("employee.emp_middle_name");
      Assert.assertTrue(middleName.contentEquals("niche"));
      String empID = response.jsonPath().get("employee.employee_id");

      boolean comparingIDs = empID.contentEquals(employee_id);

    }

    @Test
    public void createEmployee(){
        RequestSpecification request = given().header("Content-Type", "application/json").
                header("Authorization", token).body("{\n" +
                        "  \"emp_firstname\": \"selda\",\n" +
                        "  \"emp_lastname\": \"ms\",\n" +
                        "  \"emp_middle_name\": \"niche\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2018-09-21\",\n" +
                        "  \"emp_status\": \"probation\",\n" +
                        "  \"emp_job_title\": \"QA Engineer\"\n" +
                        "}");

        Response response = request.when().post("/createEmployee.php");
        response.prettyPrint();

        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);

        //assertion
        response.then().assertThat().body("Message", equalTo("Employee Created"));
        response.then().assertThat().header("Server", equalTo("Apache/2.4.39 (Win64) PHP/7.2.18"));

    }




}
