package com.workSchedule.workSchedule.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.workSchedule.workSchedule.enums.JobTitle;
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
	private Integer age;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;

	@Column
	private UserType userType;
	
	@Column
	private JobTitle jobTitle;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST, 
			CascadeType.REFRESH })
	private List<TimesheetEntry> timesheetEntries;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST, 
			CascadeType.REFRESH })
	private List<MorningMeeting> morningMeetings;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST, 
			CascadeType.REFRESH })
	private List<Task> tasks;
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	private Company company;
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	private Project project;
	
	public MyUser() {}
	
	public MyUser(String email, String password, String firstName, String lastName, UserType userType,
			JobTitle jobTitle,int age,Company company) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userType = userType;
		this.jobTitle = jobTitle;
		this.age = age;
		this.timesheetEntries = new ArrayList<TimesheetEntry>();
		this.morningMeetings = new ArrayList<MorningMeeting>();
		this.tasks = new ArrayList<Task>();
		this.company = company;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

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

	public List<MorningMeeting> getMorningMeetings() {
		return morningMeetings;
	}

	public void setMorningMeetings(List<MorningMeeting> morningMeetings) {
		this.morningMeetings = morningMeetings;
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

	public JobTitle getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	
}
