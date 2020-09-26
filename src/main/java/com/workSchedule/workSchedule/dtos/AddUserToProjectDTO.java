package com.workSchedule.workSchedule.dtos;

public class AddUserToProjectDTO {

	private Long projectId;
	private Long userId;
	
	public AddUserToProjectDTO() {}
	
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	
}
