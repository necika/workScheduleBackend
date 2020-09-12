package com.workSchedule.workSchedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.workSchedule.workSchedule.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long>{

	@Query(value = "select * from company where id = ?1", nativeQuery = true)
	Company getOneById(Long id);
	
}
