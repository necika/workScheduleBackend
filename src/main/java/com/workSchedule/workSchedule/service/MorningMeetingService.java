package com.workSchedule.workSchedule.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.workSchedule.workSchedule.dtos.MorningMeetingDTO;
import com.workSchedule.workSchedule.model.MorningMeeting;
import com.workSchedule.workSchedule.model.MyUser;
import com.workSchedule.workSchedule.repository.MorningMeetingRepository;
import com.workSchedule.workSchedule.repository.UserRepository;

@Service
public class MorningMeetingService {

	@Autowired MorningMeetingRepository meetingRepo;
	
	@Autowired UserRepository userRepo;

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
		meeting.setDateStamp(getCurrentDateStamp(dateString));
		meeting.setProblems(meetingDTO.getProblems());
		meeting.setToday(meetingDTO.getToday());
		meeting.setUser(user);
		meeting.setYesterday(meetingDTO.getYesterday());
		
		if(meetingDTO.getId() != null) {
			meeting.setId(meetingDTO.getId());
		}
		meeting = meetingRepo.save(meeting);
		return new ResponseEntity(new MorningMeetingDTO(meeting),HttpStatus.OK);
		
	}
	private Long getCurrentDateStamp(String dateString) {
		int year = Integer.parseInt(dateString.split("-")[0]);
		int month = Integer.parseInt(dateString.split("-")[1]);
		int day = Integer.parseInt(dateString.split("-")[2]);
		Date date = new Date(year,month,day);
		return date.getTime();
	}
}
