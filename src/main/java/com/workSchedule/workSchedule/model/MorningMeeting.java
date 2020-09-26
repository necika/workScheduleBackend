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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class MorningMeeting {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	private String yesterday;
	
	@Column
	private String today;
	
	@Column
	private String problems;
	
	@Column
	private Long dateStamp;
	
	@Column
	private String yesterdayTasksIds;
	
	@Column
	private String todayTasksIds;
	
	@Column
	private String problemTasksIds;
	
	@JsonIgnore
	@ManyToMany(cascade = {
	        CascadeType.PERSIST,
	        CascadeType.MERGE})
	@JoinTable(name = "meeting_task",
	        joinColumns = @JoinColumn(name = "meeting_id"),
	        inverseJoinColumns = @JoinColumn(name = "task_id"))
	private List<Task> tasks = new ArrayList<Task>();
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	private MyUser user;
	
	public MorningMeeting() {}

	public Long getId() {
		return id;
	}
	
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	public String getYesterdayTasksIds() {
		return yesterdayTasksIds;
	}

	public void setYesterdayTasksIds(String yesterdayTasksIds) {
		this.yesterdayTasksIds = yesterdayTasksIds;
	}

	public String getTodayTasksIds() {
		return todayTasksIds;
	}

	public void setTodayTasksIds(String todayTasksIds) {
		this.todayTasksIds = todayTasksIds;
	}

	public String getProblemTasksIds() {
		return problemTasksIds;
	}

	public void setProblemTasksIds(String problemTasksIds) {
		this.problemTasksIds = problemTasksIds;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getYesterday() {
		return yesterday;
	}

	public void setYesterday(String yesterday) {
		this.yesterday = yesterday;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

	public String getProblems() {
		return problems;
	}

	public void setProblems(String problems) {
		this.problems = problems;
	}

	public Long getDateStamp() {
		return dateStamp;
	}

	public void setDateStamp(Long dateStamp) {
		this.dateStamp = dateStamp;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}
	
	
}