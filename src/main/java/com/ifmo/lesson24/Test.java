package com.ifmo.lesson24;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Pool pool1 = new Pool();
        Pool pool2 = new Pool();
        Pool pool3 = new Pool();
        pool1.start();
        pool1.join();
        pool2.start();
        pool2.join();
        pool3.start();
        pool3.join();
        block();
    }
        private static void block(){
            if (cnt > 2) {System.out.println("Все потоки отработали!");
            }
        }
        public static volatile int cnt = 0;

    static class Pool2 extends Thread {
        @Override
        public void run() {
            System.out.println("Поток " +Thread.currentThread().getName() + " запустился");
        }
    }


    static class Pool extends Thread {
        private boolean isLive = false;
        @Override
        public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println("Поток " + Thread.currentThread().getName() + " прибыл");
                        synchronized (this) {
                            cnt++;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                }
            }




