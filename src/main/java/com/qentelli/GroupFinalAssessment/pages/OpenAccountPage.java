package com.qentelli.GroupFinalAssessment.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qentelli.GroupFinalAssessment.utils.WaitUtils;

public class OpenAccountPage {

    WebDriver driver;

    // Locators
    private By openNewAccountLink =
            By.linkText("Open New Account");

    private By accountTypeDropdown =
            By.id("type");

    private By existingAccountDropdown =
            By.id("fromAccountId");

    private By openAccountButton =
            By.xpath(
            "//input[@value='Open New Account']");

    private By successMessage =
            By.xpath(
            "//p[contains(text(),'Congratulations')]");

    private By generatedAccountNumber =
            By.id("newAccountId");

    // Constructor
    public OpenAccountPage(WebDriver driver) {

        this.driver = driver;
    }

    // Navigate to open account page
    public void clickOpenNewAccountLink() {

        WaitUtils.waitForElementClickable(
                driver,
                openNewAccountLink);

        driver.findElement(
                openNewAccountLink)
                .click();
    }

    // Select account type
    public void selectAccountType(
            String accountType) {

        WaitUtils.waitForElementVisible(
                driver,
                accountTypeDropdown);

        Select select =
                new Select(
                driver.findElement(
                        accountTypeDropdown));

        select.selectByVisibleText(
                accountType);
    }

    // Wait and select existing account
    public void selectExistingAccount() {

        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(20));

        // Wait until dropdown gets options
        wait.until(
                (ExpectedCondition<Boolean>) wd -> {

            Select dropdown =
                    new Select(
                    driver.findElement(
                            existingAccountDropdown));

            return dropdown.getOptions()
                    .size() > 0;
        });

        Select select =
                new Select(
                driver.findElement(
                        existingAccountDropdown));

        List<WebElement> options =
                select.getOptions();

        if (options.isEmpty()) {

            throw new RuntimeException(
            "No accounts available "
            + "for account creation");
        }

        // Select first available account
        String accountValue =
                options.get(0).getText();

        select.selectByVisibleText(
                accountValue);
    }

    // Click open account button
    public void clickOpenAccountButton() {

        WaitUtils.waitForElementClickable(
                driver,
                openAccountButton);

        driver.findElement(
                openAccountButton)
                .click();
    }

    // Complete account creation flow
    public String createNewAccount(
            String accountType) {

        clickOpenNewAccountLink();

        selectAccountType(
                accountType);

        selectExistingAccount();

        clickOpenAccountButton();

        WaitUtils.waitForElementVisible(
                driver,
                generatedAccountNumber);

        return driver.findElement(
                generatedAccountNumber)
                .getText();
    }

    // Validate account creation
    public boolean isAccountCreatedSuccessfully() {

        try {

            WaitUtils.waitForElementVisible(
                    driver,
                    successMessage);

            return driver.findElement(
                    successMessage)
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }
}