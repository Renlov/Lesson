package com.ifmo.lesson14.calc;

/**
 * Created by xmitya on 23.10.16.
 */
public class CalcException extends Exception {
    public CalcException(String message) {
        super(message);
    }

    public CalcException(String message, Throwable cause) {
        super(message, cause);
    }
}
