package com.ifmo.lesson17;

public class EnglandFactory extends Factory {
    @Override
    public Car createCar() {
        return new Bently();
    }
}
