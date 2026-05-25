package com.qentelli.GroupFinalAssessment.utils;

import java.io.File;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    // Capture screenshot
    public static String captureScreenshot(
            WebDriver driver,
            String testName) {

        try {

            String timestamp =
                    LocalDateTime.now()
                    .format(
                    DateTimeFormatter
                    .ofPattern(
                    "yyyyMMdd_HHmmss"));

            File source =
                    ((TakesScreenshot) driver)
                    .getScreenshotAs(
                            OutputType.FILE);

            String destination =
                    "screenshots/"
                    + testName
                    + "_"
                    + timestamp
                    + ".png";

            FileUtils.copyFile(
                    source,
                    new File(destination));

            return destination;

        } catch (Exception e) {

            return "Screenshot capture failed";
        }
    }
}