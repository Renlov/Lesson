package com.ifmo.lesson16.print.test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket sscoket = new ServerSocket(12345);
        while(true) {
            //ждем входящее подключение
            Socket socket = sscoket.accept();

            //Создаем сериализующие/дисериализующие потоки
            ObjectOutputStream objOut = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objIn = new ObjectInputStream(socket.getInputStream());

            //ждем и читаем сообщение от клиента
            Object request = objIn.readObject();
        }
    }
}
