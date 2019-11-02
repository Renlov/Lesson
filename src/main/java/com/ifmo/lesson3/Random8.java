package com.ifmo.lesson3;

import java.util.Arrays;
import java.util.Random;

public class Random8 {
    /*
    Создайте массив из 8 случайных целых чисел из отрезка [1;10]. Выведите массив на экран
    в строку. Замените каждый элемент с нечётным индексом на ноль. Снова выведете массив на
    экран на отдельной строке.
     */
    private static final Random random = new Random();

    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();
        printArrayToLine(randomNumbers);

        int[] replacedWithZeros = replaceWithZeros(randomNumbers);
        printArrayToLine(replacedWithZeros);

    }

    public static int[] randomNumbers() {
        int[] array = new int[8];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10) + 1;
        }
        return array;
    }

    public static int[] replaceWithZeros(int[] randomNumbers) {
        for (int i = 1; i < randomNumbers.length; i += 2) {
            randomNumbers[i] = 0;
        }
        return randomNumbers;
    }

    private static void printArrayToLine(int[] array) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);
            if(i < array.length - 1){
                builder.append(" ");
            }
        }
        System.out.println(builder);
    }
}