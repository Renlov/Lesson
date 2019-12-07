package com.ifmo.lesson23;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        int cpus = Runtime.getRuntime().availableProcessors();
//создаем пулл потоков
        ExecutorService pool = Executors.newFixedThreadPool(cpus);

        List<Future<Map<String, Integer>>> futures = new ArrayList<>(cpus);
//       отправляем задачи на обработку
        for(int i = 0; i <cpus; i++){
            List<String> lines = List.of();
        }
        pool.shutdown();
    }
    private static Map<String, Integer> countWords(List<String> lines){
        return Map.of();
    }
//    private static List<String> top10()
}
