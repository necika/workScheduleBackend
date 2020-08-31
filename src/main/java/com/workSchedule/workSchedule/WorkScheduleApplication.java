package com.workSchedule.workSchedule;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkScheduleApplication {

	public static void main(String[] args) {
		//Date dd = new Date(2020,5,1);
		//System.out.println(dd.getTime());
		SpringApplication.run(WorkScheduleApplication.class, args);
	}

}
