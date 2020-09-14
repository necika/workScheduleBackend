package com.workSchedule.workSchedule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.workSchedule.workSchedule.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long>{

	@Query(value = "select * from task where id = ?1", nativeQuery = true)
	Task getOneById(Long id);
	
	@Query(value = "select * from task where user_id = ?1", nativeQuery = true)
	List<Task> findAllByUserId(Long id);
	
}
