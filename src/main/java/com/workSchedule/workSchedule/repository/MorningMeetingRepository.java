package com.workSchedule.workSchedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.workSchedule.workSchedule.model.MorningMeeting;

@Repository
public interface MorningMeetingRepository extends JpaRepository<MorningMeeting,Long>{

	@Query(value = "select * from morning_meeting where id = ?1", nativeQuery = true)
	MorningMeeting getOneById(Long id);
	
	@Query(value = "select * from morning_meeting where date_stamp = ?1",nativeQuery = true)
	MorningMeeting findByTimeStamp(Long timestamp);
}
