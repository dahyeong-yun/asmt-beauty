CREATE TABLE MEMBER(
	MEM_ID varchar(100) primary key,
    MEM_PW varchar(200) not null,
    MEM_NAME varchar(50) not null,
    MEM_AGE int,
    MEM_EMAIL varchar(200) not null,
    GENDER_ID int,
    SKINTYPE_ID int,
    AGE_ID int,
    constraint FK_MEMBER_SKINTYPE foreign key(SKINTYPE_ID) references SKINTYPE(SKINTYPE_ID) on delete cascade,
    constraint FK_MEMBER_GENDER foreign key(GENDER_ID) references GENDER(GENDER_ID) on delete cascade,
    constraint FK_MEMBER_AGE foreign key(AGE_ID) references AGE(AGE_ID) on delete cascade
);
INSERT INTO MEMBER VALUES('asd','asd','jhon',23,'asd@naver.com','1','1','2');

CREATE TABLE AGE(
	AGE_ID int primary key
);
insert into AGE values(1);
insert into AGE values(2);
insert into AGE values(3);
insert into AGE values(4);
insert into AGE values(5);

CREATE TABLE SKINTYPE(
	SKINTYPE_ID int primary key
);
insert into SKINTYPE values(1); -- 건성
insert into SKINTYPE values(2); -- 지성
insert into SKINTYPE values(3); -- 복합성
insert into SKINTYPE values(4); -- 민감성

CREATE TABLE GENDER(
	GENDER_ID int primary key
);
insert into GENDER values(0);
insert into GENDER values(1); -- 남자
insert into GENDER values(2); -- 여자


-- drop table Member;



select * from MEMBER;

commit;