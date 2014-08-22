CREATE TABLE address(
  id NUMBER(10, 0) NOT NULL,
  street VARCHAR(20) NULL,
  postal_code VARCHAR(45) NOT NULL,
  state VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));

    
create table users(
  uname char(20) primary key,
  pass char(20),
  fname char(20),
  lname char(20),
  email char(120),
  mobile char(20),
  usertype char(20));
insert into users values('User1', 'User1Pass','User1FN', 'User1LN', 'User1@st.com', '123456789', 'DEO');
create table students(
  sid int primary key,
  fname char(20),
  lname char(20),
  email char(120),
  mobile char(20),
  dob date,
  inserted_by char(20),
  updated_by char(20),
  inserted_on date,
  updated_on date);    

CREATE TABLE faculty(
  id NUMBER(10, 0) NOT NULL,
  salary NUMBER(10, 0) NOT NULL,
  sin NUMBER(10, 0) NOT NULL,
  PRIMARY KEY(id));

CREATE TABLE course(
  id NUMBER(10, 0) NOT NULL,
  name VARCHAR(45) NOT NULL,
  description VARCHAR(255),
  start_date TIMESTAMP NOT NULL,
  end_date TIMESTAMP NOT NULL,
  faculty_id NUMBER(10, 0) NOT NULL,
  PRIMARY KEY(id),
  CONSTRAINT fk_course_faculty1
    FOREIGN KEY (faculty_id)
    REFERENCES faculty(id));

CREATE TABLE grades(
  id NUMBER(10, 0),
  course_id NUMBER(10, 0) NOT NULL,
  student_id NUMBER(10, 0) NOT NULL,
  percentage NUMBER(3, 0) NOT NULL,
  PRIMARY KEY(id),
  CONSTRAINT fk_course_id
    FOREIGN KEY (course_id)
    REFERENCES course(id),
  CONSTRAINT fk_student_id
    FOREIGN KEY (student_id)
    REFERENCES students(sid));