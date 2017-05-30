package model;

import java.io.*;
import java.net.URL;
import java.util.*;

import service.DisplayEventService;
import service.LoginService;
import service.NewEventService;
import util.HibernateUtil;
import controller.NewEventServlet;
/*
 * Apparently you have to have a constructor and pass in objects of User, Event, Participant, and Venue
 * Otherwise, how would you know which one is the current object
 * OR you have to pass in the request (from jsp page) in order to obtain the current object. 
 */
public class EventManagerBean implements Serializable {

	private User thisUser, user;
	private List<Event> listOfEvents;
	private Event thisEvent;
	private Participant thisParticipant;
	private ArrayList<Venue> listOfVenues;
	private Venue thisVenue;
	private Iterator<Event> e;
	private Iterator<Venue> v;

	public boolean nextEvent() {
		if (e == null && listOfEvents != null)
			e = listOfEvents.iterator();
		if (e != null && e.hasNext()) {
			thisEvent = (Event) e.next();
			return true;
		} else {
			e = null;
			return false;
		}
	}

	public boolean nextVenue() {
		if (v == null && listOfVenues != null)
			v = listOfVenues.iterator();
		if (v != null && v.hasNext()) {
			thisVenue = (Venue) v.next();
			return true;
		} else {
			v = null;
			return false;
		}
	}

	/*
	 * This method is to verify if the input match any record in the database.
	 * If yes, then create an User object with info. pulled off from database
	 */
	public boolean getThisUser(String userEmail, String userPassword) {

		boolean isSucceeded = false;
		LoginService loginService = new LoginService();
		isSucceeded = loginService.authenticateUser(userEmail, userPassword);
		user = loginService.getUserByUserEmail(userEmail);
		// This is nonsense because thisUser is the user object from database.
		// But since this method doesn't return a user,
		// there is probably no way to call this user object outside this class.
		// I'm gonna do it anyway.
		thisUser.setName(user.getFName(), user.getLName());
		thisUser.setPassword(user.getPassword());
		thisUser.setEmail(user.getEmail());
		thisUser.setPhone(user.getPhone());
		thisUser.setAdmin(user.isAdmin());
		return isSucceeded;
	}

	public String thisUserEmail() {
		return thisUser.getEmail();
	}

	/*
	 * update the current user email
	 */
	public void thisUserEmail(String userEmail) {
		// connect to database
		String currentEmail = thisUser.getEmail();
		LoginService loginService = new LoginService();
		thisUser = loginService.getUserByUserEmail(userEmail);
		thisUser.setEmail(userEmail);
	}

	public String thisUserPassword() {
		return thisUser.getPassword();
	}
/*
 * Update user password
 */
	public void thisUserPassword(String userPassword) {
		// connect to database
		String password = thisUser.getPassword();
		String email = thisUser.getEmail();
		LoginService loginService = new LoginService();
		thisUser = loginService.getUserByUserEmail(email);
		thisUser.setPassword(userPassword);
	}

	public String thisUserName() {
		return (thisUser.getFName() + " " + thisUser.getLName());
	}
/*
 * Update user first name, and last name
 */
	public void thisUserName(String fName, String lName) {
		// connect to database
		//I'm going to call UserService to handle the update
		thisUser.setName(fName, lName);
	}

	public String thisUserFName() {
		return thisUser.getFName();
	}

	public String thisUserLName() {
		return thisUser.getLName();
	}

	public String thisUserPhone() {
		return thisUser.getPhone();
	}

	public void thisUserPhone(String phone) {
		// connect to database
		thisUser.setPhone(phone);
	}

	public boolean isAdmin() {
		return thisUser.isAdmin();
	}

	public void setAdmin(boolean isAdmin) {
		// connect to database
		thisUser.setAdmin(isAdmin);
	}

	public void getAllEvents() {
		// connect to database
		// load all events into listOfEvents
	}

	public void getMyEvents() {
		// connect to database
		// load my events into listOfEvents
	}

	/*
	 * This method is used to add a new event to the database, by invoking
	 * NewEventServlet
	 */
	public void addEvent() {

		// event servlet takes care of getting parameters from web page, and
		// store it in database
		// I am using java.net.URL and java.net.URLConnection classes to invoke
		// the servlet
		try {
			// Change the URL according to your own url link. Your port number
			// might be different
			URL url = new URL("http://localhost:8090/EventMania/NewEventServlet");

		} catch (Exception e) {
			e.printStackTrace();
		}

		// thisEvent = new Event();
		// thisEvent.setId((int) (Math.random() * 10000));
		// thisEvent.setName("Event Name");
		// thisEvent.setType("Event Type");
		// thisEvent.setDesc("Event Description");
		// thisEvent.setStartDate(new Date());
		// thisEvent.setEndDate(new Date((new Date()).getTime() + 86400));
		// thisEvent.addParticipant(thisUser.getEmail(), 1);
		// thisEvent.bookVenue(thisVenue, new Date());
		// listOfEvents.add(thisEvent);
		// connect to database
	}

	/*
	 * Remove an event with specified ID
	 */
	public void removeEvent(int eventId) {
		//DisplayEventService takes care of pulling off all the events from database
		DisplayEventService displayService = new DisplayEventService();
		listOfEvents = displayService.getListOfEvents();
		for (Event e : listOfEvents) {
			if (e.getId() == eventId) {
				listOfEvents.remove(e);
				break;
			}
		}
	}

	public void getThisEvent(int eventID) {
		for (Event e : listOfEvents) {
			if (e.getId() == eventID) {
				thisEvent = e;
				break;
			}
		}
	}

	public int thisEventId() {
		return thisEvent.getId();
	}

	public void thisEventId(int eventId) {
		// connect to database
		HibernateUtil util = new HibernateUtil();
		util.openSession();
		thisEvent.setId(eventId);
	}

	public String thisEventName() {
		return thisEvent.getName();
	}

	public void thisEventName(String eventName) {
		// connect to database
		thisEvent.setName(eventName);
	}

	public String thisEventType() {
		return thisEvent.getType();
	}

	public void thisEventType(String eventType) {
		// connect to database
		thisEvent.setName(eventType);
	}

	public String thisEventDesc() {
		return thisEvent.getDesc();
	}

	public void thisEventDesc(String eventDesc) {
		// connect to database
		thisEvent.setDesc(eventDesc);
	}

	public Date thisEventStartDate() {
		return thisEvent.getStartDate();
	}

	public void thisEventStartDate(Date start) {
		// connect to database
		thisEvent.setStartDate(start);
	}

	public Date thisEventEndDate() {
		return thisEvent.getEndDate();
	}

	public void thisEventEndDate(Date end) {
		// connect to database
		thisEvent.setEndDate(end);
	}

	public long thisEventDuration() {
		return thisEvent.getDuration();
	}

	public boolean isPublic() {
		return thisEvent.isPublic();
	}

	public void setPublic(boolean isPublic) {
		// connect to database
		thisEvent.setPublic(isPublic);
	}

	public void addParticipant(String userEmail, int status) {
		// connect to database
		thisEvent.addParticipant(userEmail, status);
	}

	public void removeParticipant(String userEmail) {
		// connect to database
		thisEvent.removeParticipant(userEmail);
	}

	public void changeStatus(String userEmail, int status) {
		// connect to database
		thisEvent.changeStatus(userEmail, status);
	}

	public void attend() {
		// connect to database
		thisEvent.attend(thisUser.getEmail());
	}

	public void miss() {
		// connect to database
		thisEvent.miss(thisUser.getEmail());
	}

	public void addVenue(Date d) {
		// connect to database
		thisEvent.bookVenue(thisVenue, d);
	}

	public void removeVenue(String venueName) {
		// connect to database
		thisEvent.freeVenue(venueName);
	}

	public void getMyParticipants() {
		// connect to database
	}

	public void getThisParticipant(String userEmail) {
		for (Participant p : thisEvent.getList()) {
			if ((p.getEventId() == thisEvent.getId()) && (p.getEmail().equalsIgnoreCase(userEmail))) {
				thisParticipant = p;
				break;
			}
		}
	}

	public int thisParticipantId() {
		return thisParticipant.getEventId();
	}

	public String thisParticipantEmail() {
		return thisParticipant.getEmail();
	}

	public boolean isOrganizer() {
		return thisParticipant.isOrganizer();
	}

	public boolean isParticipant() {
		return thisParticipant.isParticipant();
	}

	public boolean isGuest() {
		return thisParticipant.isGuest();
	}

	public boolean isAttending() {
		return thisParticipant.isAttending();
	}

	public void setStatus(int status) {
		// connect to database
		thisParticipant.setStatus(status);
	}

	public void getAllVenues() {
		// connect to database
	}

	public void getMyVenues() {
		// connect to database
		// load my venues into listOfVenues
	}

	public void addNewVenue(String venueName, String venueAddr) {
		// connect to database
		Venue v = new Venue(venueName, venueAddr);
		if (!listOfVenues.contains(v))
			listOfVenues.add(v);
	}

	public void removeVenue() {
		// connect to database
		for (Venue v : listOfVenues) {
			if (v.getName().equalsIgnoreCase(thisVenue.getName())) {
				listOfVenues.remove(v);
				break;
			}
		}
	}

	public void getThisVenue(String venueName) {
		for (Venue v : thisEvent.getLoc()) {
			if (v.getName().equalsIgnoreCase(venueName)) {
				thisVenue = v;
				break;
			}
		}
	}

	public String thisVenueName() {
		return thisVenue.getName();
	}

	public String thisVenueAddress() {
		return thisVenue.getAddress();
	}

	public Date getDate() {
		return thisVenue.get(thisEvent.getId());
	}

	public boolean isAvailable(Date d) {
		return (thisVenue.isAvailable(d));
	}

	public void thisVenueBook(Date d) {
		// connect to database
		thisVenue.book(thisEvent.getId(), d);
	}

	public void thisVenueFree(Date d) {
		// connect to database
		thisVenue.free(d);
	}

	public void thisVenueFree(int eventId) {
		// connect to database
		thisVenue.free(eventId);
	}
}