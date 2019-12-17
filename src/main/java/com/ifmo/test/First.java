package com.ifmo.test;

public class First {
    public static void main(String[] args) throws InterruptedException {
        Barrier barrier = new Barrier();

        for (int i = 0; i <3; i++) {
            new TestThread(barrier).start();
            Thread.sleep(1000);
        }
    }

    static class Barrier {
        private int i = 0;
        void await() throws InterruptedException {
            synchronized (this) {

                if (++i == 3) {
                    System.out.println("potoki zapucheni");
                    notifyAll();
                } else {
                    wait();

                }
            }
        }

    }

    private static class TestThread extends Thread {
        private final Barrier barrier;

        private TestThread(Barrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run(){
            System.out.println("before barrier");
            try {
                barrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("After barrier");

//            try {
//                System.out.println("sozdaem potok " + Thread.currentThread().getName());
//                Thread.sleep(1000);
//            } catch (Exception ignored) {}
        }
    }
}


