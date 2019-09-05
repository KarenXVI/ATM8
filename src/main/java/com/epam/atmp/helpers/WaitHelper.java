package com.epam.atmp.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverSingleton;

public class WaitHelper {

    private static final int SHORT_TIMEOUT = 30;
    private WebDriver driver = WebDriverSingleton.getWebDriverInstance();
    private WebDriverWait wait = new WebDriverWait(driver, SHORT_TIMEOUT);

    public void waitForEnabledToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToContain(WebElement element, String text) {
        wait.until(ExpectedConditions.attributeContains(element, "value", text));
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForInvisibility(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForTextToBe(WebElement element, String expectedText) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
    }

    public void waitForPage() {

    }

}
