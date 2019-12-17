package com.ifmo.test;

public class First {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <3; i++) {
            Barrier barrier = new Barrier();
            barrier.start();
            barrier.await();
        }
    }
}

class Barrier extends Thread {
    private int i = 0;
    public synchronized void await() throws InterruptedException {
        synchronized (this) {
            if (i == 3) {
                System.out.println("potoki zapucheni");
                notifyAll();
            } else {
                i++;
                Thread.sleep(1000);
            }
        }
    }
    @Override
    public void run(){
        try {
            System.out.println("sozdaem potok " + Thread.currentThread().getName());
//Thread.sleep(1000);
        } catch (Exception e) {}
    }
}
