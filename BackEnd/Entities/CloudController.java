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

      private ArrayList<Vehicle> pendingVehicles;
      private ArrayList<Job> pendingJobs;

      public CloudController() {
            pendingVehicles = new ArrayList<Vehicle>();
            pendingJobs = new ArrayList<Job>();

            try {
                  getAllPendingVehicles();
            } catch (IOException e) {
                  e.printStackTrace();
            }

            try {
                  getAllPendingJobApps();
            } catch (IOException e) {
                  e.printStackTrace();
            }

            display();

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

      public ArrayList<Vehicle> getAllVehicles()
                  throws IOException {
            clearPendingVehicles();
            Scanner s = new Scanner(new File("GUI/Transcripts/allVehicles.txt"));
            ArrayList<String> list = new ArrayList<String>();
            while (s.hasNext()) {
                  list.add(s.next());
            }
            s.close();
            for (int i = 0; i < list.size(); i++) {

                  String pre = list.get(i);
                  String[] split = pre.split("/");
                  String make = split[0];
                  String model = split[1];
                  String yearStr = split[2];
                  String inStr = split[3];
                  String outStr = split[4];

                  Vehicle newVeh = new Vehicle(make, model, Integer.parseInt(yearStr), Integer.parseInt(inStr),
                              Integer.parseInt(outStr));
                  addToPendingVehicles(newVeh);
            }
            return pendingVehicles;
      }

      public ArrayList<Vehicle> getAllPendingVehicles()
                  throws IOException {
            clearPendingVehicles();
            Scanner s = new Scanner(new File("GUI/Transcripts/allPendingVehicleApps.txt"));
            ArrayList<String> list = new ArrayList<String>();
            while (s.hasNext()) {
                  list.add(s.next());
            }
            s.close();
            for (int i = 0; i < list.size(); i++) {

                  String pre = list.get(i);
                  String[] split = pre.split("/");
                  String make = split[0];
                  String model = split[1];
                  String yearStr = split[2];
                  String inStr = split[3];
                  String outStr = split[4];

                  Vehicle newVeh = new Vehicle(make, model, Integer.parseInt(yearStr), Integer.parseInt(inStr),
                              Integer.parseInt(outStr));
                  addToPendingVehicles(newVeh);
            }
            for (Vehicle v : pendingVehicles)
                  System.out.println(v);
            return pendingVehicles;
      }

      public ArrayList<Job> getAllPendingJobApps()
                  throws IOException {
            clearPendingJobs();
            Scanner s = new Scanner(new File("GUI/Transcripts/allPendingJobApps.txt"));
            ArrayList<String> list = new ArrayList<String>();
            while (s.hasNext()) {
                  list.add(s.next());
            }
            s.close();
            for (int i = 0; i < list.size(); i++) {

                  String pre = list.get(i);
                  String[] split = pre.split("/");
                  String name = split[0];
                  String type = split[1];
                  String duration = split[2];
                  String deadline = split[3];
                  String ID = split[4];

                  Job newJob = new Job(name, type, Integer.parseInt(duration), Integer.parseInt(deadline),
                              Integer.parseInt(ID));
                  addToPendingJobs(newJob);
            }
            for (Job j : pendingJobs)
                  System.out.println(j);
            return pendingJobs;

      }

      static ServerSocket serverSocket;
      static Socket socket;
      static DataInputStream inputStream;
      static DataOutputStream outputStream;

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