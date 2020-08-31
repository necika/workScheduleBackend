package com.workSchedule.workSchedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.workSchedule.workSchedule.model.TimesheetMonth;

@Repository
public interface TimesheetMonthRepository extends JpaRepository<TimesheetMonth, Long>{

	@Query(value = "select * from timesheet_month where month_stamp = ?1",nativeQuery = true)
    TimesheetMonth findByTimeStamp(Long timestamp);
}
