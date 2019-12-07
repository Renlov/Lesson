package com.ifmo.lesson23;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class two {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        List<Future<String>> futs = new ArrayList<>(10);

        for(int i = 0; i <10; i++){
            Future<String> future = pool.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "" + Thread.currentThread().getId();
                }
            });
            futs.add(future);
        }

        pool.shutdown();
        for (Future<String> fut : futs)
            System.out.println(fut.get());
    }
}
