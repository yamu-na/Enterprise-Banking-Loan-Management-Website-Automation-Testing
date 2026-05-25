package com.qentelli.GroupFinalAssessment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qentelli.GroupFinalAssessment.utils.WaitUtils;

public class LoginPage {

    WebDriver driver;

    // Locators
    private By usernameField =
            By.name("username");

    private By passwordField =
            By.name("password");

    private By loginButton =
            By.xpath("//input[@value='Log In']");

    private By logoutLink =
            By.linkText("Log Out");

    private By errorMessage =
            By.xpath("//p[@class='error']");

    // Constructor
    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    // Enter username
    public void enterUsername(String username) {

        WaitUtils.waitForElementVisible(
                driver,
                usernameField);

        driver.findElement(usernameField)
                .clear();

        driver.findElement(usernameField)
                .sendKeys(username);
    }

    // Enter password
    public void enterPassword(String password) {

        WaitUtils.waitForElementVisible(
                driver,
                passwordField);

        driver.findElement(passwordField)
                .clear();

        driver.findElement(passwordField)
                .sendKeys(password);
    }

    // Click login button
    public void clickLoginButton() {

        WaitUtils.waitForElementClickable(
                driver,
                loginButton);

        driver.findElement(loginButton)
                .click();
    }

    // Complete login flow
    public void loginToApplication(
            String username,
            String password) {

        enterUsername(username);

        enterPassword(password);

        clickLoginButton();
    }

    // Validate successful login
    public boolean isLogoutDisplayed() {

        try {

            WaitUtils.waitForElementVisible(
                    driver,
                    logoutLink);

            return driver.findElement(logoutLink)
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    // Capture login error message
    public String getLoginErrorMessage() {

        try {

            WaitUtils.waitForElementVisible(
                    driver,
                    errorMessage);

            return driver.findElement(errorMessage)
                    .getText();

        } catch (Exception e) {

            return "Login error message not displayed";
        }
    }
}