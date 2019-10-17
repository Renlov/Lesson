package com.ifmo.lesson2;

import java.util.Random;

public class BiggestInRandom {
    /*
     Создать программу, выводящую на экран случайно сгенерированное трёхзначное
     натуральное число и его наибольшую цифру.Примеры работы программы:
     В числе 208 наибольшая цифра 8.
     В числе 774 наибольшая цифра 7.
     В числе 613 наибольшая цифра 6.
     */
    public static void main(String[] args) {
        int rnd = threeDigitRandom();

        String largestDigit = largestDigit(rnd);

        System.out.println(largestDigit);
    }

    public static int threeDigitRandom() {
        // TODO implement
        Random rnd = new Random();
        int i = rnd.nextInt(1000);
        return i;
    }

    public static String largestDigit(int rnd) {
        // TODO implement
        int max = 0;
        int one = rnd/100;
        int two = (rnd/10)%10;
        int three = rnd%10;
        if (one >= two && one > three)  max = one;
        if (two >= one && two > three) max = two;
        if (three >= two && three > one) max = three;


        return "В числе " + rnd + " наибольшая цифра " + max + ".";
    }
}
