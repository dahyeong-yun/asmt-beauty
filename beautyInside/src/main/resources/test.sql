CREATE TABLE MEMBER(
	MEM_ID varchar(100) primary key,
    MEM_PW varchar(200) not null,
    MEM_NAME varchar(50) not null,
    MEM_AGE int,
    MEM_EMAIL varchar(200) not null,
    GENDER_ID int,
    SKINTYPE_ID int,
    AGE_ID int
);

CREATE TABLE AGE(
	AGE_ID int primary key
);

CREATE TABLE SKINTYPE(
	SKINTYPE_ID int primary key
);

CREATE TABLE GENDER(
	GENDER_ID int primary key
);

-- drop table Member;

INSERT INTO MEMBER VALUES('asd','asd','jhon',23,'asd@naver.com','1','1','2');

select * from MEMBER;

commit;