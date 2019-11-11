package com.ifmo.lesson8.appendable;

public class main {
    public static void main(String[] args) {
        //---------------------------
        System.out.println("==String==");
        StringAppendable sa = new StringAppendable(", ");
        String value = sa.append("one").append("two").append("three").value();
        //----------------------------
        System.out.println("==Integer==");
        IntAppendable ia = (IntAppendable) new IntAppendable().append(1).append(4).append(5);
        System.out.println(ia.value());

        IntAppendable ia2 = new IntAppendable(10, new ArithmeticOperation<Integer>() {
            @Override
            public Integer apply(Integer one, Integer two) {
                int res = one * two;
                return res == 0 ? 1 : res;
            }
        });
        //-----------------------------—
        DoubleAppendable da = (DoubleAppendable) new DoubleAppendable().append(1.0).append(4.0);
        System.out.println(da.value());
        DoubleAppendable da2 = new DoubleAppendable(1.3, new ArithmeticOperation() {
            @Override
            public Double apply(Object one, Object two) {
                return null;
            }
        });
//-----------------------------—
    }
}





