package com.ifmo.lesson19;

import java.lang.reflect.Field;

public class ReflecyionUtils {
    public static void main(String[] args) {
        Reflection reflection = new Reflection();
        int number = reflection.getI();
        String name = reflection.getS();
        System.out.println(number + name);
    }
    public static String toString(Object object) throws IllegalAccessException {
        final Class<?> cls = object.getClass();

        StringBuilder sb = new StringBuilder(cls.getSimpleName()).append("={");
        for (Field field : cls.getDeclaredFields()){
            if(!field.isAnnotationPresent(inject.class)){
                field.setAccessible(true);

                sb.append(field.getName())
                        .append('=')
                        .append(field.get(object))
                        .append(',');
            }
        }

        return "";
    }
}