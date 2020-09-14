package com.workSchedule.workSchedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.workSchedule.workSchedule.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long>{

	@Query(value = "select * from project where id = ?1", nativeQuery = true)
	Project getOneById(Long id);
	
}
