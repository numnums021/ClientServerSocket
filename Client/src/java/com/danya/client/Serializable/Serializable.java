package com.danya.client.Serializable;

import com.danya.client.Entity.Client;

import java.io.*;

public class Serializable {

    public ObjectOutputStream serializable(Client client) {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream( new
                    FileOutputStream("object.out"));
            objectOutputStream.writeObject(client);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return objectOutputStream;
    }

    public Object deSerializable(Client client){
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream( new
                    FileInputStream("object.out"));
            Object objectRestored = objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return objectInputStream;
    }
}
