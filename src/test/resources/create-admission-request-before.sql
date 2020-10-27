delete from admissions_test.admission_request;
ALTER TABLE admissions_test.admission_request AUTO_INCREMENT =1 ;

insert into admissions_test.admission_request( status, req_subject1_grade, req_subject2_grade, req_subject3_grade, candidate_id, faculty_id) values
( 0, 6, 7,8,2,1);
