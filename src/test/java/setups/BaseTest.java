package setups;

import utils.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import java.util.concurrent.TimeUnit;

import static utils.WebDriverSingleton.initDriver;

public class BaseTest {

    @BeforeSuite
    public void beforeSuite() {
        initDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        WebDriverSingleton.killDriver();
    }
}
