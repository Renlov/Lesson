package com.ifmo.lesson5;

public class Square extends Shape{
    public Square(double a, double b) {
        super(a, b);
    }
    @Override
    public void area(double a, double b){
        double area = a * a;
    }
}
