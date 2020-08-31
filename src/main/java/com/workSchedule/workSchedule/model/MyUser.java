package com.workSchedule.workSchedule.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.workSchedule.workSchedule.enums.UserType;

@Entity
@Table
public class MyUser {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	private String email;
	 
	@Column
	private String password;

	@Column
	private UserType userType;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST, 
			CascadeType.REFRESH })
	private List<TimesheetEntry> timesheetEntries;
	
	public MyUser() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public List<TimesheetEntry> getTimesheetEntries() {
		return timesheetEntries;
	}

	public void setTimesheetEntries(List<TimesheetEntry> timesheetEntries) {
		this.timesheetEntries = timesheetEntries;
	}
	
	
}
