package com.qentelli.GroupFinalAssessment.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiClient {

    private static final Logger logger =
            LogManager.getLogger(
                    ApiClient.class);

    // POST METHOD
    public static Response post(
            String endpoint,
            String payload) {

        logger.info(
        "POST API Request Started");

        Response response =

                given()

                .header(
                "Content-Type",
                "application/json")

                .body(payload)

                .log().all()

                .when()

                .post(endpoint)

                .then()

                .log().all()

                .extract()

                .response();

        return response;
    }

    // GET METHOD
    public static Response get(
            String endpoint) {

        logger.info(
        "GET API Request Started");

        Response response =

                given()

                .header(
                "Content-Type",
                "application/json")

                .log().all()

                .when()

                .get(endpoint)

                .then()

                .log().all()

                .extract()

                .response();

        return response;
    }
}