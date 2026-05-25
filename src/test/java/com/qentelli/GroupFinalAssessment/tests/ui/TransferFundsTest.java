package com.qentelli.GroupFinalAssessment.tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qentelli.GroupFinalAssessment.base.BaseTest;

import com.qentelli.GroupFinalAssessment.pages.LoginPage;
import com.qentelli.GroupFinalAssessment.pages.OpenAccountPage;
import com.qentelli.GroupFinalAssessment.pages.TransferFundsPage;

import com.qentelli.GroupFinalAssessment.utils.ExcelReader;

public class TransferFundsTest
        extends BaseTest {

    @Test(description =
            "Validate successful transfer")

    public void verifyTransferFundsTest() {

        try {

            logger.info(
            "Transfer Funds Test Started");

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
            "Username : " + username);

            // =====================================
            // LOGIN TO APPLICATION
            // =====================================

            LoginPage loginPage =
                    new LoginPage(driver);

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
            "Login successful");

            // =====================================
            // CREATE ACCOUNTS DYNAMICALLY
            // =====================================

            OpenAccountPage openAccountPage =
                    new OpenAccountPage(driver);

            String fromAccount =
                    openAccountPage
                    .createNewAccount(
                            "SAVINGS");

            logger.info(
            "From Account Created : "
                    + fromAccount);

            String toAccount =
                    openAccountPage
                    .createNewAccount(
                            "CHECKING");

            logger.info(
            "To Account Created : "
                    + toAccount);

            // =====================================
            // VALIDATE ACCOUNT CREATION
            // =====================================

            Assert.assertFalse(
                    fromAccount.isEmpty(),

                    "From account not created");

            Assert.assertFalse(
                    toAccount.isEmpty(),

                    "To account not created");

            // =====================================
            // READ TRANSFER DATA FROM EXCEL
            // =====================================

            String amount =
                    ExcelReader.getCellData(
                    "src/main/resources/testdata/transferData.xlsx",
                    "TransferData",
                    1,
                    2);

            String description =
                    ExcelReader.getCellData(
                    "src/main/resources/testdata/transferData.xlsx",
                    "TransferData",
                    1,
                    3);

            String expectedResult =
                    ExcelReader.getCellData(
                    "src/main/resources/testdata/transferData.xlsx",
                    "TransferData",
                    1,
                    4);

            logger.info(
            "Transfer Amount : "
                    + amount);

            logger.info(
            "Transfer Description : "
                    + description);

            logger.info(
            "Expected Result : "
                    + expectedResult);

            // =====================================
            // TRANSFER FUNDS
            // =====================================

            TransferFundsPage transferPage =
                    new TransferFundsPage(driver);

            transferPage.transferFunds(
                    amount,
                    fromAccount,
                    toAccount);

            // =====================================
            // VALIDATION
            // =====================================

            if (expectedResult.equalsIgnoreCase(
                    "success")) {

                Assert.assertTrue(
                        transferPage
                        .isTransferSuccessful(),

                        "Transfer failed");

                logger.info(
                "Transfer completed successfully");

            } else {

                Assert.assertFalse(
                        transferPage
                        .isTransferSuccessful(),

                        "Invalid transfer accepted");

                logger.info(
                "Negative transfer validated");
            }

        } catch (Exception e) {

            logger.error(
            "Exception in Transfer Funds Test");

            logger.error(
            e.getMessage());

            Assert.fail(
                    e.getMessage());
        }
    }
}