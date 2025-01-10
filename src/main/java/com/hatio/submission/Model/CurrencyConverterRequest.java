package com.hatio.submission.Model;

public class CurrencyConverterRequest {

    private String from;
    private String to;
    private double amount;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTo() {
        return to;
    }

    public double getAmount() {
        return amount;
    }
}
