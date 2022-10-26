package BackEnd;

import java.util.Random;

import BackEnd.Entities.Owner;

public class Vehicle {

    private int vehicleID;
    private boolean inUse;
    private String make;
    private String model;
    private int year;
    private int timeStart;
    private int timeEnd;
    private Owner owner;

    public Vehicle(String makeIn, String modelIn, int yearIn, int startIn, int endIn, Owner ownerIn) {
        vehicleID = new Random().nextInt(100);
        inUse = false;
        make = makeIn;
        model = modelIn;
        year = yearIn;
        timeStart = startIn;
        timeEnd = endIn;
        owner = ownerIn;
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

}
