package com.qentelli.GroupFinalAssessment.tests.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qentelli.GroupFinalAssessment.base.BaseTest;

import com.qentelli.GroupFinalAssessment.listeners.TestListener;

import com.qentelli.GroupFinalAssessment.pages.AccountsOverviewPage;
import com.qentelli.GroupFinalAssessment.pages.LoginPage;
import com.qentelli.GroupFinalAssessment.pages.TransactionHistoryPage;

import com.qentelli.GroupFinalAssessment.utils.ExcelReader;
import com.qentelli.GroupFinalAssessment.utils.ScreenshotUtils;

@Listeners(TestListener.class)

public class TransactionHistoryTest
        extends BaseTest {

    // Logger
    private static final Logger logger =
            LogManager.getLogger(
                    TransactionHistoryTest.class);

    @Test(description =
            "Validate transaction history functionality")

    public void validateTransactionHistory() {

        try {

            logger.info(
            "Transaction History Test Started");

            // =====================================
            // LAUNCH APPLICATION
            // =====================================

            driver.get(
            "https://parabank.parasoft.com/parabank/index.htm");

            logger.info(
            "Application launched successfully");

            // =====================================
            // READ LOGIN DATA FROM EXCEL
            // =====================================

            String username =
                    ExcelReader.getCellData(
                    "src/main/resources/testdata/loginData.xlsx",
                    "LoginData",
                    1,
                    0);

            String password =
                    ExcelReader.getCellData(
                    "src/main/resources/testdata/loginData.xlsx",
                    "LoginData",
                    1,
                    1);

            logger.info(
            "Username fetched successfully");

            // =====================================
            // PAGE OBJECT CREATION
            // =====================================

            LoginPage loginPage =
                    new LoginPage(driver);

            AccountsOverviewPage accountsPage =
                    new AccountsOverviewPage(driver);

            TransactionHistoryPage transactionPage =
                    new TransactionHistoryPage(driver);

            // =====================================
            // LOGIN
            // =====================================

            loginPage.loginToApplication(
                    username,
                    password);

            // =====================================
            // VALIDATE LOGIN
            // =====================================

            Assert.assertTrue(
                    loginPage
                    .isLogoutDisplayed(),

                    "Login failed");

            logger.info(
            "Login completed successfully");

            // =====================================
            // OPEN FIRST ACCOUNT
            // =====================================

            accountsPage.openFirstAccount();

            logger.info(
            "First account opened successfully");

            // =====================================
            // OPEN TRANSACTION HISTORY
            // =====================================

            transactionPage.openTransactions();

            logger.info(
            "Transaction history page opened");

            // =====================================
            // VALIDATE TRANSACTION TABLE
            // =====================================

            boolean transactionStatus =
                    transactionPage
                    .isTransactionTableDisplayed();

            Assert.assertTrue(
                    transactionStatus,

                    "Transaction history table "
                    + "is not displayed");

            logger.info(
            "Transaction history displayed successfully");

        } catch (Exception e) {

            logger.error(
            "Exception occurred in "
            + "TransactionHistoryTest");

            logger.error(
            e.getMessage());

            // Capture screenshot on failure
            ScreenshotUtils.captureScreenshot(
                    driver,
                    "TransactionHistoryFailure");

            Assert.fail(
                    e.getMessage());
        }
    }
}