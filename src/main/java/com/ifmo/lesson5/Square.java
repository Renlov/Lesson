package com.ifmo.lesson5;

public class Square extends Rectangle{
    private double a;

    public Square(double a, double b) {
        super(a, b);
    }

    @Override
    public double area() {
        return a * a;
    }
}
