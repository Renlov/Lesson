package com.ifmo.lesson2;

public class Fibonacci {
    /*
     Выведите на экран первые 11 членов последовательности Фибоначчи. Напоминаем, что
     первый и второй члены последовательности равны единицам, а каждый следующий — сумме
     двух предыдущих.
     */
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        for (int i = 2; i <= 11; ++i) {
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println(b);
    }
}
