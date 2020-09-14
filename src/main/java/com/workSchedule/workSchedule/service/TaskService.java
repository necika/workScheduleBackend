package com.workSchedule.workSchedule.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.workSchedule.workSchedule.dtos.TaskDTO;
import com.workSchedule.workSchedule.enums.TaskStatus;
import com.workSchedule.workSchedule.model.MyUser;
import com.workSchedule.workSchedule.model.Task;
import com.workSchedule.workSchedule.repository.TaskRepository;
import com.workSchedule.workSchedule.repository.UserRepository;

@Service
public class TaskService {

	@Autowired
	TaskRepository taskRepo;

	@Autowired
	UserRepository userRepo;
	
	public ResponseEntity<TaskDTO> addTask(TaskDTO taskDTO, String email) {
		MyUser user = userRepo.getOneById(taskDTO.getId());
		if(user == null) {
			return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
		}
		Task task = new Task();
		task.setDescription(taskDTO.getDescription());
		task.setName(taskDTO.getName());
		task.setStatus(TaskStatus.NEW);
		task.setUser(user);
		task = taskRepo.save(task);
		return new ResponseEntity<TaskDTO>(new TaskDTO(task),HttpStatus.OK);
	}

	public ResponseEntity<List<TaskDTO>> getAll(String email) {
		MyUser user = userRepo.findByEmail(email);
		if(user == null) {
			return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
		}
		List<Task> tasks = taskRepo.findAllByUserId(user.getId());
		return new ResponseEntity<List<TaskDTO>>(convertEntityToEntityDTOList(tasks),HttpStatus.OK);
	}
	private List<TaskDTO> convertEntityToEntityDTOList(List<Task> tasks){
		List<TaskDTO> tasksDTO = new ArrayList<TaskDTO>();
		for(Task t : tasks) {
			tasksDTO.add(new TaskDTO(t));
		}
		return tasksDTO;
	}

	public ResponseEntity<TaskDTO> changeToActive(TaskDTO taskDTO) {
		Task task = taskRepo.getOneById(taskDTO.getId());
		if(task == null) {
			return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
		}
		task.setStatus(TaskStatus.ACTIVE);
		task = taskRepo.save(task);
		return new ResponseEntity<TaskDTO>(new TaskDTO(task),HttpStatus.OK);
	}
	public ResponseEntity<TaskDTO> changeToClosed(TaskDTO taskDTO) {
		Task task = taskRepo.getOneById(taskDTO.getId());
		if(task == null) {
			return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
		}
		task.setStatus(TaskStatus.CLOSED);
		task = taskRepo.save(task);
		return new ResponseEntity<TaskDTO>(new TaskDTO(task),HttpStatus.OK);
	}
	
}
