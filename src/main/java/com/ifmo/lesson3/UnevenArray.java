package com.ifmo.lesson3;

import java.util.Arrays;

public class UnevenArray {
    /*
    Создайте массив из всех нечётных чисел от 1 до 99, выведите его на экран в строку, а затем
    этот же массив выведите на экран тоже в строку, но в обратном порядке (99 97 95 93 … 7 5 3
    1)
     */
    public static void main(String[] args) {
        int[] unevenArray = unevenArray();
        printArray(unevenArray);
        printArrayReverse(unevenArray);
    }

    public static int[] unevenArray() {
        int[] array = new int[50];
        for (int i = 1, j = 0; i < 100; i += 2) {
            array[j++] = i;
        }

        return array;
    }

    private static void printArrayReverse(int[] array){
        StringBuilder builder = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            builder.append(array[i]);
            if(i > 0){
                builder.append(" ");
            }
        }
        System.out.println(builder);
    }

    private static void printArray(int[] array){
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