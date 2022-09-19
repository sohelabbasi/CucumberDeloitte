package Runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/EmployeeSearch.feature",
        glue = "steps",
        dryRun = false,
        tags = "@smoke1"
)

public class RunnerClass {
}
