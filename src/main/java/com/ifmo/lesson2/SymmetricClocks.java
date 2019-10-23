package com.ifmo.lesson2;

public class SymmetricClocks {
    /*
    Электронные часы показывают время в формате от 00:00 до 23:59. Подсчитать сколько
    раз за сутки случается так, что слева от двоеточия показывается симметричная комбинация
    для той, что справа от двоеточия (например, 02:20, 11:11 или 15:51)
     */
    public static void main(String[] args) {
        System.out.println(symmetricTimes());
    }

    public static int symmetricTimes() {
        int count = 0;
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j++) {
                if (appendZero(String.valueOf(i)).equals(reverseString(appendZero(String.valueOf(j))))){
                    count++;
                }
            }
        }

        return count;
    }

    private static String appendZero(String str){
        if(str.length() >= 2) return str;
        return "0"+str;
    }

    private static String reverseString(String str){
        StringBuilder builder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            builder.append(str.charAt(i));
        }
        return builder.toString();
    }
}