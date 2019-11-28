package com.ifmo.lesson19;

import java.util.List;

public class Reflection {
    private int i;
    private String s = "Lol";
    private List list;

//    public Reflection(int i, String s) {
//        this.i = i;
//        this.s = s;
//    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}