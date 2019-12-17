package com.ifmo.lesson25;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

public class HappyNewYearMF {
    public static void main(String[] args) throws InterruptedException {
        LocalDateTime ny = LocalDateTime.of(2020, Month.JANUARY,1,1,0);

        LocalDateTime now = LocalDateTime.now();

        Duration duration = Duration.between(now, ny);

        long days = duration.toDays();
        Duration hoursDuration = duration.minusDays(days);
        long hours = hoursDuration.toHours();
        Duration minusDuration = hoursDuration.minusHours(hours);
        long minutes = minusDuration.toHours();
        Duration secondDuration = hoursDuration.minusHours(minutes);
        long second = secondDuration.toSeconds();
        System.out.println(days +" "+ hours +" "+ minutes +" "+ second);

        Thread.sleep(1000);
    }
}
