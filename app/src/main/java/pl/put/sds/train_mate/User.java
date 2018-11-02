package pl.put.sds.train_mate;

import java.util.ArrayList;

public class User {

    public String userID, firsName, lastName, pictureURL, gender;
    public ArrayList<String> sportTags;
    public Double latitude, longitude;
    public long age;

    public User(){

    }

    public User(String firsName, String lastName, String pictureURL, String gender, ArrayList<String> sportTags, Double latitude, Double longitude, long age) {
        this.userID = userID;
        this.firsName = firsName;
        this.lastName = lastName;
        this.pictureURL = pictureURL;
        this.gender = gender;
        this.sportTags = sportTags;
        this.latitude = latitude;
        this.longitude = longitude;
        this.age = age;
    }

    public User(String userID, String firsName, String lastName, String pictureURL, String gender, ArrayList<String> sportTags, Double latitude, Double longitude, long age) {
        this.userID = userID;
        this.firsName = firsName;
        this.lastName = lastName;
        this.pictureURL = pictureURL;
        this.gender = gender;
        this.sportTags = sportTags;
        this.latitude = latitude;
        this.longitude = longitude;
        this.age = age;
    }
}
