package com.workSchedule.workSchedule.dtos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.workSchedule.workSchedule.model.MorningMeeting;

public class MorningMeetingDTO {

	private Long id;
	private String yesterday;
	private String today;
	private String problems;
	private Long userId;
	private List<String> yesterdayTasks;
	private List<String> todayTasks;
	private List<String> problemTasks;
	
	public MorningMeetingDTO() {}
	
	public MorningMeetingDTO(MorningMeeting meeting) {
		this.id = meeting.getId();
		this.yesterday = meeting.getYesterday();
		this.today = meeting.getToday();
		this.problems = meeting.getProblems();
		this.userId = meeting.getUser().getId();
		if(meeting.getProblemTasksIds() != null) {
			String data = meeting.getProblemTasksIds().substring(1, meeting.getProblemTasksIds().length() - 1);
			String [] array = data.split(","); 
			this.problemTasks = Arrays.asList(array);
		}
		if(meeting.getTodayTasksIds() != null) {
			String data = meeting.getTodayTasksIds().substring(1, meeting.getTodayTasksIds().length() - 1);
			String [] array = data.split(","); 
			this.todayTasks = Arrays.asList(array);
		}
		if(meeting.getYesterdayTasksIds() != null) {
			String data = meeting.getYesterdayTasksIds().substring(1, meeting.getYesterdayTasksIds().length() - 1);
			String [] array = data.split(","); 
			this.yesterdayTasks = Arrays.asList(array);
		}
	}

	public Long getId() {
		return id;
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

	
	
	public List<String> getYesterdayTasks() {
		return yesterdayTasks;
	}

	public void setYesterdayTasks(List<String> yesterdayTasks) {
		this.yesterdayTasks = yesterdayTasks;
	}

	public List<String> getTodayTasks() {
		return todayTasks;
	}

	public void setTodayTasks(List<String> todayTasks) {
		this.todayTasks = todayTasks;
	}


	public List<String> getProblemTasks() {
		return problemTasks;
	}

	public void setProblemTasks(List<String> problemTasks) {
		this.problemTasks = problemTasks;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
