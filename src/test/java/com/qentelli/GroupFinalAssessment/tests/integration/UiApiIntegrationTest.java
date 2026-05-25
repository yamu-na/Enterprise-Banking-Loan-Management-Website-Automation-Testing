package com.qentelli.GroupFinalAssessment.tests.integration;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qentelli.GroupFinalAssessment.api.PayloadManager;
import com.qentelli.GroupFinalAssessment.api.UserApi;

import com.qentelli.GroupFinalAssessment.base.BaseApi;
import com.qentelli.GroupFinalAssessment.base.BaseTest;

import com.qentelli.GroupFinalAssessment.listeners.TestListener;

import com.qentelli.GroupFinalAssessment.pages.LoginPage;

import com.qentelli.GroupFinalAssessment.utils.ExcelReader;

import io.restassured.response.Response;

@Listeners(TestListener.class)

public class UiApiIntegrationTest
        extends BaseTest {

    @Test(description =
            "Validate UI and API Integration")

    public void uiApiIntegrationTest() {

        try {

            logger.info(
            "UI API Integration Test Started");

            // =====================================
            // API SETUP
            // =====================================

            BaseApi.setup();

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
            // UI LOGIN
            // =====================================

            LoginPage loginPage =
                    new LoginPage(driver);

            loginPage.loginToApplication(
                    username,
                    password);

            Assert.assertTrue(
                    loginPage
                    .isLogoutDisplayed(),

                    "UI Login Failed");

            logger.info(
            "UI Login Successful");

            // =====================================
            // READ API DATA
            // =====================================

            String firstname =

                    ExcelReader.getCellData(
                    "src/main/resources/testdata/apiData.xlsx",
                    "ApiData",
                    1,
                    2);

            String lastname =

                    ExcelReader.getCellData(
                    "src/main/resources/testdata/apiData.xlsx",
                    "ApiData",
                    1,
                    3);

            String email =

                    ExcelReader.getCellData(
                    "src/main/resources/testdata/apiData.xlsx",
                    "ApiData",
                    1,
                    4);

            // =====================================
            // CREATE PAYLOAD
            // =====================================

            String payload =

                    PayloadManager
                    .createUserPayload(
                            firstname,
                            lastname,
                            email);

            // =====================================
            // CREATE USER API
            // =====================================

            Response response =

                    UserApi.createUser(
                            payload);

            // =====================================
            // VALIDATIONS
            // =====================================

            Assert.assertEquals(

                    response.getStatusCode(),

                    201,

                    "User creation failed");

            int userId =

                    response.jsonPath()
                    .getInt("id");

            logger.info(
            "Generated User ID : "
            + userId);

            Assert.assertTrue(
                    userId > 0,

                    "Invalid User ID");

            logger.info(
            "UI API Integration Test Passed");

        } catch (Exception e) {

            logger.error(
            "Exception in Integration Test", e);

            Assert.fail(
                    e.getMessage());
        }
    }
}