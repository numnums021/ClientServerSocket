package com.danya.server;

import com.numnums021.Phone;
import lombok.extern.java.Log;

import java.io.*;
import java.net.ServerSocket;

@Log
public class Server {
    static final int PORT = 8000;

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            log.info("com.danya.server.Server started");

            while (true) {
                    Phone phone = new Phone(serverSocket);

                    String checkExit = "";
                    if (checkExit.equals("123"))
                        break;

                    new Thread(()->{
                        String request = phone.readLine();
                        log.info("Request: " + request);

                        // String response = "HI FROM SERVER: " + request.length();
                        String response = request;

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex){
                            log.info("Interrupted!" + ex);
                            Thread.currentThread().interrupt();
                        }
                        phone.writeLine(response);
                        log.info("Response: " + response);

                        try {
                            phone.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }
                    }).start();
                    }
        } catch (IOException e) {
            log.info("Error: " + e);
        }
    }
}
