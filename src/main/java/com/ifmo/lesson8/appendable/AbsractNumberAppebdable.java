package com.ifmo.lesson8.appendable;

public abstract class AbsractNumberAppebdable<T> implements Appedable<T> {
    private AbsractNumberAppebdable<T> value;
    AbsractNumberAppebdable(AbsractNumberAppebdable value){
        this.value = value;
    }
   public Appedable<T> append(T o){
        return (Appedable<T>) o;
   }
}
