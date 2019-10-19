package com.ifmo.lesson1;

public class DivisionRemainder {
    /*
    В переменных q и w хранятся два натуральных числа. Создайте программу,
    выводящую на экран результат деления q на w с остатком.
    Пример вывода программы (для случая, когда в q хранится 21, а в w хранится 8):
    21 / 8 = 2 и 5 в остатке
     */
    public static void main(String[] args) {
        int q = 21;
        int w = 8;
        // comenta

        calculate(q, w);
    }

    public static void calculate(int q, int w) {
        int i = q/w;
        int r = q%w;
        System.out.printf("%s / %s = %s и %s в остатке\n", q, w, i, r);
    }
}
