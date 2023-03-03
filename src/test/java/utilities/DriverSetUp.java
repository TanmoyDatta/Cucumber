package utilities;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverSetUp {

    private static final ThreadLocal<WebDriver> LOCAL_DRIVER = new ThreadLocal(); // localDriver nam a akta variable nilam
    // localDriver k set korar jonno method likhte hobe , and get korar jonno akta method likhte hobe
    // isolate kora holo ata
    // LOCAL_DRIVER er set method

    public static void setDriver(WebDriver driver) { // set method , set method korte (WebDriver driver) nite hobe/  [void thakle return kore na]
        DriverSetUp.LOCAL_DRIVER.set(driver); // localDriver er variable  er moddhe driver ta assgin kore dibo / set kore dilam
    }
    // LOCAL_DRIVER er get method
    public static WebDriver getDriver() {
        return LOCAL_DRIVER.get(); // localDriver ta get korlam
    }

    public static WebDriver getBrowser(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            case "edge":
                return new EdgeDriver();
            default:
                throw new RuntimeException("Browser is not found using the name '"+browserName+"'!");
        }
    }

    public static synchronized void setBrowser(String browserName) {
        WebDriver webDriver = getBrowser(browserName);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.manage().window().maximize();
        setDriver(webDriver);
    }

    public static synchronized void quitBrowser(Scenario scenario) {
        takeScreenShot(scenario);
        getDriver().quit();
    }

    public static void takeScreenShot(Scenario scenario){
        if (scenario.isFailed()){
            String screenShoteName = scenario.getName().replaceAll(" ","_");
            byte[] sourcePath = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath,"image/png",screenShoteName);
        }
    }
}
