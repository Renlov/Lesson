package com.ifmo.lesson5;

/**
 * Односвязный список, где каждый предыдущий
 * элемент харнит ссылку на следующий. Список
 * оканчивается ссылкой со значением {@code null}.
 */
public class LinkedList {
    /**
     * Ссылка на первый элемент списка.
     */
    private Item head;

    /**
     * Добавляет значение в конец списка.
     *
     * @param val Значение, которое будет добавлено.
     */
    public void add(Shape val) {
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
     * Извлекает значение из списка по индексу.
     *
     * @param i Индекс значения в списке.
     * @return Значение, которое находится по индексу
     * или {@code null}, если не найдено.
     */
    public Shape get(int i) {
        if (i < 0) return null;
        Item item = found(i);
        if (item != null) {
            return item.value;
        }
        return null;
    }

    /**
     * Удаляет значение по индексу и возвращает
     * удаленный элемент.
     *
     * @param i Индекс, по которому будет удален элемент.
     * @return Удаленное значение или {@code null}, если не найдено.
     */
    public Shape remove(int i) {
        if (i < 0) return null;

        if (i == 0) {
            Shape val = head.value;
            head = null;
            return val;
        }

        Item item = found(i - 1);
        if (item != null) {
            if (item.next != null) {
                Shape val = item.next.value;
                item.next = item.next.next;
                return val;
            }
        }
        return null;
    }

    /**
     * Ищет объект с заданным индексом
     * @param i Индекс, по которому будет производится поиск.
     * @return Объект типа Item или {@code null}, если не найден
     */
    private Item found(int i) {
        Item item = head;
        for (int j = 0; j <= i; j++) {
            if (item == null) return null;
            if (j == i) return item;
            item = item.next;
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

    }
}