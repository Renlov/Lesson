package com.ifmo.lesson3;

import java.lang.reflect.Array;
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
        for (int i = 0; i < 10; i++) {
            System.out.print(evenArray[i] + " ");
            if (i == 9) System.out.println("\n");
            // TODO implement
        }
        for (int i = 0; i <10; i++) {
            System.out.println(evenArray[i]);


        }
    }
    public static int[] evenArray() {
        int[] arr = new int[10];
        for (int i = 2, j = 0; i <=20 ; i+=2, j++) {
            arr[j] = i;
        }
        return arr;
    }
}
