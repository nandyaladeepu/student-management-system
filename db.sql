drop table user_details;  
drop table student_details;  
create table user_details( 
uname char(20) primary key,  
pass char(20),  
fname char(20),  
lname char(20),  
email char(120),  
mobile char(20),  
usertype char(20));  
  
insert into user_details values('User1', 'User1Pass',  
'User1FN', 'User1LN', 'User1@st.com', '123456789', 'DEO');  
  
create table student_details(  
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


CREATE SEQUENCE id_sequence START WITH 1 INCREMENT BY 1;
CREATE OR REPLACE TRIGGER id_trigger
BEFORE INSERT
ON student_details
REFERENCING NEW AS NEW
FOR EACH ROW
BEGIN
SELECT id_sequence.nextval INTO :NEW.SID FROM dual;
END;
/