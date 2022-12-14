package BackEnd.Entities;

import java.sql.*;

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
      private ArrayList<Vehicle> declinedVehicles;
      private ArrayList<Job> declinedJobs;

      public CloudController() {
            pendingVehicles = new ArrayList<Vehicle>();
            pendingJobs = new ArrayList<Job>();
            allVehicles = new ArrayList<Vehicle>();
            allJobs = new ArrayList<Job>();
            declinedVehicles = new ArrayList<Vehicle>();
            declinedJobs = new ArrayList<Job>();
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

      public ArrayList<Vehicle> getAllVehicles() {
            try {
                  connection = DriverManager.getConnection(url, username, password);
                  String sql = "SELECT * FROM AllVehicles WHERE STATUS = 1";
                  Statement statement = connection.createStatement();
                  ResultSet rs = statement.executeQuery(sql);

                  while (rs.next()) {
                        Vehicle newVeh = new Vehicle(rs.getInt("VehicleID"), rs.getString("make"),
                                    rs.getString("model"),
                                    rs.getInt("year"), rs.getString("timeIn"), rs.getString("timeOut"),
                                    rs.getString("status"));
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
                  String sql = "SELECT * FROM AllVehicles WHERE STATUS = 0";
                  Statement statement = connection.createStatement();
                  ResultSet rs = statement.executeQuery(sql);

                  while (rs.next()) {
                        Vehicle newVeh = new Vehicle(rs.getInt("VehicleID"), rs.getString("make"),
                                    rs.getString("model"),
                                    rs.getInt("year"), rs.getString("timeIn"), rs.getString("timeOut"),
                                    rs.getString("status"));
                        pendingVehicles.add(newVeh);
                  }
                  connection.close();
            } catch (SQLException e) {
                  e.getMessage();
            }
            return pendingVehicles;
      }

      public ArrayList<Job> getAllJobs() {
            try {
                  connection = DriverManager.getConnection(url, username, password);
                  String sql = "SELECT * FROM AllJobs WHERE Status = 1";
                  Statement statement = connection.createStatement();
                  ResultSet rs = statement.executeQuery(sql);

                  while (rs.next()) {
                        Job newJob = new Job(rs.getInt("JobID"), rs.getString("name"),
                                    rs.getString("type"),
                                    rs.getInt("duration"), rs.getString("deadline"), rs.getInt("status"));
                        allJobs.add(newJob);
                  }
                  connection.close();
            } catch (SQLException e) {
                  e.getMessage();
            }
            return allJobs;
      }

      public ArrayList<Job> getAllPendingJobs() {
            try {
                  connection = DriverManager.getConnection(url, username, password);
                  String sql = "SELECT * FROM AllJobs WHERE STATUS = 0";
                  Statement statement = connection.createStatement();
                  ResultSet rs = statement.executeQuery(sql);

                  while (rs.next()) {
                        Job newJob = new Job(rs.getInt("JobID"), rs.getString("name"),
                                    rs.getString("type"),
                                    rs.getInt("duration"), rs.getString("deadline"), rs.getInt("status"));
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
                  String sql = "UPDATE AllVehicles SET Status = 1 WHERE VEHICLEID=" + id;
                  Statement statement = connection.createStatement();
                  int row = statement.executeUpdate(sql);
                  connection.close();
            } catch (SQLException e1) {
                  e1.getMessage();
            }
      }

      public void declineVehicle(String id) {
            try {
                  connection = DriverManager.getConnection(url, username, password);
                  String sql = "UPDATE AllVehicles SET Status = 2 WHERE VEHICLEID=" + id;
                  Statement statement = connection.createStatement();
                  int row = statement.executeUpdate(sql);
                  connection.close();
            } catch (SQLException e1) {
                  e1.getMessage();
            }
      }

      public void acceptJob(String id) {
            try {
                  connection = DriverManager.getConnection(url, username, password);
                  String sql = "UPDATE AllJobs SET Status = 1 WHERE JOBID=" + id;
                  Statement statement = connection.createStatement();
                  int row = statement.executeUpdate(sql);
                  connection.close();
            } catch (SQLException e1) {
                  e1.getMessage();
            }
      }

      public void declineJob(String id) {
            try {
                  connection = DriverManager.getConnection(url, username, password);
                  String sql = "UPDATE AllJobs SET Status = 2 WHERE JOBID=" + id;
                  Statement statement = connection.createStatement();
                  int row = statement.executeUpdate(sql);
                  connection.close();
            } catch (SQLException e1) {
                  e1.getMessage();
            }
      }

      public ArrayList<Vehicle> getDeclinedVehicles() {
            try {
                  connection = DriverManager.getConnection(url, username, password);
                  String sql = "SELECT * FROM AllVehicles WHERE Status = 2";
                  Statement statement = connection.createStatement();
                  ResultSet rs = statement.executeQuery(sql);

                  while (rs.next()) {
                        Vehicle newVeh = new Vehicle(rs.getInt("VehicleID"), rs.getString("make"),
                                    rs.getString("model"),
                                    rs.getInt("year"), rs.getString("timeIn"), rs.getString("timeOut"),
                                    rs.getString("status"));
                        declinedVehicles.add(newVeh);
                  }
                  connection.close();
            } catch (SQLException e) {
                  e.getMessage();
            }
            for (Vehicle v : declinedVehicles)
                  System.out.println(v);
            return declinedVehicles;
      }

      public ArrayList<Job> getDeclinedJobs() {
            try {
                  connection = DriverManager.getConnection(url, username, password);
                  String sql = "SELECT * FROM AllJobs WHERE Status = 2";
                  Statement statement = connection.createStatement();
                  ResultSet rs = statement.executeQuery(sql);

                  while (rs.next()) {
                        Job newJob = new Job(rs.getInt("JobID"), rs.getString("name"),
                                    rs.getString("type"),
                                    rs.getInt("duration"), rs.getString("deadline"), rs.getInt("status"));
                        declinedJobs.add(newJob);
                  }
                  connection.close();
            } catch (SQLException e) {
                  e.getMessage();
            }
            for (Vehicle v : declinedVehicles)
                  System.out.println(v);
            return declinedJobs;
      }

      public String getFullJobTime() {
            int[] jobTimes = new int[allJobs.size()];
            jobTimes[0] = allJobs.get(0).getJobDuration();
            for (int i = 1; i < allJobs.size(); i++) {
                  jobTimes[i] = jobTimes[i - 1] + allJobs.get(i).getJobDuration();
            }
            String fullJobTime = Arrays.toString(jobTimes);
            return fullJobTime;
      }

      public String getAllJobIds() {
            int[] jobIds = new int[allJobs.size()];
            for (int i = 0; i < allJobs.size(); i++) {
                  jobIds[i] = allJobs.get(i).getJobID();
            }
            String allJobIds = Arrays.toString(jobIds);
            return allJobIds;
      }

      public void clearDeclinedVehicles() {
            try {
                  connection = DriverManager.getConnection(url, username, password);
                  String sql = "DELETE FROM AllVehicles WHERE STATUS = 2";
                  Statement statement = connection.createStatement();
                  int row = statement.executeUpdate(sql);
                  connection.close();
            } catch (SQLException e1) {
                  e1.getMessage();
            }
      }

      public void clearDeclinedJobs() {
            try {
                  connection = DriverManager.getConnection(url, username, password);
                  String sql = "DELETE FROM AllJobs WHERE STATUS = 2";
                  Statement statement = connection.createStatement();
                  int row = statement.executeUpdate(sql);
                  connection.close();
            } catch (SQLException e1) {
                  e1.getMessage();
            }
      }

}
