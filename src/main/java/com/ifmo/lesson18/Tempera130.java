package com.ifmo.lesson18;

public class Tempera130 implements Listener {
    @Override
    public void publish(Integer tempera) {
        if (tempera >= 130) System.out.println("Срабатывание Красного кода! " + tempera);
    }
}
