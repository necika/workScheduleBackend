package com.workSchedule.workSchedule.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.workSchedule.workSchedule.dtos.TimesheetEntryDTO;
import com.workSchedule.workSchedule.model.TimesheetMonth;
import com.workSchedule.workSchedule.repository.TimesheetMonthRepository;
import com.workSchedule.workSchedule.util.Authorized;

@Service
public class TimesheetMonthService {

	@Autowired
	TimesheetMonthRepository tsMonthRepo;
	
	public ResponseEntity<Long> getTimesheetMonthId(String value) {
		int month = Integer.parseInt(value.split("-")[1]);
		int year = Integer.parseInt(value.split("-")[0]);
		Long monthStamp = new Date(year,month,1).getTime();
		TimesheetMonth timesheetMonth = tsMonthRepo.findByTimeStamp(monthStamp);
		if(timesheetMonth == null) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Long>(timesheetMonth.getId(),HttpStatus.OK);
	}
	
}
