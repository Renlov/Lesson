package com.ifmo.lesson17;

public class CanadaFactory extends Factory {
    @Override
    public Car createCar() {
        return new Crysler();
    }
}
