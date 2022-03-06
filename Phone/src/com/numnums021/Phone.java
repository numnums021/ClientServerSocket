package com.numnums021;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Phone implements Closeable {

    private final Socket socket;
    private final BufferedReader reader;
    private final BufferedWriter writer;

    public Phone(String ip, int port) {
        try {
            this.socket = new Socket(ip, port);
            this.reader = createReader();
            this.writer = createWriter();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Phone(ServerSocket serverSocket) {
        try {
            this.socket = serverSocket.accept() ;
            this.reader = createReader();
            this.writer = createWriter();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void write(String message) {
        try{
            writer.write(message);
            writer.newLine();
            writer.flush();
        }
        catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }

    public String read(){
        try{
            return reader.readLine();
        }
        catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }

    private BufferedReader createReader() throws IOException {
        return new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()));
    }

    private BufferedWriter createWriter() throws IOException {
        return new BufferedWriter(
                new OutputStreamWriter(
                        socket.getOutputStream()));
    }

    @Override
    public void close() throws IOException {
        writer.close();
        reader.close();
        socket.close();
    }
}
