package com.ifmo.lesson6;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Этот класс должен реализовывать следующие методы: add(), get(), remove() и iterator() из интерфейса List.
 * Если при выполнении add() в массиве нет свободных элементов, то создать новый - вдвое больше,
 * скопировать в него все значения из старого и + 1, который сейчас добавляется.
 * Удаление должно сдвинуть все элементы влево, если это требуется.
 * Например, если список с такими элементами:
 * |0|1|2|3|4|5|
 * Удаляем элемент по индексу 2:
 * |0|1|_|3|4|5|
 * Перемещаем все элементы влево:
 * |0|1|3|4|5|_|
 * Теперь при итерации по ним после 1 будет идти сразу 3, как в связном списке.
 */
public class ArrayList implements List {
    private static final int DEFAULT_SIZE = 10;

    private Object[] values;
    private int tail;

    private class ArrayListIterator implements Iterator<Object>{

        private int index;
        @Override
        public boolean hasNext() {
            return index < tail;
        }

        @Override
        public Object next() {
            return get(index++);
        }
    }
    /**
     * Создаёт новый {@link #ArrayList} с размером внутреннего массива по умолчанию.
     */
    public ArrayList() {
        this(DEFAULT_SIZE);
    }

    /**
     * Создаёт новый {@link #ArrayList} с размером внутреннего массива,
     * равного {@code initialSize}.
     *
     * @param initialSize Начальный размер внутреннего массива.
     */
    public ArrayList(int initialSize) {
        values = new Object[initialSize];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(Object val) {
        if (tail == values.length) reSize();
        values[tail++] = val;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object get(int i) {
        if (i < 0 || i >= tail) return null;
        return values[i];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object remove(int i) {
        if (i < 0 || i >= tail) return null;
        Object value = values[i];
        for (int j = i; j < tail - 1; j++) {
            values[j] = values[j + 1];
        }
        values[--tail] = null;
        return value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }

    /**
     * Метод расширяет внутренний массив в два раза
     */
    private void reSize() {
        values = Arrays.copyOf(values, values.length * 2);
    }
}