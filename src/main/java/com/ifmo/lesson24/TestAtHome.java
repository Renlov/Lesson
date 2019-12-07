package com.ifmo.lesson24;
import java.util.*;
import java.util.concurrent.*;

public class TestAtHome {
    public static CyclicBarrier barrier= new CyclicBarrier(3);
    public static void main(String[] args) throws InterruptedException {
        Pool thread1 = new Pool();
        Pool thread2 = new Pool();
        Pool thread3 = new Pool();
        thread1.start();
        Thread.sleep(1000);
        thread2.start();
        Thread.sleep(1000);
        thread3.start();
    }
    public static class Pool extends Thread{
        @Override
        public void run(){
            try {
                System.out.println("Поток " + Thread.currentThread().getName() + " запустился");
                barrier.await();
                System.out.println("Поток " + Thread.currentThread().getName() + " снова сработал");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }
}
