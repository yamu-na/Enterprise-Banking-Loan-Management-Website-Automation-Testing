package com.qentelli.GroupFinalAssessment.tests.api;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qentelli.GroupFinalAssessment.api.AuthApi;

import com.qentelli.GroupFinalAssessment.base.BaseApi;

import com.qentelli.GroupFinalAssessment.constants.ApiConstants;

import com.qentelli.GroupFinalAssessment.listeners.TestListener;

import com.qentelli.GroupFinalAssessment.utils.ExcelReader;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

@Listeners(TestListener.class)

public class AuthApiTest
        extends BaseApi {

    @Test(description =
            "Validate Login API")

    public void loginApiTest() {

        String username =

                ExcelReader.getCellData(
                "src/main/resources/testdata/apiData.xlsx",
                "ApiData",
                1,
                0);

        String password =

                ExcelReader.getCellData(
                "src/main/resources/testdata/apiData.xlsx",
                "ApiData",
                1,
                1);

        Response response =

                AuthApi.login(
                username,
                password);

        Assert.assertEquals(
                response.getStatusCode(),
                ApiConstants.CREATED_STATUS_CODE);

        String token =

                response.jsonPath()
                .getString("token");

        Assert.assertNotNull(token);

        Assert.assertTrue(

                response.getTime()

                < ApiConstants
                .RESPONSE_TIME);

        response.then()

                .assertThat()

                .body(

                JsonSchemaValidator
                .matchesJsonSchemaInClasspath(

                "schemas/loginSchema.json"));
    }
}