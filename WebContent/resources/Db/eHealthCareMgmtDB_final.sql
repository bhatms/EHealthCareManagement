-- --------------------------------------------
-- SCHEMA for eHealthcare Management
-- --------------------------------------------
DROP DATABASE IF EXISTS EHealthDB;
CREATE DATABASE EHealthDB;
USE EHealthDB;


-- --------------------------------------------
-- Specializations Table
-- --------------------------------------------
DROP TABLE IF EXISTS specializations;
CREATE TABLE IF NOT EXISTS specializations (
    special_id VARCHAR(100) PRIMARY KEY,
    special_title VARCHAR(100) NOT NULL,
    special_desc VARCHAR(100) NULL
);
  
  insert into specializations(special_id, special_title, special_desc)
  values('Anaesthesiology','Anaesthesiology','Anaesthesiology');
  
    insert into specializations(special_id, special_title, special_desc)
  values('Dental','Dental','Dental');  
  
  insert into specializations(special_id, special_title, special_desc)
  values('Oncology','Oncology','Oncology');
  
	insert into specializations(special_id, special_title, special_desc)
  values('Cardiology','Cardiology','Cardiology');
  
      insert into specializations(special_id, special_title, special_desc)
  values('Physiotherapy','Physiotherapy','Physiotherapy');
  
        insert into specializations(special_id, special_title, special_desc)
  values('General','General','General');
  
      insert into specializations(special_id, special_title, special_desc)
  values('Andrology','Andrology','Andrology');
  
  insert into specializations(special_id, special_title, special_desc)
  values('Nephrology','Nephrology','Nephrology');
  
  insert into specializations(special_id, special_title, special_desc)
  values('Urology','Urology','Urology');
  
   insert into specializations(special_id, special_title, special_desc)
  values('Hepatology','Hepatology','Hepatology');
  
  
   insert into specializations(special_id, special_title, special_desc)
  values('Audiology','Audiology','Audiology');
  
    insert into specializations(special_id, special_title, special_desc)
  values('Dermatology','Dermatology','Dermatology');
  
  insert into specializations(special_id, special_title, special_desc)
  values('ENT','ENT','Ear nose tounge');
  


-- --------------------------------------------
-- State Table
-- --------------------------------------------
  drop table IF EXISTS state;
  create table IF NOT EXISTS state (
  state_id int primary key auto_increment,
  code char(2) not null,
  name varchar(64) not null
);

insert into state (code,name) values ('AL','Alabama');
insert into state (code,name) values ('AK','Alaska');
insert into state (code,name) values ('AZ','Arizona');
insert into state (code,name) values ('AR','Arkansas');
insert into state (code,name) values ('CA','California');
insert into state (code,name) values ('CO','Colorado');
insert into state (code,name) values ('CT','Connecticut');
insert into state (code,name) values ('DE','Delaware');
insert into state (code,name) values ('FL','Florida');
insert into state (code,name) values ('GA','Georgia');
insert into state (code,name) values ('GU','Guam');
insert into state (code,name) values ('HI','Hawaii');
insert into state (code,name) values ('ID','Idaho');
insert into state (code,name) values ('IL','Illinois');
insert into state (code,name) values ('IN','Indiana');
insert into state (code,name) values ('IA','Iowa');
insert into state (code,name) values ('KS','Kansas');
insert into state (code,name) values ('KY','Kentucky');
insert into state (code,name) values ('LA','Louisiana');
insert into state (code,name) values ('ME','Maine');
insert into state (code,name) values ('MD','Maryland');
insert into state (code,name) values ('MA','Massachusetts');
insert into state (code,name) values ('MI','Michigan');
insert into state (code,name) values ('MN','Minnesota');
insert into state (code,name) values ('MS','Mississippi');
insert into state (code,name) values ('MO','Missouri');
insert into state (code,name) values ('MT','Montana');
insert into state (code,name) values ('NE','Nebraska');
insert into state (code,name) values ('NV','Nevada');
insert into state (code,name) values ('NH','New Hampshire');
insert into state (code,name) values ('NJ','New Jersey');
insert into state (code,name) values ('NM','New Mexico');
insert into state (code,name) values ('NY','New York');
insert into state (code,name) values ('NC','North Carolina');
insert into state (code,name) values ('ND','North Dakota');
insert into state (code,name) values ('OH','Ohio');
insert into state (code,name) values ('OK','Oklahoma');
insert into state (code,name) values ('OR','Oregon');
insert into state (code,name) values ('PA','Pennsylvania');
insert into state (code,name) values ('SC','South Carolina');
insert into state (code,name) values ('SD','South Dakota');
insert into state (code,name) values ('TN','Tennessee');
insert into state (code,name) values ('TX','Texas');
insert into state (code,name) values ('UT','Utah');
insert into state (code,name) values ('VT','Vermont');
insert into state (code,name) values ('VA','Virginia');
insert into state (code,name) values ('WA','Washington');
insert into state (code,name) values ('WV','West Virginia');
insert into state (code,name) values ('WI','Wisconsin');
insert into state (code,name) values ('WY','Wyoming');




-- --------------------------------------------
-- User Table
-- --------------------------------------------

drop table IF EXISTS user;

CREATE TABLE IF NOT EXISTS user (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(100) NOT NULL unique,
    password VARCHAR(100) not null,
	role varchar(1) not null
)  COMMENT='Stores User Information';


 -- Admin Credentials
    
insert into user (email,password, role)
values('admin@ehealth.com','adminadmin','A');


 -- Doctor Credentials

insert into user  (email,password, role)
 values('harryZ@gmail.com','password11', 'D' );
 
 insert into user  (email,password, role)
 values('novakj@gmail.com','password11', 'D' );
 
 insert into user  (email,password, role)
 values('rojfed@gmail.com','password11', 'D' );
 
 insert into user  (email,password, role)
 values('ramsey@gmail.com','password11', 'D' );
 
 insert into user  (email,password, role)
 values('sammy@gmail.com','password11', 'D' );
 
 insert into user  (email,password, role)
 values('card@gmail.com','password11', 'D' );
 
 insert into user  (email,password, role)
 values('sahrzZ@gmail.com','password11', 'D' );
 
 insert into user  (email,password, role)
 values('shafz@gmail.com','password11', 'D' );
 
 insert into user  (email,password, role)
 values('harryZ1@gmail.com','password11', 'D' );
 
 insert into user  (email,password, role)
 values('novakj1@gmail.com','password11', 'D' );
 
 insert into user  (email,password, role)
 values('rojfed1@gmail.com','password11', 'D' );
 
 insert into user  (email,password, role)
 values('ramsey1@gmail.com','password11', 'D' );
 
 insert into user  (email,password, role)
 values('sammy1@gmail.com','password11', 'D' );
 
 insert into user  (email,password, role)
 values('card1@gmail.com','password11', 'D' );
 
 insert into user  (email,password, role)
 values('sahrz1Z@gmail.com','password11', 'D' );
 
 insert into user  (email,password, role)
 values('shafz1@gmail.com','password11', 'D' );
 
  insert into user  (email,password, role)
 values('samm@gmail.com','password11', 'D' );
 
  insert into user  (email,password, role)
 values('ramm@gmail.com','password11', 'D' );
 
  insert into user  (email,password, role)
 values('rajj@gmail.com','password11', 'D' );
 
  insert into user  (email,password, role)
 values('deann@gmail.com','password11', 'D' );
 
  insert into user  (email,password, role)
 values('donn@gmail.com','password11', 'D' );
 
  insert into user  (email,password, role)
 values('brian@gmail.com','password11', 'D' );
 
  insert into user  (email,password, role)
 values('zehl@gmail.com','password11', 'D' );
 
  insert into user  (email,password, role)
 values('jocc@gmail.com','password11', 'D' );
 

 
 -- Patient Credentials
 
 insert into user  (email,password, role)
 values('jwatson@ssdi.com','password11', 'P' );
 
 insert into user  (email,password, role)
 values('jdonald@ssdi.com','password11', 'P' );
 
 insert into user  (email,password, role)
 values('rgeller@ssdi.com','password11', 'P' );
 
 insert into user  (email,password, role)
 values('tcruise@ssdi.com','password11', 'P' );
 
 insert into user  (email,password, role)
 values('tcr@uncc.edu','password11', 'P' );
 
  insert into user  (email,password, role)
 values('jwatson1@ssdi.com','password11', 'P' );
 
 insert into user  (email,password, role)
 values('jdonald1@ssdi.com','password11', 'P' );
 
 insert into user  (email,password, role)
 values('rgeller1@ssdi.com','password11', 'P' );
 
 insert into user  (email,password, role)
 values('tcruise1@ssdi.com','password11', 'P' );
 
 insert into user  (email,password, role)
 values('tcr1@uncc.edu','password11', 'P' );
 
insert into user  (email,password, role)
 values('jwatson2@ssdi.com','password11', 'P' );
 
  insert into user  (email,password, role)
 values('jdonald2@ssdi.com','password11', 'P' );
 
 insert into user  (email,password, role)
 values('rgeller2@ssdi.com','password11', 'P' );
 
 insert into user  (email,password, role)
 values('tcruise2@ssdi.com','password11', 'P' );
 
 insert into user  (email,password, role)
 values('tcr2@uncc.edu','password11', 'P');
 
 
 
-- --------------------------------------------
-- Doctor Table
-- --------------------------------------------

drop table IF EXISTS doctor ;
CREATE TABLE IF NOT EXISTS doctor (
    doctor_id INT PRIMARY KEY AUTO_INCREMENT,
    doctor_reg_num VARCHAR(10),
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) NOT NULL,
    doctor_qualification VARCHAR(50) NOT NULL,
    specialization_id VARCHAR(100) NOT NULL,
    doctor_designation VARCHAR(50) NOT NULL,
    doctor_visiting_days VARCHAR(100) NOT NULL,
    doctor_visiting_Hours VARCHAR(100) NOT NULL,
    doctor_email VARCHAR(100) NOT NULL UNIQUE,
    doctor_phone_num VARCHAR(10) NULL,
    user_id int,
	FOREIGN KEY (user_id) REFERENCES User(user_id),
	FOREIGN KEY (specialization_id) REFERENCES specializations(special_id)
)  COMMENT='Stores Doctor Information';


                            
INSERT INTO doctor (doctor_reg_num, first_name,last_Name,doctor_qualification,specialization_id,
                    doctor_designation,doctor_visiting_days,doctor_visiting_Hours,
                    doctor_email,doctor_phone_num,user_id)
VALUES('DOC23452','Harry','Zen','FRC','Anaesthesiology','Physician','Monday','9:00am to 4:00pm',
		'harryZ@gmail.com','9966332255',2),
('DOC23452','Noak','Jheck','FRC','Anaesthesiology','Physician','Tuesday, Thursday','9:00am to 4:00pm',
		'novakj@gmail.com','9966332255',3),
('DOC23452','Roj','Fed','FRC','Cardiology','Physician','Tuesday, Wednesday','9:00am to 4:00pm',
		'rojfed@gmail.com','9966332255',4),
('DOC23452','Ram','Jesay','FRC','Dental','Physician','Tuesday, Thursday','9:00am to 4:00pm',
		'ramsey@gmail.com','9966332255',5),
('DOC23452','Sammy','Ross','FRC','Dental','Physician','Tuesday, Friday','9:00am to 4:00pm',
		'sammy@gmail.com','9966332255',6),
('DOC23452','Carry','Duff','FRC','General','Physician','Tuesday, Saturday','9:00am to 4:00pm',
		'card@gmail.com','9966332255',7),
('DOC23452','Sahar','Zeck','FRC','Oncology','Physician','Wednesday, Thursday','9:00am to 4:00pm',
		'sahrzZ@gmail.com','9966332255',8),
('DOC23452','Farukh','Shon','FRC','Physiotherapy','Physician','Tuesday, Thursday','9:00am to 4:00pm',
		'shafz@gmail.com','9966332255',9),

('DOC23452','Holy','Zen','FRC','Anaesthesiology','Physician','Monday, Thursday','9:00am to 4:00pm',
		'harryZ1@gmail.com','9966332255',10),
('DOC23452','Neonk','Jheck','FRC','Anaesthesiology','Physician','Tuesday, Thursday','9:00am to 4:00pm',
		'novakj1@gmail.com','9966332255',11),
('DOC23452','Rohkj','Fed','FRC','Cardiology','Physician','Monday,Tuesday','9:00am to 4:00pm',
		'rojfed1@gmail.com','9966332255',12),
('DOC23452','Ramanand','Jesay','FRC','Dental','Physician','Tuesday, Sunday','9:00am to 4:00pm',
		'ramsey1@gmail.com','9966332255',13),
('DOC23452','Samuel','Ross','FRC','Dental','Physician','Tuesday, Thursday','9:00am to 4:00pm',
		'sammy1@gmail.com','9966332255',14),
('DOC23452','Carios','Duff','FRC','General','Physician','Tuesday, Thursday','9:00am to 4:00pm',
		'card1@gmail.com','9966332255',15),
('DOC23452','Sohas','Zeck','FRC','Oncology','Physician','Tuesday, Thursday','9:00am to 4:00pm',
		'sahrz1Z@gmail.com','9966332255',16),
('DOC23452','Farerai','Shon','FRC','Physiotherapy','Physician','Tuesday, Thursday','9:00am to 4:00pm',
		'shafz1@gmail.com','9966332255',17),
        
('DOC23452','Soly','Den','FRC','ENT','Physician','Monday, Thursday','9:00am to 4:00pm',
		'samm@gmail.com','9966332255',18),
('DOC23452','Ram','Man','FRC','ENT','Physician','Tuesday, Wednesday','9:00am to 4:00pm',
		'ramm@gmail.com','9966332255',19),
('DOC23452','Raj','Jha','FRC','Dermatology','Physician','Monday, Thursday','9:00am to 4:00pm',
		'rajj@gmail.com','9966332255',20),
('DOC23452','Dean','Jean','FRC','Audiology','Physician','Tuesday, Thursday','9:00am to 4:00pm',
		'deann@gmail.com','9966332255',21),
('DOC23452','Don','Ross','FRC','Hepatology','Physician','Tuesday, Thursday','9:00am to 4:00pm',
		'donn@gmail.com','9966332255',22),
('DOC23452','Brian','Adams','FRC','Urology','Physician','Saturday, Thursday','9:00am to 4:00pm',
		'brian@gmail.com','9966332255',23),
('DOC23452','Zhel','Zeck','FRC','Nephrology','Physician','Tuesday, Thursday','9:00am to 4:00pm',
		'zehl@gmail.com','9966332255',24),
('DOC23452','John','Shon','FRC','Andrology','Physician','Tuesday, Thursday','9:00am to 4:00pm',
		'jocc@gmail.com','9966332255',25);
 


-- --------------------------------------------
-- Patient Table
-- --------------------------------------------
  drop table IF EXISTS patient;
  CREATE TABLE IF NOT EXISTS patient (
    patient_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) NOT NULL,
    address_line1 VARCHAR(50) NOT NULL,
    address_city VARCHAR(50) NOT NULL,
    address_state VARCHAR(50) NOT NULL,
    address_zip VARCHAR(6) NOT NULL,
    phone_no VARCHAR(10) NOT NULL,
    email VARCHAR(100) NOT NULL unique,
	dob varchar(50),
    gender  varchar(1),
    user_id int,
	FOREIGN KEY (user_id) REFERENCES User(user_id)
)  COMMENT='Stores Patient Information';



insert into patient (first_name, last_name, address_line1,
    address_city, address_state, address_zip, phone_no, email,dob, gender, user_id)
values('John','Watson','123 bakers street','Charlotte','NC','33662',9966441122,'jwatson@ssdi.com','11/11/1985','m',18),
('James','Donald','123 bakers street','Charlotte','NC','33662',9955441122,'jdonald@ssdi.com','11/11/1985','m',19),
('Ross','Galler','123 bakers street','Charlotte','NC','33662',9955441122,'rgeller@ssdi.com','11/11/1985','f',20),
('Tom','Cruise','123 bakers street','Charlotte','NC','33662',9955441122,'tcruise@ssdi.com','11/11/1985','f',21),
('Tommy','Cruise','123 bakers street','Charlotte','NC','33662',9955441122,'tcr@uncc.edu','11/11/1985','f',22),

('Johny','Watson','123 bakers street','Charlotte','NC','33662',9966441122,'jwatson1@ssdi.com','11/11/1985','m',23),
('Jamesy','Donald','123 bakers street','Charlotte','NC','33662',9955441122,'jdonald1@ssdi.com','11/11/1985','m',24),
('Rossy','Galler','123 bakers street','Charlotte','NC','33662',9955441122,'rgeller1@ssdi.com','11/11/1985','f',25),
('Tomy','Cruise','123 bakers street','Charlotte','NC','33662',9955441122,'tcruise1@ssdi.com','11/11/1985','f',26),
('Tommty','Cruise','123 bakers street','Charlotte','NC','33662',9955441122,'tcr1@uncc.edu','11/11/1985','f',27),

('Johner','Watson','123 bakers street','Charlotte','NC','33662',9966441122,'jwatson2@ssdi.com','11/11/1985','m',28),
('Jameser','Donald','123 bakers street','Charlotte','NC','33662',9955441122,'jdonald2@ssdi.com','11/11/1985','m',29),
('Rosser','Galler','123 bakers street','Charlotte','NC','33662',9955441122,'rgeller2@ssdi.com','11/11/1985','f',30),
('Tomer','Cruise','123 bakers street','Charlotte','NC','33662',9955441122,'tcruise2@ssdi.com','11/11/1985','f',31),
('Tommyer','Cruise','123 bakers street','Charlotte','NC','33662',9955441122,'tcr2@uncc.edu','11/11/1985','f',32);



-- --------------------------------------------
-- Patient Query Table
-- --------------------------------------------
Drop Table if exists patient_query;

Create Table IF NOT EXISTS patient_query
(
patient_id INT NOT NULL,
query_id INT PRIMARY KEY auto_increment,
query_category VARCHAR(50) NOT NULL,
query_description TEXT NOT NULL,
query_status ENUM('New', 'In-Progress', 'Closed'),
query_date DATE,
doctor_id INT,
doctors_reply VARCHAR(500),
Foreign Key (doctor_id) References doctor (doctor_id),
Foreign Key (patient_id) References patient (patient_id)
);

INSERT INTO patient_query 
 (patient_id, query_category, query_description, query_status, query_date) 
 values ( 1, 'Cardiology', 'Fever', 'New', '2015-04-10'); 