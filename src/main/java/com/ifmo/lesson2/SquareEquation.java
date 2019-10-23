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
        double discriminant = Math.pow(b, 2) - 4*a*c;
        if(discriminant > 0){
            double root1 = ((-b)+Math.sqrt(discriminant))/(2 * a);
            double root2 = ((-b)-Math.sqrt(discriminant))/(2 * a);
            return new double[]{root1, root2};
        }else if(discriminant == 0){
            double root = (-b)/(2 * a);
            return new double[]{root};
        }
        return null;
    }
}