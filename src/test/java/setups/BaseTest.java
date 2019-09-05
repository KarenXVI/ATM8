package setups;

import utils.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        driver = WebDriverSingleton.getWebDriverInstance();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        WebDriverSingleton.kill();
    }
}
