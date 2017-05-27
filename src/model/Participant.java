package model;

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
	public boolean isOrganizer() {
		return isOrganizer;
	}
	public void setOrganizer(boolean isOrganizer) {
		this.isOrganizer = isOrganizer;
	}
	public boolean isParticipant() {
		return isParticipant;
	}
	public void setParticipant(boolean isParticipant) {
		this.isParticipant = isParticipant;
	}
	public boolean isGuest() {
		return isGuest;
	}
	public void setGuest(boolean isGuest) {
		this.isGuest = isGuest;
	}
	public boolean isAttending() {
		return isAttending;
	}
	public void setAttending(boolean isAttending) {
		this.isAttending = isAttending;
	}
	public int getEventId() {
		return eventId;
	}
	public String getUserEmail() {
		return userEmail;
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

}
