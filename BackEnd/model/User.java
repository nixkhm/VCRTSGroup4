package BackEnd.model;

import java.util.Random;

public class User {

    private String name;
    private int userID;
    private String email;
    private int phone;
    private User entity;

    public User(String nameIn, String emailIn, int phoneIn, User entityIn) {
        name = nameIn;
        userID = new Random().nextInt(100);
        phone = phoneIn;
        entity = entityIn;
    }

    public String getName() {
        return name;
    }

    public int getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

    public User getEntity() {
        return entity;
    }
}