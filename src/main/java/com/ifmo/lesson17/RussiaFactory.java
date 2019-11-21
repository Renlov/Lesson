package com.ifmo.lesson17;

public class RussiaFactory extends Factory {
    @Override
    public Car createCar() {
        return new Lada();
    }
}
