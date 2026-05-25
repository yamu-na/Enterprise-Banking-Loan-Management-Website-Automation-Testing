package com.qentelli.GroupFinalAssessment.tests.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qentelli.GroupFinalAssessment.api.UserApi;

import com.qentelli.GroupFinalAssessment.base.BaseApi;

import com.qentelli.GroupFinalAssessment.constants.ApiConstants;

import com.qentelli.GroupFinalAssessment.listeners.TestListener;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

@Listeners(TestListener.class)

public class FetchUserApiTest
        extends BaseApi {

    // Logger
    private static final Logger logger =
            LogManager.getLogger(
                    FetchUserApiTest.class);

    @Test(description =
            "Validate Fetch User API")

    public void fetchUserApiTest() {

        try {

            logger.info(
            "Fetch User API Test Started");

            // Existing User ID
            int userId = 1;

            logger.info(
            "Fetching User ID : "
            + userId);

            // =====================================
            // FETCH USER API
            // =====================================

            Response response =

                    UserApi.getUser(
                            userId);

            logger.info(
            "Fetch User API Executed");

            // =====================================
            // STATUS CODE VALIDATION
            // =====================================

            Assert.assertEquals(

                    response.getStatusCode(),

                    ApiConstants
                    .SUCCESS_STATUS_CODE,

                    "Invalid Status Code");

            logger.info(
            "Status Code Validated");

            // =====================================
            // RESPONSE BODY VALIDATION
            // =====================================

            String responseBody =
                    response.getBody()
                    .asString();

            logger.info(
            "Response Body : "
            + responseBody);

            Assert.assertNotNull(
                    responseBody,

                    "Response body is null");

            Assert.assertFalse(
                    responseBody.isEmpty(),

                    "Response body is empty");

            Assert.assertNotEquals(
                    responseBody,
                    "null",

                    "API returned null response");

            // =====================================
            // SCHEMA VALIDATION
            // =====================================

            response.then()

                    .assertThat()

                    .body(

                    JsonSchemaValidator
                    .matchesJsonSchemaInClasspath(

                    "schemas/userDetailsSchema.json"));

            logger.info(
            "Schema Validation Completed");

            // =====================================
            // RESPONSE TIME VALIDATION
            // =====================================

            Assert.assertTrue(

                    response.getTime()

                    < ApiConstants
                    .RESPONSE_TIME,

                    "Response time exceeded");

            logger.info(
            "Response Time Validated");

            logger.info(
            "Fetch User API Test Passed");

        } catch (Exception e) {

            logger.error(
            "Exception in Fetch User API Test", e);

            Assert.fail(
                    e.getMessage());
        }
    }
}