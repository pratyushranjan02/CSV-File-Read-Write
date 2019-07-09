package com.solution;

public class MainCSV {
	
	//All are not encapsulated because we are using the constructor in another class
	String firstName;
	String lastName;
	String company;
	String address;
	String city;
	String country;
	String state;
	int zip;
	int phone1;
	int phone;
	String email;
	String subject;
	String emailBody;
	
	
	//getters and setters methods for the required fields
	public String getFirstName() {
		return firstName;
	}

	public String getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	

}
