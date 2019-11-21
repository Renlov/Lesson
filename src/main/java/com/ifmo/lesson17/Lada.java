package com.ifmo.lesson17;

public class Lada implements Car {
    @Override
    public int power() {
        return 5;
    }

    @Override
    public int maxSpeed() {
        return 10;
    }
}
