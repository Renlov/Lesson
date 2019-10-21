package com.ifmo.lesson3;

import java.util.Arrays;
import java.util.Random;

public class Random12 {
    /*
    Создайте массив из 12 случайных целых чисел из отрезка [-15;15]. Определите какой
    элемент является в этом массиве максимальным и сообщите индекс его последнего
    вхождения в массив.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();

        // TODO implement

        int max = max(randomNumbers);
        int maxLastIndex = lastIndexOf(randomNumbers, max);
        System.out.println(Arrays.toString(randomNumbers));
        System.out.println(max);
        System.out.println(maxLastIndex);
        // TODO implement
    }

    public static int[] randomNumbers() {
        Random rnd = new Random();
        int low = -15, high = 15;
        int[] arr = new int[12];
        for (int i = 0; i <arr.length; i++) {
            int j = rnd.nextInt(high - low) + low;
            arr[i] = j;
        }
        return arr;
    }

    public static int max(int[] randomNumbers) {
        int max = 0;
        for (int i = 0; i <12; i++) {
            if(randomNumbers[i] > max) max = randomNumbers[i];
        }
        return max;
    }

    public static int lastIndexOf(int[] randomNumbers, int max) {
        int index = 0;
        for (int i = 0; i <randomNumbers.length; i++) {
            if (randomNumbers[i] == max) index = i;
        }
        return index;
    }
}
