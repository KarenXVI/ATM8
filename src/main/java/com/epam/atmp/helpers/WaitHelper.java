package com.epam.atmp.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverSingleton;

public class WaitHelper {

    private static final int SHORT_TIMEOUT = 50;
    private static WebDriver driver = WebDriverSingleton.getWebDriverInstance();
    private static WebDriverWait wait = new WebDriverWait(driver, SHORT_TIMEOUT);

    public static void waitForEnabledToBeClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (WebDriverException e){
            throw new Error("Element was not clickable " + element.toString());
        }
    }

    public static void isTextVisible(WebElement element, String text) {
        try {
            wait.until(ExpectedConditions.attributeContains(element, "value", text));
        } catch (WebDriverException e){
            throw new Error("Text was not visible on the element " + element.toString());
        }
    }

    public static void waitForVisibility(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (WebDriverException e){
            throw new Error("Element was not visible " + element.toString());
        }
    }

    public static void waitForInvisibility(WebElement element) {
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (WebDriverException e){
            throw new Error("Element was visible " + element.toString());
        }
    }

    public static void waitForTextToBe(WebElement element, String expectedText) {
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
        } catch(WebDriverException e){
            throw new Error("Text was not visible " + element.toString());
        }
    }


}
