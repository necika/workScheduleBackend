package com.workSchedule.workSchedule.dtos;

import com.workSchedule.workSchedule.model.MorningMeeting;

public class MorningMeetingDTO {

	private Long id;
	private String yesterday;
	private String today;
	private String problems;
	private Long userId;
	
	public MorningMeetingDTO() {}
	
	public MorningMeetingDTO(MorningMeeting meeting) {
		this.id = meeting.getId();
		this.yesterday = meeting.getYesterday();
		this.today = meeting.getToday();
		this.problems = meeting.getProblems();
		this.userId = meeting.getUser().getId();
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
