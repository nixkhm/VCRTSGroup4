package GUI.Start;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class index {

    static DataInputStream inputStream;
    static DataOutputStream outputStream;

    public static void main(String[] args) {
        LogInFrame logIn = new LogInFrame();

        try {
            System.out.println("The application has connected to the Server");
            System.out.println("client started!");
            // connect the client socket to server
            Socket socket = new Socket("localhost", 8000);

            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
