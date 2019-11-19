package com.ifmo.lesson16.print.test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket();

        socket.connect(new InetSocketAddress("127.0.0.1", 12345));
        ObjectOutputStream objOut = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream objIn = new ObjectInputStream(socket.getInputStream());

        objOut.writeObject(new Echo("Dummy text"));

        Echo response = (Echo) objIn.readObject();
        System.out.println(response);
        socket.close();


    }
}
