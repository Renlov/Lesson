package com.ifmo.lesson18;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Tass tass = new Tass();
        tass.subscribe(new Tempera70());
        tass.subscribe(new Tempera110());
        tass.subscribe(new Tempera130());
        Random rnd = new Random();
        for (int count = 0; count <200; count++) {
            count+= rnd.nextInt(5);
            tass.notifyListeners(count);
        }
    }
}
