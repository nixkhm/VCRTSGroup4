import java.util.*;

public class OwnerCreation{
    private String ownerName;
    private String ownerMake;
    private String ownerModel;
    private Double ownerYear;

    public ownerCreation(private String ownerName, private String ownerMake, private String ownerModel, private double ownerYear,){
        this.ownerName = ownerName;
        this.ownerMake = ownerMake;
        this.ownerModel = ownerModel;
        this.ownerYear = ownerYear;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public String getOwnerMake(){
        return ownerMake;
    }

    public String getOwnerModel(){
        return ownerModel;
    }

    public double getOwnerYear(){
        return ownerYear;
    }
    
}