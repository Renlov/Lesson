package com.ifmo.lesson6;

/**
 * Структура данных, работающая по принципу LIFO (Last In First Out).
 * Это означает, что элементы добавляются в одном порядке, а
 * извлекаются в обратном.
 * Например:
 * 1 -> stack
 * 2 -> stack
 * 3 -> stack
 *
 * 3 <- stack
 * 2 <- stack
 * 1 <- stack
 * <pre>
 *     Stack stack = new LinkedList();
 *
 *     stack.push("1");
 *     stack.push("2");
 *     stack.push("3");
 *
 *     stack.pop(); // "3"
 *     stack.pop(); // "2"
 *     stack.pop(); // "1"
 *     stack.pop(); // null
 * </pre>
 *
 */
public interface Stack {
    /**
     * Добавляет элемент в голову стека.
     *
     * @param value Добавляемые данные.
     */
    void push(Object value);

    /**
     * Удаляет элемент из головы стека.
     *
     * @return Данные из головы стека или {@code null}, если стек пустой.
     */
    Object pop();
}
