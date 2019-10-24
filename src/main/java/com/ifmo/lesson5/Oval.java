package com.ifmo.lesson5;

public class Oval extends Shape {
    public Oval(double a, double b) {
        super(a, b);
    }
    @Override
    public void area(double a, double b){
        double area = Math.PI * a * b;
    }
}
