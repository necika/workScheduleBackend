package com.workSchedule.workSchedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.workSchedule.workSchedule.dtos.AddCompanyDTO;
import com.workSchedule.workSchedule.enums.JobTitle;
import com.workSchedule.workSchedule.enums.UserType;
import com.workSchedule.workSchedule.model.Company;
import com.workSchedule.workSchedule.model.MyUser;
import com.workSchedule.workSchedule.repository.CompanyRepository;
import com.workSchedule.workSchedule.repository.UserRepository;

@Service
public class CompanyService {

	@Autowired CompanyRepository companyRepo;
	
	@Autowired UserRepository userRepo;
	
	@Autowired PasswordEncoder encoder;

	public ResponseEntity<AddCompanyDTO> save(AddCompanyDTO companyDTO) {
		Company company = new Company(companyDTO.getCompanyName(),companyDTO.getCompanyDescription());
		company = companyRepo.save(company);
		if(company.getId() == null) {
			return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
		}
		MyUser user = new MyUser(companyDTO.getUsername(),encoder.encode(companyDTO.getPassword()),companyDTO.getFirstName(),
				companyDTO.getLastName(),UserType.ADMIN,JobTitle.SENIOR,companyDTO.getAge(),company,null);
		user = userRepo.save(user);
		if(user.getId() == null) {
			return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<AddCompanyDTO>(companyDTO,HttpStatus.OK);
	}
	
	
	
}
