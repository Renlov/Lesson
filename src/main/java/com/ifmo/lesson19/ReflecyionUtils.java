package com.ifmo.lesson19;

public class ReflecyionUtils {
    public static void main(String[] args) {
        Reflection reflection = new Reflection();
        int number = reflection.getI();
        String name = reflection.getS();
        System.out.println(number + name);

    }
}