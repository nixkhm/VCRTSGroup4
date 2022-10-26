package BackEnd.Entities;

import BackEnd.Vehicle;

public class Owner extends User {

    private Vehicle vehicle;

    public Owner(String nameIn, String emailIn, int phoneIn, User entityIn, Vehicle vehicleIn) {
        super(nameIn, emailIn, phoneIn, entityIn);
        vehicle = vehicleIn;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

}
