package com.ifmo.lesson6.work;

public class Accumulator {
    private double value;
    private Operation operation;

    Accumulator(double value, Operation operation){
        this.value = value;
        this.operation = operation;
    }
    double getValue(){
        return value;
    }
    public void accumulate(double v) {

    }
    public static void main(String[] args) {
        Accumulator accumulator1 = new Accumulator(230, new Plus());
        System.out.println(accumulator1);
    }


}
