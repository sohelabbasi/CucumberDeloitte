package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class EmployeeSearchSteps extends CommonMethods {
    @When("user clicks on employee list option")
    public void user_clicks_on_employee_list_option() {
        WebElement empListOption = driver.findElement(By.id("menu_pim_viewEmployeeList"));
       click(empListOption);
    }

    @When("user enters employee id")
    public void user_enters_employee_id() {
        WebElement empIdSearch = driver.findElement(By.id("empsearch_id"));
       sendText(empIdSearch, "12013276");
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {

        WebElement searchButton = driver.findElement(By.id("searchBtn"));
       click(searchButton);
    }

    @Then("user should be able to see employee information")
    public void user_should_be_able_to_see_employee_information() {
        System.out.println("Employee information is displayed");
    }

    @When("user enters name of the employee")
    public void user_enters_name_of_the_employee() {
        WebElement empNameSearch = driver.findElement(By.id("empsearch_employee_name_empName"));
       sendText(empNameSearch, "gisel");
    }

}
