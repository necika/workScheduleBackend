package com.workSchedule.workSchedule.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.workSchedule.workSchedule.dtos.TimesheetEntryDTO;

@Entity
@Table
public class TimesheetEntry {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	private Integer day;
	
	@Column
	private String task;
	
	@Column
	private String description;
	
	@Column
	private String startTime;
	
	@Column
	private String endTime;
	
	@Column
	private Integer minutes;
	
	@Column
	private Integer position;
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	private TimesheetMonth timesheetMonth;
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	private MyUser user;

	public TimesheetEntry() {}
	
	public TimesheetEntry(TimesheetEntryDTO tsDTO,TimesheetMonth tsMonth,MyUser user) {
		super();
		this.id = tsDTO.getId();
		this.day = tsDTO.getDay();
		this.task = tsDTO.getTask();
		this.description = tsDTO.getDescription();
		this.startTime = tsDTO.getStartTime();
		this.endTime = tsDTO.getEndTime();
		this.position = tsDTO.getPosition();
		this.timesheetMonth = tsMonth;
		this.user = user;
		setMinutes(tsDTO.getStartTime());
	}

	public Long getId() {
		return id;
	}

	
	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDay() {
		return day;
	}

	
	public Integer getMinutes() {
		String[] array = startTime.split(":");
		return Integer.parseInt(array[0])*60 + Integer.parseInt(array[1]);
	}

	public void setMinutes(String startTime) {
		String[] array = startTime.split(":");
		Integer minutes = Integer.parseInt(array[0])*60 + Integer.parseInt(array[1]);
		this.minutes = minutes;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public TimesheetMonth getTimesheetMonth() {
		return timesheetMonth;
	}

	public void setTimesheetMonth(TimesheetMonth timesheetMonth) {
		this.timesheetMonth = timesheetMonth;
	}
	
}
