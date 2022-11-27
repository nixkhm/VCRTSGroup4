package BackEnd.Entities;

import java.sql.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class JobServer {

    static ServerSocket serverSocket2;
    static Socket socket2;
    static DataInputStream inputStream2;
    static DataOutputStream outputStream2;

    static Connection connection = null;
    static String url = "jdbc:mysql://127.0.0.1:3306/VCRTSGroup4?user=root?useTimezone=true&serverTimezone=UTC";
    static String username = "root";
    static String password = "CUS1166VCRTSGROUP4";

    public static void main(String[] args) {

        while (true) {

            String messageIn = "";
            try {

                System.out.println("This is the server of of VCRTS");
                System.out.println("wating for client to connect...");

                try {
                    serverSocket2 = new ServerSocket(1000);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                while (true) {
                    try {
                        socket2 = serverSocket2.accept();
                    } catch (IOException e) {
                        System.out.println("I/O error: " + e);
                    }

                    inputStream2 = new DataInputStream(socket2.getInputStream());

                    messageIn = inputStream2.readUTF();

                    String infoToBeAdded = messageIn;

                    String pre = infoToBeAdded;
                    String[] split = pre.split("/");
                    String jobID = split[0];
                    String name = split[1];
                    String type = split[2];
                    String duration = split[3];
                    String deadline = split[4];

                    System.out.println(jobID + " " + name + " " + type + " " + duration + " " + deadline);

                    try {
                        connection = DriverManager.getConnection(url, username, password);

                        String sql = "INSERT INTO PendingJobApplications"
                                + "(JobID , name, type, duration, deadline)"
                                + "VALUES ("
                                + Integer.parseInt(jobID)
                                + ",'" + name
                                + "','" + type
                                + "'," + Integer.parseInt(duration)
                                + "," + Integer.parseInt(deadline)
                                + ")";

                        System.out.println(sql);

                        Statement statement = connection.createStatement();
                        int row = statement.executeUpdate(sql);
                        if (row > 0)
                            System.out.println("Data was inserted!");

                        connection.close();

                    } catch (SQLException e) {
                        e.getMessage();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}