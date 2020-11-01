package com.zerobank.pages.zerobankPages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityPage {


    public AccountActivityPage() {
        PageFactory.initElements(Driver.get(), this);
    }



    Select dropdown = new Select(Driver.get().findElement(By.id("aa_accountId")));


    @FindBy(linkText="Account Activity")
    public WebElement accountActivityPageButton;



    @FindBy(xpath="//a[@href=\"#ui-tabs-2\"]")
    public WebElement findTrancsactionsTab;

    @FindBy(id="aa_fromDate")
    public WebElement datesFrom;


    @FindBy(className="ui-state-default ui-state-active")
    public WebElement datesFrom09_01;



    @FindBy(id="aa_fromDate")
    public WebElement datesTo;


    @FindBy(className="ui-state-default ui-state-active")
    public WebElement datesTo09_06;


    @FindBy(className="btn btn-primary")
    public WebElement findButton;



}
