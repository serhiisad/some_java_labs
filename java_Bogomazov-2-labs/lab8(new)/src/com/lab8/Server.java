package com.lab8;

import java.net.*;
import java.io.*;

public class Server {
    // Выбираем номер порта за пределами 1-1024:
    public static final int PORT = 8080;
    public static BufferedReader in;
    public static PrintWriter out;
    public static Socket socket;
    public static ServerSocket s;
    public static String lastMessage;

    public static void main(String[] args) throws IOException {
        ServerGUI app = new ServerGUI();
        app.setVisible(true);
        createServer();
    }

    public static void createServer() throws IOException {
        ServerSocket s = new ServerSocket(PORT);
        System.out.println("Started: " + s);
        try {
            // Блокируем пока не произойдет соединение:
            Socket socket = s.accept();
            try {
                System.out.println("Connection accepted: " + socket);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // Вывод автоматически обновляется
                // классом PrintWriter:
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                while (true)  {
                    String message = in.readLine();
                    ServerGUI.setLabel(message);
//                    lastMessage = message;
//                    if (str.equals("END")) break;
//                    System.out.println("Echoing: " + lastMessage);
//                    out.println(str);
//                    sendMessage(lastMessage);
                }
            } catch (Exception e) {
                System.out.println("1 Error: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("2 Error: " + e.getMessage());
        }
    }

    public static void sendMessage(String str) {
        out.println(str);
    }
}