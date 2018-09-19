-- 2.1 SELECT
SELECT * FROM EMPLOYEE; -- POSTED ALL 8 ROWS IN EMPLOYEE

SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King'; -- POSTED ROW FOR "ROBERT KING"

SELECT * FROM EMPLOYEE WHERE (FIRSTNAME = 'Andrew') AND (REPORTSTO IS NULL); -- POSTED ROW FOR "ANDREW ADAMS

-- 2.2 ORDER BY
SELECT * FROM ALBUM ORDER BY TITLE DESC; -- POSTED THE LIST IN ORDER DESCENDING ORDER BASED ON TITLE

SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY; -- POSTED ONLY THE FIRST NAME OF THE CUSTOMERS IN THE ORDER OF THE CITY

-- 2.3 INSERT INTO
INSERT INTO GENRE (GENREID, NAME) VALUES ('26','TexMex');
INSERT INTO GENRE (GENREID, NAME) VALUES ('27', 'Musical Theatre'); 
SELECT * FROM GENRE ORDER BY GENREID;-- INSERTED THE VALUES TEXMEX AND MUSICAL THEATRE INTO GENRE
DELETE FROM GENRE WHERE GENREID = 26;
DELETE FROM GENRE WHERE GENREID = 27;-- TO DELETE THE VALUES JUST INSERTED

INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES ('9', 'Roberts', 'Julia', 'IT Staff', '6', '10-APR-64', '01-AUG-03', '1254 4th St. NW', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (756) 525-9654', '+1 (756) 525-3457', 'julia@chinookcorp.com');
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES ('10', 'Robertson', 'Brook', 'IT Staff', '6', '11-OCT-67', '21-JUN-02', '129 20th St. NW', 'Edmonton', 'AB', 'Canada', 'T5K 5I8', '+1 (769) 543-1578', '+1 (769) 543-6734', 'brook@chinookcorp.com');-- INSERTED THE ROWS INTO EMPLOYEE AS THE TOP VALUES
SELECT * FROM EMPLOYEE;-- INSERTED THE TWO ROWS ON THE TOP OF THE TABLE
DELETE FROM EMPLOYEE WHERE LASTNAME = 'Roberts';
DELETE FROM EMPLOYEE WHERE LASTNAME = 'Robertson';-- TO DELETE THE VALUES JUST INSERTED

INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES ('60', 'Matt', 'Jones', '(null)', '266 Lex Ln.', 'Naples', '(null)', 'Italy', '75874', '+32 (646) 582-1687', '+32 (646) 582-6573', 'matt.jones@yahoo.com', '5');
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES ('61', 'Bruce', 'Broussard', '(null)', '685 Luthor Ave.', 'Paris', '(null)', 'France', '964725', '+62 (528) 366-5634', '+62 (528) 366-6745', 'bruce.broussard@yahoo.com', '4');
SELECT * FROM CUSTOMER ORDER BY CUSTOMERID;-- INSERTED THE ROWS INTO CUSTOMER
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Matt';
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Bruce';-- TO DELETE THE VALUES JUST INSERTED

-- 2.4 UPDATE
UPDATE CUSTOMER SET FIRSTNAME= 'Robert' WHERE FIRSTNAME = 'Aaron';
UPDATE CUSTOMER SET LASTNAME= 'Walter' WHERE LASTNAME = 'Mitchell'; --UPDATED THE NAME "Aaron Mitchell" TO "Robert Walter"

UPDATE ARTIST SET NAME= 'CCR' WHERE NAME = 'Creedence Clearwater Revival'; --UPDATED THE NAME "Creedence Clearwater Revivial" TO "CCR"

-- 2.5 LIKE
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%'; --SELECTED AND SHOWN ALL OF THE BILLING ADDRESSES THAT STARTED WITH "T"

-- 2.6 BETWEEN
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50; --POSTS THE ROWS WHO'S TOTAL IS BETWEEN 15 AND 50

SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04'; --POSTS THE ROWS WHO'S HIRE DATE WAS BETWEEN JUNE 1, 2003 AND MARCH 1, 2004

-- 2.7 DELETE
DELETE FROM INVOICELINE
WHERE INVOICEID = ANY(
    SELECT INVOICEID FROM INVOICE WHERE CUSTOMERID = 32);
DELETE FROM INVOICE WHERE CUSTOMERID = 32;
DELETE FROM CUSTOMER WHERE CUSTOMERID = 32;
SELECT * FROM CUSTOMER;--DELETED THE ROW OF ROBERT WALTER FROM CUSTOMERS AND ANY CONNECTION TO ROBERT

-- 3.1 SYSTEM DEFINED FUNCTIONS
SELECT TO_CHAR(SYSDATE, 'HH24:MI:SS' ) "NOW" FROM DUAL; -- PRINTS THE CURRENT TIME IN A TABLE NAMED NOW

SELECT LENGTH(NAME) FROM MEDIATYPE; -- PRINTS THE LENGTH OF THE NAME IN MEDIATYPE

-- 3.2 SYSTEM DEFINED AGGREGATE FUNCTIONS
SELECT AVG(TOTAL) FROM INVOICE; -- RETURNED THE AVEARAGE FROM INVOICES

SELECT * FROM TRACK WHERE UNITPRICE = (SELECT MAX(UNITPRICE) FROM TRACK); -- RETURNED THE ROWS WITHIN TRACK THAT COST THE MOST

-- 3.3 USER DEFINED SCALAR FUNCTIONS
SELECT AVG(UNITPRICE) FROM INVOICELINE; -- RETURNS THE AVERAGE PRICE OF INVOICELINE ITEMS IN THE INVOICELINE TABLE

-- 3.4 USER DEFINED TABLE VALUED FUNCTIONS
CREATE OR REPLACE TYPE EMP_OBJECT FORCE IS OBJECT(EMP_NAME VARCHAR2(200), YEAR_BORN DATE); --Create object to store data
/
CREATE OR REPLACE TYPE EMPLOYEE_BORN IS TABLE OF EMP_OBJECT;--Create table to store emp objects
/
CREATE OR REPLACE FUNCTION BORN_AFTER_DATE(BIRTHYEAR IN NUMBER)
RETURN EMPLOYEE_BORN AS L_EMPS EMPLOYEE_BORN := EMPLOYEE_BORN();
N INTEGER :=0;
BEGIN
    FOR i IN (SELECT (FIRSTNAME||' '|| LASTNAME) AS EMP_NAME, BIRTHDATE AS BIRTH FROM EMPLOYEE WHERE BIRTHDATE > (TO_DATE(BIRTHYEAR,'YYYY')) )
        LOOP
        L_EMPS.EXTEND(); --Extend(): Allocates one element space.
        N:=N+1;
        L_EMPS(N) :=EMP_OBJECT(i.EMP_NAME,i.BIRTH);
        END LOOP;
    RETURN L_EMPS;
END;
/

SELECT * FROM TABLE(BORN_AFTER_DATE(1968)); -- RETURN ALL EMPLOYEES THAT WERE BORN AFTER 1968

-- 4.1 BASIC STORED PROCEDURES
CREATE OR REPLACE PROCEDURE FULLNAMES(S OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN S FOR
    SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END FULLNAMES;
/
DECLARE
S SYS_REFCURSOR;
FIRSTNAME CUSTOMER.FIRSTNAME%TYPE;
LASTNAME CUSTOMER.LASTNAME%TYPE;
BEGIN
    FULLNAMES(S);
    LOOP
    FETCH S INTO FIRSTNAME,LASTNAME;
    EXIT WHEN S%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(FIRSTNAME||' '||LASTNAME);
    END LOOP
    CLOSE;
END;
/
SET SERVEROUTPUT ON; -- SELECTED ONLY THE FIRST AND LAST NAME OF ALL EMPLOYEES

-- 4.2 STORED PROCEDURES INPUT PARAMETERS
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE_ADDRESS(
    E_EMPLOYEEID IN EMPLOYEE.EMPLOYEEID%TYPE,
    E_ADDRESS IN EMPLOYEE.ADDRESS%TYPE,
    E_CITY IN EMPLOYEE.CITY%TYPE,
    E_STATE IN EMPLOYEE.STATE%TYPE,
    E_COUNTRY IN EMPLOYEE.COUNTRY%TYPE,
    E_POSTALCODE IN EMPLOYEE.POSTALCODE%TYPE,
    E_PHONE IN EMPLOYEE.PHONE%TYPE,
    E_FAX IN EMPLOYEE.FAX%TYPE)
IS
BEGIN
    UPDATE EMPLOYEE SET ADDRESS = E_ADDRESS,
    CITY = E_CITY,
    STATE = E_STATE,
    COUNTRY = E_COUNTRY,
    POSTALCODE = E_POSTALCODE,
    PHONE = E_PHONE,
    FAX = E_FAX
    WHERE EMPLOYEEID = E_EMPLOYEEID;
END;
/
SELECT FIRSTNAME||' '||LASTNAME||' ''s Address is '||ADDRESS||' '||CITY||', '
||STATE||' '||POSTALCODE||' '||COUNTRY||' with phone # '||PHONE||' and fax # '||FAX
FROM EMPLOYEE WHERE EMPLOYEEID = 8; -- SHOWS THE ADDRESS BEFORE THE CHANGE
EXECUTE UPDATE_EMPLOYEE_ADDRESS(15,'6724 DORY RD', 'NEW YORK CITY', 'NY', 96754, 'USA', '(657) 958-2547', '(657) 958- 6512');
SELECT FIRSTNAME||' '||LASTNAME||' ''s Address is '||ADDRESS||' '||CITY||', '
||STATE||' '||POSTALCODE||' '||COUNTRY||' with phone # '||PHONE||' and fax # '||FAX
FROM EMPLOYEE WHERE EMPLOYEEID = 8; -- SHOWS THE ADDRESS AFTER THE CHANGE

CREATE OR REPLACE PROCEDURE MANAGERS(S OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN S FOR
    SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE WHERE TITLE LIKE '% Manager %' AND (REPORTSTO = 1 OR REPORTSTO IS NULL);
END MANAGERS;
/
DECLARE
S SYS_REFCURSOR;
FIRSTNAME CUSTOMER.FIRSTNAME%TYPE;
LASTNAME CUSTOMER.LASTNAME%TYPE;
BEGIN
    MANAGERS(S);
    LOOP
    FETCH S INTO FIRSTNAME,LASTNAME;
    EXIT WHEN S%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(FIRSTNAME||' '||LASTNAME);
    END LOOP
    CLOSE;
END;
/
SET SERVEROUTPUT ON; -- RETURNED THE MANAGERS OF THE EMPLOYEES

-- 4.3 STORED PROCEDURES OUTPUT PARAMETERS
CREATE OR REPLACE PROCEDURE CUSTOMERS(S OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN S FOR
    SELECT FIRSTNAME, COMPANY FROM CUSTOMER;
END CUSTOMERS;
/
DECLARE
S SYS_REFCURSOR;
FIRSTNAME CUSTOMER.FIRSTNAME%TYPE;
COMPANY CUSTOMER.COMPANY%TYPE;
BEGIN
    CUSTOMERS(S);
    LOOP
    FETCH S INTO FIRSTNAME,COMPANY;
    EXIT WHEN S%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(FIRSTNAME||'       '||COMPANY);
    END LOOP
    CLOSE;
END;
/
SET SERVEROUTPUT ON; -- RETURNS THE NAME AND COMPANY OF THE CUSTOMER

-- 5.0 TRANSACTIONS
DELETE FROM INVOICE WHERE INVOICEID = 'invoiceid';
COMMIT; -- DELETE THE INVOICE OF A GIVEN INVOICEID

CREATE PROCEDURE INSERT_CUSTOMER (IN c_customer_id INT(11), IN c_first_name VARCHAR(15) IN c_last_name VARCHAR(15), IN c_order VARCHAR(10))
BEGIN
    INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, ORDER)
    VALUES (c_customer_id, c_first_name, c_last_name, c_order);
END
GO -- INSERT A NEW RECORD IN CUSTOMER WITHIN A STORED PROCEDURE

-- 6.1 AFTER/FOR
CREATE OR REPLACE TRIGGER INSERT_ON_EMPLOYEE
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
SELECT s.CUSTOMERID FROM CUSTOMER AS c;
INSERT INTO INVOICE
SET CUSTOMERID = s.CUSTOMERID;
END; -- AFTER INSERT TRIGGER WITHIN EMPLOYEE TABLE AFTER A NEW RECORD IS INSERTED

CREATE OR REPLACE TRIGGER UPDATE_ON_ALBUM
AFTER UPDATE ON ALBUM
FOR EACH ROW
DECLARE
BEGIN
    UPDATE ALBUM SET ARTISTID = 777 WHERE ARTISTID = 266;
END;
/
SELECT ARTISTID FROM ALBUM WHERE ARTISTID = '266'; -- AFTER UPDATE TRIGGER ON ALBUM TABLE AFTER A ROW IS INSERTED

CREATE OR REPLACE TRIGGER DELETE_ON_CUSTOMER
AFTER DELETE ON CUSTOMER
BEGIN
    SELECT c.CUSTOMERID FROM CUSTOMER AS c;
    DELETE FROM INVOICE
    WHERE CUSTOMERID = c.CUSTOMERID;
END; -- AFTER DELETE ON THE CUSTOMER TABLE AFTER A ROW IS DELETED

-- 7.1 INNER
SELECT CUSTOMER.FIRSTNAME, INVOICE.INVOICEID FROM CUSTOMER INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;-- JOINED THE CUSTOMER AND ORDERS, AND SPECIFY THE NAME OF THE CUSTOMER AND INVOICEID

-- 7.2 OUTER
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICEID, TOTAL
FROM CUSTOMER FULL OUTER JOIN INVOICE
ON CUSTOMER.CUSTOMERID != INVOICE.CUSTOMERID; -- JOINED CUSTOMER AND INVOICE TABLE, SPECIFYING THE CUSTOMERID, FIRSTNAME, LASTNAME, INVOICEID, AND TOTAL.

-- 7.3 RIGHT
SELECT ARTIST.NAME, ALBUM.TITLE FROM ARTIST RIGHT JOIN ALBUM
ON ARTIST.ARTISTID = ALBUM.ARTISTID; -- JOINS ALBUM AND ARTIST SPECIFYING ARTIST NAME AND TITLE

-- 7.4 CROSS
SELECT * FROM ARTIST CROSS JOIN ALBUM
ORDER BY ARTIST.NAME; -- JOINS ALBUM AND ARTIST AND SORTS BY ARTIST NAME IN ASCENDING ORDER

-- 7.5 SELF
SELECT A.FIRSTNAME, B.FIRSTNAME AS REPORTS_TO
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.REPORTSTO = B.EMPLOYEEID;-- JOINED EMPLOYEE TABLE WITH ITSELF BASED ON REPORTSTO COLUMN