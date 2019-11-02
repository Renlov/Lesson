package com.ifmo.lesson8.appendable;

public class main {
    public static void main(String[] args) {
        //---------------------------
            System.out.println("==String==");
            StringAppendable sa = new StringAppendable(", ");
            String value = sa.append("one").append("two").append("three").value();
        //----------------------------

    }
}
