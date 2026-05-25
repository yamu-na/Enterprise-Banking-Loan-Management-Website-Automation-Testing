package com.qentelli.GroupFinalAssessment.tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qentelli.GroupFinalAssessment.base.BaseTest;
import com.qentelli.GroupFinalAssessment.pages.LoginPage;

import com.qentelli.GroupFinalAssessment.utils.ExcelReader;

public class LoginTest extends BaseTest {

    @Test(description =
            "Validate login functionality")

    public void verifyLoginTest() {

        try {

            logger.info(
            "Login Test Started");

            // Read username from Excel
            String username =
                    ExcelReader.getCellData(
                    "src/main/resources/testdata/loginData.xlsx",
                    "LoginData",
                    1,
                    0);

            // Read password from Excel
            String password =
                    ExcelReader.getCellData(
                    "src/main/resources/testdata/loginData.xlsx",
                    "LoginData",
                    1,
                    1);

            // Read expected result
            String expectedResult =
                    ExcelReader.getCellData(
                    "src/main/resources/testdata/loginData.xlsx",
                    "LoginData",
                    1,
                    2);

            logger.info(
            "Username : " + username);

            // Login
            LoginPage loginPage =
                    new LoginPage(driver);

            loginPage.loginToApplication(
                    username,
                    password);

            // Positive validation
            if (expectedResult.equalsIgnoreCase(
                    "success")) {

                Assert.assertTrue(
                        loginPage
                        .isLogoutDisplayed(),

                        "Login failed");

                logger.info(
                "Login successful");

            }

            // Negative validation
            else {

                Assert.assertFalse(
                        loginPage
                        .isLogoutDisplayed(),

                        "Invalid login accepted");

                logger.info(
                "Negative login validated");
            }

        } catch (Exception e) {

            logger.error(
            "Exception in Login Test");

            Assert.fail(e.getMessage());
        }
    }
}