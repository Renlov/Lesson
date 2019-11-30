package com.ifmo.lesson21;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopWords {
    private static Map<String, Integer> totalWordCount = new HashMap<>();

    public static void main(String[] args) {
        final int cpus = Runtime.getRuntime().availableProcessors();

        final List<String> word;

        System.out.println(cpus);
    }
    private static class WordCountThread extends  Thread{
        private final List<String> word;

        private WordCountThread(List<String> word) {
            this.word = word;
        }
    }
}