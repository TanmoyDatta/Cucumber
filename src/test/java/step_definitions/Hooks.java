package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.DriverSetUp;

public class Hooks {
    private static String browserName = System.getProperty("browser","Chrome"); // console a user driver select kore dibe. , select na korle by default chrome browser open hobe

    @Before
    public void launchBrowser(){
        DriverSetUp.setBrowser(browserName);
    }

    @After
    public void quitBrowsers(Scenario scenario){
        DriverSetUp.quitBrowser(scenario);
    }
}