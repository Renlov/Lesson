package com.ifmo.nio.chat;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xmitya on 10.01.17.
 */
class Session {
    private Map<String, Object> data = new HashMap<>();

    void put(String key, Object val) {
        data.put(key, val);
    }

    @SuppressWarnings("unchecked")
    <T> T get(String key) {
        return (T) data.get(key);
    }

    @SuppressWarnings("unchecked")
    <T> T remove(String key) {
        return (T) data.remove(key);
    }
}
