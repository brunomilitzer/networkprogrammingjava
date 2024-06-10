package com.brunomilitzer.tcp2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ServerGame {

    public ServerGame() throws Exception {
        ServerSocket serverSocket = new ServerSocket(2020); // opening new port
        System.out.println("Port 2020 has been opened");

        Socket socket = serverSocket.accept();
        System.out.println("Client " + socket.getInetAddress() + " has connected");

        // I/O buffer
        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        String message;

        int secretNumber = (int) (Math.random() * 10 + 1);

        do {
          outSocket.println("Guess a number [1-10]");
          message = inSocket.readLine();
        } while (!(Integer.parseInt(message) == secretNumber));

        outSocket.println("You got it!!!");
        System.out.println("Secret number is out.  Exiting the App!");

        inSocket.close();
        System.out.println("Socket is closed.");
    }

    public static void main(String[] args) {
        try {
            new ServerGame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
