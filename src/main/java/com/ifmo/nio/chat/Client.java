package com.ifmo.nio.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Created by xmitya on 10.01.17.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();

        socket.connect(new InetSocketAddress("localhost", 12345));

        new Thread(new Receiver(socket)).start();
        new Thread(new Sender(socket)).start();
    }

    private static class Receiver extends Worker {
        private InputStream in;
        private final Socket socket;
        private byte[] buf;

        public Receiver(Socket socket) {
            this.socket = socket;
            buf = new byte[1024];
        }

        @Override
        protected void loop() throws Exception {
            int read = in.read(buf);

            System.out.println(new String(buf, 0, read));
        }

        @Override
        protected void init() throws Exception {
            in = socket.getInputStream();
        }

        @Override
        protected void stop() throws Exception {
            socket.close();
        }
    }

    private static class Sender extends Worker {
        private OutputStream out;
        private final Socket socket;
        private Scanner scanner;

        public Sender(Socket socket) {
            this.socket = socket;
        }

        @Override
        protected void loop() throws Exception {
            String msg = scanner.nextLine();

            out.write(msg.getBytes(StandardCharsets.UTF_8));
        }

        @Override
        protected void init() throws Exception {
            out = socket.getOutputStream();
            scanner = new Scanner(System.in);
        }

        @Override
        protected void stop() throws Exception {
            socket.close();
        }
    }
}
