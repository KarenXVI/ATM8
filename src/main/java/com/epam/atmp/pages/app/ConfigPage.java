package com.epam.atmp.pages.app;


import com.epam.atmp.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.atmp.helpers.WaitHelper.*;

public class ConfigPage extends BasePage<ConfigPage> {

    private final String CURRENT_PAGE_URL = "/dashboard/configuration";
    private String serverTitle = "//ul//li[text()='?']";

    @FindBy(id = "select-server")
    WebElement selectServer;
    @FindBy(xpath = "//button/span[text()='Submit']")
    WebElement submitBtn;
    @FindBy(xpath = "//ul")
    WebElement serversContainer;


    @Override
    protected String currentPageUrl() {
        return CURRENT_PAGE_URL;
    }

    public boolean isSelectServerElementVisible(){
        try {
            waitForVisibility(selectServer);
            return true;
        } catch (NullPointerException e){
            return false;
        }
    }

    public boolean isSubmitButtonVisible(){
        try {
            waitForVisibility(submitBtn);
            return true;
        } catch (NullPointerException e){
            return false;
        }
    }

    public void clickSubmit(){
        waitForEnabledToBeClickable(submitBtn);
        click(submitBtn);
    }

    public void selectServer(String server) {
        waitForVisibility(selectServer);
        click(selectServer);
        waitForTextToBe(serversContainer, server);
        click(driver.findElement(By.xpath(serverTitle.replace("?", server))));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementsByClassName('MuiButton-containedPrimary')[0].style.zIndex=\"1000\"");
        clickSubmit();
    }



}
