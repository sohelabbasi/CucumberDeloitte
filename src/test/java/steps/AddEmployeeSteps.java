package steps;

import com.github.dockerjava.core.dockerfile.DockerfileStatement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.matcher.DeclaringMethodMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AddEmployeePage;
import pages.DashboardPage;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReader;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {


    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        click(dash.pimOption);
    }

    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() {

       click(dash.addEmployeeOption);
    }

    @When("user enters firstname middlename and lastname")
    public void user_enters_firstname_middlename_and_lastname() {

        sendText(add.firstNameField, "umesh");
        sendText(add.middleNameField, "MS");
        sendText(add.lastNameField, "Mittal");

    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {

       click(add.saveButton);

    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added successfully");
    }

    @When("user enters {string} , {string} , {string}")
    public void user_enters(String firstName, String middleName, String lastName) {
        sendText(add.firstNameField, firstName);
        sendText(add.middleNameField, middleName);
        sendText(add.lastNameField, lastName);
    }

    @When("user enters {string} , {string} and {string}")
    public void user_enters_and(String fn, String mn, String ln) {
        sendText(add.firstNameField, fn);
        sendText(add.middleNameField, mn);
        sendText(add.lastNameField, ln);
    }

    @When("user add multiple employees and verify them that they are added")
    public void user_add_multiple_employees_and_verify_them_that_they_are_added(DataTable dataTable) throws InterruptedException {
       List<Map<String, String>> employeeNames = dataTable.asMaps();

        for (Map<String, String> emp:employeeNames
             ) {
            String firstNameValue = emp.get("firstName");
            String middleNameValue = emp.get("middleName");
            String lastNameValue = emp.get("lastName");

            sendText(add.firstNameField, firstNameValue);
            sendText(add.middleNameField, middleNameValue);
            sendText(add.lastNameField, lastNameValue);

            click(add.saveButton);
            Thread.sleep(2000);
            click(dash.addEmployeeOption);
            Thread.sleep(2000);
        }
    }

    @When("user adds multiple employee fromm excel file using sheet {string} and verify them")
    public void user_adds_multiple_employee_fromm_excel_file_using_sheet_and_verify_them(String sheetName) throws InterruptedException {
     List<Map<String,String>> employees = ExcelReader.excelIntoListMap(Constants.TESTDATA_FILEPATH, sheetName);

        Iterator<Map<String, String>> itr = employees.iterator();
        while (itr.hasNext()){
            Map<String, String> mapNewEmp = itr.next();

            sendText(add.firstNameField, mapNewEmp.get("firstName"));
            sendText(add.middleNameField, mapNewEmp.get("middleName"));
            sendText(add.lastNameField, mapNewEmp.get("lastName"));
            sendText(add.photograph, mapNewEmp.get("photograph"));

            if(!add.checkBox.isSelected()){
                click(add.checkBox);
            }

            sendText(add.username, mapNewEmp.get("username"));
            sendText(add.password, mapNewEmp.get("password"));
            sendText(add.confirmPassword, mapNewEmp.get("confirmPassword"));
            click(add.saveButton);
            Thread.sleep(2000);
            click(dash.addEmployeeOption);
            Thread.sleep(2000);
        }
    }

}
