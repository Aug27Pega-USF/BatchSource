
-- 2.0 SQL Queries
--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT * FROM EMPLOYEE;

--Task – Select all records from the EMPLOYEE table where last name is King.
SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM 
ORDER BY TITLE DESC;

--Task – Select first name from CUSTOMER and sort result set in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER
ORDER BY CITY ASC; 

--2.3 INSERT INTO
--Task – Insert two new records into Genre table 
INSERT INTO GENRE VALUES(26, 'Dramady');
INSERT INTO GENRE VALUES (27, 'Funk');

--Task – Insert two new records into EMPLOYEE table
INSERT INTO EMPLOYEE VALUES(9, 'Jackson', 'Janet', 'Developer', 2, '12-JAN-82', '14-JUL-02', '825 272 Ave W', 'Lethbridge', 'AB', 'Canada', 'T1H 1Y8', '+1 (430) 456-7896', '+1 (403) 758-4356', 'janet@chinookcorp.com');
INSERT INTO EMPLOYEE VALUES(10, 'Robertson', 'Robert', 'Sales Support Agent', 3, '19-AUG-78', '01-MAY-12', '8654 21st Ave S', 'Calgary', 'AB', 'Canada', 'T2P 2T3', '+1 (403) 262-3423', '+1 (403) 222-7712', 'robert@chinookcorp.com');

--Task – Insert two new records into CUSTOMER table
INSERT INTO CUSTOMER VALUES(60, 'Mark', 'Campbell', NULL, '1 12th St', 'Santiago',NULL, 'India', '110018','+91 0124 39523988', NULL, 'Campbell.Mark@yahoo.cl',3);
INSERT INTO CUSTOMER VALUES(61, 'Amanda', 'Martin', 'Apple Inc.','100 Orange Ave','Tampa', 'FL', 'USA','32801','+1 (407) 900-7208', NULL, 'Amanda.Martin@gmail.com',5);

--2.4 UPDATE
--Task – Update Aaron Mitchell in CUSTOMER table to Robert Walter
UPDATE CUSTOMER 
SET FIRSTNAME =  'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell'; 
SELECT * FROM EMPLOYEE;


--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”    
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

--2.5 LIKE
--Task – Select all invoices with a billing address like “T%” 
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

--Task – Select all EMPLOYEEs hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE 
WHERE HIREDATE BETWEEN '01-JUN-2003' AND '01-MAR-2004';

--2.7 DELETE
--Task – Delete a record in CUSTOMER table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE INVOICE DROP CONSTRAINT FK_InvoiceCustomerId;
ALTER TABLE INVOICE ADD CONSTRAINT FK_InvoiceCustomerId FOREIGN KEY (CustomerId)
       REFERENCES Customer (CustomerId) ON DELETE CASCADE;
ALTER TABLE INVOICELINE DROP CONSTRAINT FK_InvoiceLineInvoiceId;
ALTER TABLE INVOICELINE ADD CONSTRAINT FK_InvoiceLineInvoiceId FOREIGN KEY (InvoiceId)
           REFERENCES Invoice (InvoiceId) ON DELETE CASCADE;

DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

--3. SQL Functions
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
SELECT CURRENT_TIMESTAMP FROM DUAL; 

--Task – create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION LEN_MEDIATYPE (M_ID NUMBER)
RETURN NUMBER IS LEN_MED NUMBER(10) := 0;
BEGIN
    SELECT LENGTH(MEDIATYPE.NAME)INTO LEN_MED FROM MEDIATYPE
    WHERE MEDIATYPEID = M_ID;
    RETURN LEN_MED;
END;
/

SELECT LEN_MEDIATYPE(3) FROM DUAL;

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices 
CREATE OR REPLACE FUNCTION AVG_INVOICE
RETURN NUMBER AS AVG_TOTAL NUMBER(10,2); 
BEGIN 
    SELECT AVG(TOTAL) INTO AVG_TOTAL FROM INVOICE;
    RETURN AVG_TOTAL;
END; 
/
SELECT AVG_INVOICE FROM DUAL;


--Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION MOST_EXPENSIVE 
RETURN NUMBER AS EXPENSIVE NUMBER(10,2);
BEGIN
    SELECT MAX(UNITPRICE) INTO EXPENSIVE FROM TRACK;
    RETURN EXPENSIVE;
END;
/ 

SELECT MOST_EXPENSIVE FROM DUAL; 

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION AVG_INVOICELINE
RETURN NUMBER AS AVG_PRICE NUMBER(10,2);
BEGIN 
	SELECT AVG(UNITPRICE) INTO AVG_PRICE FROM INVOICELINE;
    RETURN AVG_PRICE;
END; 
/ 

SELECT AVG_INVOICELINE FROM DUAL; 

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all EMPLOYEEs who are born after 1968.
CREATE OR REPLACE TYPE EMP_OBJECT FORCE IS OBJECT(EMP_NAME VARCHAR2(200), YEAR_BORN DATE); /*Create object to store data*/
/
CREATE OR REPLACE TYPE EMPLOYEE_BORN IS TABLE OF EMP_OBJECT;/*Create table to store emp objects*/
/
CREATE OR REPLACE FUNCTION BORN_AFTER_DATE(BIRTHYEAR IN NUMBER)
RETURN EMPLOYEE_BORN AS L_EMPS EMPLOYEE_BORN := EMPLOYEE_BORN();
N INTEGER :=0;
BEGIN
    FOR i IN (SELECT (FIRSTNAME||' '|| LASTNAME) AS EMP_NAME, 
    BIRTHDATE AS BIRTH FROM EMPLOYEE
    WHERE BIRTHDATE > (TO_DATE(BIRTHYEAR,'YYYY')) )
        LOOP
        L_EMPS.EXTEND(); /*Extend(): Allocates one element space.*/
        N:=N+1;
        L_EMPS(N) :=EMP_OBJECT(i.EMP_NAME,i.BIRTH);
        END LOOP;
    RETURN L_EMPS;
END;
/
--4.0 Stored Procedures 
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE GET_NAMES
(N OUT SYS_REFCURSOR)
IS 
BEGIN
OPEN N FOR 
SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/

DECLARE 
N SYS_REFCURSOR;
FIRSTNAME EMPLOYEE.FIRSTNAME%TYPE; 
LASTNAME EMPLOYEE.LASTNAME%TYPE;
BEGIN 
    GET_NAMES(N);
    LOOP
    FETCH N INTO FIRSTNAME, LASTNAME;
    EXIT WHEN N%NOTFOUND; 
    DBMS_OUTPUT.PUT_LINE(FIRSTNAME|| '  '|| LASTNAME);
    END LOOP
    CLOSE;
END;
/
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE EMP_PERSONAL_INFO
(EMPID IN NUMBER, LNAME IN VARCHAR2, FNAME IN VARCHAR2, TTL IN VARCHAR2, REPORTS2 IN NUMBER, BDATE IN DATE, HDATE IN DATE, ADDRESS IN VARCHAR2, CITY IN VARCHAR2, ST IN VARCHAR2, CNTRY IN VARCHAR2, POSTAL IN VARCHAR2, PHN IN VARCHAR2, WHY_BOTHER IN VARCHAR2, EM IN VARCHAR2)
AS 
BEGIN
    UPDATE EMPLOYEE
	SET LASTNAME = LNAME, FIRSTNAME = FNAME, TITLE = TTL, REPORTSTO = REPORTS2, BIRTHDATE = BDATE, HIREDATE = HDATE, ADDRESS = ADDRESS, CITY = CITY, STATE = ST, COUNTRY = CNTRY, POSTALCODE = POSTAL, PHONE = PHN, FAX = WHY_BOTHER, EMAIL = EM
    WHERE EMPLOYEEID = EMPID;
COMMIT;
END;
/

--Task – Create a stored procedure that returns the managers of an employee
SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE GET_INFO(EMPID IN INT, N OUT SYS_REFCURSOR)
AS 
BEGIN
OPEN N FOR
SELECT EMPLOYEEID,(FIRSTNAME||' '||LASTNAME),REPORTSTO FROM EMPLOYEE
WHERE EMPLOYEEID = EMPID;
END;
/
DECLARE
N SYS_REFCURSOR;
EMPID EMPLOYEE.EMPLOYEEID%TYPE;
EMPNAME EMPLOYEE.FIRSTNAME%TYPE;
EMPMNGR EMPLOYEE.EMPLOYEEID%TYPE;
BEGIN 
    GET_INFO(2,N);
    LOOP
        FETCH N INTO EMPID,EMPNAME, EMPMNGR; --retrieves rows of data from the result set of a multiple-row query
        EXIT WHEN N%NOTFOUND; --BREAKS LOOP WHEN NO MORE ROWS ARE AVAILABLE
        DBMS_OUTPUT.PUT_LINE('Employee: ' ||EMPID);
        DBMS_OUTPUT.PUT_LINE('Reports to: ' ||EMPMNGR);
        END LOOP
CLOSE;
END;
/

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE GET_INFO(CUSTID IN INT, N OUT SYS_REFCURSOR)
AS 
BEGIN
OPEN N FOR
SELECT COMPANY,(FIRSTNAME||' '||LASTNAME) FROM CUSTOMER
WHERE CUSTOMERID = CUSTID;
END;
/
DECLARE
N SYS_REFCURSOR;
CUSTCOMPANY CUSTOMER.COMPANY%TYPE;
CUSTNAME CUSTOMER.FIRSTNAME%TYPE;
BEGIN 
    GET_INFO(2,N);
    LOOP
        FETCH N INTO CUSTCOMPANY, CUSTNAME; --retrieves rows of data from the result set of a multiple-row query
        EXIT WHEN N%NOTFOUND; --BREAKS LOOP WHEN NO MORE ROWS ARE AVAILABLE
        DBMS_OUTPUT.PUT_LINE('CUSTOMER: ' ||CUSTNAME);
        DBMS_OUTPUT.PUT_LINE('COMPANY: ' ||CUSTCOMPANY);
        END LOOP
CLOSE;
END;
/


--5.0 Transactions 
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
SAVEPOINT S1;
BEGIN 
    DELETE FROM INVOICE WHERE INVOICE.INVOICEID = 5;
END;
/
ROLLBACK TO S1;

--Task – Create a transaction nested within a stored procedure that inserts a new record in the CUSTOMER table
CREATE OR REPLACE PROCEDURE INSERT_NEW
(CUSTOMERID IN NUMBER,FIRSTNAME IN VARCHAR2, LASTNAME IN VARCHAR2, COMPANY IN VARCHAR2,
ADDRESS IN NUMBER, CITY IN DATE, STATE IN DATE, COUNTRY IN VARCHAR2, POSTALCODE IN VARCHAR2, 
PHONE IN VARCHAR2, FAX IN VARCHAR2, EMAIL IN VARCHAR2, SUPPORTREPID IN VARCHAR2)
AS
BEGIN 
    INSERT INTO CUSTOMER VALUES(62, 'Albert', 'Einstein', 'Apple Inc.', '2711 W Berry Street', 'Cupertino', 'CA', 'USA', '95014', '+1 (408) 996-1010', '+1 (408) 996-1011', 'al.einstein@gmail.com', NULL);
COMMIT;
END;
/
BEGIN
    DELETE FROM CUSTOMER WHERE CUSTOMERID = 62;
COMMIT;
END;
/

--6.0 Triggers 
--Task - Create an after insert trigger on the EMPLOYEE table fired after a new record is inserted into the table.
CREATE or REPLACE TRIGGER EMP_FIRED 
AFTER INSERT 
	ON EMPLOYEE
	FOR EACH ROW 
BEGIN
	IF (:NEW.STATE != 'AB')
	THEN DBMS_OUTPUT.PUT_LINE('CRUSH THEM');
	END IF; 
END EMP_FIRED;
/

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE or REPLACE TRIGGER ABLUM_CHANGE
AFTER INSERT 
	ON ALBUM
	FOR EACH ROW 
BEGIN
	IF (:NEW.TITLE != :OLD.TITLE)
	THEN DBMS_OUTPUT.PUT_LINE('It was fine the way it was');
    END IF;
END ALBUM_CHANGE;
/
--Task – Create an after delete trigger on the CUSTOMER table that fires after a row is deleted from the table.
CREATE or REPLACE TRIGGER CUSTOMER_CHANGE
AFTER INSERT 
	ON CUSTOMER
	FOR EACH ROW 
BEGIN
	IF (:NEW.ADDRESS != :OLD.ADDRESS)
	THEN DBMS_OUTPUT.PUT_LINE('Bye faithless customer');
	END IF; 
END CUSTOMER_CHANGE;
/

--7.0 JOINS
--7.1 INNER
--Task – Create an inner join that joins CUSTOMERs and orders and specifies the name of the CUSTOMER and the invoiceId.
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID FROM CUSTOMER
INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID; 

--7.2 OUTER
--Task – Create an outer join that joins the CUSTOMER and invoice table, specifying the CUSTOMERId, firstname, lastname, invoiceId, and total.
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL FROM CUSTOMER 
FULL OUTER JOIN Invoice ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT ARTIST.NAME, ALBUM.TITLE FROM ALBUM 
RIGHT JOIN ARTIST ON ALBUM.ARTISTID = ARTIST.ARTISTID;

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT ALBUM.ALBUMID, ALBUM.TITLE, ARTIST.ARTISTID, ARTIST.NAME FROM ALBUM 
CROSS JOIN ARTIST
ORDER BY ARTIST.NAME ASC;

--7.5 SELF
--Task – Perform a self-join on the EMPLOYEE table, joining on the reportsto column.
SELECT A.REPORTSTO AS REPORTSTO1, B.REPORTSTO AS REPORTSTO2, A.CITY 
FROM REPORTSTO A, REPORTSTO B 
WHERE A.EMPLOYEEID <> B.EMPLOYEEID
AND A.CITY=B.CITY 
ORDER BY A.CITY;
