package com.qentelli.GroupFinalAssessment.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import com.qentelli.GroupFinalAssessment.base.BaseTest;

import com.qentelli.GroupFinalAssessment.reports.ExtentManager;
import com.qentelli.GroupFinalAssessment.reports.ExtentTestManager;

import com.qentelli.GroupFinalAssessment.utils.ScreenshotUtils;

public class TestListener
        extends BaseTest
        implements ITestListener {

    @Override
    public void onStart(
            ITestContext context) {

        ExtentManager.getInstance();
    }

    @Override
    public void onTestStart(
            ITestResult result) {

        ExtentTestManager.setTest(

                ExtentManager.getInstance()
                .createTest(
                        result.getMethod()
                        .getMethodName()));
    }

    @Override
    public void onTestSuccess(
            ITestResult result) {

        ExtentTestManager.getTest()
        .log(Status.PASS,
                "Test Passed");
    }

    @Override
    public void onTestFailure(
            ITestResult result) {

        ExtentTestManager.getTest()
        .log(Status.FAIL,
                result.getThrowable());

        String screenshotPath =
                ScreenshotUtils
                .captureScreenshot(
                        driver,
                        result.getMethod()
                        .getMethodName());

        try {

            ExtentTestManager.getTest()
            .addScreenCaptureFromPath(
                    screenshotPath);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(
            ITestContext context) {

        ExtentManager.getInstance()
        .flush();
    }
}