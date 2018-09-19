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

CREATE TABLE MEMBER(
	MEM_ID varchar(100) primary key,
    MEM_PW varchar(200) not null,
    MEM_NAME varchar(50) not null,
    MEM_AGE int,
    MEM_EMAIL varchar(200) not null,
    GENDER_ID int,
    SKINTYPE_ID int,
    AGE_ID int,
    constraint FK_MEMBER_SKINTYPE_ID foreign key(SKINTYPE_ID) references SKINTYPE(SKINTYPE_ID) on delete cascade,
    constraint FK_MEMBER_GENDER_ID foreign key(GENDER_ID) references GENDER(GENDER_ID) on delete cascade,
    constraint FK_MEMBER_AGE_ID foreign key(AGE_ID) references AGE(AGE_ID) on delete cascade
);
INSERT INTO MEMBER VALUES('asd','asd','jhon',23,'asd@naver.com','1','1','2');
INSERT INTO MEMBER VALUES('qwe','qwe','jhon',23,'asd@naver.com','1','1','2');
INSERT INTO MEMBER VALUES('zxc','zxc','jhon',23,'asd@naver.com','1','1','2');

CREATE TABLE TIP(
TIP_ID INT AUTO_INCREMENT PRIMARY KEY,
TIP_TITLE VARCHAR(200) NOT NULL,
TIP_THUMBNAIL VARCHAR(200) NOT NULL,
TIP_URL VARCHAR(500) NOT NULL,
AGE_ID INT,
SKINTYPE_ID INT,
GENDER_ID INT,
CONSTRAINT FK_TIP_AGE_ID FOREIGN KEY(AGE_ID) REFERENCES AGE(AGE_ID) on delete cascade,
CONSTRAINT FK_TIP_SKINTYPE_ID FOREIGN KEY(SKINTYPE_ID) REFERENCES SKINTYPE(SKINTYPE_ID) on delete cascade,
CONSTRAINT FK_TIP_GENDER_ID FOREIGN KEY(GENDER_ID) REFERENCES GENDER(GENDER_ID) on delete cascade
);
insert into TIP (TIP_TITLE, TIP_THUMBNAIL, TIP_URL, AGE_ID, SKINTYPE_ID, GENDER_ID)
values('title', 'https://d33ur1yh5ph6b5.cloudfront.net/2f3e0b99-d237-4471-9cf3-7f2a4805f0e5-small','http://www.naver.com',3,1,1);
insert into TIP (TIP_TITLE, TIP_THUMBNAIL, TIP_URL, AGE_ID, SKINTYPE_ID, GENDER_ID)
values('title', 'https://d33ur1yh5ph6b5.cloudfront.net/fb47b7d4-c46f-4f86-a2a9-c5f12ca08454-mid','http://www.youtube.com',3,1,1);

CREATE TABLE FOLLOW(
    FOLLOW_ID INT AUTO_INCREMENT PRIMARY KEY,
    MEM_ID VARCHAR(100),
    TARGET_MEM_ID VARCHAR(100),
    CONSTRAINT FK_FOLLOW_MEM_ID FOREIGN KEY(MEM_ID) REFERENCES MEMBER(MEM_ID) on delete cascade,
    CONSTRAINT FK_FOLLOW_TARGET_MEM_ID FOREIGN KEY(TARGET_MEM_ID) REFERENCES MEMBER(MEM_ID) on delete cascade
);
insert into follow values(1,'asd','qwe');
insert into follow values(2,'qwe','asd');


/*
drop table MEMBER;
drop table TIP;
drop table AGE;
drop table FOLLOW;
drop table SKINTYPE;
drop table GENDER;

select * from MEMBER;
*/

select * FROM MEMBER WHERE MEM_ID = (SELECT MEM_ID FROM FOLLOW WHERE TARGET_MEM_ID = 'asd');

commit;