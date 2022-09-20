package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.util.ArrayList;
import java.util.List;

public class DashboardSteps extends CommonMethods {

    @Then("user verify all dashboard tabs")
    public void user_verify_all_dashboard_tabs(DataTable dataTable) {
       List<String> expectedTabs =  dataTable.asList();

       List<String> actualTabs = new ArrayList<>();
        for (WebElement ele: dash.dashboardTabs
             ) {
            actualTabs.add(ele.getText());
        }
        System.out.println(actualTabs);
        System.out.println(expectedTabs);

        Assert.assertTrue(expectedTabs.equals(actualTabs));

    }


}
