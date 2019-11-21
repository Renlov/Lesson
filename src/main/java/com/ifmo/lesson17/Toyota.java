package com.ifmo.lesson17;

public class Toyota implements Car {
    @Override
    public int power() {
        return 100;
    }

    @Override
    public int maxSpeed() {
        return 250;
    }
}
