package com.ifmo.lesson2;

public class First55 {
    /*
    Создайте программу, выводящую на экран первые 55 элементов последовательности 1 3 5 7 9 11 13 15 17 ….
     */
    public static void main(String[] args) {
        // TODO implement
        int b = -1;
        for (int i = 0; i <55; i++) {
            b +=2;
            System.out.println(b);
        }
    }
}
