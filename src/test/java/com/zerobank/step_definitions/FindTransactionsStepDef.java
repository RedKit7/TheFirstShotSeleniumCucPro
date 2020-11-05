package com.zerobank.step_definitions;

import com.zerobank.pages.zerobankPages.AccountActivityPage;
import com.zerobank.pages.zerobankPages.DashboardMenuPagePage;
import com.zerobank.pages.zerobankPages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.collections4.ListUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class FindTransactionsStepDef {

    AccountActivityPage accountActivity = new AccountActivityPage();
    LoginPage loginPage = new LoginPage();
    DashboardMenuPagePage dashboardMenuPagePage = new DashboardMenuPagePage();


    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {


        String url = ConfigurationReader.get("url");
        //WebDriver driver = Driver.get();
        Driver.get().get(url);

        BrowserUtils.waitFor(2);
        String username = ConfigurationReader.get("userName");
        String password = ConfigurationReader.get("password");

        //   LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);


    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) throws InterruptedException {
        Thread.sleep(3000);

        accountActivity.accountActivityPageButton.click();
        accountActivity.findTrancsactionsTab.click();

        Thread.sleep(2000);
        accountActivity.datesFrom.clear();
        accountActivity.datesFrom.sendKeys(fromDate);

        //Thread.sleep(2000);
        accountActivity.datesTo.clear();
        accountActivity.datesTo.sendKeys(toDate);


        // Thread.sleep(2000);


    }

    @When("clicks search")
    public void clicks_search() throws InterruptedException {

        //   Thread.sleep(3000);

        accountActivity.findButton.click();

    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date fromD = dateFormat.parse(fromDate);
            Date afterD = dateFormat.parse(toDate);

            BrowserUtils.waitFor(2);

            List<String> datesString = BrowserUtils.getElementsText(accountActivity.allDates);
            List<Date> actualDates = new ArrayList<>();

            for (String stringDate : datesString) {
                actualDates.add(dateFormat.parse(stringDate));
            }


            for (Date actualDate : actualDates) {
                boolean isBetween =
                        (actualDate.after(fromD) || actualDate.equals(fromD)) &&
                                (actualDate.before(afterD) || actualDate.equals(afterD));
                Assert.assertTrue("Date range is not as expected", isBetween);
            }

        } catch (ParseException e) {
            Assert.fail("Wrong date format, correct format should be: yyyy-MM-dd");
        }


    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        List<String> datesString = BrowserUtils.getElementsText(accountActivity.allDates);
        List<Date> actualDates = new ArrayList<>();

        try {
            for (String stringDate : datesString) {
                actualDates.add(dateFormat.parse(stringDate));
            }
        } catch (ParseException e) {
            Assert.fail("Wrong date format, correct format should be: yyyy-MM-dd");
        }


        List<Date> sortedDate = new ArrayList<>(actualDates);

        sortedDate.sort(Collections.reverseOrder());
        for (int i = 0; i < sortedDate.size(); i++) {
            Assert.assertEquals(sortedDate.get(i), (actualDates.get(i)));
        }

    }


    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<String> datesString = BrowserUtils.getElementsText(accountActivity.allDates);
        List<Date> actualDates = new ArrayList<>();
        Date dateNotAcceptable = null;
        try {
            dateNotAcceptable = dateFormat.parse(date);
            for (String stringDate : datesString) {
                actualDates.add(dateFormat.parse(stringDate));
            }
        } catch (ParseException e) {
            Assert.fail("Wrong date format please follow this: yyyy-MM-dd");
        }
        for (Date actualDate : actualDates) {
            Assert.assertNotEquals(actualDate, dateNotAcceptable);
        }

    }


    @When("the user enters description {string}")
    public void the_user_enters_description(String online) throws InterruptedException {

        Thread.sleep(3000);

        accountActivity.accountActivityPageButton.click();
        accountActivity.findTrancsactionsTab.click();

        Thread.sleep(2000);

        accountActivity.descriptionInput.sendKeys(online);

    }


    @Then("results table should {string} show descriptions containing {string}")
    public void resultsTableShouldShowDescriptionsContaining(String notShow , String online) throws InterruptedException {

        Thread.sleep(3000);

        List<String> allDescriptions = BrowserUtils.getElementsText(accountActivity.allDescription);

        if (notShow.equalsIgnoreCase("not")) {

            for (String allDescription : allDescriptions) {
                Assert.assertFalse(allDescription.contains(online));
            }

        } else {
            for (String allDescription : allDescriptions) {
                Assert.assertTrue(allDescription.contains(online));
            }
        }

    }



    @Then("results table should show {string} result under {string}")
    public void resultsTableShouldShowResultUnder(String show, String column) throws InterruptedException {

        Thread.sleep(5000);

        //accountActivity.accountActivityPageButton.click();
        //accountActivity.findTrancsactionsTab.click();


       // Thread.sleep(5000);

        List<String> columnContent = new ArrayList<>();

        switch (column.toLowerCase()) {
            case "deposit":
                columnContent = BrowserUtils.getElementsText(accountActivity.allDeposit);
                break;
            case "withdrawal":
                columnContent = BrowserUtils.getElementsText(accountActivity.allWithdrawal);
        }
        int sizeOfItems = columnContent.size();
        if (show.toLowerCase().contains("one")) {

            Assert.assertTrue(sizeOfItems >= 1);
        } else if (show.equalsIgnoreCase("no")) {
            for (String list : columnContent) {
                Assert.assertTrue(list.isEmpty());
            }
        } else {
            Assert.fail("Word undefined");
        }
    }





    @When("user selects type {string}")
    public void userSelectsType(String type) throws InterruptedException {

        Thread.sleep(3000);

        Select allTypes = new Select(accountActivity.selectType);
        Thread.sleep(3000);
        allTypes.selectByVisibleText(type);

        Thread.sleep(3000);

        accountActivity.findButton.click();



    }



}