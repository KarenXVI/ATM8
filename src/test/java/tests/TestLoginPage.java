package tests;

import com.epam.atmp.helpers.WaitHelper;
import com.epam.atmp.pages.LoginPage;
import java.util.concurrent.TimeUnit;
import com.epam.atmp.pages.app.ConfigPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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

//        Thread.sleep(5000);

        loginPage = new LoginPage();
        loginPage.loginToApp();
//        String loginPageTitle = loginPage.getPageTitle();


//        loginButton.click();

    }
}