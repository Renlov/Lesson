package com.ifmo.nio.chat;

/**
 * Created by xmitya on 10.01.17.
 */
public abstract class Worker implements Runnable {
    @Override
    public void run() {
        try {
            init();

            while (!isInterrupted()) {
                loop();
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                stop();
            } catch (Exception ignore) {
                // Ignore
            }
        }
    }

    protected void init() throws Exception {
        // No-op
    }

    protected void stop() throws Exception {
        // No-op
    }

    protected boolean isInterrupted() {
        return Thread.currentThread().isInterrupted();
    }

    protected abstract void loop() throws Exception;
}
