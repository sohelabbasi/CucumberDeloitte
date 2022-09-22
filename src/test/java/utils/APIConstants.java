package utils;

import io.restassured.RestAssured;

import java.util.Base64;

public class APIConstants {

    public static final String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    public static final String CREATE_EMPLOYEE_URI = baseURI+"/createEmployee.php";
    public static final String GET_ONE_EMPLOYEE_URI = baseURI+"/getOneEmployee.php";
    public static final String UPDATE_EMPLOYEE_URI = baseURI+"/updateEmployee.php";
    public static final String UPDATE_PARTIAL_EMPLOYEE_URI = baseURI+"/updatePartialEmplyeesDetails.php";
    public static final String GET_EMPLOYEES_URI = baseURI+"/getAllEmployees.php";


    public static final String Header_Content_Type = "Content-Type";
    public static final String Content_Type = "application/json";
    public static final String Header_Authorization = "Authorization";




}
