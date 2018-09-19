---Tony Durham
---2.0 SQL Queries
--2.1 SELECT
SELECT * FROM EMPLOYEE;
---
SELECT * FROM EMPLOYEE WHERE LASTNAME='King';
---
SELECT * FROM EMPLOYEE WHERE FIRSTNAME='Andrew' AND REPORTSTO IS NULL;
--2.2 ORDER BY
SELECT * FROM ALBUM ORDER BY TITLE DESC;
---
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;
--2.3 INSERT INTO
INSERT INTO GENRE VALUES (26, 'Bluegrass');
INSERT INTO GENRE VALUES (27, 'Rockabilly');
INSERT INTO EMPLOYEE VALUES(9,'Erica','Blaine','Chief Archivist',1,
    '15-OCT-65','01-MAR-03','1410 Thunderclap Lane','Edmonton','AB',
    'Canada','T5A 2E8','+1 (780) 428-1990','+1 (780) 428-0991','erica@chinookcorp.com');
INSERT INTO EMPLOYEE VALUES(10,'Brian','Capricorn','Archive Assistant',9,
    '17-NOV-83','01-MAY-83','777 Easter St','Lethbridge','AB','Canada',
    'T1H 0C1','+1 (403) 456-9006','+1 (403) 456-0001','brian@chinookcorp.com');
INSERT INTO CUSTOMER VALUES(60,'Bruce','Wayne','WayneTech','666 Crime Alley','Gotham',
    'NJ','00001','USA','+1 (555) 221-3546','+1 (555) 221-7777','bruce.wayne@hotmail.com',3);
INSERT INTO CUSTOMER VALUES(61,'Tony','Stark','Stark Industries','11 Stark Tower','NYC',
    'NY','54321','USA','+1 (555) 777-4234',NULL,'tonybro@stark.com',3);    
--2.4 Update
UPDATE CUSTOMER SET FIRSTNAME='Robert',LASTNAME='Walter' WHERE FIRSTNAME='Aaron' AND LASTNAME='Mitchell';
UPDATE ARTIST SET NAME='CCR' WHERE NAME='Creedence Clearwater Revival';
--2.5 Like
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE'T%';
--2.6 Between
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';
--2.7 DELETE
DELETE FROM INVOICELINE -- Deletes the INVOICELINE rows that match the nested select for 'Robert Walter'
WHERE INVOICEID IN
    (SELECT INVOICEID FROM INVOICE 
    WHERE CUSTOMERID IN
        (SELECT CUSTOMERID FROM CUSTOMER 
        WHERE FIRSTNAME='Robert' AND LASTNAME='Walter'));
DELETE FROM INVOICE -- Deletes the INVOICE ROWS that match the nested select for 'Robert Walter'
    WHERE CUSTOMERID IN
        (SELECT CUSTOMERID FROM CUSTOMER 
        WHERE FIRSTNAME='Robert' AND LASTNAME='Walter');
DELETE FROM CUSTOMER 
        WHERE FIRSTNAME='Robert' AND LASTNAME='Walter';
---3.0 SQL Functions
--3.1 System Defined Functions
SELECT TO_CHAR(SYSDATE,'HH12:MI:SS')FROM DUAL;
SELECT LENGTH(NAME)FROM MEDIATYPE;
--3.2 System Defined Aggregate Functions
SELECT AVG(TOTAL) FROM INVOICE;
SELECT MAX(UNITPRICE)FROM TRACK;
--3.3 USER DEFINED SCALAR FUNCTIONS
SELECT AVG(UNITPRICE) FROM INVOICELINE;
--3.4 USER DEFINED TABLE VALUED FUNCTIONS   *PROBLEM!!!!*
CREATE OR REPLACE TYPE EMP_OLD FORCE IS OBJECT(NAME VARCHAR2(200), BIRTHYEAR DATE);
/
CREATE OR REPLACE TYPE EMP_OLDER_LIST IS TABLE OF EMP_OLD; 
/
CREATE OR REPLACE FUNCTION OLDER(TESTYEAR IN NUMBER)
RETURN EMP_OLDER_LIST AS L_EMPS EMP_OLDER_LIST := EMP_OLDER_LIST();
N INTEGER :=0;
BEGIN
   FOR i IN (SELECT (FIRSTNAME||' '|| LASTNAME) AS EMP_NAME, BIRTHDATE AS BIRTH FROM EMPLOYEE WHERE BIRTHDATE > (TO_DATE(TESTYEAR,'YYYY')) )
       LOOP
       L_EMPS.EXTEND(); --Extend(): Allocates one element space.
       N:=N+1;
       L_EMPS(N) :=EMP_OLD(i.EMP_NAME,i.BIRTH);
       END LOOP;
   RETURN L_EMPS;
END;
/
---4.0 STORED PROCEDURES
--4.1 BASIC STORED PROCEDURE
CREATE OR REPLACE PROCEDURE GET_FULLNAMES
(S OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN S FOR
    SELECT FIRSTNAME,LASTNAME FROM EMPLOYEE;
END GET_FULLNAMES;
/
DECLARE
S SYS_REFCURSOR;
FIRSTNAME CUSTOMER.FIRSTNAME%TYPE;
LASTNAME CUSTOMER.LASTNAME%TYPE;
BEGIN
    GET_FULLNAMES(S);
    LOOP
    FETCH S INTO FIRSTNAME,LASTNAME;
    EXIT WHEN S%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(FIRSTNAME||' '||LASTNAME);
    END LOOP
    CLOSE;
END;
/
SET SERVEROUTPUT ON;
--4.2 STORED PROCEDURE INPUT PARAMETERS
CREATE OR REPLACE PROCEDURE EMPLOYEE_UPDATE_ADDRESS( -- Procedure changes a full address for
    P_EMPLOYEEID IN EMPLOYEE.EMPLOYEEID%TYPE,        -- a given employeeid number
    P_ADDRESS IN EMPLOYEE.ADDRESS%TYPE,
    P_CITY IN EMPLOYEE.CITY%TYPE,
    P_STATE IN EMPLOYEE.STATE%TYPE,
    P_COUNTRY IN EMPLOYEE.COUNTRY%TYPE,
    P_POSTALCODE IN EMPLOYEE.POSTALCODE%TYPE)
    IS
    BEGIN
        UPDATE EMPLOYEE SET ADDRESS = P_ADDRESS,
            CITY = P_CITY,
            STATE = P_STATE,
            COUNTRY = P_COUNTRY,
            POSTALCODE = P_POSTALCODE
        WHERE EMPLOYEEID=P_EMPLOYEEID;
    END;
    /
    SELECT FIRSTNAME||' '||LASTNAME||'''s Address is '||ADDRESS||', '||CITY||',
    '||STATE||' '||POSTALCODE||' '||COUNTRY
    FROM EMPLOYEE WHERE EMPLOYEEID=10; --shows address before change
    EXECUTE EMPLOYEE_UPDATE_ADDRESS(10,'1414 DIXIE LANE','NEW ORLEANS','LA','USA','77777');
    SELECT FIRSTNAME||' '||LASTNAME||'''s Address is '||ADDRESS||', '||CITY||',
    '||STATE||' '||POSTALCODE||' '||COUNTRY
    FROM EMPLOYEE WHERE EMPLOYEEID=10; --shows address before change
    ----
    CREATE OR REPLACE PROCEDURE FIND_MANAGER
        (EMPID IN EMPLOYEE.EMPLOYEEID%TYPE)
    AS
    BEGIN
        SELECT
        (E.FIRSTNAME||' '||E.LASTNAME) AS 'EMP',
        (M.FIRSTNAME||' '||M.LASTNAME) AS 'MANAGER'
        FROM
        EMPLOYEE AS E JOIN EMPLOYEE AS M ON E.REPORTSTO=M.EMPLOYEEID
        WHERE EMPLOYEEID=EMPLOYEE.REPORTSTO;
    END FIND_MANAGER;
 /   
    EXECUTE FIND_MANAGER(5);
---5/0 Transactions
CREATE OR REPLACE PROCEDURE DELETE_INVOICE_FROM_INVOICEID
    (TARGET_INVOICEID IN INVOICE.INVOICEID%TYPE)
    AS
    BEGIN
        DELETE FROM INVOICELINE -- Deletes the INVOICELINE rows that match the marked invoiceid
        WHERE INVOICEID=TARGET_INVOICEID;
        DELETE FROM INVOICE
        WHERE INVOICEID=TARGET_INVOICEID;
    END DELETE_INVOICE_FROM_INVOICEID;
/
EXECUTE DELETE_INVOICE_FROM_INVOICEID(4);
---
CREATE OR REPLACE PROCEDURE ADD_CUSTOMER
    (P_CUSTOMERID IN CUSTOMER.CUSTOMERID%TYPE,
    P_FIRSTNAME IN CUSTOMER.FIRSTNAME%TYPE,
    P_LASTNAME IN CUSTOMER.LASTNAME%TYPE,
    P_COMPANY IN CUSTOMER.COMPANY%TYPE,
    P_ADDRESS IN CUSTOMER.ADDRESS%TYPE,
    P_CITY IN CUSTOMER.CITY%TYPE,
    P_STATE IN CUSTOMER.STATE%TYPE,
    P_COUNTRY IN CUSTOMER.COUNTRY%TYPE,
    P_POSTALCODE IN CUSTOMER.POSTALCODE%TYPE,
    P_PHONE IN CUSTOMER.PHONE%TYPE,
    P_FAX IN CUSTOMER.FAX%TYPE,
    P_EMAIL IN CUSTOMER.EMAIL,
    P_SUPPORTREPID IN CUSTOMER.SUPPORTREPID%TYPE)
    AS
    BEGIN
        INSERT INTO CUSTOMER VALUES
        (P_CUSTOMERID,P_FIRSTNAME,P_LASTNAME,P_COMPANY,P_ADDRESS,P_CITY,
        P_STATE,P_COUNTRY,P_POSTALCODE,P_PHONE,P_FAX,P_EMAIL,P_SUPPORTREPID)
      --COMMIT; Didn't want to commit while working on homework if this is still here
    END ADD_CUSTOMER;
/

---6.0 Triggers
--6.1 AFTER/FOR
CREATE OR REPLACE TRIGGER TRG_AFTER_INSERT_EMPLOYEE
AFTER INSERT        --Trigger activates after Employee inserted
    ON EMPLOYEE     --If Country is not Canada, prints message reminding to get
    FOR EACH ROW    --Foreign Employee Form for HR
BEGIN
    IF (:NEW.COUNTRY !='Canada') THEN
        DBMS_OUTPUT.PUT_LINE('Foreign Employee Form Needed by HR');
    END IF;
END TRG_AFTER_INSERT_EMPLOYEE;
/
INSERT INTO EMPLOYEE VALUES(11,'Elizabeth','Periwhistle','US Sales Rep',2,
    '17-MAR-83','01-MAY-87','66 Sunset Strip','Los Angles','CA','USA',
    'GGF444','+1 (555) 456-7933','+1 (555) 456-8888','Elizabeth@chinookcorp.com');
-----   
CREATE OR REPLACE TRIGGER TRG_AFTER_UPDATE_ALBUM
AFTER UPDATE    --Trigger alerts if an Album Title is changed.
    ON ALBUM
    FOR EACH ROW
BEGIN
    IF(:NEW.TITLE !=:OLD.TITLE)THEN
        DBMS_OUTPUT.PUT_LINE('Title was corrected');
    END IF;
END TRG_AFTER_UPDATE_ALBUM;
/
UPDATE ALBUM
SET TITLE='Medium Ones'
WHERE ALBUMID=5;
-----
CREATE OR REPLACE TRIGGER TRG_AFTER_DELETE_CUSTOMER
AFTER DELETE
    ON CUSTOMER
    FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Customer Deleted Sucessfully!!!');
END TRG_AFTER_DELETE_CUSTOMER;
/
DELETE FROM INVOICELINE --Deletes customer with customerid=12, and all children entries
WHERE INVOICEID IN
    (SELECT INVOICEID FROM INVOICE 
    WHERE CUSTOMERID =12);
DELETE FROM INVOICE
    WHERE CUSTOMERID =12;
DELETE FROM CUSTOMER 
        WHERE CUSTOMERID =12;
---7.0 Joins
--7.1 Inner
SELECT CUSTOMER.FIRSTNAME,CUSTOMER.LASTNAME,INVOICE.INVOICEID
FROM INVOICE INNER JOIN CUSTOMER
ON CUSTOMER.CUSTOMERID=INVOICE.CUSTOMERID
ORDER BY CUSTOMER.LASTNAME, CUSTOMER.FIRSTNAME;
--7.2 OUTER
SELECT CUSTOMER.CUSTOMERID,CUSTOMER.FIRSTNAME,CUSTOMER.LASTNAME,INVOICEID,TOTAL
FROM INVOICE FULL OUTER JOIN CUSTOMER
ON CUSTOMER.CUSTOMERID=INVOICE.CUSTOMERID
ORDER BY CUSTOMER.LASTNAME, CUSTOMER.FIRSTNAME;
--7.3 RIGHT
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ALBUM RIGHT JOIN ARTIST
ON ALBUM.ARTISTID=ARTIST.ARTISTID
ORDER BY ARTIST.NAME;
--7.4 CROSS
SELECT *
FROM ALBUM CROSS JOIN ARTIST
ORDER BY ARTIST.NAME ASC;
--7.5 SELF
SELECT A.FIRSTNAME||' '||A.LASTNAME "Employee", B.FIRSTNAME||' '||B.LASTNAME "Manager"
FROM EMPLOYEE A JOIN EMPLOYEE B
ON (A.REPORTSTO = B.EMPLOYEEID);