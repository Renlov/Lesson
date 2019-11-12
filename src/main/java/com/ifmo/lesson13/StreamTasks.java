package com.ifmo.lesson13;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTasks {

    private static class Person {
        private final String name;
        private final int age;
        private final String country;

        public Person(String name, int age, String country) {
            this.name = name;
            this.age = age;
            this.country = country;
        }
    }

    public static void main(String[] args) {
        Stream<Person> people = generatePeople(100);

        List<String> countries = countriesSortedByTheirPopulationDescending(people);
        String countryThatHasMostKids = countryThatHasMostKids(people);
        Map<String, Long> populationByCountry = populationByCountry(people);

        System.out.println(countries);
        System.out.println(countryThatHasMostKids);
        System.out.println(populationByCountry);

        List<String> words = List.of("the", "hello", "approximation", "greetings", "java", "war");

        Map<Integer, Set<String>> wordsByLength = groupWordsByLength(words);
        int averageWordLength = averageWordLength(words);
        Set<String> longestWords = longestWords(words);

        System.out.println(wordsByLength);
        System.out.println(averageWordLength);
        System.out.println(longestWords);

    }

    // Метод возвращает страны в порядке убывания их населения.
    public static List<String> countriesSortedByTheirPopulationDescending(Stream<Person> people) {
        // TODO implement.
       // Map<String, Person> result =
        return List.of();
    }

    // Метод находит страну (или одну из стран), в которых больше всего человек в возрасте
    // до 18 лет.
    public static String countryThatHasMostKids(Stream<Person> people) {
        // TODO implement.
        return  people
                .filter(p -> p.age < 18)
                .collect(Collectors.groupingBy(p ->p.country, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("Unknown");
    }

    // Метод возвращает карту стран их населения.
    public static Map<String, Long> populationByCountry(Stream<Person> people) {
        // TODO implement.

        return Map.of();
    }

    private static List<String> COUNTRIES = List.of("USA", "Russia", "India");
    private static List<String> NAMES = List.of("Mike", "Max", "Jon", "Anastasia", "Elizabeth", "Viki");
    // Метод генерирует случайных людей в ограниченном наборе стран.
    // number - число желаемых людей.
    public static Stream<Person> generatePeople(int number) {
        // TODO implement.
        var rnd = new Random(80);
        int rnx = rnd.nextInt();
        Stream people = Stream.generate(
                () -> new Person(NAMES.get(rnd.nextInt(NAMES.size())), rnx, COUNTRIES.get(rnd.nextInt(COUNTRIES.size())))
        );
        return people;
    }

    // Метод возвращает карту сгруппированных слов по их длине. Например, для
    // трёхбуквенных слов будет:
    // 3 -> "the", "map", "got", "war"...
    public static Map<Integer, Set<String>> groupWordsByLength(List<String> words) {
        // TODO implement.

        return Map.of();
    }

    // Метод находит среднюю длину слов в списке.
    public static int averageWordLength(List<String> words) {
        // TODO implement.

        return 0;
    }

    // Метод находит самое длинное слово или слова, если таких несколько.
    public static Set<String> longestWords(List<String> words) {
        // TODO implement.

        return Set.of();
    }



}
