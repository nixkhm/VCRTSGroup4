package BackEnd;

import java.util.Random;

import BackEnd.model.Owner;

public class Vehicle {

    private int vehicleID;
    private boolean inUse;
    private String make;
    private String model;
    private int year;
    private int timeStart;
    private int timeEnd;
    private boolean approved;
    private Owner owner;

    public Vehicle(int vehicleIDIn, String makeIn, String modelIn, int yearIn, int startIn, int endIn) {
        vehicleID = vehicleIDIn;
        make = makeIn;
        model = modelIn;
        year = yearIn;
        timeStart = startIn;
        timeEnd = endIn;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public boolean getInUseStatus() {
        return inUse;
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

    public Owner getOwner() {
        return owner;
    }

    public void approveVehicle() {
        approved = true;
    }

    public String toString() {
        return "Make: " + make + " / Model:" + model + " / Year:" + year + " / Time Start:" + timeStart + " / Time End:"
                + timeEnd;
    }

}
