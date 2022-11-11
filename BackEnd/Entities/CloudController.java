package BackEnd.Entities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.*;
import BackEnd.*;
import BackEnd.Application.*;

public class CloudController {

      private ArrayList<Vehicle> pendingVehicles;
      private ArrayList<Job> pendingJobs;

      private VehicularCloud currentVehicularCloud;
      
      public CloudController() {
            pendingVehicles = new ArrayList<Vehicle>();
            pendingJobs = new ArrayList<Job>();

            try {
                  getAllVehApps();
            } catch (IOException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
            }

            try {
                  getAllJobApps();
            } catch (IOException e) {
                  // TODO Auto-generated catch block
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

      public void approveVehicle(VehicleApplication application, Vehicle vehicle) {
               
      }

      public void denyVehicle(VehicleApplication application, Vehicle vehicle) {

      }

      public void assignJobToVehicle(JobApplication jApplication, Job job, Vehicle vehicle) {

      }

      public void denyJob(JobApplication job) {

      }

      public VehicularCloud getVehicularCloud() {
            return currentVehicularCloud;
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

      public ArrayList<Vehicle> getAllVehApps()
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
            return pendingVehicles;
      }

      public ArrayList<Job> getAllJobApps()
                  throws IOException {
            clearPendingJobs();
            Scanner s = new Scanner(new File("GUI/Transcripts/allPendingJobsApps.txt"));
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
            return pendingJobs;
      }
     
}