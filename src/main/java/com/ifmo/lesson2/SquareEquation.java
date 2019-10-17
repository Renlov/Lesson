package com.ifmo.lesson2;

import java.util.Arrays;

public class SquareEquation {
    /*
     В три переменные a, b и c записаны три вещественных числа. Создать программу, которая
     будет находить и выводить на экран вещественные корни квадратного уравнения ax²+bx+c=0,
     либо сообщать, что корней нет.
     */
    public static void main(String[] args) {
        double a = 2;
        double b = -9;
        double c = 9;

        double[] roots = squareEquationRoots(a, b, c);

        System.out.println(Arrays.toString(roots));
    }

    /*
    Возвращает массив из двух корней или null, если таковых нет.
     */
    public static double[] squareEquationRoots(double a, double b, double c) {
        double[] myArray = new double[2];
        double d = Math.pow(b, 2) - 4 * a * c;
        if (d > 0) {
            double x = -b + Math.sqrt(Math.pow(b, 2) - 4 * a * c);
            double y = -b - Math.sqrt(Math.pow(b, 2) - 4 * a * c);
            System.out.println(x);
            System.out.println(y);
        } else if (d == 0) {
            double x = -b / 2 * a;
            System.out.println(x);
        } else {
            System.out.println("Корней нет");

        }
        return null;
    }
}
