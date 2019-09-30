package tests;

import com.epam.atmp.pages.app.ConfigPage;
import com.epam.atmp.pages.app.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import setups.BaseTest;

import static com.epam.atmp.pages.BasePage.isTextDisplayed;
import static org.testng.Assert.*;

public class TestLoginPage extends BaseTest {

    private LoginPage loginPage;
    private ConfigPage configPage;

    @BeforeTest
    public void setup() {
        loginPage = new LoginPage();
        configPage = new ConfigPage();
    }

    @Test
    public void testHomePage() throws InterruptedException {
        loginPage.get();
        assertTrue(loginPage.logoIsPresent());
        assertTrue(loginPage.verifyPageTitle("Val Repo"));
        assertTrue(loginPage.verifyLoginButtonText("Login"));
    }

    @Test
    public void testLoggingInFirstTime(){
        loginPage.get();
        loginPage.clickLogin();

        configPage.isLoaded();
        assertTrue(configPage.isSelectServerElementVisible());
        assertTrue(configPage.isSubmitButtonVisible());

    }

    @Test
    public void testLoggingInSecondTime(){
        loginPage.get();
        loginPage.clickLogin();

        configPage.isLoaded();
        assertTrue(!isTextDisplayed("Please select a use-case"));
        configPage. selectServer("Test/Quality System");
        configPage.clickSubmit();
        assertTrue(isTextDisplayed("Please select a use-case"));

        loginPage.get();
        loginPage.clickLogin();
        assertTrue(isTextDisplayed("Please select a use-case"));

    }
}