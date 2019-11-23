package com.ifmo.lesson18;

public class Tempera70 implements Listener {
    @Override
    public void publish(Integer tempera) {
        if (tempera >= 70 && tempera <= 110) System.out.println("Срабатывание Зеленого кода! " + tempera);
    }
}
