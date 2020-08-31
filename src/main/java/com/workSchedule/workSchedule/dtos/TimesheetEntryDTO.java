package com.workSchedule.workSchedule.dtos;

import com.workSchedule.workSchedule.model.TimesheetEntry;

public class TimesheetEntryDTO {

	private Long id;
	private Integer day;
	private String task;
	private String description;
	private String startTime;
	private String endTime;
	private Integer position;
	private Boolean changed;
	
	public TimesheetEntryDTO() {}

	
	
	public TimesheetEntryDTO(TimesheetEntry tse) {
		super();
		this.id = tse.getId();
		this.day = tse.getDay();
		this.task = tse.getTask();
		this.description = tse.getDescription();
		this.startTime = tse.getStartTime();
		this.endTime = tse.getEndTime();
		this.position = tse.getPosition();
		this.changed = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
	public Boolean getChanged() {
		return changed;
	}



	public void setChanged(Boolean changed) {
		this.changed = changed;
	}



	public Integer getDay() {
		return day;
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
	
	
}
