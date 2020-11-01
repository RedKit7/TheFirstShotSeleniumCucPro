package com.zerobank.step_definitions;

import com.zerobank.pages.zerobankPages.AccountActivityPage;
import com.zerobank.pages.zerobankPages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FindTransactionsStepDef {




    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() throws InterruptedException {

        String url = ConfigurationReader.get("url");
        //WebDriver driver = Driver.get();
        Driver.get().get(url);

        BrowserUtils.waitFor(2);
        String username = ConfigurationReader.get("userName");
        String password = ConfigurationReader.get("password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);





    }

    @When("the user enters date range from “{int}-{int}-{int}” to “{int}-{int}-{int}”")
    public void the_user_enters_date_range_from_to(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6) throws InterruptedException {

        Thread.sleep(4000);

        AccountActivityPage accountActivityPage = new AccountActivityPage();


        accountActivityPage.accountActivityPageButton.click();

        Thread.sleep(1000);

        accountActivityPage.findTrancsactionsTab.click();

        Thread.sleep(1000);

        accountActivityPage.datesFrom.click();

        Thread.sleep(1000);

        accountActivityPage.datesFrom09_01.click();

        Thread.sleep(1000);

        accountActivityPage.datesTo.click();

        Thread.sleep(1000);

        accountActivityPage.datesTo09_06.click();




    }

    @When("clicks search")
    public void clicks_search() throws InterruptedException {

        Thread.sleep(2000);
        AccountActivityPage accountActivityPage = new AccountActivityPage();

        accountActivityPage.findButton.click();

    }

    @Then("results table should only show transactions dates between “{int}-{int}-{int}” to “{int}-{int}-{int}”")
    public void results_table_should_only_show_transactions_dates_between_to(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6) {

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {

    }

    @Then("the results table should only not contain transactions dated “{int}-{int}-{int}”")
    public void the_results_table_should_only_not_contain_transactions_dated(Integer int1, Integer int2, Integer int3) {

    }







}
