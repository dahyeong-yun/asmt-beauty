CREATE TABLE MEMBER(
	MEM_ID varchar(100) primary key,
    MEM_PW varchar(200) not null,
    MEM_NAME varchar(50) not null,
    MEM_AGE int,
    MEM_EMAIL varchar(200) not null,
    GENDER_ID int,
    SKINTYPE int,
    AGE_ID int
);