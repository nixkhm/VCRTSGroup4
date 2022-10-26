package BackEnd.Entities;
import java.util.*;
import BackEnd.*;
import BackEnd.Application.*;

public class CloudController {
      Queue<VehicleApplication> pendingVehicleApps;
      Queue<JobApplication> pendingJobApps;
      VehicularCloud currentVehicularCloud;
      public void approveVehicle(VehicleApplication application, Vehicle vehicle){

      }
      public void denyVehicle(VehicleApplication application, Vehicle vehicle){

      }
      public void assignJobToVehicle(JobApplication jApplication, Job job, Vehicle vehicle){

      }
      public void denyJob(JobApplication job){

      }
      public VehicularCloud getVehicularCloud(){
             return currentVehicularCloud;
      }
}
