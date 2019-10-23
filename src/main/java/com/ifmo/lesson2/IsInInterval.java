package com.ifmo.lesson2;

import java.util.Random;

public class IsInInterval {
    /*
     Создать программу, которая будет проверять попало ли случайно выбранное из отрезка
    [5;155] целое число в интервал (25;100) и сообщать результат на экран.Примеры работы
    программы:
    Число 113 не содержится в интервале (25,100) Число 72 содержится в интервале (25,100) 
    Число 25 не содержится в интервале (25,100) Число 155 не содержится в интервале (25,100) 
     */
    public static void main(String[] args) {
        int rnd = randomInt();

        String inInterval = isInInterval(rnd);

        System.out.println(inInterval);
    }

    public static int randomInt() {
        return new Random().nextInt(150) + 5;
    }

    public static String isInInterval(int rnd) {
        String str = " не";
        if (rnd > 25 && rnd < 100) {
            str = "";
        }

        return String.format("Число %d%s содержится в интервале (25,100)", rnd, str);
    }

}