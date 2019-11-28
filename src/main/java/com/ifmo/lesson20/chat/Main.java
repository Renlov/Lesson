package com.ifmo.lesson20.chat;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i <10; i++) {
            Thread potok = new Thread(new HelloPotok());
            potok.setName("Tread" + i);
            potok.start();
            potok.join(2000);
        }
    }
    public static class HelloPotok implements Runnable{
        @Override
        public void run() {
            System.out.println("Поток начал работу:::" + Thread.currentThread().getName());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Поток отработал:::" + Thread.currentThread().getName());
        }
    }

}
