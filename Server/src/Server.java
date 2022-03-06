
import com.numnums021.Phone;

import java.io.*;
import java.net.ServerSocket;

public class Server {
    static final int PORT = 8000;

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started");

            while (true) {
                    Phone phone = new Phone(serverSocket);
                    new Thread(()->{
                        String request = phone.readLine();
                        System.out.println("Request: " + request);

                        String response = "HI FROM SERVER: " + request.length();

                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException ex){
                            ex.printStackTrace();
                        }
                        phone.writeLine(response);
                        System.out.println("Response: " + response);

                        try {
                            phone.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                    }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
