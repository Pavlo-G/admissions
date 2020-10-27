delete from admissions_test.faculty;
ALTER TABLE admissions_test.faculty AUTO_INCREMENT =1 ;


insert into admissions_test.faculty(name_en, name_uk, description_en,description_uk,budget_capacity,total_capacity
,req_subject1_en,req_subject1_uk,req_subject2_en,req_subject2_uk,req_subject3_en,req_subject3_uk,admission_open
) values
( 'Faculty of Art', 'Факультет Мистецтв', 'description english','опис українською',5,10,'English','Англійська','History','Історія','Ukrainian','Українська',true),
( 'Faculty of Economics', 'Факультет Економіки', 'description english','опис українською',10,15,'Math','Математика','English','Англійська','Ukrainian','Українська',true);
