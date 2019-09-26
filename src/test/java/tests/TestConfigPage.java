package tests;

        import com.epam.atmp.pages.app.ConfigPage;
        import com.epam.atmp.pages.app.LoginPage;
        import org.testng.Assert;
        import org.testng.annotations.BeforeTest;
        import org.testng.annotations.Test;
        import setups.BaseTest;
        import utils.WebDriverSingleton;

        import java.util.concurrent.TimeUnit;

public class TestConfigPage extends BaseTest {

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

        Thread.sleep(5000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl == "http://localhost:3000/dashboard/configuration");

    }


}
