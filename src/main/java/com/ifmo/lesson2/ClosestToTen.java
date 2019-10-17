package com.ifmo.lesson2;

public class ClosestToTen {
    /*
     Создать программу, выводящую на экран ближайшее к 10 из двух чисел, записанных в
     переменные m и n. Например, среди чисел 8,5 и 11,45 ближайшее к десяти 11,45.
     */
    public static void main(String[] args) {
        float m = 8.5f;
        float n = 11.45f;

        float closestToTen = closestToTen(m, n);

        System.out.println(closestToTen);
    }

    public static float closestToTen(float m, float n) {
        // TODO implement
        float a = m-n;
        float b = n-m;
        if (a > b) return m;
        else return n;
    }
}
