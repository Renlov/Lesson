package com.ifmo.lesson4;

/**
 * Односвязный список, где каждый предыдущий
 * элемент харнит ссылку на следующий. Список
 * оканчивается ссылкой со значением {@code null}.
 */
public class LinkedList {
    /** Ссылка на первый элемент списка. */
    private Item head;


    /**
     * Добавляет значение в конец списка.
     * @param val Значение, которое будет добавлено.
     */
    public void add(Object val) {
        if (head == null){ head = new Item(val); }
        else {
            Item item = head;
            while (true) {
                if(item.next == null){
                    item.next = new Item(val);

                    return;
                }
                item = item.next;
            }
        }
    }
    /**
     * Извлекает значение из списка по индексу.
     *
     * @param i Индекс значения в списке.
     * @return Значение, которое находится по индексу
     * или {@code null}, если не найдено.
     */
    public Object get(int i) {
        if (i == 0) {
            if (head != null)
                return head.value;
//            head = new Item(val);
        }
        else {
            int cnt = 0;
            Item item = head;
            while (true) {
                if(item.next == null){
                    item.next = new Item(val);

                    return;
                }
                item = item.next;
                cnt++;
            }
        }

        for (int j = 0; j <= i; j++) {
            if (head == null) return null;
            else head = head.next;
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
    public Object remove(int i) {
        head = new Item(i);
        for (int j = 0; j <= i; j++) {
        }
        while (head != null){
            if (head.value.equals(head)){

            }
        }

        return null;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
    }
}
