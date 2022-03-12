package com.danya.client;

import com.danya.client.Entity.Client;
import com.danya.client.Serializable.Serializable;
import com.danya.client.utils.JSONUtils;
import lombok.extern.java.Log;
import com.numnums021.Phone;
import java.io.*;
import java.util.Scanner;

@Log
public class ServerConnection {
    static final int PORT = 8000;
    static final String HOST = "127.0.0.1";

    public static void main(String[] args) {
        try (Phone phone = new Phone(HOST, PORT)){
            log.info("Подключён к серверу");

            log.warning("Введите имя клиента: ");
            Scanner inputText = new Scanner(System.in);
            String name = inputText.nextLine();
            log.warning("Введите возраст клиента: ");
            int year = inputText.nextInt();

            Client client = new Client(name, year);

            String request = JSONUtils.toJSON(client);

            log.info("Request: " + request);
            phone.writeLine(request);

            String response = phone.readLine();
            log.info("Response: " + response);

        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
