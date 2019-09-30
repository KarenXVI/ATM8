package utils;

import com.epam.atmp.config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    private static WebDriver driver;
    private static final String BROWSER = Config.get("/app.properties", "browser");

    private WebDriverSingleton() {
    }

    public static WebDriver initDriver() {
        if (driver == null) {
            switch (BROWSER) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized"));
                    break;
                case "firefox":
                    break;
            }
        } else {
            return driver;
        }
        return driver;
    }


    public static void killDriver() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.out.println("Cannot kill browser");
                System.out.println(e);
            } finally {
                driver = null;
            }
        }
    }

    public static WebDriver getWebDriverInstance() {
        return driver;
    }
}
