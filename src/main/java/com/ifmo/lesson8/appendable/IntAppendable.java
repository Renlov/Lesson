package com.ifmo.lesson8.appendable;

public class IntAppendable implements ArithmeticOperation, Appedable {
    private int value;
    private ArithmeticOperation arithmeticOperation;
    private static ArithmeticOperation<Integer> DEFAULT_ARITHMETIC_OP = new ArithmeticOperation<>() {
        @Override
        public Integer apply(Integer one, Integer two) {
            return one + two;
        }
    };
    IntAppendable(int value, ArithmeticOperation arithmeticOperation) {
        this.arithmeticOperation = arithmeticOperation;
        this.value = value;
    }

    public IntAppendable() {
        this(0, DEFAULT_ARITHMETIC_OP);
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