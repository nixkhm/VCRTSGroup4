package BackEnd.Entities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.*;
import BackEnd.*;
import BackEnd.Application.*;
import BackEnd.model.Job;

public class CloudController {

      private ArrayList<Vehicle> pendingVehicles;
      private ArrayList<Vehicle> approvedVehicles;

      private VehicularCloud currentVehicularCloud;

      public CloudController() {

            pendingVehicles = new ArrayList<Vehicle>();
            try {
                  getAllVehApps();
            } catch (IOException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
            }
      }

      public void addToPendingVehicles(Vehicle in) {
            pendingVehicles.add(in);
            System.out.println("Vehicle Added!");
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

      public ArrayList<Vehicle> getAllVehApps()
                  throws IOException {
                  Scanner s = new Scanner(new File("GUI/Transcripts/allVehicleApps.txt"));
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

            for (int i = 0; i < pendingVehicles.size(); i++) {
                  System.out.println(pendingVehicles.get(i).toString());
            }

            return pendingVehicles;
      }
}
