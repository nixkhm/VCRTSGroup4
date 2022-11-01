package BackEnd.Application;

public class Application {

    private boolean approvedApplication;

    public Application() {
        approvedApplication = false;
    }

    public Application getVehicleApplications(VehicleApplication vehicleApplication) {
        return vehicleApplication;
    }

    public Application getJobApplications(JobApplication jobApplication) {
        return jobApplication;
    }
}
