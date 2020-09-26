--companies
INSERT IGNORE INTO `diplomski`.`company` (`id`, `description`,`name`)
 	VALUES ('1', 'Company description 1','Company 1');

--projects
INSERT IGNORE INTO `diplomski`.`project` (`id`, `description`, `end_date`, `company_id`, `name`, `start_date`)
 	VALUES ('1', 'Project description 1', '2020-09-20', '1','Project 1','2020-09-30');
INSERT IGNORE INTO `diplomski`.`project` (`id`, `description`, `start_date`, `company_id`, `name`)
 	VALUES ('2', 'Project description 2', '2020-09-15', '1','Project 2');

--users(team leaders and employees and admins)
INSERT IGNORE INTO `diplomski`.`my_user` (`id`, `age`, `email`,`first_name`, `job_title`,`last_name`, `password`, `user_type`, `company_id`)
 	VALUES ('4', '33','admin1@admin1','Mirko', '2', 'Mirkovic', '$2a$10$lTvUa4ajfcVrhp0D0JMTIu2E.EYzzeyEHotMNJ3uTJ8xCY0bFZp7.', '2', '1');
INSERT IGNORE INTO `diplomski`.`my_user` (`id`, `age`,`email`,`first_name`, `job_title`,`last_name`, `password`, `user_type`, `company_id`)
 	VALUES ('1', '30','user@user','Marko', '0', 'Markovic', '$2a$10$lTvUa4ajfcVrhp0D0JMTIu2E.EYzzeyEHotMNJ3uTJ8xCY0bFZp7.', '1', '1');
INSERT IGNORE INTO `diplomski`.`my_user` (`id`, `age`,`email`,`first_name`, `job_title`,`last_name`, `password`, `user_type`, `company_id`) 
	VALUES ('2', '29','lead@lead','Jovan', '2','Jovanovic', '$2a$10$lTvUa4ajfcVrhp0D0JMTIu2E.EYzzeyEHotMNJ3uTJ8xCY0bFZp7.', '0', '1');

--project_users
INSERT IGNORE INTO `diplomski`.`project_user` (`project_id`, `user_id`)
 	VALUES ('2','1');
INSERT IGNORE INTO `diplomski`.`project_user` (`project_id`, `user_id`)
 	VALUES ('2','2');
INSERT IGNORE INTO `diplomski`.`project_user` (`project_id`, `user_id`)
 	VALUES ('2','4');



--users(superAdmin)
INSERT IGNORE INTO `diplomski`.`my_user` (`id`, `email`,`first_name`,`last_name`, `password`, `user_type`)
VALUES ('3', 'superadmin@superadmin','Nemanja', 'Nemanjic', '$2a$10$lTvUa4ajfcVrhp0D0JMTIu2E.EYzzeyEHotMNJ3uTJ8xCY0bFZp7.', '3');

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