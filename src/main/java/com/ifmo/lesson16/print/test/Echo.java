package com.ifmo.lesson16.print.test;

import java.io.Serializable;

public class Echo implements Serializable {
    public final String test;

    public Echo(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "Echo{" +
                "test='" + test + '\'' +
                '}';
    }
}
