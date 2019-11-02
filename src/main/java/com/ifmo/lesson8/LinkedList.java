package com.ifmo.lesson8;

import java.util.Iterator;

/**
 * Односвязный список, где каждый предыдущий
 * элемент харнит ссылку на следующий. Список
 * оканчивается ссылкой со значением {@code null}.
 */
public class LinkedList <T> implements List<T>, Stack<T>, Queue<T> {
    /**
     * Ссылка на первый элемент списка.
     */
    private Item<T> head;

    private class LinkedListIterator implements Iterator<T> {

        Item<T> item = head;

        @Override
        public boolean hasNext() {
            return item != null;
        }

        @Override
        public T next() {
            T value = item.value;//второй вопрос
            item = item.next;
            return value;
        }
    }

    /**
     * {@inheritDoc}
     * @param val
     */
    @Override
    public void add(T val) {
        if (head == null) {
            head = new Item<>(val);
        } else {
            Item item = head;
            while (item.next != null) {
                item = item.next;
            }
            item.next = new Item<>(val);//типизируем типы
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T take() {
        return remove(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T get(int i) {
        Item<T> item = find(i);
        return item != null ? item.value : null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T remove(int i) {
        T value = null;
        if (i == 0) {
            if (head != null) {
                value = head.value;
                head = head.next;
            }
        } else if (i > 0) {
            Item<T> item = find(i - 1);
            if (item != null) {
                if (item.next != null) {
                    value = item.next.value;
                    item.next = item.next.next;
                }
            }
        }
        return value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void push(T value) {
        Item<T> item = head;
        head = new Item<>(value);
        head.next = item;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T pop() {
        return remove(0);
    }

    /**
     * Метод поиска элементов односвязного списка
     *
     * @param i индекс элемента
     * @return Элемент либо {@code null} случаи если не найден данный эелемент
     */
    private Item<T> find(int i) {
        if (i == 0) {
            return head;
        } else if (i > 0) {
            Item<T> item = head;
            for (int j = 0; j <= i; j++) {
                if (item == null) return null;
                if (j == i) return item;
                item = item.next;
            }
        }
        return null;

    }
}