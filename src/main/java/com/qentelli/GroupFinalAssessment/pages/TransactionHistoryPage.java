package com.qentelli.GroupFinalAssessment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
 
public class TransactionHistoryPage extends CommonPage {
 
    private By transactionsLink =
            By.xpath("//a[contains(@href,'transaction.htm')]");
 
    private By transactionRows =
            By.xpath("//table//tr");
 
    public TransactionHistoryPage(WebDriver driver) {
        super(driver);
    }
 
    public void openTransactions() {
        wait.until(
                ExpectedConditions.elementToBeClickable(transactionsLink)
        ).click();
    }
 
    public boolean isTransactionTableDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(transactionRows)
        ).isDisplayed();
    }
}