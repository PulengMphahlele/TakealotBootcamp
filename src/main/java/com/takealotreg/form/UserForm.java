package com.takealotreg.form;

import javax.persistence.Column;


public class UserForm {
	
        private int userID;
	private String firstName;

	private String lastName;
	
	private String emailAddress;
        private String password;

	private String phone;
	
	private String gender;
        private String birthdate;

	

	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
        @Override
	public String toString() {
		return "User [userID=" + userID + ", firstName=" + firstName + ", birthdate="
                            + birthdate + ", phone=" + phone + ", emailAddress=" + emailAddress 
                            + ", gender=" + gender + ", lastName=" + lastName + "]";
	}
	

}
