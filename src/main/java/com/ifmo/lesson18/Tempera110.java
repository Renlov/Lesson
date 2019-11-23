package com.ifmo.lesson18;

public class Tempera110 implements Listener {
    @Override
    public void publish(Integer tempera) {
        if (tempera >= 110 && tempera <= 130) System.out.println("Срабатывание Желтого кода! " + tempera);
    }
}
