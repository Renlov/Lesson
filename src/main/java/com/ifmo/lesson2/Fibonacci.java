package com.ifmo.lesson2;

public class Fibonacci {
    /*
     Выведите на экран первые 11 членов последовательности Фибоначчи. Напоминаем, что
     первый и второй члены последовательности равны единицам, а каждый следующий — сумме
     двух предыдущих.
     */
    public static void main(String[] args) {
        printFib(11);
    }

    private static void printFib(int n) {
        if (n >= 1) System.out.println(1);
        if (n >= 2) System.out.println(1);
        if (n > 2) {
            int first = 1;
            int second = 1;
            int temp;
            for (int i = 2; i < n; i++) {
                temp = second;
                second += first;
                first = temp;
                System.out.println(second);
            }
        }
    }
}