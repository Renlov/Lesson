package com.ifmo.lesson12;
import java.util.*;


public interface Util {
    interface Predicate<T>{
        boolean isValid(T value);
    }
    public static <T>List<T> filter(List<T> list, Predicate<T> filter){
        List<T> result = new ArrayList<>(list.size());
        for (T item: list) {
            if(filter.isValid(item)) result.add(item);

        }
        return result;
    }

    interface Predicate1<T, R>{
        boolean isValue(T value);
    }

    interface Transformer<T, R> {
        R transform(T value);
    }
    public static <T, R> List<R> transform(List<T> list, Transformer<T, R> transformer) {
        List<T> result = new ArrayList<>(list.size());

        return null;
    }

    public static void main(String[] args) {
        List<Integer> integers = List.of(1,2,3,4,5,6,7,8,9,10);

        List<Integer> even = filter(integers, i -> i % 2 == 0);

        even.forEach(System.out::println);

        System.out.println("============");

        filter(integers, i -> i>5).forEach(System.out::println);
        System.out.println("============");
        filter(integers, i -> i>2).forEach(System.out::println);
    }
}
