package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions{
    features = "src/test/java/features",

        }
public class CucuberTestRunner extends AbstractTestNGCucumberTests {
}
