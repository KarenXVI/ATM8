package tests;

import com.epam.atmp.pages.LoginPage;
import java.util.concurrent.TimeUnit;

import com.epam.atmp.pages.app.ConfigPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import setups.BaseTest;
import utils.WebDriverSingleton;

public class TestLoginPage extends BaseTest {
    WebDriver driver;

    LoginPage loginPage;
    ConfigPage configPage;


    @BeforeTest

    public void setup(){

        driver = WebDriverSingleton.getWebDriverInstance();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://localhost:3000");

    }

    @Test(priority=0)

    public void test_Home_Page_Appear_Correct() {

        loginPage = new LoginPage();

        String loginPageTitle = loginPage.getPageTitle();

        Assert.assertTrue(loginPageTitle.toLowerCase().contains("login"));

        loginPage.loginToApp();

        Assert.assertTrue(configPage.getPageTitle().toLowerCase().contains("config"));
    }
}