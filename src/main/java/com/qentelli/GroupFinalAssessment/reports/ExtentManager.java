package com.qentelli.GroupFinalAssessment.reports;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            // Report path
            ExtentSparkReporter reporter =
                    new ExtentSparkReporter(
                    "reports/ExtentReport.html");

            // Report configuration
            reporter.config().setReportName(
                    "Banking Automation Framework Report");

            reporter.config().setDocumentTitle(
                    "Qentelli Final Assessment");

            reporter.config().setTimeStampFormat(
                    "yyyy-MM-dd HH:mm:ss");

            // Create extent report
            extent = new ExtentReports();

            extent.attachReporter(reporter);

            // System info
            extent.setSystemInfo(
                    "Framework",
                    "Selenium + TestNG");

            extent.setSystemInfo(
                    "Environment",
                    "QA");

            extent.setSystemInfo(
                    "Tester",
                    "Qentelli Team");
        }

        return extent;
    }
}