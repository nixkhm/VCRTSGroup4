public class RenterCreation {
        
    private String renterName;
    private String renterMake;
    private String renterModel;
    private Double renterYear;

    public RenterCreation(String renterName, String renterMake, String renterModel, double renterYear) {
        this.renterName = renterName;
        this.renterMake = renterMake;
        this.renterModel = renterModel;
        this.renterYear = renterYear;
    }

    public String getOwnerName() {
        return renterName;
    }

    public String getOwnerMake() {
        return renterMake;
    }

    public String getOwnerModel() {
        return renterModel;
    }

    public double getOwnerYear() {
        return renterYear;
    }
}
