package com.qentelli.GroupFinalAssessment.utils;

import org.testng.Assert;

public class AssertionUtils {

    // Validate true condition
    public static void verifyTrue(
            boolean condition,
            String message) {

        Assert.assertTrue(
                condition,
                message);
    }

    // Validate equals
    public static void verifyEquals(
            String actual,
            String expected,
            String message) {

        Assert.assertEquals(
                actual,
                expected,
                message);
    }
}