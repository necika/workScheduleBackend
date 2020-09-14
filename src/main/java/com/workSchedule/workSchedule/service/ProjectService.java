package com.workSchedule.workSchedule.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.workSchedule.workSchedule.dtos.AddProjectDTO;
import com.workSchedule.workSchedule.dtos.ProjectDTO;
import com.workSchedule.workSchedule.model.MyUser;
import com.workSchedule.workSchedule.model.Project;
import com.workSchedule.workSchedule.repository.ProjectRepository;
import com.workSchedule.workSchedule.repository.UserRepository;

@Service
public class ProjectService {

	@Autowired ProjectRepository projectRepo;
	
	@Autowired UserRepository userRepo;

	public ResponseEntity<List<ProjectDTO>> getAll(String email) {
		MyUser user = userRepo.findByEmail(email);
		if(user == null) {
			return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
		}
		List<Project> projects = projectRepo.findAll();
		if(projects == null) {
			return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<ProjectDTO>>(convertEntityToEntityDTO(projects,user.getCompany().getId()),HttpStatus.OK);
	}
	
	public ResponseEntity<ProjectDTO> saveProject(AddProjectDTO projectDTO, String email) {
		MyUser user = userRepo.findByEmail(email);
		if(user == null) {
			return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
		}
		Project project = new Project();
		project.setCompany(user.getCompany());
		project.setDescription(projectDTO.getDescription());
		project.setName(projectDTO.getName());
		project = projectRepo.save(project);
		List<MyUser> users = new ArrayList<MyUser>();
		for(Long id : projectDTO.getUsers()) {
			MyUser currUser = userRepo.getOneById(id);
			currUser.setProject(project);
			currUser = userRepo.save(currUser);
			users.add(currUser);
		}
		return new ResponseEntity<ProjectDTO>(new ProjectDTO(project),HttpStatus.OK);
	}
	
	
	private List<ProjectDTO> convertEntityToEntityDTO(List<Project> projects,Long id) {
		List<ProjectDTO> projectsDTO = new ArrayList<ProjectDTO>();
		for(Project p : projects) {
			if(p.getCompany().getId() == id) {
				projectsDTO.add(new ProjectDTO(p));
			}
		}
		return projectsDTO;
	}
	
}
