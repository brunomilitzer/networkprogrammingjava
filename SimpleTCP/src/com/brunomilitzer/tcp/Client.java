package com.brunomilitzer.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public Client() throws Exception {

        Socket socket = new Socket("localhost", 2020);
        System.out.println("Successfully connected to server");

        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        String message = inSocket.readLine();
        System.out.println("Server says: " + message);
        outSocket.println("Thanks!");

        socket.close();
        System.out.println("Socket Closed.");
    }

    public static void main(String[] args) {
        try {

            new Client();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
