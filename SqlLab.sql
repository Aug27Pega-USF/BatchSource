                        --SQL_LAB
--1 

-- 2.0 SQL QUERIES

--2.1 SELECT ALL RECORDS FROM THE EMPLOYEE TABLE
SELECT * FROM EMPLOYEE;
--SELECT ALL RECORDS FROM EMPLOYEE WHERE LAST NAME IS KING
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
-- select all records from employee where first name is Andrew and reportsto is null;
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

-- Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM 
ORDER BY TITLE DESC;

-- Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME, CITY FROM CUSTOMER
ORDER BY CITY ASC;

-- Insert two new records into Genre table 
--SELECT * FROM GENRE;
INSERT INTO GENRE VALUES(26, 'Reggaeton');
INSERT INTO GENRE VALUES(27, 'Kasav');
--Insert two new records into Employee table
SELECT * FROM EMPLOYEE;
INSERT INTO EMPLOYEE VALUES (9,'AL', 'AMADOU', 'IT Staff', 1, '10-Oct-1978', '09-Sep-18', '12702 BB Downs Blvd', 'Tampa', 'Fl','US','Tk1 3NF', '+1 (813) 990-3847',null, 'somebody@email.com');
INSERT INTO EMPLOYEE VALUES (10,'Joe', 'AMADOU', 'IT Staff', 1, '09-Dec-1971', '09-Sep-18', '12704 BB Downs Blvd', 'Tampa', 'Fl','US','Tk2 2NF', '+1 (813) 690-3847',null, 'somejoe@email.com');

--Insert two new records into Customer table
SELECT * FROM CUSTOMER;
INSERT INTO CUSTOMER VALUES (60, 'JOAKIM', 'LUIS', 'Revature', '3320 Banyan Circle', 'Tampa', 'Fl', 'US', '33613', '+49 0228 9225', null, 'joakim@myemail.com', 3);
INSERT INTO CUSTOMER VALUES (61, 'BALLEMA', 'LORE', 'Revature', '3120 Banyan Circle', 'Tampa', 'Fl', 'US', '33613', '+49 0228 3225', null, 'lore2018@myemail.com', 5);

-- Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER 
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' and LASTNAME = 'Mitchell';
-- Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”	
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME='Creedence Clearwater Revival';

-- Select all invoices with a billing address like “T%” 
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

-- Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
--Select all employees hired between 1st of June 2003 and 1st of March 20 04
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-2003' AND '01-MAR-2004';

--Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
--before we delete we need to alter/remove constraints because the customer has an invoice (there is a relation between customer and invoice)
ALTER TABLE Invoice DROP CONSTRAINT FK_InvoiceCustomerId;
-- that is you alter/delete the child first; then we delete the(parent) customer
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

-- 3.0 SQL FUNCTIONS

-- 3.1 Create a function that returns the current time.
select current_timestamp from dual;

-- create a function that returns the length of name in MEDIATYPE table
SELECT LENGTH(NAME) FROM MEDIATYPE;

-- Create a function that returns the average total of all invoices 

CREATE OR REPLACE FUNCTION AVG_TOTAL
RETURN NUMBER AS AVG_TOTAL NUMBER;
BEGIN
    SELECT AVG(TOTAL) INTO AVG_TOTAL FROM INVOICE;
    RETURN AVG_TOTAL;
END AVG_TOTAL;


SELECT AVG_TOTAL FROM DUAL;

--Create a function that returns the most expensive track
--SELECT BYTES, UNITPRICE, TRACKID, (BYTES * UNITPRICE) FROM TRACK;
CREATE OR REPLACE FUNCTION MOST_EXPENSIVE
RETURN NUMBER AS EXPENSIVE NUMBER;
BEGIN
    SELECT  MAX(BYTES * UNITPRICE) INTO EXPENSIVE FROM TRACK;
    RETURN EXPENSIVE;
END;
/

SELECT MOST_EXPENSIVE FROM DUAL;

-- 3.3 Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION AVG_INVOI
RETURN NUMBER AS AVG_PRICE NUMBER;
BEGIN
   SELECT AVG(UNITPRICE) INTO AVG_PRICE FROM INVOICELINE;
   RETURN AVG_PRICE;
END;
/

SELECT avg_invoi FROM DUAL;

-- 3.4 Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE TYPE EMP_OBJECT FORCE IS OBJECT(EMP_NAME VARCHAR2(200), YEAR_BORN DATE); /*Create object to store data*/
/
CREATE OR REPLACE TYPE EMPLOYEE_BORN IS TABLE OF EMP_OBJECT;/*Create table to store emp objects*/
/
CREATE OR REPLACE FUNCTION BORN_AFTER_DATE(BIRTHYEAR IN NUMBER)
RETURN EMPLOYEE_BORN AS L_EMPS EMPLOYEE_BORN := EMPLOYEE_BORN();
N INTEGER :=0;
BEGIN
    FOR i IN (SELECT (FIRSTNAME||' '|| LASTNAME) AS EMP_NAME, BIRTHDATE AS BIRTH FROM EMPLOYEE WHERE BIRTHDATE > (TO_DATE(BIRTHYEAR,'YYYY')) )
        LOOP
        L_EMPS.EXTEND(); /*Extend(): Allocates one element space.*/
        N:=N+1;
        L_EMPS(N) :=EMP_OBJECT(i.EMP_NAME,i.BIRTH);
        END LOOP;
    RETURN L_EMPS;
END;
/

SELECT * FROM TABLE(BORN_AFTER_DATE(1968));

--4.0 STORED PROCEDURES

--4.1 Create a stored procedure that selects the first and last names of all the employees.
--USING EXPLICIT CURSOR DECLARATION AND OPENING
CREATE OR REPLACE PROCEDURE SELECT_NAMES
(VAL OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN VAL FOR
    SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/
--CALL THE PROCEDURE
DECLARE
VAL SYS_REFCURSOR;
V_FIRSTNAME EMPLOYEE.FIRSTNAME%TYPE;
V_LASTNAME  EMPLOYEE.LASTNAME%TYPE;
BEGIN
    SELECT_NAMES(VAL);--CALL PROCEDURE AND OPEN CURSOR
    LOOP
    FETCH VAL INTO V_FIRSTNAME, V_LASTNAME;
    EXIT WHEN VAL%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(V_FIRSTNAME || ' , ' || V_LASTNAME);
    END LOOP
CLOSE;
END;
/

--4.2
-- Create a stored procedure that updates the personal information of an employee.

CREATE OR REPLACE PROCEDURE UPDATE_AN_EMPLOYEE_INFO
(I_EMP_ID IN NUMBER, I_FIRSTNAME IN VARCHAR2,I_LASTNAME IN VARCHAR2)
AS
BEGIN
    UPDATE EMPLOYEE
    SET FIRSTNAME = I_FIRSTNAME, LASTNAME = I_LASTNAME
    WHERE I_EMP_ID = EMPLOYEEID;
    COMMIT;
END;
/

EXECUTE UPDATE_AN_EMPLOYEE_INFO(9, 'AL','Amadou');


-- Create a stored procedure that returns the managers of an employee .
SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE GET_REPORTSTO_NUM 
(S OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN S FOR
    SELECT REPORTSTO, FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/

DECLARE
EMP_ID  EMPLOYEE.EMPLOYEEID%TYPE;
FIRSTNAME  EMPLOYEE.FIRSTNAME%TYPE;
LASTNAME  EMPLOYEE.LASTNAME%TYPE;
REPORTSTO  EMPLOYEE.REPORTSTO%TYPE;
EMPLOYEE  EMPLOYEE.EMPLOYEE%TYPE;
S SYS_REFCURSOR;
BEGIN
    GET_REPORTSTO_NUM(S);
    LOOP
    FETCH S INTO REPORTSTO, FIRSTNAME, LASTNAME;
    SELECT S FROM DUAL JOIN EMPLOYEE ON EMP_ID = REPORSTO;
    EXIT WHEN S%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(FIRSTNAME || ' REPORTS TO ' || REPORTSTO);
    END LOOP
CLOSE;
END;
/


--4.3 Create a stored procedure that returns the name and company of a customer.
SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE GET_NAME_AND_COMPANY
(I_CUSTOMERID IN NUMBER)
AS
V_FIRST CUSTOMER.FIRSTNAME%TYPE;
V_LAST CUSTOMER.LASTNAME%TYPE;
V_COMP CUSTOMER.COMPANY%TYPE;
BEGIN
    SELECT FIRSTNAME, LASTNAME, COMPANY 
    INTO V_FIRST, V_LAST, V_COMP
    FROM CUSTOMER
    WHERE I_CUSTOMERID = CUSTOMERID;
    DBMS_OUTPUT.PUT_LINE(' FIRSTNAME: ' || V_FIRST || ' LASTNAME: ' || V_LAST || ' COMPANY: ' || V_COMP);
END;
/

EXECUTE GET_NAME_AND_COMPANY(10);

--LET'S CREATE SOME SEQUENCES
CREATE SEQUENCE SQ_INSERT_EMPL
START WITH 11
INCREMENT BY 1;
  

--5.0 TRANSACTIONS
--Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
--THESE ARE THE SQLs

ALTER TABLE INVOICELINE DROP CONSTRAINT FK_INVOICELINEINVOICEID;
ALTER TABLE INVOICE DROP CONSTRAINT FK_INVOICECUSTOMERID;
DELETE FROM INVOICE WHERE INVOICEID = INVOICEID;

--Create a transaction nested within a stored procedure that inserts a new record in the Customer 
--CREATE OR REPLACE PROCEDURE ADD_NEW_RECORD
--(C_ID IN NUMBER, FIRST IN VARCHAR2, LAST IN VARCHAR2, ADDR IN VARCHAR2, CITY IN VARCHAR2, ST IN VARCHAR2,CTRY IN VARCHAR2, PCODE IN VARCHAR2,
--PH IN VARCHAR2, FAX IN VARCHAR2, EMAIL IN VARCHAR2, SUP IN NUMBER)
--AS
--BEGIN
--    BEGIN 
--        INSERT INTO CUSTOMER VALUES(C_ID,FIRST, LAST, COMP, ADDR, CITY,ST,CTRY, PCODE, PH, FAX, EMAIL, SUP);
--    COMMIT;
--END;
--END;



--6.0 TRIGERS
--6.1 Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER TR_INSERT_ON_EMPLOYEE_AFTER
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
DECLARE
FIRST EMPLOYEE.FIRSTNAME%TYPE;
LAST EMPLOYEE.LASTNAME%TYPE;
PHONE EMPLOYEE.PHONE%TYPE;
EMAIL EMPLOYEE.EMAIL%TYPE;
BEGIN
    INSERT INTO EMPLOYEE VALUES(SQ_INSERT_EMPL.nextval, FIRST, LAST,NULL ,NULL, NULL, NULL, NULL,NULL,NULL, NULL,NULL,PHONE,NULL,EMAIL);
    DBMS_OUTPUT.PUT_LINE(FIRST || LAST || PHONE || EMAIL);
END TR_INSERT_ON_EMPLOYEE_AFTER;

-- Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER TR_UPDATE_ON_ALBUM_AFTER
AFTER UPDATE ON ALBUM
FOR EACH ROW
DECLARE
A_ID ARTIST.ARTISTID%TYPE;
A_NAME ARTIST.NAME%TYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE(' ARTIST ' || A_NAME || ' WITH ID ' || A_ID || ' HAS BEEN UPDATED');
END TR_UPDATE_ON_ALBUM_AFTER;

--Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER TR_DELETE_ON_CUSTOMER_AFTER
AFTER DELETE ON CUSTOMER
FOR EACH ROW
DECLARE
C_ID INVOICE.CUSTOMERID%TYPE;
BEGIN
    DELETE FROM INVOICE WHERE CUSTOMERID = C_ID;
    DBMS_OUTPUT.PUT_LINE(C_ID || 'HAS BEEN DELETED');
END TR_INSERT_ON_EMPLOYEE_AFTER;


--7.0 JOINS

--7.1 Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT FIRSTNAME, LASTNAME, INVOICEID
FROM CUSTOMER
INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.INVOICEID;

--Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME,INVOICE.INVOICEID,INVOICE.TOTAL
FROM CUSTOMER
FULL OUTER JOIN INVOICE ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID;

--Create a right join that joins album and artist specifying artist name and title.
SELECT NAME, TITLE
FROM ALBUM
RIGHT JOIN ARTIST ON ALBUM.ARTISTID = ARTIST.ARTISTID;

--Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT NAME 
FROM ALBUM CROSS JOIN ARTIST
ORDER BY NAME;

--Perform a self-join on the employee table, joining on the reportsto column.
--SELECT * FROM EMPLOYEE;
SELECT ((A.FIRSTNAME || ' ' ) || (' '|| A.LASTNAME))AS EMPLOYEENAME, ((B.FIRSTNAME ||' ' )  || ( ' '|| B.LASTNAME)) AS REPORTSTONAME
FROM EMPLOYEE A JOIN EMPLOYEE B 
ON A.REPORTSTO = B.EMPLOYEEID;










