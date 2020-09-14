package com.workSchedule.workSchedule.dtos;

public class ChangingUserDataDTO {

	private Long id;
	private Long projectId;
	private String title;
	
	public ChangingUserDataDTO() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}
