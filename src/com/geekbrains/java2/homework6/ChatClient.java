package com.geekbrains.java2.homework6;

import java.io.IOException;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;

public class ChatClient {
    public static final String USERNAME = "Client";

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 9000;

    private static Socket socket;

    private static DataInputStream inputStream;
    private static DataOutputStream outputStream;

    private static void startChatClient() {
        System.out.println("Connecting to SimpleChat server: " + SERVER_HOST + ":" + SERVER_PORT);

        try {
            socket = new Socket(SERVER_HOST, SERVER_PORT);

            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
            // Thread for reading server messages
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (socket.isConnected()) {
                        String serverMsg = null;
                        try {
                            serverMsg = inputStream.readUTF();
                            System.out.println(serverMsg);
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
                        String clientMsg = scanner.nextLine();
                        try {
                            outputStream.writeUTF(USERNAME + "> " + clientMsg);
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
        startChatClient();
    }
}
