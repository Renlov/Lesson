package com.ifmo.lesson2;

public class First20 {
    /*
     Создайте программу, выводящую на экран первые 20 элементов последовательности 2 4 8
     16 32 64 128 ….
     */
    public static void main(String[] args) {
        printSequence(20);
    }

    private static void printSequence(int lastNumber){

        for (int i = 1; i <= lastNumber; i++) {
            System.out.println(1 << i);
        }
    }
}