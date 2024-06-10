package com.brunomilitzer.thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable {

    private Socket socket;
    private ServerMain serverMain;

    public ServerThread(Socket socket, ServerMain serverMain) {
        this.socket = socket;
        this.serverMain = serverMain;
    }

    @Override
    public void run() {
        try {
            int clientNumber = serverMain.getClientNumber();

            System.out.println("Client " + clientNumber + ". has connected.");

            // I/O buffer
            BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outSocket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            outSocket.println("Welcome! You are client number " + clientNumber + ". What's your name? "); // Send "Welcome!" to the Client
            String message = inSocket.readLine(); // Receive "Thanks!"
            System.out.println("Client says: " + message);

            inSocket.close();
            System.out.println("Client " + clientNumber + " has disconnected.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
