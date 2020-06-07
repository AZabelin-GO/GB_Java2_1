package com.geekbrains.java2.homework6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
    public static final String USERNAME = "Server";

    private static final int PORT = 9000;

    private static Socket socket;

    public static DataInputStream inputStream;
    public static DataOutputStream outputStream;

    private static void startServer() {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Launching SimpleChatServer. Listening on port: " + PORT);

            socket = serverSocket.accept();

            System.out.println("Client connected");

            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

            outputStream.writeUTF("Welcome to SimpleChat!");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (socket.isConnected()) {
                        String clientMsg = null;
                        try {
                            clientMsg = inputStream.readUTF();
                            System.out.println(clientMsg);
                        } catch (IOException e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                }
            }).start();

            // Thread for sending messages
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Scanner scanner = new Scanner(System.in);

                    while (socket.isConnected()) {
                        String serverMsg = scanner.nextLine();
                        try {
                            outputStream.writeUTF(USERNAME + "> " + serverMsg);
                        } catch (IOException e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        startServer();
    }
}
