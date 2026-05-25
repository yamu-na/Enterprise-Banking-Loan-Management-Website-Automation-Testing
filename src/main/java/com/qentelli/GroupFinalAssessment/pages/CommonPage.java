package com.qentelli.GroupFinalAssessment.pages;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonPage {
	protected WebDriver driver;
    protected WebDriverWait wait;
 
    public CommonPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

}
