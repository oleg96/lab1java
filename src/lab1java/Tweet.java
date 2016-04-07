package lab1java;

import java.util.Date;

public class Tweet {
    private double latitude;
    private double longitude;
    private Date date;
    private String message;
    public Tweet(double latitude, double longitude, Date date, String message) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
        this.message = message;
    }
    @Override
    public String toString() {
        return "Latitude: "+latitude+" | "+"Longitude: "+longitude+" | Date: "+date+" | Message: "+message;
    }
}
