package tests;

import com.epam.atmp.helpers.WaitHelper;
import com.epam.atmp.pages.app.LoginPage;
import java.util.concurrent.TimeUnit;
import com.epam.atmp.pages.app.ConfigPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import setups.BaseTest;
import utils.WebDriverSingleton;

public class TestLoginPage extends BaseTest {

    WebDriver driver;
    WaitHelper waitHelper = new WaitHelper();

    LoginPage loginPage;

    ConfigPage configPage;




    @BeforeTest

    public void setup(){

        driver = WebDriverSingleton.getWebDriverInstance();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://localhost:3000");

    }

    @Test(priority=0)

    public void testHomePage() throws InterruptedException {

        loginPage = new LoginPage();

        loginPage.loginToApp();

    }

}