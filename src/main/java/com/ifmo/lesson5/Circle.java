package com.ifmo.lesson5;

public class Circle extends Shape {
    public Circle(double a, double b) {
        super(a, b);
    }
    @Override
    public void area(double a, double b){
        double area = 2 * Math.PI * a;
    }

}
