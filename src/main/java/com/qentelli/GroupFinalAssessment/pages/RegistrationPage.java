package com.qentelli.GroupFinalAssessment.pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
import com.qentelli.GroupFinalAssessment.utils.RandomDataUtils;
import com.qentelli.GroupFinalAssessment.utils.WaitUtils;
 
public class RegistrationPage {
 
    WebDriver driver;
 
    Logger logger =
            LogManager.getLogger(
                    RegistrationPage.class);
 
    public RegistrationPage(WebDriver driver) {
 
        this.driver = driver;
    }
 
    // Locators
 
    By firstName =
            By.id("customer.firstName");
 
    By lastName =
            By.id("customer.lastName");
 
    By address =
            By.id("customer.address.street");
 
    By city =
            By.id("customer.address.city");
 
    By state =
            By.id("customer.address.state");
 
    By zipCode =
            By.id("customer.address.zipCode");
 
    By phoneNumber =
            By.id("customer.phoneNumber");
 
    By ssn =
            By.id("customer.ssn");
 
    By username =
            By.id("customer.username");
 
    By password =
            By.id("customer.password");
 
    By confirmPassword =
            By.id("repeatedPassword");
 
    By registerButton =
            By.xpath(
            "//input[@value='Register']");
 
    By successMessage =
            By.xpath(
            "//h1[contains(text(),'Welcome')]");
 
    By accountCreatedMessage =
            By.xpath(
            "//p[contains(text(),'Your account was created successfully')]");
 
  
    By validationMessage =
            By.xpath(
            "//span[@class='error']");
 
    // Runtime Generated Data
 
    public String generatedUsername;
 
    public String generatedPassword;
 
    // Registration Method
 
    public void registerCustomer(
            String fname,
            String lname,
            String addr,
            String cityName,
            String stateName,
            String zip,
            String mobile,
            String ssnNumber) {
 
        logger.info(
        "Customer Registration Started");
 
        generatedUsername =
                RandomDataUtils
                .generateUsername();
 
        generatedPassword =
                RandomDataUtils
                .generatePassword();
 
        logger.info(
        "Generated Username : "
                + generatedUsername);
 
        logger.info(
        "Password generated successfully");
 
        WaitUtils.waitForElementVisible(
                driver,
                firstName);
 
        driver.findElement(firstName)
                .sendKeys(fname);
 
        driver.findElement(lastName)
                .sendKeys(lname);
 
        driver.findElement(address)
                .sendKeys(addr);
 
        driver.findElement(city)
                .sendKeys(cityName);
 
        driver.findElement(state)
                .sendKeys(stateName);
 
        driver.findElement(zipCode)
                .sendKeys(zip);
 
        driver.findElement(phoneNumber)
                .sendKeys(mobile);
 
        driver.findElement(ssn)
                .sendKeys(ssnNumber);
 
        driver.findElement(username)
                .sendKeys(generatedUsername);
 
        driver.findElement(password)
                .sendKeys(generatedPassword);
 
        driver.findElement(confirmPassword)
                .sendKeys(generatedPassword);
 
        logger.info(
        "Submitting Registration Form");
 
        WaitUtils.waitForElementClickable(
                driver,
                registerButton);
 
        driver.findElement(registerButton)
                .click();
    }
 
    // Validation Methods
 
    public boolean isRegistrationSuccessful() {
 
        logger.info(
        "Validating Registration Success");
 
        WaitUtils.waitForElementVisible(
                driver,
                successMessage);
 
        return driver.findElement(
                successMessage)
                .isDisplayed();
    }
 
    public String getSuccessMessage() {
 
        logger.info(
        "Fetching Success Message");
 
        WaitUtils.waitForElementVisible(
                driver,
                successMessage);
 
        return driver.findElement(
                successMessage)
                .getText();
    }
 
    public boolean isAccountCreatedMessageDisplayed() {
 
        logger.info(
        "Validating Account Creation Message");
 
        WaitUtils.waitForElementVisible(
                driver,
                accountCreatedMessage);
 
        return driver.findElement(
                accountCreatedMessage)
                .isDisplayed();
    }
 
    
 
    public String getCurrentPageUrl() {
 
        logger.info(
        "Fetching Current URL");
 
        return driver.getCurrentUrl();
    }
 
    // Negative Scenario Methods
 
    public void clickRegisterButtonOnly() {
 
        logger.info(
        "Clicking Register Button Without Data");
 
        WaitUtils.waitForElementClickable(
                driver,
                registerButton);
 
        driver.findElement(registerButton)
                .click();
    }
 
    public boolean isValidationMessageDisplayed() {
 
        logger.info(
        "Checking Validation Message");
 
        WaitUtils.waitForElementVisible(
                driver,
                validationMessage);
 
        return driver.findElement(
                validationMessage)
                .isDisplayed();
    }
}