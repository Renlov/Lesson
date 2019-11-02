package com.ifmo.lesson8.appendable;

public class StringAppendable implements Appedable {

    private String value;

    public StringAppendable(String separator) {
        this.value = separator;
    }

    @Override
    public Appedable<String> append(Object o) {
        return append(0);
    }

    @Override
    public String value() {
        return value;
    }

    //value
    //String
    //separator v constructor
}
