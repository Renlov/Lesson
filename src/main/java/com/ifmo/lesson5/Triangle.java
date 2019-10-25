package com.ifmo.lesson5;

public class Triangle extends Shape {
    private double a;
    private double b;

    public Triangle(double a, double b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public double area() {
        return (1.0/2.0) * a * b;
    }

}
