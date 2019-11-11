package com.ifmo.lesson8.appendable;

public class DoubleAppendable implements Appedable, ArithmeticOperation {
    private double value;
    private ArithmeticOperation arithmeticOperation;
    private static ArithmeticOperation<Double> DEFAULT_ARITHMETIC_OP = new ArithmeticOperation<>() {
        @Override
        public Double apply(Double one, Double two) {
            return one + two;
        }
    };
    DoubleAppendable(double value, ArithmeticOperation arithmeticOperation) {
        this.arithmeticOperation = arithmeticOperation;
        this.value = value;
    }

    public DoubleAppendable() {
        this(0, DEFAULT_ARITHMETIC_OP);
    }

    public void DoubleAppendable(){}
    @Override
    public Appedable<Double> append(Object o) {

        return append(o);
    }

    @Override
    public Object value() {
        return value;
    }

    @Override
    public Double apply(Object one, Object two) {
        return null;
    }
}