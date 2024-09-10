package com.example.model;

import java.util.List;

public class SellerPayments {
    private String sellerId;
    private List<Payment> payments;

    public SellerPayments(String sellerId, List<Payment> payments) {
        this.sellerId = sellerId;
        this.payments = payments;
    }

    public String getSellerId() {
        return sellerId;
    }

    public List<Payment> getPayments() {
        return payments;
    }
}
