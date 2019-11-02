package com.ifmo.lesson7;

import com.ifmo.lesson6.List;

import java.util.function.Predicate;

public class Util {
    public static Object find(Predicate pred, List list){
        for (Object object : list){
            if(pred.test(object)) return object;
        }
        return null;
    }
    public static List filter(Predicate pred, List list){
        return null;
    }

}
