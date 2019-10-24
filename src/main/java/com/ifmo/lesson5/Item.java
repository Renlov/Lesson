package com.ifmo.lesson5;

/**
 * Элемент связного списка, хранящий ссылку
 * на следующий элемент и на значение.
 * <p>
 *     Класс package-private, т.к. используется
 *     только для LinkedList'a.
 * </p>
 */
class Item {
    /** Значение элемента. */
    Shape value;

    /** Ссылка на следующий элемент. */
    Item next;

    /**
     * Инициализирует элемент со значением
     * {@code value}.
     *
     * @param value Значение, которое будет сохранено
     *              в этом элементе.
     */
    Item(Shape value) {
        this.value = value;
    }
}
