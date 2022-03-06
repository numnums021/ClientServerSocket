
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static final int PORT = 8000;

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started");

            while (true) {
            try(Socket socket = serverSocket.accept()){
                System.out.println("Client connected");

                    // создали другой поток, который умеет немного больше
                    try (
                            BufferedWriter writer =
                                    new BufferedWriter(
                                            new OutputStreamWriter(socket.getOutputStream()));
                            BufferedReader reader =
                                    new BufferedReader(
                                            new InputStreamReader(socket.getInputStream()))) {

                        String request = reader.readLine();
                        System.out.println(request);

                        String response = "HI FROM SERVER: " + request.length();
                        System.out.println(response);

                        writer.write(response);
                        writer.newLine();
                        writer.flush();
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
