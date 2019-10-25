package com.ifmo.lesson5;

public class Shapes {
    public static void main(String[] args) {
        double totalArea = totalArea(
                new Rectangle(10, 15),
                new Square(23));
                new  Circle(5, 5);
                new Oval(4 , 3);
                new Triangle(3,5,6);

        System.out.println(totalArea);
    }

    public static double totalArea(Shape... shapes) {
        double sum = 0;

        for (Shape shape : shapes) {
            sum += shape.area();
        }

        return sum;
    }
}
