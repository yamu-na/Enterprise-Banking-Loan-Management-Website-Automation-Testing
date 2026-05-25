package com.qentelli.GroupFinalAssessment.models;

public class TransferData {

    private String transferAmount;

    private String description;

    private String expectedResult;

    public String getTransferAmount() {

        return transferAmount;
    }

    public void setTransferAmount(
            String transferAmount) {

        this.transferAmount = transferAmount;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(
            String description) {

        this.description = description;
    }

    public String getExpectedResult() {

        return expectedResult;
    }

    public void setExpectedResult(
            String expectedResult) {

        this.expectedResult = expectedResult;
    }
}