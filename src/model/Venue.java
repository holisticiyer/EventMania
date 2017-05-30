package model;
import java.util.*;
public class Venue {
    private final String venueName, venueAddr;
    private ArrayList<Date> dateBooked;
    private ArrayList<Integer> eventBooked;
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
    public Date get(int eventId) {
        if(eventBooked.contains(eventId))
            return dateBooked.get(eventBooked.indexOf(eventId));
        else
            return null;
    }
    public boolean isAvailable(Date d) {
        return (!dateBooked.contains(d));
    }
    public void book(int eventId, Date d) {
        if(!dateBooked.contains(d)) {
            eventBooked.add(eventId);
            dateBooked.add(d);
        }
    }
    public void free(Date d) {
        if(dateBooked.contains(d)) {
            eventBooked.remove(dateBooked.indexOf(d));
            dateBooked.remove(d);
        }
    }
    public void free(int eventId) {
        for(int id:eventBooked) {
            if(id == eventId) {
                dateBooked.remove(eventBooked.indexOf(id));
                eventBooked.remove(id);
            }
        }
    }
    @Override
    public boolean equals(Object o) {
        if(o != null && o instanceof Venue) {
            Venue v = (Venue) o;
            return(v.getName().equalsIgnoreCase(venueName));
        }
        else
            return false;
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.venueName);
        return hash;
    }
}