package model;
import java.util.*;
public class Event {
    private int eventId;
    private String eventName, eventType, eventDesc;
    private Date start, end;
    private boolean isPublic;
    private ArrayList<Participant> invitationList;
    private ArrayList<Venue> eventLoc;
    
    public Event(int id, String name, String type, String desc, Date start, Date end){
    	this.eventId = id;
    	this.eventName = name;
    	this.eventType = type;
    	this.eventDesc = desc;
    	this.start = start;
    	this.end = end;
    }
    
    public int getId() {
        return eventId;
    }
    public String getName() {
        return eventName;
    }
    public String getType() {
        return eventType;
    }
    public String getDesc() {
        return eventDesc;
    }
    public Date getStartDate() {
        return start;
    }
    public Date getEndDate() {
        return end;
    }
    public long getDuration() {
        return ((end.getTime() - start.getTime()) / 1000);
    }
    public boolean isPublic() {
        return isPublic;
    }
    public ArrayList<Participant> getList() {
        return invitationList;
    }
    public ArrayList<Venue> getLoc() {
        return eventLoc;
    }
    public void setId(int eventId) {
        this.eventId = eventId;
    }
    public void setName(String eventName) {
        this.eventName = eventName;
    }
    public void setType(String eventType) {
        this.eventType = eventType;
    }
    public void setDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }
    public void setStartDate(Date start) {
        this.start = start;
    }
    public void setEndDate(Date end) {
        this.end = end;
    }
    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }
    public void addParticipant(String userEmail, int status) {
        Participant p = new Participant(eventId, userEmail, status);
        if(!invitationList.contains(p))
            invitationList.add(p);
    }
    public void removeParticipant(String userEmail) {
        for(Participant p:invitationList) {
            if(p.getEmail().equals(userEmail)) {
                invitationList.remove(p);
                break;
            }
        }
    }
    public void changeStatus(String userEmail, int status) {
        for(Participant p:invitationList) {
            if(p.getEmail().equals(userEmail)) {
                p.setStatus(status);
                break;
            }
        }
    }
    public void attend(String userEmail) {
        for(Participant p:invitationList) {
            if(p.getEmail().equals(userEmail)) {
                p.attend();
                break;
            }
        }
    }
    public void miss(String userEmail) {
        for(Participant p:invitationList) {
            if(p.getEmail().equals(userEmail)) {
                p.miss();
                break;
            }
        }
    }
    public void bookVenue(Venue v, Date d) {
        v.book(eventId, d);
        if(!eventLoc.contains(v))
            eventLoc.add(v);
    }
    public void freeVenue(String venueName) {
        for(Venue v:eventLoc) {
            if(v.getName().equalsIgnoreCase(venueName)) {
                v.free(eventId);
                eventLoc.remove(v);
                break;
            }
        }
    }
    @Override
    public boolean equals(Object o) {
        if(o != null && o instanceof Event) {
            Event e = (Event) o;
            return((e.getId() == eventId));
        }
        else
            return false;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.eventId;
        return hash;
    }
}