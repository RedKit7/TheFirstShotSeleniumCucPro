package com.zerobank.step_definitions;


import com.zerobank.pages.zerobankPages.AccountActivityPage;
import com.zerobank.pages.zerobankPages.AccountSummaryPage;
import com.zerobank.pages.zerobankPages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


public class AccountActivityNavigationStepDef {



    @Given("the user is logged in")
    public void the_user_is_logged_in() throws InterruptedException {

        String url = ConfigurationReader.get("url");
        //WebDriver driver = Driver.get();
        Driver.get().get(url);

        BrowserUtils.waitFor(2);
        String username = ConfigurationReader.get("userName");
        String password = ConfigurationReader.get("password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);

    }

    @When("the user clicks on Savings link on the Account Summary page Then the Account Activity page should be displayed")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page_Then_the_Account_Activity_page_should_be_displayed() throws InterruptedException {

        Thread.sleep(3000);
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.savingsLink.click();

        Thread.sleep(2000);

        String actualUrl = Driver.get().getCurrentUrl();
        String expectedUrl = "http://zero.webappsecurity.com/bank/account-activity.html?accountId=1";

        Assert.assertEquals(actualUrl,expectedUrl);
    }
    @When("Account drop down should have Savings selected")
    public void account_drop_down_should_have_Savings_selected() {


        // AccountActivityPage accountActivityPage = new AccountActivityPage();

        Select dropdown = new Select(Driver.get().findElement(By.id("aa_accountId")));
        dropdown.selectByVisibleText("Savings");

        //dropdown.selectByIndex(0);
        //dropdown.selectByValue("1");


        System.out.println("dropdown.getFirstSelectedOption().getText() = " + dropdown.getFirstSelectedOption().getText());

        Assert.assertEquals("Savings",dropdown.getFirstSelectedOption().getText());


    }


        @When("the user clicks on Brokerage link on the Account Summary page Then the Account Activity page should be displayed")
        public void the_user_clicks_on_Brokerage_link_on_the_Account_Summary_page_Then_the_Account_Activity_page_should_be_displayed() throws InterruptedException {


            String url = ConfigurationReader.get("url");
            //WebDriver driver = Driver.get();
            Driver.get().get(url);

            BrowserUtils.waitFor(2);
            String username = ConfigurationReader.get("userName");
            String password = ConfigurationReader.get("password");

            LoginPage loginPage = new LoginPage();
            loginPage.login(username,password);



            Thread.sleep(3000);
            AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
            accountSummaryPage.brokerageLink.click();

            Thread.sleep(2000);


            String expectedUrl = "http://zero.webappsecurity.com/bank/account-activity.html?accountId=6";
            String actualUrl = Driver.get().getCurrentUrl();

            Assert.assertEquals(actualUrl,expectedUrl);


        }

        @When("Account drop down should have Brokerage selected")
        public void account_drop_down_should_have_Brokerage_selected() {

            Select dropdown = new Select(Driver.get().findElement(By.id("aa_accountId")));
            dropdown.selectByValue("6");

            System.out.println("dropdown.getFirstSelectedOption().getText() = " + dropdown.getFirstSelectedOption().getText());

            Assert.assertEquals("Brokerage",dropdown.getFirstSelectedOption().getText());


        }



    @When("the user clicks on Checking link on the Account Summary page Then the Account Activity page should be displayed")
    public void the_user_clicks_on_Checking_link_on_the_Account_Summary_page_Then_the_Account_Activity_page_should_be_displayed() throws InterruptedException {

        String url = ConfigurationReader.get("url");
        //WebDriver driver = Driver.get();
        Driver.get().get(url);

        BrowserUtils.waitFor(2);
        String username = ConfigurationReader.get("userName");
        String password = ConfigurationReader.get("password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);



        Thread.sleep(3000);
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.checkingLink.click();

        Thread.sleep(2000);


        String expectedUrl = "http://zero.webappsecurity.com/bank/account-activity.html?accountId=2";
        String actualUrl = Driver.get().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

    }



    @When("Account drop down should have Checking selected")
    public void account_drop_down_should_have_Checking_selected() {

        Select dropdown = new Select(Driver.get().findElement(By.id("aa_accountId")));
        dropdown.selectByIndex(1);

        System.out.println("dropdown.getFirstSelectedOption().getText() = " + dropdown.getFirstSelectedOption().getText());

        Assert.assertEquals("Checking",dropdown.getFirstSelectedOption().getText());

    }



}
