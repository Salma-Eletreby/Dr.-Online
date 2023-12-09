--Creation of Views
--best rated dr view
create view BEST_RATED_DOCTOR AS
select doc_id "Doctor ID", fname || ' ' || lname "Doctor Name" , count(rat_rating)"Number of ratings", round (avg(rat_rating),2)"Average Rating"  
from (doctor join rating on doc_id = docid) join u_ser on username=user_name 
where rat_date > '31-DEC-2019'
group by doc_id, fname, lname
order by avg(rat_rating) desc;

select * from BEST_RATED_DOCTOR;

--patient view
create view Records_Pat 
as select patient.PAT_ID, patient.AGE, U_SER.* 
from patient join U_SER on username=user_name;

--doctors view
create view Records_DOC
as select doctor.doc_id , doctor.doc_biodata , doctor.posid , doctor.specid, U_SER.* 
from DOCTOR join U_SER on username=user_name;

--topics to be approved view
create view need_approval as
select TOPIC.*
from TOPIC join U_SER on topic.user_name = u_ser.username
where u_ser.usertypeid=3330 AND approved is null;

--Medicine view
create view med_info AS
select * from MEDECINE;

--Topics View
create view topics AS
select T_ID "Topic Id", DATE_CREATED "Date written", APPROVED "Approved Status", TITLE "Title", SPECID "Speciality Id", TTYPEID "User Type", USER_NAME "Username"
from Topic
where APPROVED = 'Yes';

--Replies view 
create view replies AS
select REP_ID "Patient ID", REPLY Reply , Reply_Date "Date" , TID "Topic Id" , USER_NAME Username
FROM REPLY ;