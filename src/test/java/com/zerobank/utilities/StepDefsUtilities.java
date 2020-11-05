package com.zerobank.utilities;

import com.zerobank.pages.zerobankPages.AccountActivityPage;
import com.zerobank.pages.zerobankPages.AccountSummaryPage;
import com.zerobank.pages.zerobankPages.DashboardMenuPagePage;
import com.zerobank.pages.zerobankPages.LoginPage;

import java.util.List;

public class StepDefsUtilities {



    static AccountActivityPage accountActivity = new AccountActivityPage();
    static LoginPage loginPage = new LoginPage();
    static AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    static DashboardMenuPagePage dashboardMenuPagePage = new DashboardMenuPagePage();

    public static List<String> getListOf(String listOf){
        List<String> columnContent;
        columnContent = BrowserUtils.getElementsText(accountActivity.allDeposit);
        switch (listOf){
            case "deposit":
                columnContent = BrowserUtils.getElementsText(accountActivity.allDeposit);
                break;
            case "withdrawal":
                columnContent = BrowserUtils.getElementsText(accountActivity.allWithdrawal);
        }
        return columnContent;

    }



}
