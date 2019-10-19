package com.ifmo.lesson3;

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

        // TODO implement

        int average1 = average(randomNumbers1);
        int average2 = average(randomNumbers2);

        // TODO implement
    }

    public static int[] randomNumbers() {
        // TODO implement

        return new int[0];
    }

    public static int average(int[] randomNumbers) {
        // TODO implement

        return 0;
    }
}
