package com.ifmo.lesson20.chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by xmitya on 28.08.16.
 */
public class ChatClient {

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("HH:mm:ss.SSS");

    private SocketAddress serverAddr;

    private String name;

    private Scanner scanner;

    private Socket socket;

    private ObjectOutputStream objOut;

    public ChatClient(SocketAddress serverAddr, Scanner scanner) {
        this.serverAddr = serverAddr;
        this.scanner = scanner;
    }

    private void start() throws IOException {
        System.out.println("Enter your name: ");

        name = scanner.nextLine();

        openConnection();

        Thread reader = new Thread(new Reader(socket));
        reader.start();

        System.out.println("Enter message to send: ");

        while (true) {
            String msg = scanner.nextLine();

            if ("/exit".equals(msg)) {
                IOUtils.closeQuietly(socket);

                break;
            }
            else if ("/nick".equals(msg)) {
                System.out.println("Enter new name:");

                name = scanner.nextLine();

                continue;
            }

            if (msg != null && !msg.isEmpty())
                buildAndSendMessage(msg);
        }
    }

    private void openConnection() {
        try {
            socket = new Socket();

            socket.connect(serverAddr);

            objOut = new ObjectOutputStream(socket.getOutputStream());
        }
        catch (IOException e) {
            IOUtils.closeQuietly(socket);

            throw new ChatUncheckedException("Error connecting to server", e);
        }
    }

    private class Reader implements Runnable {
        private final Socket socket;

        private Reader(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (socket) {
                ObjectInputStream objIn = new ObjectInputStream(socket.getInputStream());

                while (!Thread.currentThread().isInterrupted()) {
                    Message message = (Message) objIn.readObject();

                    printMessage(message);
                }
            }
            catch (IOException e) {
                throw new ChatUncheckedException("Error reading message", e);
            }
            catch (ClassNotFoundException e) {
                throw new ChatUncheckedException("Error de-serializing message", e);
            }

            System.exit(1);
        }
    }

    private void printMessage(Message msg) {
        System.out.printf("%s: %s => %s\n", FORMAT.format(new Date(msg.getTimestamp())), msg.getSender(), msg.getText());
    }

    private void buildAndSendMessage(String msg) {
        Message message = new Message(System.currentTimeMillis(), name, msg);

        try {
            objOut.writeObject(message);
            objOut.flush();
        }
        catch (IOException e) {
            IOUtils.closeQuietly(socket);

            throw new ChatUncheckedException("Error sending message", e);
        }

    }

    private static SocketAddress parseAddress(String addr) {
        String[] split = addr.split(":");
        return new InetSocketAddress(split[0], Integer.parseInt(split[1]));
    }

    public static void main(String[] args) throws IOException {
        String addr = null;

        if (args != null && args.length > 0)
            addr = args[0];

        Scanner scanner = new Scanner(System.in);

        if (addr == null) {
            System.out.println("Enter server address");

            addr = scanner.nextLine();
        }

        ChatClient client = new ChatClient(parseAddress(addr), scanner);

        client.start();
    }
}
