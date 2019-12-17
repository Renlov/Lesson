package ru.ifmo;


import java.util.logging.Logger;

/**
 * Created by xmitya on 25.12.16.
 */
public class HelloWorld {
    private static final Logger LOG = Logger.getLogger(String.valueOf(HelloWorld.class));

    public static void main(String[] args) {
        LOG.info("Application started");

        System.out.printf("Hello, %s!\n", new ru.ifmo.DataSource().getData());

        LOG.info("Application stopped");
    }
}
