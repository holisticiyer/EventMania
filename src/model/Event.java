package model;

import java.util.ArrayList;
import java.util.Date;

public class Event {
	
	private int eventId;
    private String eventName, eventType, eventDesc;
    private Date start, end;
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
    public Event(String userEmail, Venue v) {
        Participant p = new Participant(eventId, userEmail, 1);
        p.attend();
        invitationList.add(p);
        eventLoc.add(v);
    }
    public int getID() {
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
    public ArrayList<Participant> getList() {
        return invitationList;
    }
    public ArrayList<Venue> getLoc() {
        return eventLoc;
    }
    public void setID(int eventId) {
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

}
