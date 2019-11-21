package com.ifmo.lesson17;

public class main {
    public static void main(String[] args) {
        Factory factory = Factory.getFactory("Russia");
        Car car = factory.createCar();
    }
}
