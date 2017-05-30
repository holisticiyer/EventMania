package model;
public class User {
    private String userEmail, userPassword;
    private String fName, lName;
    private String phone;
    private boolean isAdmin;
    
    public User(String userId, String email, String password, String firstName, String lastName,
			String phone) {

		this.userEmail = email;
		this.userPassword = password;
		this.fName = firstName;
		this.lName = lastName;
		this.phone = phone;

	}

    
    public User(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        setAdmin(false);
    }
    public String getEmail() {
        return userEmail;
    }
    public String getPassword() {
        return userPassword;
    }
    public String getName() {
        return (fName + " " + lName);
    }
    public String getFName() {
        return fName;
    }
    public String getLName() {
        return lName;
    }
    public String getPhone() {
        return phone;
    }
    public boolean isAdmin() {
        return isAdmin;
    }
    public void setEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public void setPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public void setName(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}