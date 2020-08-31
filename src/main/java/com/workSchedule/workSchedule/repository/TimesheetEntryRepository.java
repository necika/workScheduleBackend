package com.workSchedule.workSchedule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.workSchedule.workSchedule.model.TimesheetEntry;

@Repository
public interface TimesheetEntryRepository extends JpaRepository<TimesheetEntry, Long>{

	@Query(value = "select * from timesheet_entry where timesheet_month_id = ?1 and user_id = ?2",nativeQuery = true)
	List<TimesheetEntry> getAllByMonth(Long tmId,Long userId);
	
	@Query(value = "select * from timesheet_entry where id = ?1", nativeQuery = true)
	TimesheetEntry getOneById(Long id);
}
