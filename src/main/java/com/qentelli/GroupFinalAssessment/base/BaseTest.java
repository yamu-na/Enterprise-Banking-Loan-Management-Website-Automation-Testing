package com.qentelli.GroupFinalAssessment.base;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import org.openqa.selenium.WebDriver;
//
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//
//import com.qentelli.GroupFinalAssessment.driver.DriverFactory;
//import com.qentelli.GroupFinalAssessment.utils.ConfigReader;
//
//public class BaseTest {
//
//    protected  WebDriver driver;
//
//    protected Logger logger =
//            LogManager.getLogger(this.getClass());
//
//    @BeforeMethod
//
//    public void setup() {
//
//        logger.info(
//        "Browser setup started");
//
//        DriverFactory.initializeBrowser(
//                ConfigReader.getProperty(
//                        "browser"));
//
//        driver =
//                DriverFactory.getDriver();
//
//        driver.get(
//                ConfigReader.getProperty(
//                        "url"));
//
//        logger.info(
//        "Application launched successfully");
//    }
//
//    @AfterMethod
//
//    public void tearDown() {
//
//        logger.info(
//        "Closing browser");
//
//        DriverFactory.quitBrowser();
//    }
//}
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 
import org.openqa.selenium.WebDriver;
 
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
 
import com.qentelli.GroupFinalAssessment.driver.DriverFactory;
import com.qentelli.GroupFinalAssessment.utils.ConfigReader;
 
public class BaseTest {
 
    protected WebDriver driver;
 
    protected Logger logger =
            LogManager.getLogger(this.getClass());
 
    @BeforeMethod
 
    public void setup() {
 
        try {
 
            logger.info(
            "Browser setup started");
 
            DriverFactory.initializeBrowser(
                    ConfigReader.getProperty(
                            "browser"));
 
            driver =
                    DriverFactory.getDriver();
 
            driver.manage().window().maximize();
 
            driver.get(
                    ConfigReader.getProperty(
                            "url"));
 
            logger.info(
            "Application launched successfully");
 
        } catch (Exception e) {
 
            logger.error(
            "Exception during browser setup", e);
 
            throw new RuntimeException(e);
        }
    }
 
    @AfterMethod
 
    public void tearDown() {
 
        try {
 
            logger.info(
            "Closing browser");
 
            DriverFactory.quitBrowser();
 
        } catch (Exception e) {
 
            logger.error(
            "Exception during browser close", e);
        }
    }
}