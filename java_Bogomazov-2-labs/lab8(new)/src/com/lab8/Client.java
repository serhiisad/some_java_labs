package com.lab8;

import java.net.*;
import java.io.*;

public class Client {
    public static final int PORT = 8080;
    public static BufferedReader in;
    public static PrintWriter out;
    public static Socket socket;
    public static String lastMessage;

    public static void main(String[] args) throws IOException {
        ClientGUI app = new ClientGUI();
        app.setVisible(true);
        createClient();
    }

    public static void createClient() throws IOException {
        InetAddress addr = InetAddress.getByName(null);
        System.out.println("addr = " + addr);
        Socket socket = new Socket(addr, Server.PORT);
        // Окружаем все блоками try-finally to make
        // чтобы убедиться что сокет закрывается:
        try {
            System.out.println("socket = " + socket);
            in = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            // Вывод автоматически сбрасывается
            // с помощью PrintWriter:
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
            // Сообшаем, что мы завершаем передачу
//            out.println("END");
            while (true) {
                String message = in.readLine();
//                lastMessage = message;
//                System.out.println("Echoing: " + lastMessage);
                ClientGUI.setLabel(message);
            }
        } finally {
            // В любом случае - закрываем сокет и сообшаем об этом
//            System.out.println("closing...");
//            socket.close();
        }
    }

    public static void sendMessage(String str) {
        out.println(str);
    }
}