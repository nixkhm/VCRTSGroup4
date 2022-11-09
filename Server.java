import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    static ServerSocket serverSocket;
    static Socket socket;
    static DataInputStream inputStream;
    static DataOutputStream outputStream;

    public static void main(String[] args) {

        String messageIn = "";
        String messageOut = "";
        Scanner keyInput;

        try {

            System.out.println("----------$$$ This is server side $$$--------");
            System.out.println("wating for client to connect...");
            // creating the server
            serverSocket = new ServerSocket(8000);

            socket = serverSocket.accept();

            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}