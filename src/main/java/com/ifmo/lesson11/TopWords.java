package com.ifmo.lesson11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class TopWords {
    public static void main(String[] args) throws IOException {
        // Создаем файл, указывая путь к текстовому файлу на диске
        File text;
        text = new File("c:/test/Lesson/src/main/resources/wap.txt");

        // Вычитываем все строки из файла
        List<String> lines = Files.readAllLines(text.toPath());

        // Создаем пустую коллекцию для слов.
        List<String> words = new ArrayList<>();

        for (String line : lines) {
            // Для каждой строки
            String[] wordSplit =
                    line.toLowerCase() // Переводим в нижний регистр
                            .replaceAll("\\p{Punct}", " ") // Заменяем все знаки на пробел
                            .trim() // Убираем пробелы в начале и конце строки.
                            .split("\\s"); // Разбиваем строки на слова

            for (String s : wordSplit) {
                // Выбираем только непустые слова.
                if (s.length() > 0)
                    words.add(s.trim());
            }
        }

        System.out.println(top10Words(lines));
        System.out.println(top10Phrases(lines));
        System.out.println(charactersFrequency(lines));
    }

    public static Map<String, Integer> top10Words(List<String> lines) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : lines) {
            if (!map.containsKey(word)) map.put(word, 1);
            else map.put(word, map.get(word) + 1);
        }

    return map;
    }


    public static Map<String, Integer> top10Phrases(List<String> lines) {
        // todo implement
        return Map.of();
    }

    public static Map<String, Character> charactersFrequency(List<String> lines) {
        // todo implement
        return Map.of();
    }
}
