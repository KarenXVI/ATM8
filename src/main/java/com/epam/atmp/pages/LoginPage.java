package com.epam.atmp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import utils.WebDriverSingleton;

public class LoginPage {

    protected WebDriver driver;

    By loginButton = By.name("Login");
    By titleText =By.className("Val Repo");

    public LoginPage(){

        this.driver = WebDriverSingleton.getWebDriverInstance();

    }

    public void clickLogin(){

        driver.findElement(loginButton).click();

    }

    public String getPageTitle(){

        return    driver.findElement(titleText).getText();

    }

    public void loginToApp(){

        this.clickLogin();
    }

}
