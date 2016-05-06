package lab1java;

import java.util.Calendar;
import java.util.Date;
/**
 * Define class which contains information about tweet
 * @see Double
 * @see Date
 * @see String
 * @author Oleg Fedorov
 */
public class Tweet {
    /**
     * Class constructor
     */
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
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public String getMessage() {
        return message;
    }
    public Date getDate() {
        return date;
    }
}
