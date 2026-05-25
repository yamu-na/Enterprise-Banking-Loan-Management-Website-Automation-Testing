package com.qentelli.GroupFinalAssessment.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
import com.qentelli.GroupFinalAssessment.utils.WaitUtils;
 
public class HomePage {
 
    WebDriver driver;
 
    Logger logger =
            LogManager.getLogger(
                    HomePage.class);
 
    public HomePage(WebDriver driver) {
 
        this.driver = driver;
    }
 
    By registerLink =
            By.linkText("Register");
 
    By loginLink =
            By.linkText("Log In");
 
    public void clickRegisterLink() {
 
        logger.info(
        "Clicking Register Link");
 
        WaitUtils.waitForElementClickable(
                driver,
                registerLink);
 
        driver.findElement(registerLink)
                .click();
    }
 
    public void clickLoginLink() {
 
        logger.info(
        "Clicking Login Link");
 
        WaitUtils.waitForElementClickable(
                driver,
                loginLink);
 
        driver.findElement(loginLink)
                .click();
    }
}