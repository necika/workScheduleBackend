--companies
INSERT IGNORE INTO `diplomski`.`company` (`id`, `description`,`name`)
 	VALUES ('1', 'Company description 1','Company 1');

--projects
INSERT IGNORE INTO `diplomski`.`project` (`id`, `description`, `company_id`, `name`)
 	VALUES ('1', 'Project description 1', '1','Project 1');
INSERT IGNORE INTO `diplomski`.`project` (`id`, `description`, `company_id`, `name`)
 	VALUES ('2', 'Project description 2', '1','Project 2');

--users(team leaders and employees and admins)
INSERT IGNORE INTO `diplomski`.`my_user` (`id`, `age`, `email`,`first_name`, `job_title`,`last_name`, `password`, `user_type`, `company_id`, `project_id`)
 	VALUES ('4', '33','admin1@admin1','Mirko', '2', 'Mirkovic', 'sifra', '2', '1', '1');
INSERT IGNORE INTO `diplomski`.`my_user` (`id`, `age`,`email`,`first_name`, `job_title`,`last_name`, `password`, `user_type`, `company_id`, `project_id`)
 	VALUES ('1', '30','user@user','Marko', '0', 'Markovic', 'sifra', '1', '1', '1');
INSERT IGNORE INTO `diplomski`.`my_user` (`id`, `age`,`email`,`first_name`, `job_title`,`last_name`, `password`, `user_type`, `company_id`, `project_id`) 
	VALUES ('2', '29','lead@lead','Jovan', '2','Jovanovic', 'sifra', '0', '1', '1');

--users(superAdmin)
INSERT IGNORE INTO `diplomski`.`my_user` (`id`, `email`,`first_name`,`last_name`, `password`, `user_type`)
VALUES ('3', 'superadmin@superadmin','Nemanja', 'Nemanjic', 'sifra', '3');

--tasks
INSERT IGNORE INTO `diplomski`.`task` (`id`, `description`,`name`,`status`,`user_id`)
VALUES ('1', 'Task description1','Task name1', '0', '1');
INSERT IGNORE INTO `diplomski`.`task` (`id`, `description`,`name`, `status`,`user_id`)
VALUES ('2', 'Task description2','Task name2','0', '1');

--ts months
INSERT IGNORE INTO `diplomski`.`timesheet_month` (`id`, `month`, `month_stamp`) values ('1', '2020-06', '61551698400000');
INSERT IGNORE INTO `diplomski`.`timesheet_month` (`id`, `month`, `month_stamp`) values ('2', '2020-05', '61549106400000');

--ts entries
INSERT IGNORE INTO `diplomski`.`timesheet_entry` (`id`, `day`, `description`, `end_time`, `minutes`,`position`,`start_time`, `task`, `timesheet_month_id`, `user_id`) 
values ('1', 1, 'Description 1', '10:00', 480,0 ,'08:00', 'Task 1', '1', '1');
INSERT IGNORE INTO `diplomski`.`timesheet_entry` (`id`, `day`, `description`, `end_time`, `minutes`, `position`,`start_time`, `task`, `timesheet_month_id`, `user_id`) 
values ('2', 2, 'Description 1', '11:00', 480,0 ,'08:00', 'Task 1', '1', '1');
INSERT IGNORE INTO `diplomski`.`timesheet_entry` (`id`, `day`, `description`, `end_time`, `minutes`, `position`,`start_time`, `task`, `timesheet_month_id`, `user_id`) 
values ('5', 1, 'Description 1', '11:00', 600,1 ,'10:00', 'Task 1', '1', '1');
INSERT IGNORE INTO `diplomski`.`timesheet_entry` (`id`, `day`, `description`, `end_time`, `minutes`, `position`,`start_time`, `task`, `timesheet_month_id`, `user_id`) 
values ('3', 1, 'Description 1', '10:00',480 ,0 ,'08:00', 'Task 1', '2', '1');
INSERT IGNORE INTO `diplomski`.`timesheet_entry` (`id`, `day`, `description`, `end_time`, `minutes`, `position`,`start_time`, `task`, `timesheet_month_id`, `user_id`) 
values ('4', 1, 'Description 1', '10:00',480,0 ,'08:00', 'Task 1', '2', '2');

--morning meetings
INSERT IGNORE INTO `diplomski`.`morning_meeting` (`id`, `date_stamp`, `problems`, `today`, `yesterday`,`user_id`) 
values ('1', '61560338400000', '', 'Task today', 'Task yesterday', '1');