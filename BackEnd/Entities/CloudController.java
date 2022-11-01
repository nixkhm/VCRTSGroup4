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

public class CloudController {

      static ArrayList<Vehicle> pendingVehicles;
      ArrayList<Vehicle> approvedVehicles;

      VehicularCloud currentVehicularCloud;

      public CloudController() {
            try {
                  getAllVehApps("GUI/Transcripts/allVehicleApps.txt");
            } catch (IOException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
            }
      }

      public static void addToPendingVehicles(Vehicle in) {
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

      public void getAllVehApps(String filename)
                  throws IOException {
            try (Scanner in = new Scanner(new File(filename))) {
                  Scanner s = new Scanner(new File("GUI/Transcripts/allVehicleApps.txt"));
                  ArrayList<String> list = new ArrayList<String>();
                  while (s.hasNext()) {
                        list.add(s.next());
                  }
                  s.close();
                  for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i));
                  }

            }
      }
}
