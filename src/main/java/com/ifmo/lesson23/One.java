package com.ifmo.lesson23;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class One {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return Thread.currentThread().getName() + "furure task";
            }
        });
        Runnable r = futureTask;
        Future<String> fut = futureTask;

        new Thread(r).start();
        String res = fut.get();
        System.out.println(res);
    }
}
