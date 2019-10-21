package com.ifmo.lesson3;

import java.util.Arrays;
import java.util.Random;

public class TwoArrays {
    /*
     Создайте 2 массива из 5 случайных целых чисел из отрезка [0;5] каждый, выведите
     массивы на экран в двух отдельных строках. Посчитайте среднее арифметическое элементов
     каждого массива и сообщите, для какого из массивов это значение оказалось больше (либо
     сообщите, что их средние арифметические равны).
     */
    public static void main(String[] args) {
        int[] randomNumbers1 = randomNumbers();
        int[] randomNumbers2 = randomNumbers();
        System.out.println(Arrays.toString(randomNumbers1));
        System.out.println(Arrays.toString(randomNumbers2));
        // TODO implement

        int average1 = average(randomNumbers1);
        int average2 = average(randomNumbers2);
        if (average1> average2) System.out.println("Среднее арифметическое для первого больше, чем для второго");
        if (average1< average2) System.out.println("Среднее арифметическое для второго больше, чем для первого");
        if (average1 == average2) System.out.println("Средние арифметические равны");

        // TODO implement
    }

    public static int[] randomNumbers() {
        Random rnd = new Random();
        int low = 0, high = 5;
        int[] arr = new int[5];
        for (int i = 0; i <arr.length; i++) {
            int j = rnd.nextInt(high - low) + low;
            arr[i] = j;
        }
        return arr;
    }

    public static int average(int[] randomNumbers) {
        int count = 0;
        for (int i = 0; i <randomNumbers.length; i++) {
            count+=randomNumbers[i];
        }

        return count/randomNumbers.length;
    }
}
