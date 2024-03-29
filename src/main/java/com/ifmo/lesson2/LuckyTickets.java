package com.ifmo.lesson2;

public class LuckyTickets {
    /*
    В городе N проезд в трамвае осуществляется по бумажным отрывным билетам. Каждую
    неделю трамвайное депо заказывает в местной типографии рулон билетов с номерами от
    000001 до 999999. «Счастливым» считается билетик у которого сумма первых трёх цифр
    номера равна сумме последних трёх цифр, как, например, в билетах с номерами 003102 или
    567576. Трамвайное депо решило подарить сувенир обладателю каждого счастливого билета
    и теперь раздумывает, как много сувениров потребуется. С помощью программы подсчитайте
    сколько счастливых билетов в одном рулоне?
     */
    public static void main(String[] args) {
        System.out.println(luckyTickets());
    }

    public static int luckyTickets() {
        int count = 0;
        for (int i = 000001; i<1000000 ; i++) {
            int one = i/100000;
            int two = (i%100000)/10000;
            int three = (i%10000)/1000;
            int four = (i%1000)/100;
            int five = (i%100)/10;
            int six = i%10;
            if (one+two+three == four+five+six) count++;
        }

        return count;
    }
}
