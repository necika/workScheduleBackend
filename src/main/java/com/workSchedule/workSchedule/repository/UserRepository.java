package com.workSchedule.workSchedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workSchedule.workSchedule.model.MyUser;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Long>{

	MyUser findByEmail(String email);
}
