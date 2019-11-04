package com.ifmo.lesson8.appendable;

public class DoubleAppendable implements Appedable, ArithmeticOperation {
    private double value;
    DoubleAppendable(double value, ArithmeticOperation arithmeticOperation){
        this.value = value;
    }
    public void DoubleAppendable(){}
    @Override
    public Appedable<Double> append(Object o) {
        return append(o);
    }

    @Override
    public Object value() {
        return null;
    }

    @Override
    public Double apply(Object one, Object two) {
        return null;
    }
}
