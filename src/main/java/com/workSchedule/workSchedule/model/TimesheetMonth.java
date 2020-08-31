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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class TimesheetMonth {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	private String month;
	
	@Column
	private Long monthStamp;
	
	@JsonIgnore
	@OneToMany(mappedBy = "timesheetMonth", fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST, 
			CascadeType.REFRESH })
	private List<TimesheetEntry> timesheetEntries;

	public TimesheetMonth() {
		super();
	}

	public TimesheetMonth(String month,Long monthStamp) {
		this.month = month;
		this.monthStamp = monthStamp;
		this.timesheetEntries = new ArrayList<TimesheetEntry>();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Long getMonthStamp() {
		return monthStamp;
	}

	public void setMonthStamp(Long monthStamp) {
		this.monthStamp = monthStamp;
	}

	public List<TimesheetEntry> getTimesheetEntries() {
		return timesheetEntries;
	}

	public void setTimesheetEntries(List<TimesheetEntry> timesheetEntries) {
		this.timesheetEntries = timesheetEntries;
	}
	
	
	
}
