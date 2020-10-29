delete from admissions_test.admission_request;
delete from admissions_test.candidate_profile;
delete from admissions_test.candidate;
ALTER TABLE admissions_test.candidate_profile AUTO_INCREMENT = 1;
ALTER TABLE admissions_test.candidate AUTO_INCREMENT = 1;

insert into admissions_test.candidate(username, password, candidate_status,role) values
( 'admin', '$2a$08$fNUHI3FnO3cbT6VAcClJOOsIq93f2101ud2RAKiZFAh7Y2h.oFRzC', 'ACTIVE','ADMIN'),
( 'user', '$2a$08$fNUHI3FnO3cbT6VAcClJOOsIq93f2101ud2RAKiZFAh7Y2h.oFRzC', 'ACTIVE','USER');
insert into admissions_test.candidate_profile(first_name,last_name,email,address,city,region,school,phone_number,candidate_id) values
( 'Admin','Adminov', 'admin@admin.com', 'some street 12/22','someCity','someRegion','someSchool','050-123-1234',1),
( 'User','Userov', 'user@user.com', 'some street 25/17','someCity','someRegion','someSchool','050-123-1234',2);