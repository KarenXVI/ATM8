package com.epam.atmp.pages;

import com.epam.atmp.helpers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WebDriverSingleton;

public class LoginPage {

    protected WebDriver driver = WebDriverSingleton.getWebDriverInstance();
    WaitHelper waitHelper = new WaitHelper();

    WebElement loginButton = driver.findElement(By.xpath("//button[contains(@class, 'MuiButtonBase-root')]"));
    WebElement loading = driver.findElement(By.xpath("//div[contains(@class, 'makeStyles-container-1')]"));

    By titleText =By.className("Val Repo");

    public LoginPage(){

    }

    public void clickLogin(){

        waitHelper.waitForEnabledToBeClickable(loginButton);
        loginButton.click();

    }

    public String getPageTitle(){

        return    driver.findElement(titleText).getText();

    }

    public void loginToApp(){
        waitHelper.waitForInvisibility(loading);

        waitHelper.waitForVisibility(loginButton);
        this.clickLogin();
    }

}
