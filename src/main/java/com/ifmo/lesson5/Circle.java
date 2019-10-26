package com.ifmo.lesson5;

public class Circle extends Oval {
    private double a;
    private double b;

    public Circle(double a, double b) {
        super(a, b);
    }
    @Override
    public double area() {
        return Math.PI * (a * a);
    }
}
