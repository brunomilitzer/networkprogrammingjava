package com.brunomilitzer.tcp2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientGame {

    public ClientGame() throws Exception {

        Socket socket = new Socket("localhost", 2020);
        System.out.println("Successfully connected to server");

        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        Scanner scanner = new Scanner(System.in);

        String userNumber;

        while (inSocket.readLine().startsWith("Guess")) {
            System.out.println("Server says: Guess a number [1-10]");
            userNumber = scanner.nextLine();
            outSocket.println(userNumber);
        }

        System.out.println("You got it!!!");

        socket.close();
        System.out.println("Socket Closed.");
    }

    public static void main(String[] args) {
        try {

            new ClientGame();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
