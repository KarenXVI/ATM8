package com.epam.atmp.pages;


import com.epam.atmp.config.Config;
import org.jsoup.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;


import static org.testng.Assert.assertEquals;
import static utils.WebDriverSingleton.getWebDriverInstance;

public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {
    protected static WebDriver driver = getWebDriverInstance();
    private final String BASE_URL = Config.get("/app.properties", "baseUrl");


    protected BasePage() {
        PageFactory.initElements(driver, this);
    }

    protected abstract String currentPageUrl();

    private String getPageFullUrl() {
        return BASE_URL + currentPageUrl();
    }

    @Override
    protected void load() {
        driver.get(getPageFullUrl());

    }

    @Override
    public void isLoaded() throws Error {
        assertEquals(driver.getCurrentUrl(), getPageFullUrl());
    }

    public void click(WebElement element) {
        element.click();
    }

    public void clickWithJS(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element );
    }

    public String getElementText(WebElement element) {
        return element.getText().trim();
    }

    public void setChecked(WebElement element, boolean checked) {
        if (element.isSelected()) {
            if (!checked)
                element.click();
        } else {
            if (checked)
                element.click();
        }
    }

    public boolean webElementIsSelected(WebElement element) {
        return element.isSelected();
    }

    public String getElementAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    public void scrollBy(String x, String y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(?, #)".replace("?", x).replace("#", y));
    }

    public void selectOption(WebElement element, String option) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(option);
    }

    public static boolean isTextDisplayed(String text){
        try {
            return driver.findElement(By.xpath("//*[text() = '" + text + "']")).isDisplayed();
        }catch ( Exception e){
            System.out.println(e);
            return false;
        }

    }


}
