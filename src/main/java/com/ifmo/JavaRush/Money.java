package com.ifmo.JavaRush;

public abstract class Money {
    public Money(double amount) {
    }

    public double getAmount(){
        return amount;
    }
    private double amount;
    public abstract String getCurrencyName();

}

