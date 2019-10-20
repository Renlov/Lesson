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
        System.out.println("Число "+ randomInt()+" " + isInInterval(rnd));
        // TODO implement
    }

    public static int randomInt() {
        // TODO implement
        Random rnd = new Random();
        int low = 5, higt =155;
        int i = rnd.nextInt(higt-low)+low;
        return i;

    }

    public static String isInInterval(int rnd) {
        if(25 < rnd  && rnd < 100) return "содержится в интервале (25,100)";
        else return "не содержится в интервале (25,100)";

    }

}
