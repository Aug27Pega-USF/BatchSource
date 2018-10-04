--these drops are for updating the forms, everything needs to be deleted or improperly formatted data would persist.
DROP TABLE EMPLOYEE;
DROP TABLE EMPLOYEE_TYPE_LOOKUP;
DROP TABLE TRF_APPROVAL_PACKET;
DROP TABLE TUITION_REIMBURSEMENT_FORM;
DROP TABLE EVENT_TYPE_LOOKUP;
DROP SEQUENCE trf_seq;



CREATE TABLE EMPLOYEE_TYPE_LOOKUP(
    USER_TYPE_ID VARCHAR2(1),
    USER_TYPE VARCHAR2(20),
    CONSTRAINT PK_USER_TYPE_ID PRIMARY KEY(USER_TYPE_ID)
);

INSERT ALL
INTO EMPLOYEE_TYPE_LOOKUP(USER_TYPE_ID, USER_TYPE) VALUES ('E','EMPLOYEE')
INTO EMPLOYEE_TYPE_LOOKUP(USER_TYPE_ID, USER_TYPE) VALUES ('S', 'SUPERVISOR') --SUPERVISOR IS THE SAME AS EMPLOYEE, EXCEPT IT HAS AN ADDITIONAL APPROVE.
INTO EMPLOYEE_TYPE_LOOKUP(USER_TYPE_ID, USER_TYPE) VALUES ('H', 'DEPARTMENT HEAD')
INTO EMPLOYEE_TYPE_LOOKUP(USER_TYPE_ID, USER_TYPE) VALUES ('B', 'BENEFITS COORDINATOR')
INTO EMPLOYEE_TYPE_LOOKUP(USER_TYPE_ID, USER_TYPE) VALUES ('G', 'GENERAL MANAGER')
SELECT * FROM dual;

CREATE TABLE EMPLOYEE(
    USER_ID NUMBER NOT NULL,
    REFERSTO NUMBER,
    USER_TYPE_ID VARCHAR2(1) DEFAULT 'E',
    FIRST_NAME VARCHAR2(20),
    LAST_NAME VARCHAR2(20),
    BASIC_INFO_PLACEHOLDER VARCHAR2(100),
    USERNAME VARCHAR2(16) NOT NULL,
    PASSWORD_HASH VARCHAR2(100) NOT NULL,
    AVAILABLE_REIMBURSEMENT NUMERIC(7,2) DEFAULT 1000,
    PENDING_REIMBURSEMENT NUMERIC(7,2) DEFAULT 0,
    AWARDED_REIMBURSEMENT NUMERIC(7,2) DEFAULT 0,
    CONSTRAINT PK_USER PRIMARY KEY (USER_ID),
    CONSTRAINT UNI_USERNAME UNIQUE (USERNAME),
    CONSTRAINT USER_TYPE_ID FOREIGN KEY (USER_TYPE_ID) REFERENCES EMPLOYEE_TYPE_LOOKUP(USER_TYPE_ID)
);

INSERT ALL
INTO EMPLOYEE VALUES(1,NULL,'H', 'LEONARA', 'MARSLAND', 'I AM A FEMALE', 'LEONARA1', F_ENCRYPT('MARSLAND1'), 1000,0,0)
INTO EMPLOYEE VALUES(2,1,'S', 'LEONARA', 'MARSLAND', 'I AM A FEMALE', 'LEONARA1', F_ENCRYPT('MARSLAND1'), 1000,0,0)
INTO EMPLOYEE VALUES(3,1,'S', 'LEONARA', 'MARSLAND', 'I AM A FEMALE', 'LEONARA1', F_ENCRYPT('MARSLAND1'), 1000,0,0)
INTO EMPLOYEE VALUES(4,2,'E', 'LEONARA', 'MARSLAND', 'I AM A FEMALE', 'LEONARA1', F_ENCRYPT('MARSLAND1'), 1000,0,0)
INTO EMPLOYEE VALUES(5,2,'E', 'LEONARA', 'MARSLAND', 'I AM A FEMALE', 'LEONARA1', F_ENCRYPT('MARSLAND1'), 1000,0,0)
INTO EMPLOYEE VALUES(6,3,'E', 'LEONARA', 'MARSLAND', 'I AM A FEMALE', 'LEONARA1', F_ENCRYPT('MARSLAND1'), 1000,0,0)
INTO EMPLOYEE VALUES(7,NULL,'H', 'LEONARA', 'MARSLAND', 'I AM A FEMALE', 'LEONARA1', F_ENCRYPT('MARSLAND1'), 1000,0,0)
INTO EMPLOYEE VALUES(8,7,'S', 'LEONARA', 'MARSLAND', 'I AM A FEMALE', 'LEONARA1', F_ENCRYPT('MARSLAND1'), 1000,0,0)
INTO EMPLOYEE VALUES(10,8,'E', 'LEONARA', 'MARSLAND', 'I AM A FEMALE', 'LEONARA1', F_ENCRYPT('MARSLAND1'), 1000,0,0)
INTO EMPLOYEE VALUES(11,8,'E', 'LEONARA', 'MARSLAND', 'I AM A FEMALE', 'LEONARA1', F_ENCRYPT('MARSLAND1'), 1000,0,0)
INTO EMPLOYEE VALUES(12,7,'E', 'LEONARA', 'MARSLAND', 'I AM A FEMALE', 'LEONARA1', F_ENCRYPT('MARSLAND1'), 1000,0,0)
INTO EMPLOYEE VALUES(13,NULL,'B', 'LEONARA', 'MARSLAND', 'I AM A FEMALE', 'LEONARA1', F_ENCRYPT('MARSLAND1'), 1000,0,0)
INTO EMPLOYEE VALUES(14,NULL,'B', 'LEONARA', 'MARSLAND', 'I AM A FEMALE', 'LEONARA1', F_ENCRYPT('MARSLAND1'), 1000,0,0)
INTO EMPLOYEE VALUES(15,NULL,'G', 'LEONARA', 'MARSLAND', 'I AM A FEMALE', 'LEONARA1', F_ENCRYPT('MARSLAND1'), 1000,0,0)
SELECT * FROM dual;

CREATE TABLE EVENT_TYPE_LOOKUP(
    EVENT_TYPE_ID VARCHAR2(1),
    EVENT_TYPE VARCHAR2(35),
    REIMBURSEMENT_PERCENTAGE NUMBER,
    CONSTRAINT PK_EVENT_ID PRIMARY KEY (EVENT_TYPE_ID)
);

INSERT ALL
INTO EVENT_TYPE_LOOKUP(EVENT_TYPE_ID, EVENT_TYPE, REIMBURSEMENT_PERCENTAGE) VALUES ('1','UNIVERSITY COURSES', 80)
INTO EVENT_TYPE_LOOKUP(EVENT_TYPE_ID, EVENT_TYPE, REIMBURSEMENT_PERCENTAGE) VALUES ('2', 'SEMINARS', 60)
INTO EVENT_TYPE_LOOKUP(EVENT_TYPE_ID, EVENT_TYPE, REIMBURSEMENT_PERCENTAGE) VALUES ('3', 'CERTIFICATION PREPARATION CLASSES', 75)
INTO EVENT_TYPE_LOOKUP(EVENT_TYPE_ID, EVENT_TYPE, REIMBURSEMENT_PERCENTAGE) VALUES ('4', 'CERTIFICATION', 100)
INTO EVENT_TYPE_LOOKUP(EVENT_TYPE_ID, EVENT_TYPE, REIMBURSEMENT_PERCENTAGE) VALUES ('5', 'TECHNICAL TRAINING', 90)
INTO EVENT_TYPE_LOOKUP(EVENT_TYPE_ID, EVENT_TYPE, REIMBURSEMENT_PERCENTAGE) VALUES ('6', 'OTHER', 30)
SELECT * FROM dual;

CREATE TABLE TUITION_REIMBURSEMENT_FORM(
    TRF_ID NUMBER NOT NULL,
    --ADD EMPLOYEEID
    FIRST_NAME VARCHAR2(20) NOT NULL,
    LAST_NAME VARCHAR2(20) NOT NULL,
    BASIC_INFO_PLACEHOLDER VARCHAR2(100) NOT NULL,
    EVENT_DATETIME TIMESTAMP NOT NULL,
    EVENT_LOCATION VARCHAR2(25) NOT NULL,
    EVENT_DESCRIPTION VARCHAR2(200) NOT NULL,
    EVENT_COST NUMERIC(7,2) NOT NULL,
    GRADING_FORMAT VARCHAR2(20) NOT NULL, -- MAYBE CHANGE THIS TO A GRADINGFORMAT ID WHICH WOULD REEFERENCE ANOTHER TABLE
    PASSING_GRADE VARCHAR2(3),
    EVENT_TYPE_ID VARCHAR2(1) NOT NULL,
    WORK_RELATED_JUSTIFICATION VARCHAR2(200) NOT NULL,
    OPTIONAL_ATTACHMENTS_EXIST VARCHAR2(1) DEFAULT 'N', 
    SUPERVISOR_APPROVAL_EXIST VARCHAR2(1) DEFAULT 'N',
    HEAD_APPROVAL_EXIST VARCHAR2(1) DEFAULT 'N',
    WORK_TIME_MISSED NUMBER DEFAULT 0,
    PROJECTED_REIMBURSEMENT NUMERIC(7,2), --USE A PROCEDURE TO SET THIS.
    CONSTRAINT PK_TRF PRIMARY KEY (TRF_ID),
    CONSTRAINT FK_EVENT_ID FOREIGN KEY (EVENT_TYPE_ID) REFERENCES EVENT_TYPE_LOOKUP(EVENT_TYPE_ID)
);

CREATE SEQUENCE trf_seq START WITH 1;

CREATE OR REPLACE TRIGGER trf_bir 
BEFORE INSERT ON TUITION_REIMBURSEMENT_FORM 
FOR EACH ROW

BEGIN
  SELECT trf_seq.NEXTVAL
  INTO   :new.trf_id
  FROM   dual;
END;
/

CREATE TABLE TRF_APPROVAL_PACKET( --this is using same primary key, but makes sending information cleaner/faster. the creation of this would be using a procedure that is called and turns the trf form into this.
    TRF_ID NUMBER NOT NULL,
    PROJECTED_REIMBURSEMENT NUMERIC(7,2) NOT NULL,
    DS_APPROVAL VARCHAR2(1) DEFAULT 'N',
    DH_APPROVAL VARCHAR2(1) DEFAULT 'N',
    BC_APPROVAL VARCHAR2(1) DEFAULT 'N',
    EXCEEDREASON VARCHAR2(200),
    CONSTRAINT FK_TRF_ID FOREIGN KEY (TRF_ID) REFERENCES TUITION_REIMBURSEMENT_FORM(TRF_ID)
);

CREATE OR REPLACE FUNCTION LOGIN(IUSERNAME VARCHAR2, IPASSWORD VARCHAR2)
RETURN NUMBER AS IUSER_ID NUMBER; 
DECRYPTED VARCHAR2(100);
BEGIN
    DECRYPTED:=F_ENCRYPT(IPASSWORD);
    SELECT USER_ID INTO IUSER_ID FROM EMPLOYEE WHERE USERNAME=IUSERNAME AND PASSWORD_HASH=DECRYPTED;
    RETURN IUSER_ID;
END;
/

CREATE OR REPLACE FUNCTION GET_EMP_LEVEL(IUSER_ID NUMBER)
RETURN VARCHAR2 AS IUSER_LEVEL VARCHAR2(1);
BEGIN
    SELECT USER_TYPE_ID INTO IUSER_LEVEL FROM EMPLOYEE WHERE USER_ID=IUSER_ID;
    RETURN IUSER_LEVEL;
END;
/