package com.ethioProject.Bean;


public class User {

	private int UserID;
	private String FirstName;
	private String LastName;
	private String Email;
	private String PhoneNo;
	private String Password;
	private String Location;
	private boolean is_admin;
	private boolean is_projectmanager;

	public boolean isIs_projectmanager() {
		return is_projectmanager;
	}

	public void setIs_projectmanager(boolean is_projectmanager) {
		this.is_projectmanager = is_projectmanager;
	}

	public boolean getIs_admin() {
		return is_admin;
	}
	public void setIs_admin(boolean is_admin) {
		this.is_admin = is_admin;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "User{" +
				"UserID=" + UserID +
				", FirstName='" + FirstName + '\'' +
				", LastName='" + LastName + '\'' +
				", Email='" + Email + '\'' +
				", PhoneNo='" + PhoneNo + '\'' +
				", Password='" + Password + '\'' +
				", Location='" + Location + '\'' +
				", is_admin=" + is_admin +
				", is_projectmanager=" + is_projectmanager +
				'}';
	}
}
