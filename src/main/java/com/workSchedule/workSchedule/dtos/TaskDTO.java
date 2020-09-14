package com.workSchedule.workSchedule.dtos;

import com.workSchedule.workSchedule.enums.TaskStatus;
import com.workSchedule.workSchedule.model.MyUser;
import com.workSchedule.workSchedule.model.Task;

public class TaskDTO {

	private Long id;
	private String name;
	private String description;
	private TaskStatus status;
	private MyUser user;
	
	public TaskDTO() {}
	
	public TaskDTO(Task t) {
		this.id = t.getId();
		this.name = t.getName();
		this.description = t.getDescription();
		this.status = t.getStatus();
		this.user = t.getUser();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}
	
}
