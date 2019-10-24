package com.ifmo.lesson5;

public class Triangle extends Shape {
    public Triangle(double a, double b) {
        super(a, b);
    }
    @Override
    public void area(double a, double b){
        double area = (1.0/2.0) * a * b;
    }
}
