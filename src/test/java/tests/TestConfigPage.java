package tests;

import org.testng.annotations.BeforeTest;
import setups.BaseTest;
import utils.WebDriverSingleton;

import java.util.concurrent.TimeUnit;

public class TestConfigPage extends BaseTest {

    @BeforeTest

    public void setup(){

        driver = WebDriverSingleton.getWebDriverInstance();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://localhost:3000");

    }


}
