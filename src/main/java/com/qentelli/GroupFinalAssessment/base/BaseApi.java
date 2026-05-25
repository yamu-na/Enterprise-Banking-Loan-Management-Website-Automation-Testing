package com.qentelli.GroupFinalAssessment.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.BeforeClass;

import com.qentelli.GroupFinalAssessment.utils.ConfigReader;

import io.restassured.RestAssured;

public class BaseApi {

    // Static Logger
    protected static Logger logger =

            LogManager.getLogger(
                    BaseApi.class);

    @BeforeClass

    public static void setup() {

        try {

            logger.info(
            "API setup started");

            RestAssured.baseURI =

                    ConfigReader.getProperty(
                            "apiBaseUrl");

            logger.info(
            "Base URI Configured : "
            + RestAssured.baseURI);

        } catch (Exception e) {

            logger.error(
            "API Setup Failed", e);

            throw new RuntimeException(e);
        }
    }
}