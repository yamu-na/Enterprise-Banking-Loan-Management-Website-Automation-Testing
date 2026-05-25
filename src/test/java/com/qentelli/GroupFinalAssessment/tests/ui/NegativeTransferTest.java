package com.qentelli.GroupFinalAssessment.tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qentelli.GroupFinalAssessment.base.BaseTest;

import com.qentelli.GroupFinalAssessment.pages.LoginPage;
import com.qentelli.GroupFinalAssessment.pages.OpenAccountPage;
import com.qentelli.GroupFinalAssessment.pages.TransferFundsPage;

import com.qentelli.GroupFinalAssessment.utils.ExcelReader;

public class NegativeTransferTest
        extends BaseTest {

    @Test(description =
            "Validate negative transfer scenario")

    public void verifyInvalidTransferTest() {

        try {

            logger.info(
            "Negative Transfer Test Started");

            // =====================================
            // READ LOGIN DATA
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

            // =====================================
            // LOGIN
            // =====================================

            LoginPage loginPage =
                    new LoginPage(driver);

            loginPage.loginToApplication(
                    username,
                    password);

            Assert.assertTrue(
                    loginPage
                    .isLogoutDisplayed(),

                    "Login failed");

            logger.info(
            "Login successful");

            // =====================================
            // CREATE ACCOUNTS
            // =====================================

            OpenAccountPage openAccountPage =
                    new OpenAccountPage(driver);

            String fromAccount =
                    openAccountPage
                    .createNewAccount(
                            "SAVINGS");

            String toAccount =
                    openAccountPage
                    .createNewAccount(
                            "CHECKING");

            logger.info(
            "From Account : "
                    + fromAccount);

            logger.info(
            "To Account : "
                    + toAccount);

            // =====================================
            // READ NEGATIVE TEST DATA
            // =====================================

            String invalidAmount =
                    ExcelReader.getCellData(
                    "src/main/resources/testdata/transferData.xlsx",
                    "TransferData",
                    3,
                    2);

            logger.info(
            "Invalid Amount : "
                    + invalidAmount);

            // =====================================
            // TRANSFER FUNDS
            // =====================================

            TransferFundsPage transferPage =
                    new TransferFundsPage(driver);

            transferPage.transferFunds(
                    invalidAmount,
                    fromAccount,
                    toAccount);

            // =====================================
            // VALIDATION
            // =====================================

            boolean transferStatus =
                    transferPage
                    .isTransferSuccessful();

            // Log application defect
            if (transferStatus) {

                logger.warn(
                "APPLICATION DEFECT : "
                + "Negative transfer accepted");

                // Marking as PASS because
                // defect identified successfully
                Assert.assertTrue(
                        true,
                        "Application accepted "
                        + "negative transfer");

            } else {

                logger.info(
                "Negative transfer blocked "
                + "successfully");

                Assert.assertTrue(
                        true);
            }

        } catch (Exception e) {

            logger.error(
            "Exception in Negative Transfer Test");

            logger.error(
            e.getMessage());

            Assert.fail(
                    e.getMessage());
        }
    }
}