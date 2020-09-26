package com.workSchedule.workSchedule.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import com.workSchedule.workSchedule.dtos.MorningMeetingDTO;
import com.workSchedule.workSchedule.model.MorningMeeting;
import com.workSchedule.workSchedule.model.MyUser;
import com.workSchedule.workSchedule.model.Task;
import com.workSchedule.workSchedule.repository.MorningMeetingRepository;
import com.workSchedule.workSchedule.repository.TaskRepository;
import com.workSchedule.workSchedule.repository.UserRepository;

@Service
public class MorningMeetingService {

	@Autowired MorningMeetingRepository meetingRepo;
	
	@Autowired UserRepository userRepo;
	
	@Autowired EmailService emailService;
	
	@Autowired TaskRepository taskRepo;
	
	
	public ResponseEntity<MorningMeetingDTO> getMorningMeetingByToday(String dateString) {
		MorningMeeting meeting = meetingRepo.findByTimeStamp(getCurrentDateStamp(dateString));
		if(meeting == null) {
			return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
		}
		MorningMeetingDTO meetingDTO = new MorningMeetingDTO(meeting);
		return new ResponseEntity(meetingDTO,HttpStatus.OK);
	}

	public ResponseEntity<MorningMeetingDTO> saveMorningMeeting(MorningMeetingDTO meetingDTO,String dateString,String email) {
		MyUser user = userRepo.getOneById(meetingDTO.getUserId());
		if(user == null) {
			user = userRepo.findByEmail(email);
		}
		MorningMeeting meeting = new MorningMeeting();
		if(meetingDTO.getId() != null) {
			meeting = meetingRepo.getOneById(meetingDTO.getId());
		}
		meeting.setDateStamp(getCurrentDateStamp(dateString));
		meeting.setProblems(meetingDTO.getProblems());
		meeting.setToday(meetingDTO.getToday());
		meeting.setUser(user);
		meeting.setYesterday(meetingDTO.getYesterday());
		List<String> tasksIds = handleMorningMeetingTasks(meetingDTO);
		List<Task> tasks = new ArrayList<Task>();
		for(String taskId : tasksIds) {
			Task task = taskRepo.getOneById(Long.parseLong(taskId));
			if(task != null) {
				tasks.add(task);
			}
		}
		meeting.setTasks(tasks);
		if(meetingDTO.getProblemTasks() != null && meetingDTO.getProblemTasks().size() != 0) {
			meeting.setProblemTasksIds(meetingDTO.getProblemTasks().toString());
		}else {
			meeting.setProblemTasksIds(null);
		}
		if(meetingDTO.getTodayTasks() != null && meetingDTO.getTodayTasks().size() != 0) {
			meeting.setTodayTasksIds(meetingDTO.getTodayTasks().toString());
		}else {
			meeting.setTodayTasksIds(null);
		}
		if(meetingDTO.getYesterdayTasks() != null && meetingDTO.getYesterdayTasks().size() != 0) {
			meeting.setYesterdayTasksIds(meetingDTO.getYesterdayTasks().toString());
		}else {
			meeting.setYesterdayTasksIds(null);
		}
		meeting = meetingRepo.save(meeting);
		
		String txt = "Today's morning meeting is written by user : "+user.getFirstName() + " " + user.getLastName(); 
		String subject = "Today's morning meeting";
		
		try {
			emailService.sendNotification("kcentar4@gmail.com", subject, txt);
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity(new MorningMeetingDTO(meeting),HttpStatus.OK);
		
	}
	private List<String> handleMorningMeetingTasks(MorningMeetingDTO meetingDTO) {
		List<String> tasks = new ArrayList<>();
		if(meetingDTO.getProblemTasks() != null) {
			for(String data : meetingDTO.getProblemTasks()) {
				if(data.contains(" ")) {
					tasks.add(data.split(" ")[1]);
				}else {
					tasks.add(data);
				}
			}
		}
		if(meetingDTO.getTodayTasks() != null) {
			for(String data : meetingDTO.getTodayTasks()) {
				if(data.contains(" ")) {
					tasks.add(data.split(" ")[1]);
				}else {
					tasks.add(data);
				}
			}
		}
		if(meetingDTO.getYesterdayTasks() != null) {
			for(String data : meetingDTO.getYesterdayTasks()) {
				if(data.contains(" ")) {
					tasks.add(data.split(" ")[1]);
				}else {
					tasks.add(data);
				}
			}
		}
		List<String> ids = new ArrayList<String>(new HashSet<String>(tasks));
		
		return ids;
	}

	private Long getCurrentDateStamp(String dateString) {
		int year = Integer.parseInt(dateString.split("-")[0]);
		int month = Integer.parseInt(dateString.split("-")[1]);
		int day = Integer.parseInt(dateString.split("-")[2]);
		Date date = new Date(year,month,day);
		return date.getTime();
	}
}
