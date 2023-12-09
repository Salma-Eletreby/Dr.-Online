-----------------------------------------------------------------------------------------------
--insert values  into pos_desc table
insert into pos_desc values ('general physician ',
            ' highly trained specialists who provide a range of non-surgical health care to adult patients');
insert into pos_desc values ('consultant physician',
            'senior doctor who practises in one of the medical specialties');
insert into pos_desc values ('resident doctor',
            'medical school graduate and doctor in training who is taking part in a graduate medical education (GME) program');
insert into pos_desc values ('surgeon',
            'doctor who specializes in evaluating and treating conditions that may require surgery, or physically changing the human body');
insert into pos_desc values ('specialist',
            ' medical doctor who is an expert in a specific area of medicine.');        

-----------------------------------------------------------------------------------------------------------------
-- insert values into pos table


insert into pos values (1111,'general physician ');
insert into pos values (2222,'consultant physician');
insert into pos values (3333,'resident doctor');
insert into pos values (4444,'surgeon');
insert into pos values (5555,'specialist');


-----------------------------------------------------------------------------------------
-- insert into user type description table 


insert into user_t_desc values ('admin','the one that supervise the all instructions in the hospital');
insert into user_t_desc values ('doctor',' the one that trying to give the best solution for the patients pains');
insert into user_t_desc values ('patient',' who needs the survice from the hospitals');
            
-----------------------------------------------------------------------------------------
--insert into user type table


insert into USER_TYPE values (1110,'admin');
insert into USER_TYPE values (2220,'doctor');
insert into USER_TYPE values (3330,'patient');

-----------------------------------------------------------------------------------

-- insert into specialty name table

insert into SPECIALTY_DESC values ('ENT',
            'who has special training in diagnosing and treating diseases of the ear, nose, and throat');
insert into SPECIALTY_DESC values ('Neurology',
            'treats disorders that affect the brain, spinal cord, and nerves');
insert into SPECIALTY_DESC values ('Cardiology',
            'a physician whois an expert in the care of your heart and blood vessels.');

-------------------------------------------------------------------------------------------------
--insert into specialty table

insert into SPECIALTY values (1100,'ENT');
insert into SPECIALTY values (2200,'Neurology');
insert into SPECIALTY values (3300,'Cardiology');
---------------------------------------------------------------------------------------------------
--insert into TOPIC_DESC table

insert into TOPIC_DESC values ('questionnaire','Question topic');
insert into TOPIC_DESC values ('patient opinion','the opinion of the patients');
insert into TOPIC_DESC values ('general information','information about the health');
insert into TOPIC_DESC values ('discussion','explaining of several things');
insert into TOPIC_DESC values ('new medication release','the informations about new medicine');
insert into TOPIC_DESC values ('research update','new updates has been done on specific research');

------------------------------------------------------------------
--insert into TOPIC_TYPE table
insert into TOPIC_TYPE values (1000,'questionnaire');
insert into TOPIC_TYPE values (2000,'patient opinion');
insert into TOPIC_TYPE values (3000,'general information');
insert into TOPIC_TYPE values (4000,'discussion');
insert into TOPIC_TYPE values (5000,'new medication release');
insert into TOPIC_TYPE values (6000,'research update');

------------------------------------------------------------------------------------------
--insert into U_SER table

insert into U_SER values ('aa123456', 'aa123456', TO_DATE('01/01/2000', 'DD/MM/YYYY'), 'F', 'amna', 'ahmed', 3330);
insert into U_SER values ('bb123456', 'bb123456', TO_DATE('02/02/2002', 'DD/MM/YYYY'), 'M', 'noor', 'khaled', 3330);
insert into U_SER values ('cc123456', 'cc123456', TO_DATE('03/03/2001', 'DD/MM/YYYY'), 'M', 'islam', 'taha', 1110);
insert into U_SER values ('dd123456', 'dd123456', TO_DATE('04/04/2010', 'DD/MM/YYYY'), 'F', 'fatma', 'hassan', 3330);
insert into U_SER values ('ee123456', 'ee123456', TO_DATE('05/05/2011', 'DD/MM/YYYY'), 'F', 'salma', 'amr', 3330);
insert into U_SER values ('ff123456', 'ff123456', TO_DATE('06/06/2011', 'DD/MM/YYYY'), 'M', 'fahad', 'ali', 3330);
insert into U_SER values ('gg123456', 'gg123456', TO_DATE('11/11/2011', 'DD/MM/YYYY'), 'F', 'rahaf', 'Omar', 2220);
insert into U_SER values ('hh123456', 'hh123456', TO_DATE('12/11/2011', 'DD/MM/YYYY'), 'F', 'rabab', 'mohamed', 2220);
insert into U_SER values ('ii123456', 'ii123456', TO_DATE('13/11/2011', 'DD/MM/YYYY'), 'M', 'ahmed', 'ragab', 2220);
insert into U_SER values ('jj123456', 'jj123456', TO_DATE('14/11/2011', 'DD/MM/YYYY'), 'M', 'hassan', 'yousef', 2220);
insert into U_SER values ('kk123456', 'kk123456', TO_DATE('15/11/2011', 'DD/MM/YYYY'), 'M', 'soliman', 'atif', 2220);

--------------------------------------------------------------------------------------------------------------------
--insert into PATIENT table

insert into PATIENT values (1234, 'bb123456',30);
insert into PATIENT values (5678, 'dd123456',42);
insert into PATIENT values (1122, 'ee123456',25);
insert into PATIENT values (3344, 'aa123456',29);
insert into PATIENT values (5566, 'ff123456',57);

-----------------------------------------------------------------------------------------------------
--insert into PATIENT_COND table


insert into PATIENT_COND values (1234, 'headache');
insert into PATIENT_COND values (1234, 'eye pain');
insert into PATIENT_COND values (5678, 'Epilepsy and Seizures');
insert into PATIENT_COND values (1122, 'Colds and Flu');
insert into PATIENT_COND values (3344, 'Stomach Aches');
insert into PATIENT_COND values (5566, 'anemia');
-----------------------------------------------------------------------------------
--insert into DOCTOR table

insert into DOCTOR values (2018, 'ENT general physician ', 1111, 1100, 'gg123456');
insert into DOCTOR values (2019, 'neurology consultant physician', 2222, 2200, 'hh123456');
insert into DOCTOR values (2020, 'cardiology resident doctor ', 3333, 3300, 'ii123456');
insert into DOCTOR values (2021, 'neurology surgeon', 4444, 2200, 'jj123456');
insert into DOCTOR values (2022, 'ENT specialist', 5555, 1100, 'kk123456');


--------------------------------------------------------------------------------------
--insert into RATING table

insert into RATING values(4001, TO_DATE('10/10/2010', 'DD/MM/YYYY'), 4, 'the doctor was good', 1234, 2018);
insert into RATING values(4002, TO_DATE('14/04/2014', 'DD/MM/YYYY'), 3, 'not bad', 5566, 2018);
insert into RATING values(4003, TO_DATE('15/04/2014', 'DD/MM/YYYY'), 2, 'had bad experience', 1122, 2018);
insert into RATING values(4004, TO_DATE('20/04/2014', 'DD/MM/YYYY'), 4, 'the doctor was good', 3344, 2018);

insert into RATING values(4005, TO_DATE('11/11/2011', 'DD/MM/YYYY'), 5, 'the doctor was excellent', 5678, 2019);
insert into RATING values(4006, TO_DATE('25/04/2014', 'DD/MM/YYYY'), 3, 'not bad', 5566, 2019);
insert into RATING values(4007, TO_DATE('14/04/2015', 'DD/MM/YYYY'), 2, 'had bad experience', 1234, 2019);
insert into RATING values(4008, TO_DATE('19/04/2016', 'DD/MM/YYYY'), 3, 'not bad', 1122, 2019);


insert into RATING values(4009, TO_DATE('12/12/2012', 'DD/MM/YYYY'), 4, 'the doctor was good', 1122, 2020);
insert into RATING values(4010, TO_DATE('14/04/2020', 'DD/MM/YYYY'), 3, 'not bad', 5566, 2020);
insert into RATING values(4011, TO_DATE('16/04/2014', 'DD/MM/YYYY'), 4, 'the doctor was good', 3344, 2020);
insert into RATING values(4012, TO_DATE('14/07/2021', 'DD/MM/YYYY'), 5, 'the doctor was excellent', 1234, 2020);

insert into RATING values(4013, TO_DATE('13/03/2013', 'DD/MM/YYYY'), 2, 'had bad experience ', 3344, 2021);
insert into RATING values(4014, TO_DATE('14/07/2018', 'DD/MM/YYYY'), 3, 'not bad', 1234, 2021);
insert into RATING values(4015, TO_DATE('14/09/2022', 'DD/MM/YYYY'), 1, 'did not even listen to me', 5566, 2021);
insert into RATING values(4016, TO_DATE('14/10/2014', 'DD/MM/YYYY'), 3, 'not bad', 5678, 2021);

insert into RATING values(4017, TO_DATE('30/04/2019', 'DD/MM/YYYY'), 2, 'had bad experience', 1122, 2022);
insert into RATING values(4018, TO_DATE('15/05/2020', 'DD/MM/YYYY'), 3, 'not bad', 5566, 2022);
insert into RATING values(4019, TO_DATE('30/06/2021', 'DD/MM/YYYY'), 3, 'not bad', 1234, 2022);
insert into RATING values(4020, TO_DATE('09/07/2022', 'DD/MM/YYYY'), 5, 'the doctor was excellent', 5678, 2022);
----------------------------------------------------------------------------------------------
--insert into TOPIC table


insert into TOPIC values (11, TO_DATE('23/04/2014', 'DD/MM/YYYY'), 'Yes', 'Covid and stomach ache', 1100, 1000,'gg123456');
insert into TOPIC values (22, TO_DATE('24/04/2015', 'DD/MM/YYYY'), 'Yes', 'Psychiatric illness', 2200, 3000, 'hh123456');
insert into TOPIC values (33, TO_DATE('25/04/2015', 'DD/MM/YYYY'), 'Yes', 'chronic diseases', 3300, 3000, 'ii123456');
insert into TOPIC values (44, TO_DATE('26/04/2019', 'DD/MM/YYYY'), 'Yes', 'what is new in research', 2200, 6000, 'jj123456');
insert into TOPIC values (55, TO_DATE('27/07/2017', 'DD/MM/YYYY'), 'Yes', 'the new one', 1100, 5000, 'kk123456');
insert into TOPIC values (66, TO_DATE('27/07/2021', 'DD/MM/YYYY'), null , 'Headache w/ heart pain', 2200, 2000, 'aa123456');
insert into TOPIC values (77, TO_DATE('11/01/2022', 'DD/MM/YYYY'), null , 'Best hospitals in area', null, 1000, 'bb123456');
insert into TOPIC values (88, TO_DATE('14/04/2022', 'DD/MM/YYYY'), 'Yes' , 'Blocked ears', 1100, 3000, 'ee123456');
insert into TOPIC values (99, TO_DATE('11/12/2020', 'DD/MM/YYYY'), 'No' , 'Fix for pacer', 3300, 4000, 'ff123456');
--------------------------------------------------------------------------------
--insert into REPLY table

insert into REPLY values(111, 'well written topic', TO_DATE('25/04/2015', 'DD/MM/YYYY'), 22, 'bb123456'); 
insert into REPLY values(222, 'agreed', TO_DATE('25/05/2019', 'DD/MM/YYYY'), 33, 'dd123456'); 
insert into REPLY values(333, 'such an excellent topic', TO_DATE('25/06/2019', 'DD/MM/YYYY'), 22, 'aa123456'); 
insert into REPLY values(444, 'That reasearch should release the solution soon', TO_DATE('25/07/2019', 'DD/MM/YYYY'), 44, 'dd123456'); 
insert into REPLY values(555, 'This topic is so benefial ', TO_DATE('25/08/2019', 'DD/MM/YYYY'), 33, 'aa123456'); 
--------------------------------------------------------------------------------------------------
--insert into MEDECINE table

insert into MEDECINE values(666, 'dodofen', 'for the headache', 1.23 );
insert into MEDECINE values(777, 'stratera', 'to increase the concentration for children', 8.23 );
insert into MEDECINE values(888, 'zertek', 'for any kind of allergy', 9.23 );
insert into MEDECINE values(999, 'adole', 'Pain reliever', 6.23 );
insert into MEDECINE values(101, 'ferrous', 'for the treatment of iron deficiency anaemia', 9.50 );


-----------------------------------------------------------------------------------------------
--insert into PAT_MED table

insert into PAT_MED values(1234, 666, TO_DATE('25/09/2019', 'DD/MM/YYYY'),TO_DATE('01/10/2019', 'DD/MM/YYYY'));
insert into PAT_MED values(5678, 777, TO_DATE('01/7/2019', 'DD/MM/YYYY'),TO_DATE('01/10/2020', 'DD/MM/YYYY'));
insert into PAT_MED values(1122, 888, TO_DATE('25/09/2019', 'DD/MM/YYYY'),TO_DATE('20/10/2019', 'DD/MM/YYYY'));
insert into PAT_MED values(3344, 999, TO_DATE('25/04/2019', 'DD/MM/YYYY'),TO_DATE('02/05/2019', 'DD/MM/YYYY'));
insert into PAT_MED values(5566, 101, TO_DATE('25/09/2019', 'DD/MM/YYYY'),TO_DATE('01/10/2021', 'DD/MM/YYYY'));