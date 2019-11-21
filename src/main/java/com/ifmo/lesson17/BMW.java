package com.ifmo.lesson17;

public class BMW implements Car {
    @Override
    public int power() {
        return 200;
    }

    @Override
    public int maxSpeed() {
        return 300;
    }
}
