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
        System.out.println(Arrays.toString(unevenArray));
        for (int i = 49; i >= 0; i--) {
            System.out.print(unevenArray[i] + " ");
        }

        // TODO implement
    }

    public static int[] unevenArray() {
        int[] count = new int[50];
        for (int i = 0, j = 1; i <count.length; i++, j+=2) {
            count[i]=j;
        }
        return count;
    }
}
