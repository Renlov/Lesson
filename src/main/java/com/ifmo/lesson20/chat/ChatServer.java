package com.ifmo.lesson20.chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by xmitya on 28.08.16.
 */
public class ChatServer {

    private int port;

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("HH:mm:ss.SSS");

    private final Set<Connection> connections = new CopyOnWriteArraySet<>();
    private final BlockingDeque<Message> messageQueue = new LinkedBlockingDeque<>();

    public ChatServer(int port) {
        this.port = port;
    }

    private void start() throws IOException {
        new Thread(new Writer()).start();

        try (ServerSocket ssocket = new ServerSocket(port)) {
            System.out.println("Server started on " + ssocket);

            while (true) {
                Socket sock = ssocket.accept();

                connections.add(new Connection(sock));

                new Thread(new Reader(sock)).start();
            }
        }
    }

    private class Reader implements Runnable {
        private final Socket socket;

        private Reader(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (socket;
                 ObjectInputStream objIn = new ObjectInputStream(socket.getInputStream())) {
                System.out.printf("%s connected\n", socket.getInetAddress().getHostAddress());

                while (!Thread.currentThread().isInterrupted()) {
                    Message msg = (Message) objIn.readObject();

                    messageQueue.add(msg);

                    printMessage(msg);
                }

            }
            catch (IOException e) {
                System.err.println("Disconnected " + socket.getInetAddress().getHostAddress());

//                throw new ChatUncheckedException("Error acquire input stream", e);
            }
            catch (ClassNotFoundException e) {
                throw new ChatUncheckedException("Error de-serializing message", e);
            }
            finally {
                connections.removeIf(connection -> connection.socket == socket);
            }
        }
    }

    private class Writer implements Runnable {
        @Override
        public void run() {
            Thread.currentThread().setName("Writer");

            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Message msg = messageQueue.take();

                    for (Connection connection : connections) {
                        try {
                            connection.objOut.writeObject(msg);
                            connection.objOut.flush();
                        }
                        catch (IOException e) {
                            System.err.printf("Error sending message %s to %s\n", msg, connection.socket);

                            connections.remove(connection);
                            IOUtils.closeQuietly(connection.socket);
                        }
                    }
                }
            }
            catch (InterruptedException e) {
                throw new ChatUncheckedException("Writer was interrupted", e);
            }
        }
    }

    private static class Connection {
        final Socket socket;
        final ObjectOutputStream objOut;

        Connection(Socket socket) throws IOException {
            this.socket = socket;
            this.objOut = new ObjectOutputStream(socket.getOutputStream());
        }
    }

    private void printMessage(Message msg) {
        System.out.printf("%s: %s => %s\n", FORMAT.format(new Date(msg.getTimestamp())), msg.getSender(), msg.getText());
    }

    public static void main(String[] args) throws IOException {
        if (args == null || args.length == 0)
            throw new IllegalArgumentException("Port must be specified");

        int port = Integer.parseInt(args[0]);

        ChatServer chatServer = new ChatServer(port);

        chatServer.start();
    }
}
