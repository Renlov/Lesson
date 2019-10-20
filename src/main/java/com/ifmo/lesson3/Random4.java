package com.ifmo.lesson3;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Random;

public class Random4 {
    /*
    Создайте массив из 4 случайных целых чисел из отрезка [10;99], выведите его на экран в
    строку. Определить и вывести на экран сообщение о том, является ли массив строго
    возрастающей последовательностью.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();
        System.out.println(Arrays.toString(randomNumbers));
        System.out.println(isIncreasingSequence(randomNumbers));
    }

    public static int[] randomNumbers() {
        Random rnd = new Random();
        int low = 10, high = 99;
        int[] arr = new int[4];
        for (int i = 0; i <arr.length; i++) {
            int j = rnd.nextInt(high - low) + low;
            arr[i] = j;
        }
        return arr;
    }

    public static boolean isIncreasingSequence(int[] randomNumbers) {
        if(randomNumbers[0] < randomNumbers[1] && randomNumbers[1] < randomNumbers[2] && randomNumbers[2] < randomNumbers[3]) return true;
        else return false;
    }
}
