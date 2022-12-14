package BackEnd;

import java.util.Random;

public class Vehicle {

    private int vehicleID;
    private String make;
    private String model;
    private int year;
    private String timeStart;
    private String timeEnd;
    private String status;

    public Vehicle(int vehicleIDIn, String makeIn, String modelIn, int yearIn, String startIn, String endIn,
            String statusIn) {
        vehicleID = vehicleIDIn;
        make = makeIn;
        model = modelIn;
        year = yearIn;
        timeStart = startIn;
        timeEnd = endIn;
        status = statusIn;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public String getStatus() {
        return status;
    }

    public String toString() {
        return "Make: " + make + " / Model:" + model + " / Year:" + year + " / Time Start:" + timeStart + " / Time End:"
                + timeEnd + "/ Status:" + status;
    }

}
