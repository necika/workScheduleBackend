--users

INSERT IGNORE INTO `diplomski`.`my_user` (`id`, `email`, `password`, `user_type`) VALUES ('1', 'user@user', 'sifra', '1');
INSERT IGNORE INTO `diplomski`.`my_user` (`id`, `email`, `password`, `user_type`) VALUES ('2', 'lead@lead', 'sifra', '0');

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