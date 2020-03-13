CREATE TABLE "MEMBER" (
	"M_NO"	number		NOT NULL,
	"M_ID"	varchar2(50)		NOT NULL,
	"M_NAME"	varchar2(30)		NOT NULL,
	"M_PASSWORD"	varchar2(60)		NOT NULL,
	"M_EMAIL"	varchar2(100)		NOT NULL,
	"M_ADDRESS"	varchar2(200)		NOT NULL,
	"M_PHONE"	varchar2(100)		NOT NULL,
	"M_CODE"	varchar2(10)		NULL,
	"M_ACCOUNT"	varchar2(50)		NULL,
	"M_DIVISION"	varchar2(10)		NOT NULL,
	"M_REGISTRATION"	varchar2(50)		NULL,
	"M_JOINDATE"	date	DEFAULT sysdate	NOT NULL,
	"M_SECESSIONDATE"	date	DEFAULT null	NULL
);

CREATE TABLE "DIVISION" (
	"D_DIVISION"	varchar2(10)		NOT NULL,
	"D_TITLE"	varchar2(20)		NOT NULL
);

CREATE TABLE "BANK" (
	"B_CODE"	varchar2(10)		NOT NULL,
	"B_TITLE"	varchar2(30)		NOT NULL
);

CREATE TABLE "LOGIN" (
	"L_ID"	varchar2(50)		NOT NULL,
	"L_LOGINTIME"	date	DEFAULT sysdate	NOT NULL
);

ALTER TABLE "MEMBER" ADD CONSTRAINT "PK_MEMBER" PRIMARY KEY (
	"M_NO",
	"M_ID"
);

ALTER TABLE "DIVISION" ADD CONSTRAINT "PK_DIVISION" PRIMARY KEY (
	"D_DIVISION"
);

ALTER TABLE "BANK" ADD CONSTRAINT "PK_BANK" PRIMARY KEY (
	"B_CODE"
);



create sequence MEMBER_SEQ
  start with 1
  increment BY 1
  maxvalue 9999999;
  
commit;

drop table MEMBER;

insert into MEMBER(M_NO, M_ID, M_NAME, M_PASSWORD, M_EMAIL, M_ADDRESS, M_PHONE, M_DIVISION, M_JOINDATE)
      		values(MEMBER_SEQ.nextval, 'jpsystem', '관리자', 'jp', 'jpsystem2020@gmail.com', 'test', 'test', 'S1', SYSDATE);
insert into DIVISION values('S1', '관리자');
insert into DIVISION values('A1', '일반회원');
insert into DIVISION values('B1', '분양자회원');

insert into BANK values('NULL', 'NULL');
insert into BANK values('B1', '우리은행');
insert into BANK values('B2', '국민은행');
insert into BANK values('B3', '신한은행');
insert into BANK values('B4', '하나은행');
insert into BANK values('B5', '케이뱅크');
insert into BANK values('B6', '카카오뱅크');
insert into BANK values('B7', 'KDB산업은행');
insert into BANK values('B8', 'IBK기업은행');
insert into BANK values('B9', '회원수협');
insert into BANK values('B10', '농-축협');
insert into BANK values('B11', '산림조합');
insert into BANK values('B12', '새마을금고');
insert into BANK values('B13', '신용협동조합');
insert into BANK values('B14', '대구은행');
insert into BANK values('B15', '부산은행');
insert into BANK values('B16', '경남은행');
insert into BANK values('B17', '광주은행');
insert into BANK values('B18', '전북은행');
insert into BANK values('B19', '제주은행');
