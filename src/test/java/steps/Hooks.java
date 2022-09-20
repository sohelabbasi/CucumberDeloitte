package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks extends CommonMethods {

    @Before
    public void start(){
        openbrowserAndLaunchApplication();
    }


    @After
    public void close(Scenario scenario){
        byte[] pic;
        if(scenario.isFailed()){
            pic = takeScreenshot("failed/" + scenario.getName());
        }else{
            pic = takeScreenshot("passed/" + scenario.getName());
        }
        scenario.attach(pic, "image/png", scenario.getName());

        tearDown();
    }


}
