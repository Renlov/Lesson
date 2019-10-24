package com.ifmo.lesson5;

public class Rectangle extends Shape {

    public Rectangle(double a, double b) {
        super(a, b);
    }

    @Override
    public void area(double a, double b) {
        double area = a * b;
    }
}
