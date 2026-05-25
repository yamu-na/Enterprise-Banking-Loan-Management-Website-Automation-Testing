package com.qentelli.GroupFinalAssessment.tests.ui;

import com.qentelli.GroupFinalAssessment.utils.ScreenshotUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
 
import com.qentelli.GroupFinalAssessment.base.BaseTest;
 
import com.qentelli.GroupFinalAssessment.pages.HomePage;
import com.qentelli.GroupFinalAssessment.pages.RegistrationPage;
 
import com.qentelli.GroupFinalAssessment.utils.ConfigReader;
import com.qentelli.GroupFinalAssessment.utils.ExcelReader;
 
public class RegistrationTest extends BaseTest {
 
    @Test
 
    public void verifyCustomerRegistration() {
 
        logger.info(
        "Registration Test Started");
 
        // Excel Path From Config
 
        String excelPath =
                ConfigReader.getProperty(
                        "excelPath");
 
        // Reading Data From Excel
 
        String firstName =
                ExcelReader.getCellData(
                        excelPath,
                        "CustomerData",
                        1,
                        0);
 
        String lastName =
                ExcelReader.getCellData(
                        excelPath,
                        "CustomerData",
                        1,
                        1);
 
        String address =
                ExcelReader.getCellData(
                        excelPath,
                        "CustomerData",
                        1,
                        2);
 
        String city =
                ExcelReader.getCellData(
                        excelPath,
                        "CustomerData",
                        1,
                        3);
 
        String state =
                ExcelReader.getCellData(
                        excelPath,
                        "CustomerData",
                        1,
                        4);
 
        String zip =
                ExcelReader.getCellData(
                        excelPath,
                        "CustomerData",
                        1,
                        5);
 
        String phone =
                ExcelReader.getCellData(
                        excelPath,
                        "CustomerData",
                        1,
                        6);
 
        String ssn =
                ExcelReader.getCellData(
                        excelPath,
                        "CustomerData",
                        1,
                        7);
 
        // Home Page
 
        HomePage homePage =
                new HomePage(driver);
 
        homePage.clickRegisterLink();
 
        // Registration Page
 
        RegistrationPage registrationPage =
                new RegistrationPage(driver);
 
        registrationPage.registerCustomer(
                firstName,
                lastName,
                address,
                city,
                state,
                zip,
                phone,
                ssn);
 
        // Validations
 
        Assert.assertTrue(
                registrationPage
                .isRegistrationSuccessful(),
 
                "Registration Failed");
 
        Assert.assertTrue(
                registrationPage
                .getSuccessMessage()
                .contains("Welcome"),
 
                "Welcome Message Not Displayed");
 
        Assert.assertTrue(
                registrationPage
                .isAccountCreatedMessageDisplayed(),
 
                "Account Creation Message Missing");
 
      
 
        Assert.assertEquals(
 
                registrationPage
                .getCurrentPageUrl(),
 
                "https://parabank.parasoft.com/parabank/register.htm",
 
                "URL Validation Failed");
 
        logger.info(
        "Generated Username : "
                + registrationPage.generatedUsername);
 
        logger.info(
        "Registration Test Completed");
    }
 
    @Test
 
    public void verifyRegistrationWithoutMandatoryFields() {
 
        logger.info(
        "Negative Registration Test Started");
 
        HomePage homePage =
                new HomePage(driver);
 
        homePage.clickRegisterLink();
 
        RegistrationPage registrationPage =
                new RegistrationPage(driver);
 
        registrationPage.clickRegisterButtonOnly();
 
        Assert.assertTrue(
 
                registrationPage
                .isValidationMessageDisplayed(),
 
                "Validation Message Not Displayed");
 
        // Capture Screenshot At End
 
        String screenshotPath =
 
                ScreenshotUtils.captureScreenshot(
                        driver,
                        "verifyRegistrationWithoutMandatoryFields");
 
        logger.info(
        "Screenshot Captured At : "
                + screenshotPath);
 
        logger.info(
        "Negative Registration Test Completed");
    }
}
