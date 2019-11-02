package com.ifmo.lesson6;

import java.util.Iterator;

/**
 * Односвязный список, где каждый предыдущий
 * элемент харнит ссылку на следующий. Список
 * оканчивается ссылкой со значением {@code null}.
 */
public class LinkedList implements List, Stack, Queue {
    /**
     * Ссылка на первый элемент списка.
     */
    private Item head;

    private class LinkedListIterator implements Iterator<Object> {

        Item item = head;

        @Override
        public boolean hasNext() {
            return item != null;
        }

        @Override
        public Object next() {
            Object value = item.value;
            item = item.next;
            return value;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(Object val) {
        if (head == null) {
            head = new Item(val);
        } else {
            Item item = head;
            while (item.next != null) {
                item = item.next;
            }
            item.next = new Item(val);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object take() {
        return remove(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object get(int i) {
        Item item = find(i);
        return item != null ? item.value : null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object remove(int i) {
        Object value = null;
        if (i == 0) {
            if (head != null) {
                value = head.value;
                head = head.next;
            }
        } else if (i > 0) {
            Item item = find(i - 1);
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
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void push(Object value) {
        Item item = head;
        head = new Item(value);
        head.next = item;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object pop() {
        return remove(0);
    }

    /**
     * Метод поиска элементов односвязного списка
     *
     * @param i индекс элемента
     * @return Элемент либо {@code null} случаи если не найден данный эелемент
     */
    private Item find(int i) {
        if (i == 0) {
            return head;
        } else if (i > 0) {
            Item item = head;
            for (int j = 0; j <= i; j++) {
                if (item == null) return null;
                if (j == i) return item;
                item = item.next;
            }
        }
        return null;

    }
}