package com.ifmo.lesson3;

import java.util.Arrays;

public class EvenArray {
    /*
    Создайте массив из всех чётных чисел от 2 до 20 и выведите элементы массива на экран
    сначала в строку, отделяя один элемент от другого пробелом, а затем в столбик (отделяя один
    элемент от другого началом новой строки). Перед созданием массива подумайте, какого он
    будет размера.2 4 6 … 18 20246…20
     */
    public static void main(String[] args) {
        int[] evenArray = evenArray();
        printArrayToLine(evenArray);
        printArrayToColumn(evenArray);
    }

    public static int[] evenArray() {
        int[] array = new int[20];
        int j = 0;
        for (int i = 2; i <= 20; i += 2, j++) {
            array[j] = i;
        }
        return Arrays.copyOf(array, j);
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

    private static void printArrayToColumn(int[] array){
        Arrays.stream(array).forEach(System.out::println);
    }

}