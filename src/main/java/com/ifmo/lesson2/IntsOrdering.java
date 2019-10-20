package com.ifmo.lesson2;
public class IntsOrdering {
    /*
     В три переменные a, b и c явно записаны программистом три целых попарно неравных
     между собой числа. Создать программу, которая переставит числа в переменных таким
     образом, чтобы при выводе на экран последовательность a, b и c оказалась строго
     возрастающей.

     Числа в переменных a, b и c: 3, 9, -1
     Возрастающая последовательность: -1, 3, 9

     Числа в переменных a, b и c: 2, 4, 3
     Возрастающая последовательность: 2, 3, 4

     Числа в переменных a, b и c: 7, 0, -5
     Возрастающая последовательность: -5, 0, 7
     */
    public static void main(String[] args) {
        int a = 3, b = 9, c = -1;
        String ordering = ordering(a, b, c);

        System.out.println(ordering);
    }

    public static String ordering(int a, int b, int c) {
        // TODO implement
        int first = 0;
        int second = 0;
        int third = 0;

        if(a<b&&a<c) {
            if(b<c) {
                first = a;
                second = b;
                third = c;
            }
            else {
                first = a;
                second = c;
                third = b;
            }
        }

        if(b<a&&b<c) {
            if(a<c) {
                first = b;
                second = a;
                third = c;
            }
            else {
                first = b;
                second = c;
                third = a;
            }
        }

        if(c<a&&c<b) {
            if(a<b) {
                first = c;
                second = a;
                third = b;
            }
            else {
                first = c;
                second = b;
                third = a;
            }
        }

        return "Числа в переменных a, b и c: " + a + ", " + b + ", " + c + "\n" +
                "Возрастающая последовательность: "  + first + ", " + second + ", " + third;
    }
}
