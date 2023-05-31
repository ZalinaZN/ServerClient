import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
//    private static final int PORT = 8495;

    public static void main(String[] args) {
        String city = null;


        try (ServerSocket serverSocket = new ServerSocket(Main.PORT);) { // порт можете выбрать любой в доступном диапазоне 0-65536. Но чтобы не нарваться на уже занятый - рекомендуем использовать около 8080
            System.out.println("Server started");

            while (true) {
                try (Socket clientSocket = serverSocket.accept(); // ждем подключения
                     PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ) {
                    if(city == null){
                        writer.println("Введите город");
                        city = reader.readLine();
                        writer.println("Ok");
                    } else  {
                        writer.println(city);
                        String newCity = reader.readLine();
                        if (city.charAt(city.length()-1) == newCity.charAt(0)){

                            city = newCity;
                            writer.println("Ok");
                        }else {
                            writer.println("Not Ok");
                        }
                    }

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void isFerst(){

    }

}