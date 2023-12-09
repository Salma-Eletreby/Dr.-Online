--creating position name table
--created due to normalisation
create table POS_DESC(
POSname varchar2(20) primary key,
POS_desc varchar2(140));

--Creating position table
--cannot be named position as it is a keyword
create table POS(
POS_ID number(4) primary key,
POS_name varchar2(20) not null,
constraint FK_POS_name foreign key(POS_name) references POS_DESC(POSname) on delete cascade);

--create user type description table
create table user_t_desc(
usertype_name varchar2 (16) primary key,
usertype_desc varchar2 (140),
constraint chk_user check (usertype_name in ('doctor','patient','admin')));

--creating user type table
create table USER_TYPE(
usertype_ID number(4) primary key,
usertype_name varchar2 (16) not null,
constraint FK_name_uType foreign key(usertype_name) references user_t_desc(usertype_name) on delete cascade);

--creating specialty name table
--created due to normalisation
create table SPECIALTY_DESC(
SPEC_name varchar2(20) primary key,
SPEC_desc varchar2(140),
constraint SPEC_CK check (SPEC_name in ('ENT', 'Neurology', 'Cardiology')));

--Creating specialty table
create table SPECIALTY(
SPEC_ID number(4) primary key,
SPEC_name varchar2(20) not null,
constraint FK_name_spec foreign key(SPEC_name) references SPECIALTY_DESC(SPEC_name) on delete cascade);

--creating topic desc table
create table TOPIC_DESC(
T_name varchar2(25) primary key,
T_desc varchar2(140),
constraint Topic_CK 
check (T_name in ('questionnaire', 'patient opinion', 'general information',
'discussion', 'new medication release', 'research update')));


--creating Topic Type table
create table TOPIC_TYPE(
TTYPE_ID number(4) primary key,
T_name varchar2(25) not null,
constraint FK_name_T foreign key(T_name) references TOPIC_DESC(T_name) on delete cascade);

--creating username table
--name altered as it is a keyword
create table U_SER(
UserName varchar2(16) primary key,
pass varchar2(16) not null,
Date_created date,
gender varchar2(1),
FName varchar2(12) not null,
LName varchar2(12) not null,
UserTypeID number(4) not null,
constraint FK_UserTypeID foreign key(UserTypeID) references USER_TYPE(UserType_ID) on delete cascade,
constraint user_gender_chk check(gender='M' OR gender='F'));

--creating patient table
create table PATIENT(
Pat_ID number(4) primary key,
User_Name varchar2(16) not null,
Age number(3),
constraint FK_User_pat foreign key(User_Name) references U_SER(UserName) on delete cascade,
constraint PT_age_chk check (Age>18));

--creating patient conditions table
create table PATIENT_COND(
Pat_ID number(4),
Pat_condition varchar2(24),
constraint FK_cond foreign key(Pat_ID) references PATIENT(Pat_ID) on delete cascade,
constraint pk_cond primary key(Pat_ID,Pat_condition));

--creating Doctor table
create table DOCTOR(
Doc_ID number(4) primary key,
Doc_BIOData varchar2(140),
PosID number(4),
SpecID number(4),
User_Name varchar2(16) not null,
constraint FK_posID foreign key(PosID) references POS(POS_ID) on delete cascade,
constraint FK_specID foreign key(SpecID) references SPECIALTY(SPEC_ID) on delete cascade,
constraint FK_User_doc foreign key(User_Name) references U_SER(UserName) on delete cascade);

--creating Rating
create table RATING(
Rat_ID number(4) primary key,
Rat_Date date,
Rat_Rating number(1) not null,
Rat_Comment varchar2(140),
PatID number(4) not null,
DocID number(4)not null,
constraint FK_patID foreign key(PatID) references PATIENT(PAT_ID) on delete cascade,
constraint FK_docID foreign key(DocID) references DOCTOR(Doc_ID) on delete cascade,
constraint RAT_CK check (Rat_Rating between 1 and 5));

--creating topic table
create table TOPIC(
T_ID number(4) primary key,
Date_created date,
Approved varchar2(3),
title varchar2(24) not null,
SpecID number(4),
TTYpeID number(4) not null,
User_Name varchar2(16) not null,
constraint app_CK check (Approved='Yes' OR Approved='No'),
constraint FK_TspecID foreign key(SpecID) references SPECIALTY(SPEC_ID) on delete cascade,
constraint FK_TUser_topic foreign key(User_Name) references U_SER(username) on delete cascade,
constraint FK_type foreign key(TTYpeID) references TOPIC_TYPE(TTYPE_ID) on delete cascade);

--creating reply table
create table REPLY(
Rep_ID number(4) primary key,
Reply varchar2(140) not null,
Reply_Date date,
TID number(4) not null,
User_name varchar2(16) not null,
constraint FK_TID foreign key(TID) references TOPIC(T_ID) on delete cascade,
constraint FK_User_reply foreign key(User_Name) references U_SER(UserName) on delete cascade);

--create medecine table
create table MEDECINE(
MED_ID number(4) primary key,
Med_name varchar(12) not null,
Med_desc varchar(140),
Med_pirce number(3,2));

--creating patient medecine table
create table PAT_MED(
PATID number(4),
MEDID number(4),
start_date date,
end_date date,
constraint pat_med_pk primary key (PATID,MEDID),
constraint FK_MID foreign key(MEDID) references MEDECINE(MED_ID) on delete cascade,
constraint FK_PID foreign key(PATID) references PATIENT(Pat_ID) on delete cascade,
constraint end_chk check(start_date<end_date));