package com.ifmo.lesson21;

import java.util.ArrayList;
import java.util.List;

public class Sync {
    private int cnt;

    public static void main(String[] args) throws InterruptedException {
        List<Adder> adders = new ArrayList<>(100);
        Sync sync = new Sync();

        for (int i = 0; i <100 ; i++) {
            adders.add(sync.new Adder());

            for (Adder adder : adders)
                adder.start();

            for (Adder adder : adders)
                adder.join();

            System.out.println(sync.cnt);
        }
    }

    private class Adder extends Thread{
        @Override
        public void run(){
            for(int i = 0; i<100_000; i++){
                cnt++;
            }
        }
    }
}
