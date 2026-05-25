package com.qentelli.GroupFinalAssessment.driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static ThreadLocal<WebDriver>
            driverThreadLocal =
            new ThreadLocal<>();

    // Initialize browser
    public static void initializeBrowser(
            String browserName) {

        if (browserName.equalsIgnoreCase(
                "chrome")) {

            WebDriverManager.chromedriver()
                    .setup();

            driverThreadLocal.set(
                    new ChromeDriver());

        } else if (browserName
                .equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver()
                    .setup();

            driverThreadLocal.set(
                    new EdgeDriver());

        } else {

            throw new RuntimeException(
            "Invalid browser name");
        }

        getDriver().manage().window()
                .maximize();

        getDriver().manage().timeouts()
                .implicitlyWait(
                        Duration.ofSeconds(0));
    }

    // Get driver
    public static WebDriver getDriver() {

        return driverThreadLocal.get();
    }

    // Quit browser
    public static void quitBrowser() {

        if (driverThreadLocal.get()
                != null) {

            getDriver().quit();

            driverThreadLocal.remove();
        }
    }
}