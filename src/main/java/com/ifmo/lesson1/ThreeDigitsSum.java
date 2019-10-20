package com.ifmo.lesson1;

public class ThreeDigitsSum {
    public static void main(String[] args) {
        int n = 123;

        int sum = sum(n);

        System.out.println(sum);
    }

    public static int sum(int n) {
        return (n/100 + n%100/10 +n%10);
    }
}
