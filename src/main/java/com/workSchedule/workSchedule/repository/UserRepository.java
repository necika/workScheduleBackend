package com.workSchedule.workSchedule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.workSchedule.workSchedule.model.MyUser;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Long>{

	MyUser findByEmail(String email);
	
	@Query(value = "select * from my_user where id = ?1",nativeQuery = true)
	MyUser getOneById(Long id);
	
	@Query(value = "select * from my_user where company_id = ?1",nativeQuery = true)
	List<MyUser> getAllByCompany(Long id);
	
	@Query(value = "select * from my_user where company_id = ?1 && user_type= '0' ",nativeQuery = true)
	List<MyUser> getAllByCompanyAndTeamLeaders(Long id);
	
	@Query(value = "select * from my_user where company_id = ?1 && user_type= '1' && project_id = ?2 ",nativeQuery = true)
	List<MyUser> getAllByProject(Long companyId,Long projectId);
}
