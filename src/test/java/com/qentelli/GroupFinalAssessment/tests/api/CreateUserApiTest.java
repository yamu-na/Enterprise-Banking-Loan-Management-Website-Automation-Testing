package com.qentelli.GroupFinalAssessment.tests.api;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qentelli.GroupFinalAssessment.api.PayloadManager;
import com.qentelli.GroupFinalAssessment.api.UserApi;

import com.qentelli.GroupFinalAssessment.base.BaseApi;

import com.qentelli.GroupFinalAssessment.constants.ApiConstants;

import com.qentelli.GroupFinalAssessment.listeners.TestListener;

import com.qentelli.GroupFinalAssessment.models.UserData;

import com.qentelli.GroupFinalAssessment.utils.ExcelReader;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

@Listeners(TestListener.class)

public class CreateUserApiTest
        extends BaseApi {

    @Test(description =
            "Validate Create User API")

    public void createUserApiTest() {

        // Read Excel Data
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

        // Dynamic Payload
        String payload =

                PayloadManager
                .createUserPayload(
                        firstname,
                        lastname,
                        email);

        // Create User API
        Response response =

                UserApi.createUser(
                        payload);

        // Status Code Validation
        Assert.assertEquals(

                response.getStatusCode(),

                ApiConstants
                .CREATED_STATUS_CODE);

        // Store Runtime User ID
        int userId =

                response.jsonPath()
                .getInt("id");

        UserData.setUserId(userId);

        System.out.println(
        "Generated User ID : "
        + userId);

        // Schema Validation
        response.then()

                .assertThat()

                .body(

                JsonSchemaValidator
                .matchesJsonSchemaInClasspath(

                "schemas/createUserSchema.json"));

        // Response Time Validation
        Assert.assertTrue(

                response.getTime()

                < ApiConstants
                .RESPONSE_TIME);
    }
}