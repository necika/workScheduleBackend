package com.workSchedule.workSchedule.dtos;

import java.util.List;

import com.workSchedule.workSchedule.model.Company;
import com.workSchedule.workSchedule.model.MyUser;
import com.workSchedule.workSchedule.model.Project;

public class ProjectDTO {

	private Long id;
	private String name;
	private String description;
	private Company company;
	private List<MyUser> users;
	private String startDate;
	private String endDate;
	
	public ProjectDTO() {}
	
	public ProjectDTO(Project project) {
		this.id = project.getId();
		this.name = project.getName();
		this.description = project.getDescription();
		this.company = project.getCompany();
		this.users = project.getUsers();
		this.startDate = project.getStartDate();
		if(project.getEndDate() == null) {
			this.endDate = "";
		}else {
			this.endDate = project.getEndDate();
		}
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<MyUser> getUsers() {
		return users;
	}

	public void setUsers(List<MyUser> users) {
		this.users = users;
	}
	
}
