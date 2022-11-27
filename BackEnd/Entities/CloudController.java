package BackEnd.Entities;

import java.sql.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import BackEnd.*;

public class CloudController {

      static Connection connection = null;
      static String url = "jdbc:mysql://127.0.0.1:3306/VCRTSGroup4?user=root?useTimezone=true&serverTimezone=UTC";
      static String username = "root";
      static String password = "CUS1166VCRTSGROUP4";

      private ArrayList<Vehicle> pendingVehicles;
      private ArrayList<Job> pendingJobs;
      private ArrayList<Vehicle> allVehicles;
      private ArrayList<Job> allJobs;

      public CloudController() {
            pendingVehicles = new ArrayList<Vehicle>();
            pendingJobs = new ArrayList<Job>();
            allVehicles = new ArrayList<Vehicle>();
            allJobs = new ArrayList<Job>();
      }

      public void display() {
            System.out.println("-------------------------------------------------------");
            System.out.println("Vehicle Apps");
            if (pendingVehicles.size() == 0) {
                  System.out.println("none");
            }
            for (int i = 0; i < pendingVehicles.size(); i++) {
                  System.out.println(pendingVehicles.get(i).toString());
            }
            System.out.println("Job Apps");
            if (pendingJobs.size() == 0) {
                  System.out.println("none");
            }
            for (int i = 0; i < pendingJobs.size(); i++) {
                  System.out.println(pendingJobs.get(i).toString());
            }
            System.out.println("-------------------------------------------------------");
      }

      public void addToPendingVehicles(Vehicle in) {
            pendingVehicles.add(in);
      }

      public void clearPendingVehicles() {
            pendingVehicles.clear();
      }

      public void addToPendingJobs(Job in) {
            pendingJobs.add(in);
      }

      public void clearPendingJobs() {
            pendingJobs.clear();
      }

      public String getFullJobTime() {
            int[] jobTimes = new int[pendingJobs.size()];
            jobTimes[0] = pendingJobs.get(0).getJobDuration();
            for (int i = 1; i < pendingJobs.size(); i++) {
                  jobTimes[i] = jobTimes[i - 1] + pendingJobs.get(i).getJobDuration();
            }
            String fullJobTime = Arrays.toString(jobTimes);
            return fullJobTime;
      }

      public String getAllJobIds() {
            int[] jobIds = new int[pendingJobs.size()];
            for (int i = 0; i < pendingJobs.size(); i++) {
                  jobIds[i] = pendingJobs.get(i).getJobID();
            }
            String allJobIds = Arrays.toString(jobIds);
            return allJobIds;
      }

      public ArrayList<Vehicle> getAllVehicles() {
            try {
                  connection = DriverManager.getConnection(url, username, password);
                  String sql = "SELECT * FROM AllVehicles";
                  Statement statement = connection.createStatement();
                  ResultSet rs = statement.executeQuery(sql);

                  while (rs.next()) {
                        Vehicle newVeh = new Vehicle(rs.getInt("VehicleID"), rs.getString("make"),
                                    rs.getString("model"),
                                    rs.getInt("year"), rs.getInt("timeIn"), rs.getInt("timeOut"));
                        allVehicles.add(newVeh);
                  }
                  connection.close();
            } catch (SQLException e) {
                  e.getMessage();
            }
            return allVehicles;
      }

      public ArrayList<Vehicle> getAllPendingVehicles() {
            try {
                  connection = DriverManager.getConnection(url, username, password);
                  String sql = "SELECT * FROM PendingVehicleApplications";
                  Statement statement = connection.createStatement();
                  ResultSet rs = statement.executeQuery(sql);

                  while (rs.next()) {
                        Vehicle newVeh = new Vehicle(rs.getInt("VehicleID"), rs.getString("make"),
                                    rs.getString("model"),
                                    rs.getInt("year"), rs.getInt("timeIn"), rs.getInt("timeOut"));
                        pendingVehicles.add(newVeh);
                  }
                  connection.close();
            } catch (SQLException e) {
                  e.getMessage();
            }
            return pendingVehicles;
      }

      public ArrayList<Job> getAllPendingJobApps() {
            try {
                  connection = DriverManager.getConnection(url, username, password);
                  String sql = "SELECT * FROM PendingJobApplications";
                  Statement statement = connection.createStatement();
                  ResultSet rs = statement.executeQuery(sql);

                  while (rs.next()) {
                        Job newJob = new Job(rs.getInt("JobID"), rs.getString("name"),
                                    rs.getString("type"),
                                    rs.getInt("duration"), rs.getInt("deadline"));
                        pendingJobs.add(newJob);
                  }
                  connection.close();
            } catch (SQLException e) {
                  e.getMessage();
            }
            return pendingJobs;
      }

      public ArrayList<Job> getAllJobs() {
            try {
                  connection = DriverManager.getConnection(url, username, password);
                  String sql = "SELECT * FROM AllJobs";
                  Statement statement = connection.createStatement();
                  ResultSet rs = statement.executeQuery(sql);

                  while (rs.next()) {
                        Job newJob = new Job(rs.getInt("JobID"), rs.getString("name"),
                                    rs.getString("type"),
                                    rs.getInt("duration"), rs.getInt("deadline"));
                        pendingJobs.add(newJob);
                  }
                  connection.close();
            } catch (SQLException e) {
                  e.getMessage();
            }
            return pendingJobs;
      }

      public void acceptVehicle(String id) {
            try {
                  connection = DriverManager.getConnection(url, username, password);
                  String sql = "SELECT * FROM PendingVehicleApplications WHERE VEHICLEID=" + id;
                  Statement statement = connection.createStatement();
                  ResultSet rs = statement.executeQuery(sql);

                  while (rs.next()) {
                        sql = "INSERT INTO AllVehicles"
                                    + "(VehicleID , Make, Model, Year, TimeIn, TimeOut)"
                                    + "VALUES ("
                                    + rs.getInt("VehicleID")
                                    + ",'" + rs.getString("make")
                                    + "','" + rs.getString("model")
                                    + "'," + rs.getInt("year")
                                    + "," + rs.getInt("timeIn")
                                    + "," + rs.getInt("timeOut")
                                    + ")";

                        statement = connection.createStatement();
                        int row = statement.executeUpdate(sql);
                        if (row > 0)
                              System.out.println("Data was inserted!");
                        sql = "DELETE FROM PendingVehicleApplications WHERE VEHICLEID =" + id;
                        row = statement.executeUpdate(sql);
                        if (row > 0)
                              System.out.println("Data was DELETED!");
                  }
                  connection.close();
            } catch (SQLException e1) {
                  e1.getMessage();
            }
      }

      public void declineVehicle(String id) {
            try {
                  connection = DriverManager.getConnection(url, username, password);
                  String sql = "DELETE FROM PendingVehicleApplications WHERE VEHICLEID=" + id;
                  Statement statement = connection.createStatement();
                  int row = statement.executeUpdate(sql);
                  connection.close();
            } catch (SQLException e1) {
                  e1.getMessage();
            }
      }

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

                              try {
                                    connection = DriverManager.getConnection(url, username, password);

                                    String sql = "INSERT INTO PendingVehicleApplications"
                                                + "(VehicleID , Make, Model, Year, TimeIn, TimeOut)"
                                                + "VALUES ("
                                                + Integer.parseInt(vehicleID)
                                                + ",'" + make
                                                + "','" + model
                                                + "'," + Integer.parseInt(year)
                                                + "," + Integer.parseInt(timeIn)
                                                + "," + Integer.parseInt(timeOut)
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