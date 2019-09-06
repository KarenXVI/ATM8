package com.epam.atmp.pages.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import utils.WebDriverSingleton;

public class ConfigPage {

    protected WebDriver driver;

    By titleText = By.xpath("//");

    public ConfigPage(){

        this.driver = WebDriverSingleton.getWebDriverInstance();

    }


    public String getPageTitle(){

        return    driver.findElement(titleText).getText();

    }


    public void checkPage() {

    }
}
