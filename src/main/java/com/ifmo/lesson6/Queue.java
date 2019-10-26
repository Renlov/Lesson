package com.ifmo.lesson6;

/**
 * Структура данных, работающая по принципу FIFO (First In First Out).
 * Это означает, что элементы добавляются и извлекаются в одинаковом порядке.
 * Например:
 * 1 -> queue
 * 2 -> queue
 * 3 -> queue
 *
 * 1 <- queue
 * 2 <- queue
 * 3 <- queue
 * <pre>
 *     Queue queue = new LinkedList();
 *
 *     stack.add("1");
 *     stack.add("2");
 *     stack.add("3");
 *
 *     stack.take(); // "1"
 *     stack.take(); // "2"
 *     stack.take(); // "3"
 *     stack.take(); // null
 * </pre>
 *
 */
public interface Queue {
    /**
     * Добавляет элемент в конец очереди.
     *
     * @param value Данные, которые будут добавлены в очередь.
     */
    void add(Object value);

    /**
     * Удаляет элемент из головы очереди.
     *
     * @return Данные, которые будут удалены из очереди или {@code null}, если очередь пустая.
     */
    Object take();
}
