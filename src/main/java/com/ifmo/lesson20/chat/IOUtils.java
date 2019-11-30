package com.ifmo.lesson20.chat;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by xmitya on 08.12.16.
 */
public final class IOUtils {
    private IOUtils() {}

    public static void closeQuietly(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException e) {
                // Ignore
            }
        }
    }
}
