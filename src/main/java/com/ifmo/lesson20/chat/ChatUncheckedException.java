package com.ifmo.lesson20.chat;

/**
 * Created by xmitya on 08.12.16.
 */
public class ChatUncheckedException extends RuntimeException {
    public ChatUncheckedException(String message) {
        super(message);
    }

    public ChatUncheckedException(String message, Throwable cause) {
        super(message, cause);
    }
}
