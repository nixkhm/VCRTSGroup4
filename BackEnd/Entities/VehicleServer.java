package BackEnd.Entities;

import java.sql.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

public class VehicleServer {

    static Connection connection = null;
    static String url = "jdbc:mysql://127.0.0.1:3306/VCRTSGroup4?user=root?useTimezone=true&serverTimezone=UTC";
    static String username = "root";
    static String password = "CUS1166VCRTSGROUP4";

    static ServerSocket serverSocket;
    static Socket socket;
    static DataInputStream inputStream;
    static DataOutputStream outputStream;

    public static void main(String[] args) {

        while (true) {
            String messageIn = "";
            try {
                System.out.println("This is the server of of VCRTS");
                System.out.println("wating for client to connect...");
                try {
                    serverSocket = new ServerSocket(8000);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                while (true) {
                    try {
                        socket = serverSocket.accept();
                    } catch (IOException e) {
                        System.out.println("I/O error: " + e);
                    }

                    inputStream = new DataInputStream(socket.getInputStream());
                    outputStream = new DataOutputStream(socket.getOutputStream());

                    messageIn = inputStream.readUTF();

                    String infoToBeAdded = messageIn;

                    String pre = infoToBeAdded;
                    String[] split = pre.split("/");
                    String vehicleID = split[0];
                    String make = split[1];
                    String model = split[2];
                    String year = split[3];
                    String timeIn = split[4];
                    String timeOut = split[5];
                    String status = split[6];

                    try {
                        connection = DriverManager.getConnection(url, username, password);

                        String sql = "INSERT INTO AllVehicles"
                                + "(VehicleID , Make, Model, Year, TimeIn, TimeOut, Status)"
                                + "VALUES ("
                                + Integer.parseInt(vehicleID)
                                + ",'" + make
                                + "','" + model
                                + "'," + Integer.parseInt(year)
                                + "," + Integer.parseInt(timeIn)
                                + "," + Integer.parseInt(timeOut)
                                + "," + status
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
