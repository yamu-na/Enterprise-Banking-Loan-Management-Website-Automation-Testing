package com.qentelli.GroupFinalAssessment.tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qentelli.GroupFinalAssessment.base.BaseTest;

import com.qentelli.GroupFinalAssessment.pages.LoginPage;
import com.qentelli.GroupFinalAssessment.pages.OpenAccountPage;

import com.qentelli.GroupFinalAssessment.utils.ExcelReader;

public class OpenAccountTest
        extends BaseTest {

    @Test(description =
            "Validate account creation")

    public void verifyOpenAccountTest() {

        try {

            logger.info(
            "Open Account Test Started");

            // Read login data
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

            // Login first
            LoginPage loginPage =
                    new LoginPage(driver);

            loginPage.loginToApplication(
                    username,
                    password);

            // Validate login
            Assert.assertTrue(
                    loginPage.isLogoutDisplayed(),

                    "Login failed");

            logger.info(
            "Login successful");

            // Open account
            OpenAccountPage openAccountPage =
                    new OpenAccountPage(driver);

            String accountNumber =
                    openAccountPage
                    .createNewAccount(
                            "SAVINGS");

            // Validation
            Assert.assertTrue(
                    openAccountPage
                    .isAccountCreatedSuccessfully(),

                    "Account creation failed");

            Assert.assertFalse(
                    accountNumber.isEmpty(),

                    "Account number not generated");

            logger.info(
            "Generated Account Number : "
                    + accountNumber);

        } catch (Exception e) {

            logger.error(
            "Exception in Open Account Test");

            Assert.fail(e.getMessage());
        }
    }
}