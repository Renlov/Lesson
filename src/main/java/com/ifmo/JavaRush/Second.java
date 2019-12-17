package com.ifmo.JavaRush;
import java.util.LinkedList;
import java.util.List;

public class Second {
    public static List<Thread> list;
    public static void main(String[] args) throws InterruptedException {
        list = new LinkedList<>();
        for (int i = 0; i <3; i++) {
            Barrier barrier = new Barrier();
            barrier.start();
            list.add(barrier);
            barrier.await();
        }
    }
    public static class Barrier extends Thread {
        public void await() throws InterruptedException {
            synchronized (this) {
                if (list.size() == 3) {
                    System.out.println("potoki zapucheni");
                    notifyAll();
                } else {
                    Thread.sleep(1000);
                }
            }
        }
        @Override
        public void run(){
            try {
                System.out.println("sozdaem potok " + Thread.currentThread().getName());
            } catch (Exception e) {}
        }
    }
}
