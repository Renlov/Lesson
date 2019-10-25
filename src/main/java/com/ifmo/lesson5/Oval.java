package com.ifmo.lesson5;

public class Oval extends Shape {
    private double a;
    private double b;

    public Oval(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        return Math.PI * a * b;
    }
}
