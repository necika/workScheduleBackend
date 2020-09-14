package com.workSchedule.workSchedule.dtos;

import java.util.List;

public class AddProjectDTO {

	private String name;
	private String description;
	private List<Long> users;
	private Long teamLeader;
	
	public AddProjectDTO() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Long> getUsers() {
		return users;
	}

	public void setUsers(List<Long> users) {
		this.users = users;
	}

	public Long getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(Long teamLeader) {
		this.teamLeader = teamLeader;
	}
	
}
