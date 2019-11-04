package com.ifmo.lesson8.appendable;

public class IntAppendable implements ArithmeticOperation, Appedable {
    private int value;

    IntAppendable(int value, ArithmeticOperation arithmeticOperation) {

        this.value = value;
    }
    public void IntAppendable(){}
    @Override
    public Appedable<Integer> append(Object o) {

        return append(o);
    }

    @Override
    public Object value() {
        return value;
    }

    @Override
    public Integer apply(Object one, Object two) {
        return null;
    }
}