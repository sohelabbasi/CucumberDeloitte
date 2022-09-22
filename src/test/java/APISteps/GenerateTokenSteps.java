package APISteps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.bouncycastle.cert.ocsp.Req;

import static io.restassured.RestAssured.given;

public class GenerateTokenSteps {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    public static String token;


    @Given("a JWT is generated")
    public void a_jwt_is_generated() {
        RequestSpecification generateToken = given().header("Content-Type", "application/json").
                body("{\n" +
                        "  \"email\": \"eishwar@123.com\",\n" +
                        "  \"password\": \"myworld\"\n" +
                        "}");

        Response response = generateToken.when().post("/generateToken.php");
        response.prettyPrint();

        token = "Bearer " + response.jsonPath().getString("token");
        System.out.println(token);
    }
}
