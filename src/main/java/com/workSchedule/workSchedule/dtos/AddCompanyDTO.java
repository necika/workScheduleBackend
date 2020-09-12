package com.workSchedule.workSchedule.dtos;

public class AddCompanyDTO {

	private String companyName;
	private String companyDescription;
	private String username;
	private String firstName;
	private String lastName;
	private String password;
	private int age;
	
	public AddCompanyDTO() {}

	public String getCompanyName() {
		return companyName;
	}

	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyDescription() {
		return companyDescription;
	}

	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
