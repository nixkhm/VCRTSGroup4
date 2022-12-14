package BackEnd;

import java.util.Random;

public class Vehicle {

    private int vehicleID;
    private String make;
    private String model;
    private int year;
    private int timeStart;
    private int timeEnd;
    private String status;

    public Vehicle(int vehicleIDIn, String makeIn, String modelIn, int yearIn, int startIn, int endIn,
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

    public int getTimeStart() {
        return timeStart;
    }

    public int getTimeEnd() {
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
