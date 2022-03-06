import com.numnums021.Phone;
import java.io.*;

public class Client {
    static final int PORT = 8000;
    static final String HOST = "127.0.0.1";

    public static void main(String[] args) {
        try (Phone phone = new Phone(HOST, PORT)){
            System.out.println("Подключён к серверу");
            String request = "Москва";
            System.out.println("Request: " + request);
            phone.writeLine(request);

            String response = phone.readLine();
            System.out.println("Response: " + response);

        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
