package model;
import java.util.Objects;
public class Participant {
    private final int eventId;
    private final String userEmail;
    private boolean isOrganizer, isParticipant, isGuest, isAttending;
    public Participant(int eventId, String userEmail, int status) {
        this.eventId = eventId;
        this.userEmail = userEmail;
        noStatus();
        setStatus(status);
        miss();
    }
    public int getEventId() {
        return eventId;
    }
    public String getEmail() {
        return userEmail;
    }
    public boolean isOrganizer() {
        return isOrganizer;
    }
    public boolean isParticipant() {
        return isParticipant;
    }
    public boolean isGuest() {
        return isGuest;
    }
    public boolean isAttending() {
        return isAttending;
    }
    private void noStatus() {
        isOrganizer= false;
        isParticipant= false;
        isGuest= false;
    }
    public void setStatus(int status) {
        noStatus();
        switch(status) {
            case 1: isOrganizer = true; break;
            case 2: isParticipant = true; break;
            case 3: isGuest = true;
        }
    }
    public void attend() {
        isAttending = true;
    }
    public void miss() {
        isAttending = false;
    }
    @Override
    public boolean equals(Object o) {
        if(o != null && o instanceof Participant) {
            Participant p = (Participant) o;
            return((p.getEmail().equals(userEmail) && (p.getEventId() == eventId)));
        }
        else
            return false;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.eventId;
        hash = 23 * hash + Objects.hashCode(this.userEmail);
        return hash;
    }
}