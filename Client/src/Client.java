import java.io.*;
import java.net.Socket;

public class Client {
    static final int PORT = 8000;
    static final String HOST = "127.0.0.1";

    public static void main(String[] args) {
        try (
            Socket socket = new Socket(HOST, PORT);

            BufferedWriter writer =
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    socket.getOutputStream()));
            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()))) {
            System.out.println("Подключён к серверу");
            String request = "Москва";
            System.out.println("Request: " + request);
            writer.write(request);
            writer.newLine();
            writer.flush();

            String response = reader.readLine();
            System.out.println("Response: " + response);


        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
