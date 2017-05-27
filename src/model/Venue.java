package model;
import java.util.*;
public class Venue {

    private final String venueName, venueAddr;
    private ArrayList<Date> isBooked;
    public Venue(String venueName, String venueAddr) {
        this.venueName = venueName;
        this.venueAddr = venueAddr;
    }
    public String getName() {
        return venueName;
    }
    public String getAddress() {
        return venueAddr;
    }
    public boolean isAvailable(Date d) {
        return (!isBooked.contains(d));
    }
    public void book(Date d) {
        if(!isBooked.contains(d))
            isBooked.add(d);
    }
    public void free(Date d) {
        if(isBooked.contains(d))
            isBooked.remove(d);
    }

}
