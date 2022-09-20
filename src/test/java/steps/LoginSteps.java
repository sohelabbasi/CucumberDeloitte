package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.Constants;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class LoginSteps extends CommonMethods {

    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() {
        openbrowserAndLaunchApplication();
    }

    @When("user enters valid admin username and password")
    public void user_enters_valid_admin_username_and_password() {
        sendText(login.usernameField, ConfigReader.getPropertyValue("username"));
        sendText(login.passwordField, ConfigReader.getPropertyValue("password"));
    }


    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        click(login.loginButton);
    }

    @Then("user should be able to see dashboard page")
    public void user_should_be_able_to_see_dashboard_page() {
        System.out.println("Test passed");
    }

    @When("user enters invalid admin username and password")
    public void user_enters_invalid_admin_username_and_password() {
       sendText(login.usernameField, "admin1");
       sendText(login.passwordField, "HUm@n");
    }


    @Then("user should be able to see error message")
    public void user_should_be_able_to_see_error_message() {
        System.out.println("I am able to see error message");
    }

}
