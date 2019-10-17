package com.ifmo.lesson1;

public class IsEven {
    /*
    Напишите программу, которая выводит true, если число четное и false, если нет.
    Попробуйте сделать при помощи битовых операций.
     */
    public static void main(String[] args) {
        int n = 24;

        System.out.println(isEven(n));
    }

    public static boolean isEven(int n) {
        return (n & 1) == 0;

    }
}
