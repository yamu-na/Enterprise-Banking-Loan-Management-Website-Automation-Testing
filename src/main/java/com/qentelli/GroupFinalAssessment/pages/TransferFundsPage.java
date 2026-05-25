//package com.qentelli.GroupFinalAssessment.pages;
//
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.qentelli.GroupFinalAssessment.utils.WaitUtils;
//
//public class TransferFundsPage {
//
//    WebDriver driver;
//
//    // Locators
//    private By transferFundsLink =
//            By.linkText("Transfer Funds");
//
//    private By amountField =
//            By.id("amount");
//
//    private By fromAccountDropdown =
//            By.id("fromAccountId");
//
//    private By toAccountDropdown =
//            By.id("toAccountId");
//
//    private By transferButton =
//            By.xpath("//input[@value='Transfer']");
//
//    private By successMessage =
//            By.xpath(
//            "//h1[contains(text(),'Transfer Complete')]");
//
//    // Constructor
//    public TransferFundsPage(WebDriver driver) {
//
//        this.driver = driver;
//    }
//
//    // Open transfer page
//    public void clickTransferFundsLink() {
//
//        WaitUtils.waitForElementClickable(
//                driver,
//                transferFundsLink);
//
//        driver.findElement(
//                transferFundsLink)
//                .click();
//    }
//
//    // Enter transfer amount
//    public void enterTransferAmount(
//            String amount) {
//
//        WaitUtils.waitForElementVisible(
//                driver,
//                amountField);
//
//        driver.findElement(
//                amountField)
//                .clear();
//
//        driver.findElement(
//                amountField)
//                .sendKeys(amount);
//    }
//
//    // Select from account dynamically
//    public void selectFromAccount(
//            String fromAccount) {
//
//        waitForDropdownOptions(
//                fromAccountDropdown);
//
//        Select select =
//                new Select(
//                driver.findElement(
//                        fromAccountDropdown));
//
//        boolean accountFound = false;
//
//        List<WebElement> options =
//                select.getOptions();
//
//        for (WebElement option : options) {
//
//            if (option.getText()
//                    .trim()
//                    .equals(fromAccount)) {
//
//                select.selectByVisibleText(
//                        fromAccount);
//
//                accountFound = true;
//
//                break;
//            }
//        }
//
//        if (!accountFound) {
//
//            throw new RuntimeException(
//            "From account not found : "
//            + fromAccount);
//        }
//    }
//
//    // Select to account dynamically
//    public void selectToAccount(
//            String toAccount) {
//
//        waitForDropdownOptions(
//                toAccountDropdown);
//
//        Select select =
//                new Select(
//                driver.findElement(
//                        toAccountDropdown));
//
//        boolean accountFound = false;
//
//        List<WebElement> options =
//                select.getOptions();
//
//        for (WebElement option : options) {
//
//            if (option.getText()
//                    .trim()
//                    .equals(toAccount)) {
//
//                select.selectByVisibleText(
//                        toAccount);
//
//                accountFound = true;
//
//                break;
//            }
//        }
//
//        if (!accountFound) {
//
//            throw new RuntimeException(
//            "To account not found : "
//            + toAccount);
//        }
//    }
//
//    // Wait for dropdown options
//    public void waitForDropdownOptions(
//            By dropdownLocator) {
//
//        WebDriverWait wait =
//                new WebDriverWait(
//                        driver,
//                        Duration.ofSeconds(20));
//
//        wait.until(
//                (ExpectedCondition<Boolean>) wd -> {
//
//            Select dropdown =
//                    new Select(
//                    driver.findElement(
//                            dropdownLocator));
//
//            return dropdown.getOptions()
//                    .size() > 0;
//        });
//    }
//
//    // Click transfer button
//    public void clickTransferButton() {
//
//        WaitUtils.waitForElementClickable(
//                driver,
//                transferButton);
//
//        driver.findElement(
//                transferButton)
//                .click();
//    }
//
//    // Complete transfer workflow
//    public void transferFunds(
//            String amount,
//            String fromAccount,
//            String toAccount) {
//
//        clickTransferFundsLink();
//
//        enterTransferAmount(
//                amount);
//
//        selectFromAccount(
//                fromAccount);
//
//        selectToAccount(
//                toAccount);
//
//        clickTransferButton();
//    }
//
//    // Validate transfer success
//    public boolean isTransferSuccessful() {
//
//        try {
//
//            WaitUtils.waitForElementVisible(
//                    driver,
//                    successMessage);
//
//            return driver.findElement(
//                    successMessage)
//                    .isDisplayed();
//
//        } catch (Exception e) {
//
//            return false;
//        }
//    }
//}
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

public class TransferFundsPage {

    WebDriver driver;

    // Locators
    private By transferFundsLink =
            By.linkText("Transfer Funds");

    private By amountField =
            By.id("amount");

    private By fromAccountDropdown =
            By.id("fromAccountId");

    private By toAccountDropdown =
            By.id("toAccountId");

    private By transferButton =
            By.xpath("//input[@value='Transfer']");

    private By successMessage =
            By.xpath(
            "//h1[contains(text(),'Transfer Complete')]");

    private By errorMessage =
            By.xpath(
            "//*[contains(text(),'error') "
            + "or contains(text(),'Invalid') "
            + "or contains(text(),'negative')]");

    // Constructor
    public TransferFundsPage(WebDriver driver) {

        this.driver = driver;
    }

    // Open transfer page
    public void clickTransferFundsLink() {

        WaitUtils.waitForElementClickable(
                driver,
                transferFundsLink);

        driver.findElement(
                transferFundsLink)
                .click();
    }

    // Enter amount
    public void enterTransferAmount(
            String amount) {

        WaitUtils.waitForElementVisible(
                driver,
                amountField);

        driver.findElement(
                amountField)
                .clear();

        driver.findElement(
                amountField)
                .sendKeys(amount);
    }

    // Select from account
    public void selectFromAccount(
            String fromAccount) {

        waitForDropdownOptions(
                fromAccountDropdown);

        Select select =
                new Select(
                driver.findElement(
                        fromAccountDropdown));

        List<WebElement> options =
                select.getOptions();

        boolean found = false;

        for (WebElement option : options) {

            if (option.getText()
                    .trim()
                    .equals(fromAccount)) {

                select.selectByVisibleText(
                        fromAccount);

                found = true;

                break;
            }
        }

        if (!found) {

            throw new RuntimeException(
            "From account not found");
        }
    }

    // Select to account
    public void selectToAccount(
            String toAccount) {

        waitForDropdownOptions(
                toAccountDropdown);

        Select select =
                new Select(
                driver.findElement(
                        toAccountDropdown));

        List<WebElement> options =
                select.getOptions();

        boolean found = false;

        for (WebElement option : options) {

            if (option.getText()
                    .trim()
                    .equals(toAccount)) {

                select.selectByVisibleText(
                        toAccount);

                found = true;

                break;
            }
        }

        if (!found) {

            throw new RuntimeException(
            "To account not found");
        }
    }

    // Wait for dropdown options
    public void waitForDropdownOptions(
            By dropdownLocator) {

        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(20));

        wait.until(
                (ExpectedCondition<Boolean>) wd -> {

            Select dropdown =
                    new Select(
                    driver.findElement(
                            dropdownLocator));

            return dropdown.getOptions()
                    .size() > 0;
        });
    }

    // Click transfer button
    public void clickTransferButton() {

        WaitUtils.waitForElementClickable(
                driver,
                transferButton);

        driver.findElement(
                transferButton)
                .click();
    }

    // Transfer workflow
    public void transferFunds(
            String amount,
            String fromAccount,
            String toAccount) {

        clickTransferFundsLink();

        enterTransferAmount(
                amount);

        selectFromAccount(
                fromAccount);

        selectToAccount(
                toAccount);

        clickTransferButton();
    }

    // Positive validation
    public boolean isTransferSuccessful() {

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

    // Negative validation
    public boolean isTransferFailed() {

        try {

            return driver.findElement(
                    errorMessage)
                    .isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }
}