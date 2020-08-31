package com.workSchedule.workSchedule.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.workSchedule.workSchedule.dtos.TimesheetEntryDTO;
import com.workSchedule.workSchedule.model.MyUser;
import com.workSchedule.workSchedule.model.TimesheetEntry;
import com.workSchedule.workSchedule.model.TimesheetMonth;
import com.workSchedule.workSchedule.repository.TimesheetEntryRepository;
import com.workSchedule.workSchedule.repository.TimesheetMonthRepository;
import com.workSchedule.workSchedule.repository.UserRepository;

@Service
public class TimesheetEntryService {

	@Autowired TimesheetEntryRepository tseRepo;
	@Autowired TimesheetMonthRepository tmRepo;
	@Autowired UserRepository userRepo;

	public ResponseEntity<List<TimesheetEntryDTO>> getTimesheetEntryByMonth(String value,String email) {
		MyUser user = userRepo.findByEmail(email);
		if(user == null) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
		
		int month = Integer.parseInt(value.split("-")[1]);
		int year = Integer.parseInt(value.split("-")[0]);
		Long monthStamp = new Date(year,month,1).getTime();
		TimesheetMonth timesheetMonth = tmRepo.findByTimeStamp(monthStamp);
		if(timesheetMonth != null) {
			List<TimesheetEntry> tseList = tseRepo.getAllByMonth(timesheetMonth.getId(), user.getId());
			List<TimesheetEntryDTO> retValueDto = convertTimesheetListToTimesheetDtoList(tseList);
			return new ResponseEntity<List<TimesheetEntryDTO>>(retValueDto,HttpStatus.OK);
		}
		timesheetMonth = new TimesheetMonth(value,monthStamp);
		timesheetMonth = tmRepo.save(timesheetMonth);
		return new ResponseEntity<List<TimesheetEntryDTO>>(new ArrayList<TimesheetEntryDTO>(),HttpStatus.OK);
	}
	private List<TimesheetEntryDTO> convertTimesheetListToTimesheetDtoList(List<TimesheetEntry> tseList) {
		List<TimesheetEntryDTO> tseListDTO =  new ArrayList<TimesheetEntryDTO>();
		if(tseList != null && tseList.size() != 0) {
			for(TimesheetEntry tse : tseList) {
				tseListDTO.add(new TimesheetEntryDTO(tse));
			}
		}
		return tseListDTO;
	}
	public ResponseEntity<TimesheetEntryDTO> saveTimesheetEntry(TimesheetEntryDTO tsEntryDTO) {
		TimesheetEntry tsEntry = tseRepo.getOneById(tsEntryDTO.getId());
		TimesheetEntry newTsEntry = new TimesheetEntry(tsEntryDTO, tsEntry.getTimesheetMonth(), tsEntry.getUser());
		newTsEntry = tseRepo.save(newTsEntry);
		TimesheetEntryDTO retEntry = new TimesheetEntryDTO(newTsEntry);
		return new ResponseEntity<TimesheetEntryDTO>(retEntry,HttpStatus.OK);
	}
	
}
