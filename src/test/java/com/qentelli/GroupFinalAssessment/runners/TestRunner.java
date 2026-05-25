package com.qentelli.GroupFinalAssessment.runners;

import org.testng.TestNG;

public class TestRunner {

    public static void main(
            String[] args) {

        TestNG testng =
                new TestNG();

        testng.setTestSuites(

                java.util.List.of(
                "testng.xml"));

        testng.run();
    }
}