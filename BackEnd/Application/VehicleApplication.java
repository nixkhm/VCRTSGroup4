package BackEnd.Application;

import BackEnd.Vehicle;

public class VehicleApplication extends Application {

    private Application applicationInfo;
    private Vehicle vehicle;

    public VehicleApplication(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

}
