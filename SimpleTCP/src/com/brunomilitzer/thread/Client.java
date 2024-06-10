package com.brunomilitzer.thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public Client() throws Exception {

        Socket socket = new Socket("localhost", 2020);
        System.out.println("Successfully connected to server");

        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        Scanner scanner = new Scanner(System.in);

        String message = inSocket.readLine();
        System.out.println("Server says: " + message);
        message = scanner.nextLine(); // User is prompted to type a message for the server
        outSocket.println(message);

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
