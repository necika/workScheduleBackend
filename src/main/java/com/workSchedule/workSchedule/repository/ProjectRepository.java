package com.workSchedule.workSchedule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.workSchedule.workSchedule.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long>{

	@Query(value = "select * from project where id = ?1", nativeQuery = true)
	Project getOneById(Long id);
	
	@Query(value = "select p.id,p.name,p.start_date,p.end_date,p.description,p.company_id from project p inner join project_user pu on p.id = pu.project_id and pu.user_id = ?1", nativeQuery = true)
	List<Project> getProjectByLeaderId(Long id);
	
}
