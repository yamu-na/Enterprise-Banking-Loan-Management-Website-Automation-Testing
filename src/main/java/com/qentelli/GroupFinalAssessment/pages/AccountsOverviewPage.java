package com.qentelli.GroupFinalAssessment.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountsOverviewPage extends CommonPage {
 
    private By firstAccount =
            By.xpath("(//a[contains(@href,'activity.htm?id=')])[1]");
 
    public AccountsOverviewPage(WebDriver driver) {
        super(driver);
    }
 
    public void openFirstAccount() {
        wait.until(
                ExpectedConditions.elementToBeClickable(firstAccount)
        ).click();
    }
}