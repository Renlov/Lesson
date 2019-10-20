package com.ifmo.lesson3;

import java.util.Arrays;
import java.util.Random;

public class Random8 {
    /*
    Создайте массив из 8 случайных целых чисел из отрезка [1;10]. Выведите массив на экран
    в строку. Замените каждый элемент с нечётным индексом на ноль. Снова выведете массив на
    экран на отдельной строке.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();

        System.out.println(Arrays.toString(randomNumbers));

        int[] replacedWithZeros = replaceWithZeros(randomNumbers);

        System.out.println(Arrays.toString(replacedWithZeros));
    }

    public static int[] randomNumbers() {
        Random rnd = new Random();
        int low = 1, high = 10;
        int[] arr = new int[8];
        for (int i = 0; i <arr.length; i++) {
            int j = rnd.nextInt(high - low) + low;
            arr[i] = j;
        }
        return arr;
    }

    public static int[] replaceWithZeros(int[] randomNumbers) {
        int[] arr = new int[8];
        for (int i = 0; i <randomNumbers.length ; i++) {
            if (randomNumbers[i] % 2 == 0) arr[i] = randomNumbers[i];
            else arr[i] = 0;
        }

        return arr;
    }
}
