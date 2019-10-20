package com.ifmo.lesson3;

import java.util.Arrays;

public class Fibonacci20 {
    /*
    Создайте массив из 20-ти первых чисел Фибоначчи и выведите его на экран. Напоминаем,
    что первый и второй члены последовательности равны единицам, а каждый следующий —
    сумме двух предыдущих.
     */
    public static void main(String[] args) {
        int[] fibonacciNumbers = fibonacciNumbers();
        fibonacciNumbers[0] = 1;
        System.out.println(Arrays.toString(fibonacciNumbers));
    }

    public static int[] fibonacciNumbers() {
        int[] arr = new int[20];
        for (int i = 0, j = 0; i <arr.length; i++) {
            j+=i;
            arr[i] = j;
        }

        return arr;
    }

}
