//package com.ifmo.lesson21;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Potok implements Runnable {
//    public static Map<String, Integer> totalWordCount() throws IOException {
//        File text;
//        text = new File("c:/test/Lesson/src/main/resources/wap.txt");
//
//        // Вычитываем все строки из файла
//        List<String> lines = Files.readAllLines(text.toPath());
//
//        // Создаем пустую коллекцию для слов.
//        List<String> words = new ArrayList<>();
//
//        for (String line : lines) {
//            // Для каждой строки
//            String[] wordSplit =
//                    line.toLowerCase() // Переводим в нижний регистр
//                            .replaceAll("\\p{Punct}", " ") // Заменяем все знаки на пробел
//                            .trim() // Убираем пробелы в начале и конце строки.
//                            .split("\\s"); // Разбиваем строки на слова
//
//            for (String s : wordSplit) {
//                // Выбираем только непустые слова.
//                if (s.length() > 0)
//                    words.add(s.trim());
//            }
//        }
//        return
//    }
//
//    @Override
//    public void run() {
//
//    }
//}
//