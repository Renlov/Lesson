package com.ifmo.lesson8.appendable;

public interface Appedable<T> {
    Appedable<T> append(T o);
    T value();
}
