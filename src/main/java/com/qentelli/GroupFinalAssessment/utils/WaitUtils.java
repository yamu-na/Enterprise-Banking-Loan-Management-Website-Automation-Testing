package com.qentelli.GroupFinalAssessment.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    // Wait for element visibility
    public static WebElement
    waitForElementVisible(
            WebDriver driver,
            By locator) {

        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(20));

        return wait.until(
                ExpectedConditions
                .visibilityOfElementLocated(
                        locator));
    }

    // Wait for element clickable
    public static WebElement
    waitForElementClickable(
            WebDriver driver,
            By locator) {

        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(20));

        return wait.until(
                ExpectedConditions
                .elementToBeClickable(
                        locator));
    }
}