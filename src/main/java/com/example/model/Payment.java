package com.example.model;

public class Payment {
    private String chargeCode;
    private double amount;

    public Payment(String chargeCode, double amount) {
        this.chargeCode = chargeCode;
        this.amount = amount;
    }

    public String getChargeCode() {
        return chargeCode;
    }

    public double getAmount() {
        return amount;
    }
}
