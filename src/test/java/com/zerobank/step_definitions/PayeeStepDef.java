package com.zerobank.step_definitions;

import com.zerobank.pages.zerobankPages.AccountActivityPage;
import com.zerobank.pages.zerobankPages.DashboardMenuPagePage;
import com.zerobank.pages.zerobankPages.LoginPage;
import com.zerobank.pages.zerobankPages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class PayeeStepDef {


    LoginPage loginPage = new LoginPage();
    DashboardMenuPagePage dashboardMenuPagePage = new DashboardMenuPagePage();
    AccountActivityPage accountActivity = new AccountActivityPage();
    PayBillsPage payBillsPage = new PayBillsPage();


    @Given("I am on the {string} page")  //"Pay Bills"
    public void i_am_on_the_page(String pageName) {

        String url = ConfigurationReader.get("url");

        switch (pageName.toLowerCase()){
            case "login":
                url = ConfigurationReader.get("url")+"/login.html";
                Driver.get().get(url);
                break;
            case "home":
                Driver.get().get(url);
            case "main":
                break;
            default:
                dashboardMenuPagePage.goToMenu(pageName); // i am going to "pay bills" tab
                break;
        }

 /*
        String url = ConfigurationReader.get("url");
        //WebDriver driver = Driver.get();
        Driver.get().get(url);

        BrowserUtils.waitFor(2);
        String username = ConfigurationReader.get("userName");
        String password = ConfigurationReader.get("password");

        //   LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
*/

    }

    @Given("the user accesses the {string} tab") //"Add New Payee"
    public void the_user_accesses_the_tab(String tabName) {

        if (tabName.toLowerCase().equals("find transactions")){
            accountActivity.findTransactions.click();
        }
        dashboardMenuPagePage.goToTab(tabName);


     //   payBillsPage.addNewPayeeTab.click();

    }


    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String>Table) {
     payBillsPage.newPayeeNameInput.sendKeys(Table.get("Payee Name"));
     payBillsPage.newPayeeAddressInput.sendKeys(Table.get("Payee Address"));
     payBillsPage.newPayeeAccountInput.sendKeys(Table.get("Account"));
     payBillsPage.newPayeeDetailsInput.sendKeys(Table.get("Payee details"));
     payBillsPage.addNewPayeeTab.click();

    }

    @Then("message {string} alert should be displayed")
    public void message_alert_should_be_displayed(String expectedMessage) {

        String actualMessage = payBillsPage.alertMessageBox.getText();

        Assert.assertEquals(actualMessage,expectedMessage,"The new payee The Law Offices of Hyde, Price & Scharks was successfully created.");
/*

        if (expectedMessage.contains("success")) {
            Assert.assertTrue("Alert Box is not displayed", payBillsPage.alertMessageBox.isDisplayed());
            String actualMessage = payBillsPage.alertMessageBox.getText();
            Assert.assertEquals("Alert Box Message does not match: " + actualMessage, expectedMessage, actualMessage);
        } else {
            //TODO ... HTML5 FILL OUT THE FIELD IS HERE !!!
            if (payBillsPage.amountInput.getAttribute("value").isEmpty()) {
                String actualValidationMessage = payBillsPage.amountInput.getAttribute("validationMessage");
                Assert.assertEquals("Alert Box Message does not match",expectedMessage,actualValidationMessage);
            } else {
                String actualValidationMessage = payBillsPage.dateInput.getAttribute("validationMessage");
                Assert.assertEquals("Alert Box Message does not match",expectedMessage,actualValidationMessage);
            }
        }

        */

    }


}
