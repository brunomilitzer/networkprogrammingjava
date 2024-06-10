package com.brunomilitzer.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server() throws Exception {
        ServerSocket serverSocket = new ServerSocket(2020); // opening new port
        System.out.println("Port 2020 has been opened");

        Socket socket = serverSocket.accept();
        System.out.println("Client " + socket.getInetAddress() + " has connected");

        // I/O buffer
        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        outSocket.println("Welcome!"); // Send "Welcome!" to the Client
        String message = inSocket.readLine(); // Receive "Thanks!"
        System.out.println("Client says: " + message);

        inSocket.close();
        System.out.println("Socket is closed.");
    }

    public static void main(String[] args) {
        try {
            new Server();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
