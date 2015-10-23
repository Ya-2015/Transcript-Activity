--------------------------------------------------------
--  File created - Friday-October-23-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ENROLLMENT
--------------------------------------------------------

  CREATE TABLE "TESTUSERDB"."ENROLLMENT" 
   (	"CODE" VARCHAR2(100 BYTE), 
	"CREDIT" NUMBER(*,0), 
	"GRADE" VARCHAR2(5 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into TESTUSERDB.ENROLLMENT
SET DEFINE OFF;
Insert into TESTUSERDB.ENROLLMENT (CODE,CREDIT,GRADE) values ('englsih',4,'A');
Insert into TESTUSERDB.ENROLLMENT (CODE,CREDIT,GRADE) values ('chinese',3,'A');
Insert into TESTUSERDB.ENROLLMENT (CODE,CREDIT,GRADE) values ('math',3,'B');
Insert into TESTUSERDB.ENROLLMENT (CODE,CREDIT,GRADE) values ('art',3,'B');
Insert into TESTUSERDB.ENROLLMENT (CODE,CREDIT,GRADE) values ('science',2,'A');
Insert into TESTUSERDB.ENROLLMENT (CODE,CREDIT,GRADE) values ('test',2,'C');
Insert into TESTUSERDB.ENROLLMENT (CODE,CREDIT,GRADE) values ('java 101',3,'A');
Insert into TESTUSERDB.ENROLLMENT (CODE,CREDIT,GRADE) values ('art',3,'A');
Insert into TESTUSERDB.ENROLLMENT (CODE,CREDIT,GRADE) values ('programming',3,'C');
