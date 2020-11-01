package com.zerobank.pages.zerobankPages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSummaryPage {


    public AccountSummaryPage(){ PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(linkText="Savings")
    public WebElement savingsLink;


    @FindBy(linkText="Brokerage")
    public WebElement brokerageLink;


    @FindBy(linkText="Checking")
    public WebElement checkingLink;




}
