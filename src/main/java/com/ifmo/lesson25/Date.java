package com.ifmo.lesson25;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Date {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int date = scanner.nextInt();
        DateInt(date);
    }
    private static void DateInt(int date){
        LocalDate date1 = LocalDate.of(date, 1, 1);
        List<LocalDate> fridays = date1.datesUntil(date1.plusYears(1))
                .filter(d -> d.getDayOfWeek() == DayOfWeek.FRIDAY && d.getDayOfMonth() == 13)
                .collect(Collectors.toList());

        System.out.println(fridays);
    }

}
