import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    //    private static final int PORT = 8495;

    public static void main(String[] args) {

        try (Socket clientSocket = new Socket(Main.HOST,Main.PORT);) {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            {
                String city = in.readLine();
                System.out.println(city);

                Scanner scanner = new Scanner(System.in);
                String newCity = scanner.nextLine();
                out.println(newCity);

                String result = in.readLine();
                System.out.println(result);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
