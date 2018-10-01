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
    MEM_PROFILE varchar(200),
    GENDER_ID int,
    SKINTYPE_ID int,
    AGE_ID int,
    constraint FK_MEMBER_SKINTYPE_ID foreign key(SKINTYPE_ID) references SKINTYPE(SKINTYPE_ID) on delete cascade,
    constraint FK_MEMBER_GENDER_ID foreign key(GENDER_ID) references GENDER(GENDER_ID) on delete cascade,
    constraint FK_MEMBER_AGE_ID foreign key(AGE_ID) references AGE(AGE_ID) on delete cascade
);
INSERT INTO MEMBER VALUES('asd','asd','jhon',23,'asd@naver.com','1','1','2','ad');
INSERT INTO MEMBER VALUES('qwe','qwe','jhon',23,'asd@naver.com','1','1','2','ad');
INSERT INTO MEMBER VALUES('zxc','zxc','jhon',23,'asd@naver.com','1','1','2','ad');
INSERT INTO MEMBER VALUES('asdasd','asd','Chris',33,'asd@naver.com','1','1','3','ad');
select * from Member;

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
insert into follow values(3,'asd','zxc');
SELECT * FROM FOLLOW;
SELECT * FROM MEMBER WHERE MEM_ID IN(SELECT MEM_ID FROM FOLLOW WHERE TARGET_MEM_ID = 'asd'); -- 나를 팔로우 하고 있는 사람
SELECT * FROM MEMBER WHERE MEM_ID IN(SELECT TARGET_MEM_ID FROM FOLLOW WHERE MEM_ID = 'asd'); -- 내가 팔로우 하고 있는 사람

CREATE TABLE ITEM(
    ITEM_ID INT auto_increment primary KEY,
    ITEM_NAME VARCHAR(100) NOT NULL,
    ITEM_BRAND VARCHAR(100) NOT NULL,
    ITEM_CATEGORY VARCHAR(100) NOT NULL,
    AGE_ID INT,
    SKINTYPE_ID INT,
    GENDER_ID INT,
    ITEM_PRICE INT NOT NULL,
	ITEM_CAPA VARCHAR(100),
    ITEM_IMAGE VARCHAR(400) NOT NULL,
    CONSTRAINT FK_ITEM_AGE_ID FOREIGN KEY(AGE_ID) REFERENCES AGE(AGE_ID)  on delete cascade,
    CONSTRAINT FK_ITEM_SKINTYPE_ID FOREIGN KEY(SKINTYPE_ID) REFERENCES SKINTYPE(SKINTYPE_ID) on delete cascade,
    CONSTRAINT FK_ITEM_GENDER_ID FOREIGN KEY(GENDER_ID) REFERENCES GENDER(GENDER_ID) on delete cascade
);
drop table item;
insert into ITEM values(1,'룰루','아모레','클렌징',2,2,1,10000,'200ml','http://d9vmi5fxk1gsw.cloudfront.net/home/glowmee/upload/20180814/1534239707375.png');
insert into ITEM values(2,'래쉬포머','케이트','마스카라',2,2,1,18000,'8.6g','http://d9vmi5fxk1gsw.cloudfront.net/home/glowmee/upload/20180814/1534239707375.png');

insert into ITEM values(3,'매트 아이 컬러','로라메르시에','아이섀도우',2,1,2,35000,'2.6g','http://d9vmi5fxk1gsw.cloudfront.net/home/glowmee/upload/20161208/1481167028266.png');
insert into ITEM values(4,'문더스트 아이섀도루','어반디케이','아이섀도우',2,3,1,28000,'1.5g','http://d9vmi5fxk1gsw.cloudfront.net/home/glowmee/upload/20150819/1439956037587.PNG');
insert into ITEM values(5,'계이득 아이즈','에뛰드하우스','아이새도우',2,2,2,4000,'2.0g','http://d9vmi5fxk1gsw.cloudfront.net/home/glowmee/upload/20170117/1484622944149.png');
insert into ITEM values(6,'세이프 미 릴리프 모이스처','메이크프렘','클렌징폼',2,2,1,16000,'150g','http://d9vmi5fxk1gsw.cloudfront.net/home/glowmee/upload/20180920/1537429962535.PNG');

insert into ITEM values(7,'아쿠아 수딩 토너','리얼베리어','스킨',3,1,2,35000,'200ml','http://d9vmi5fxk1gsw.cloudfront.net/home/glowmee/upload/20180409/1523244109405.png');
insert into ITEM values(8,'모공 퓨리파잉 토너','스킨미소','스킨',3,3,1,15000,'250ml','http://d9vmi5fxk1gsw.cloudfront.net/home/glowmee/upload/20171026/1509000346452.png');
insert into ITEM values(9,'리지스트 트리트먼트','디시즈리얼','모공케어',3,2,2,32000,'30ml','http://d9vmi5fxk1gsw.cloudfront.net/home/glowmee/upload/20170106/1483665133449.png');
insert into ITEM values(10,'헤븐스 휴 하이라이터','스틸라','하이라이터',3,2,1,40000,'4.5ml','http://d9vmi5fxk1gsw.cloudfront.net/home/glowmee/upload/20170116/1484538430288.png');

select * from ITEM;
SELECT * FROM ITEM ORDER BY ITEM_ID LIMIT 4;
SELECT * FROM ITEM WHERE AGE_ID =(SELECT AGE_ID FROM MEMBER WHERE MEM_ID = 'asd') LIMIT 4;


CREATE TABLE REVIEW(
    REVIEW_ID INT auto_increment primary KEY,
    MEM_ID VARCHAR(100) NOT NULL,
    REVIEW_TITLE VARCHAR(200) NOT NULL,
    REVIEW_CONTENT VARCHAR(4000) NOT NULL,
    ITEM_ID INT,
    REVIEW_LIKE INT,
    REVIEW_GRADE float,
    CONSTRAINT FK_REVIEW_MEM_ID FOREIGN KEY(MEM_ID) REFERENCES MEMBER(MEM_ID)  on delete cascade,
    CONSTRAINT FK_REVIEW_ITEM_ID FOREIGN KEY(ITEM_ID) REFERENCES ITEM(ITEM_ID) on delete cascade
);
insert into REVIEW values (1,'asd','이거 진짜 좋아요','그냥 좋음',1,12,3.4);
insert into REVIEW values (2,'zxc','이거 진짜 싫어요','그냥 싫음',1,1,1.4);
insert into REVIEW(MEM_ID, REVIEW_TITLE, REVIEW_CONTENT, ITEM_ID, REVIEW_LIKE, REVIEW_GRADE) values ('zxc','이거 진짜 싫어요','그냥 싫음',1,1,1.4);
select *  from REVIEW;
drop table REVIEW;

CREATE TABLE STORE(
    STO_ID INT AUTO_INCREMENT PRIMARY KEY,
    ITEM_ID INT,
    MEM_ID VARCHAR(100),
    CONSTRAINT FK_STORE_ITEM_ID FOREIGN KEY(ITEM_ID) REFERENCES ITEM(ITEM_ID) on delete cascade,
    CONSTRAINT FK_STORE_MEM_ID FOREIGN KEY(MEM_ID) REFERENCES MEMBER(MEM_ID) on delete cascade
);
select * from STORE;
/*
drop table MEMBER;
drop table TIP;
drop table AGE;
drop table FOLLOW;
drop table SKINTYPE;
drop table GENDER;


*/
select * from MEMBER;
select * FROM MEMBER WHERE MEM_ID = (SELECT MEM_ID FROM FOLLOW WHERE TARGET_MEM_ID = 'asd');
alter table member add column  MEM_PROFILE varchar(200);
commit;