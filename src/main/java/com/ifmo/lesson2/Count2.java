package com.ifmo.lesson2;

public class Count2 {
    /*
         В городе N есть большой склад на котором существует 50000 различных полок. Для
        удобства работников руководство склада решило заказать для каждой полки табличку с
        номером от 00001 до 50000 в местной типографии, но когда таблички напечатали, оказалось
    что печатный станок из-за неисправности не печатал цифру 2, поэтому все таблички, в
    номерах которых содержалась одна или более двойка (например, 00002 или 20202) — надо
    перепечатывать. Напишите программу, которая подсчитает сколько всего таких ошибочных
    табличек оказалось в бракованной партии.
     */
    public static void main(String[] args) {
        System.out.println(count2());
    }

    public static int count2() {
        // TODO implement
        int a = 0;
        for (int i = 00001; i <= 50000; i++) {
            int j = i;
            while (j > 0) {
                if (j % 10 == 2){
                    a++;
                    break;}
                j = j / 10;
            }
        }

            return a;
        }

}
