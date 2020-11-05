package com.zerobank.pages.zerobankPages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage {


    public AccountActivityPage() {
        PageFactory.initElements(Driver.get(), this);
    }



  //  Select dropdown = new Select(Driver.get().findElement(By.id("aa_accountId")));


    @FindBy(id="account_activity_tab")
    public WebElement accountActivityPageButton;



    @FindBy(xpath="//a[@href=\"#ui-tabs-2\"]")
    public WebElement findTrancsactionsTab;

    @FindBy(id="aa_fromDate")
    public WebElement datesFrom;


    @FindBy(className="ui-state-default ui-state-active")
    public WebElement datesFrom09_01;



    @FindBy(id="aa_toDate")
    public WebElement datesTo;


    @FindBy(className="ui-state-default ui-state-active")
    public WebElement datesTo09_06;


    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement findButton;


    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr//td[1]")
    public List<WebElement> allDates;


    @FindBy(id = "aa_description")
    public WebElement descriptionInput;


    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr//td[2]")
    public List<WebElement> allDescription;


    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr//td[3]")
    public List<WebElement> allDeposit;


    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr//td[4]")
    public List<WebElement> allWithdrawal;

    @FindBy(id = "aa_type")
    public WebElement selectType;

    @FindBy(xpath = "//li[starts-with(@class,'ui-state-default')][.='Find Transactions']")
    public WebElement findTransactions;

    // =========================

/*

    @FindBy(id = "aa_accountId")
    public WebElement accountOptions;

    @FindBy(xpath = "//table//thead//th")
    public List<WebElement> columnNames;

    @FindBy(xpath = "//li[starts-with(@class,'ui-state-default')][.='Find Transactions']")
    public WebElement findTransactions;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDateInput;

    @FindBy(id = "aa_toDate")
    public WebElement toDateInput;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement findButton;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr//td[1]")
    public List<WebElement> allDates;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr//td[2]")
    public List<WebElement> allDescription;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr//td[3]")
    public List<WebElement> allDeposit;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr//td[4]")
    public List<WebElement> allWithdrawal;

    @FindBy(id = "aa_description")
    public WebElement descriptionInput;

    @FindBy(id = "aa_type")
    public WebElement selectType;


*/





}
