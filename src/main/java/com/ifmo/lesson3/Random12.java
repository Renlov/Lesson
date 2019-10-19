package com.ifmo.lesson3;

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

        // TODO implement
    }

    public static int[] randomNumbers() {
        // TODO implement

        return new int[0];
    }

    public static int max(int[] randomNumbers) {
        // TODO implement

        return 0;
    }

    public static int lastIndexOf(int[] randomNumbers, int max) {
        // TODO implement

        return 0;
    }
}
