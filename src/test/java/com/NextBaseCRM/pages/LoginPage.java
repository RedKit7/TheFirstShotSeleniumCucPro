package com.NextBaseCRM.pages;

import com.NextBaseCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(name = "USER_LOGIN")
    public WebElement userName;

    @FindBy(id = "log_entry_favorites_4522")
    public WebElement starIcon;

    @FindBy(name="USER_PASSWORD")
    public WebElement password;

    @FindBy(className = "login-btn")
    public WebElement submit;

    @FindBy(xpath = "//input[@placeholder='Filter and search']")
    public WebElement FilSearch;

    @FindBy(xpath = "//span[text()='Favorites']")
    public WebElement favoriteBtn;


    public void login(String userNameStr, String passwordStr) {
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();
        // verification that we logged
    }


}