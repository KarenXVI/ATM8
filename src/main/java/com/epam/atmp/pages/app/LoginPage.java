package com.epam.atmp.pages.app;

import com.epam.atmp.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.atmp.helpers.WaitHelper.*;

public class LoginPage extends BasePage<LoginPage> {

    private final String CURRENT_PAGE_URL = "/";

    @FindBy(className = "MuiButton-label")
    WebElement loginButton;
    @FindBy(xpath = "//*[contains(@src, 'BOSCH')]")
    WebElement logo;
    @FindBy(xpath = "//h1[text()='Val Repo']")
    WebElement pageTitle;
    @FindBy(xpath = "//h1")
    WebElement title;


    @Override
    protected String currentPageUrl() {
        return CURRENT_PAGE_URL;
    }

    public void clickLogin(){
       waitForEnabledToBeClickable(loginButton);
       click(loginButton);

    }
    public boolean logoIsPresent(){
        try {
            waitForVisibility(logo);
            return true;
        } catch (NullPointerException e){
            return false;
        }
    }

    public boolean verifyPageTitle(String text){
        try {
            waitForTextToBe(title, text);
            return true;
        } catch  (NullPointerException e){
            return false;
        }
    }
    public String getPageTitle(){
        return title.getText().trim();
    }

    public boolean verifyLoginButtonText(String text){
        try{
            waitForEnabledToBeClickable(loginButton);
            waitForTextToBe(loginButton, text);
            return true;
        } catch (NullPointerException e){
            return false;
        }
    }



}
