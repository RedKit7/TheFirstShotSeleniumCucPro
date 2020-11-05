package com.zerobank.step_definitions;

import com.zerobank.pages.zerobankPages.AccountActivityPage;
import com.zerobank.pages.zerobankPages.DashboardMenuPagePage;
import com.zerobank.pages.zerobankPages.LoginPage;
import com.zerobank.pages.zerobankPages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class purchaseForeignCurrencyStepDef {


    LoginPage loginPage = new LoginPage();
    DashboardMenuPagePage dashboardMenuPagePage = new DashboardMenuPagePage();
    AccountActivityPage accountActivity = new AccountActivityPage();
    PayBillsPage payBillsPage = new PayBillsPage();

    Random random = new Random();


    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List <String> expectedCurrencyList) {
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

        Select listSelect = new Select(payBillsPage.currencyList);
        List<String> actualCurrencyList = BrowserUtils.getElementsText(listSelect.getOptions());

        actualCurrencyList.remove(0);


        for (String expectedCurListEach : expectedCurrencyList) {
            Assert.assertTrue(actualCurrencyList.contains(expectedCurListEach));

        }


    }


    @When("user tries to calculate cost without selecting/entering a {string}") // currency, value
    public void user_tries_to_calculate_cost_without_selecting_a(String enterValueTo) {

     //   Random random = new Random();

        Random rand = new Random();
        if (enterValueTo.equalsIgnoreCase("currency")){

            int i = random.nextInt();
            payBillsPage.amountInputForeignCash.sendKeys(i+"");

        } else if (enterValueTo.equalsIgnoreCase("value")){

            Select allCurrency = new Select(payBillsPage.currencyList);

            int randomNr = rand.nextInt(allCurrency.getOptions().size());
            allCurrency.selectByIndex(randomNr);
        }
        payBillsPage.calculateCostsButton.click();
    }



    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.get().switchTo().alert();
        Assert.assertFalse(alert.getText().isEmpty());
        alert.accept();
    }

}