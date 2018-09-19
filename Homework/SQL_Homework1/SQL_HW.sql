/*SQL Lab
Due Tuesday September 18, 9am
1. Setting up Oracle Chinook
In this section you will begin the process of working with the Oracle Chinook database
(https://github.com/lerocha/chinook-database)
Task – Open the Chinook_Oracle.sql file and execute the scripts within.

2.0 SQL Queries
In this section you will be performing various queries against the Oracle Chinook database.

2.1 SELECT
Task – Select all records from the Employee table.
Task – Select all records from the Employee table where last name is King.
Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
*/
SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King'; 
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;


/*
2.2 ORDER BY
Task – Select all albums in Album table and sort result set in descending order by title.
Task – Select first name from Customer and sort result set in ascending order by city
*/
SELECT * FROM ALBUM ORDER BY TITLE ASC;
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;

SELECT SUBSTR('HELLO',3) FROM DUAL;
/*
2.3 INSERT INTO
Task – Insert two new records into Genre table
Task – Insert two new records into Employee table
Task – Insert two new records into Customer table
*/
INSERT INTO GENRE (GENREID, NAME) VALUES (26,'PUNK');
INSERT INTO GENRE (GENREID, NAME) VALUES (27,'Country');

INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE,HIREDATE, ADDRESS,CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL) 
VALUES (9,'Rivera','Luis','Software Developer', 6,TO_DATE('28-Aug-96','dd-mm-yy'),TO_DATE('2-Sep-18','dd-mm-yy'), '1101 Stanford Dr', 'Coral Gables', 'FL','US','33146','+1 (111) 111-1111','+1 (111) 111-1111','luisdoi@c.com' );
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE,HIREDATE, ADDRESS,CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL) 
VALUES (10,'Medara','Kevin','Software Developer', 6, TO_DATE('15-Dec-96','dd-mm-yy'),TO_DATE('2-Sep-18','dd-mm-yy'), '7380 Main St.', 'Hollywood', 'FL','US','25983','+1 (222) 222-2222','+1 (222) 222-2222','kmed@c.com' );

INSERT INTO CUSTOMER (CUSTOMERID, LASTNAME, FIRSTNAME, COMPANY, ADDRESS,CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID) 
VALUES (60,'Wick','John',null, '11234 Railroad Dr', 'Houston', 'TX','US','33146','+1 (111) 111-1111','+1 (111) 111-1111','jwick@c.com', 3);
INSERT INTO CUSTOMER (CUSTOMERID, LASTNAME, FIRSTNAME, COMPANY, ADDRESS,CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID) 
VALUES (61,'Sparrow','Jack',null, '7380 Main St.', 'Dallas', 'TX','US','25983','+1 (222) 222-2222','+1 (222) 222-2222','jspar@c.com', 4);


/*
2.4 UPDATE
Task – Update Aaron Mitchell in Customer table to Robert Walter
Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
*/
UPDATE CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

UPDATE ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';

/*
2.5 LIKE
Task – Select all invoices with a billing address like “T%”
*/

SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

/*
2.6 BETWEEN
Task – Select all invoices that have a total between 15 and 50
Task – Select all employees hired between 1
st of June 2003 and 1
st of March 2004
*/

SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

/*
2.7 DELETE
Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints
that rely on this, find out how to resolve them).
*/

ALTER TABLE INVOICE DROP CONSTRAINT FK_InvoiceCustomerId; 
ALTER TABLE INVOICE ADD CONSTRAINT FK_InvoiceCustomerId FOREIGN KEY (CustomerId)
        REFERENCES Customer (CustomerId) ON DELETE CASCADE;
ALTER TABLE INVOICELINE DROP CONSTRAINT FK_InvoiceLineInvoiceId;
ALTER TABLE INVOICELINE ADD CONSTRAINT FK_InvoiceLineInvoiceId FOREIGN KEY (InvoiceId)
            REFERENCES Invoice (InvoiceId) ON DELETE CASCADE;

DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';


/*
3. SQL Functions
In this section you will be using the Oracle system functions, as well as your own functions, to perform
various actions against the database

3.1 System Defined Functions
Task – Create a function that returns the current time.
Task – create a function that returns the length of name in MEDIATYPE table
*/
CREATE OR REPLACE FUNCTION GETTIME 
RETURN TIMESTAMP IS
    current_time TIMESTAMP;
    BEGIN 
        current_time := CURRENT_TIMESTAMP;
        RETURN current_time;
    END;
/

SELECT GETTIME FROM DUAL;

CREATE OR REPLACE FUNCTION getMEDIATYPELength(mediatypeidnum NUMBER)
RETURN number IS
    MTLen number(10) := 0;
BEGIN
    SELECT length(MEDIATYPE.NAME) INTO MTLen
    FROM MEDIATYPE
    WHERE MEDIATYPE.MEDIATYPEID = mediatypeidnum;
    
    RETURN MTLen;
END;
/
SELECT getMEDIATYPELength(3) FROM DUAL;


/*
3.2 System Defined Aggregate Functions
Task – Create a function that returns the average total of all invoices
Task – Create a function that returns the most expensive track
*/
CREATE OR REPLACE FUNCTION AVG_TOTAL_INVOICE
RETURN NUMBER IS
    avg_total NUMBER(10,2) := 0;
    num_invoices NUMBER(10) := 0;
BEGIN
    SELECT COUNT(TOTAL) INTO num_invoices FROM INVOICE;
    SELECT SUM(TOTAL) INTO avg_total FROM INVOICE;
    avg_total := avg_total/num_invoices;
RETURN
    avg_total;   
END;
/
SELECT AVG_TOTAL_INVOICE FROM DUAL;


CREATE OR REPLACE FUNCTION GETMOSTEXPENSIVETRACK
RETURN VARCHAR2 IS
    trk VARCHAR2(200);
    c NUMBER(10):= 0;
BEGIN
    SELECT COUNT(TRACK.NAME) INTO c FROM TRACK WHERE TRACK.UNITPRICE = (SELECT MAX(UNITPRICE) FROM TRACK);
    IF c > 1 THEN
        trk:= 'more than one maximum value. probably more than one entry with the same max value';
    ELSIF c = 1 THEN
        SELECT TRACK.NAME INTO trk FROM TRACK WHERE TRACK.UNITPRICE = (SELECT MAX(UNITPRICE) FROM TRACK);
    ELSE
        trk:= 'no max available';
    END IF;
    
    --SELECT NAME INTO trk FROM TRACK WHERE TRACK.UNITPRICE = (SELECT MAX(UNITPRICE) FROM TRACK);
RETURN trk;
END;
/

SELECT GETMOSTEXPENSIVETRACK FROM DUAL;

/*
3.3 User Defined Scalar Functions
Task – Create a function that returns the average price of invoiceline items in the invoiceline table
*/
CREATE OR REPLACE FUNCTION AVERAGE_INVOICELINE_PRICE
RETURN NUMBER AS 
    av NUMBER(10,2);
BEGIN
    SELECT AVG (UNITPRICE) INTO av
    FROM INVOICELINE;
RETURN
    av;
END;
/

SELECT AVERAGE_INVOICELINE_PRICE FROM DUAL;

/*
3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who are born after 1968.
*/

-- Employee object
CREATE OR REPLACE TYPE EMP_OBJ AS
OBJECT(
EMPLOYEEID NUMBER(6),
LASTNAME VARCHAR2(20),
FIRSTNAME VARCHAR2(20),
TITLE VARCHAR2(30),
BIRTHDATE DATE
);
/
-- Employee table that has employee objects
CREATE OR REPLACE TYPE EMP_BIRTHDATE IS TABLE OF EMP_OBJ;
/
-- Function that returns a table of employee objects born after a certain birthyear
CREATE OR REPLACE FUNCTION Employees_Born_After(BIRTHYEAR IN NUMBER)
RETURN EMP_BIRTHDATE AS
    EMPLOYEELIST EMP_BIRTHDATE := EMP_BIRTHDATE();
    N INTEGER := 1;
BEGIN
    FOR i IN (SELECT EMPLOYEEID,LASTNAME,FIRSTNAME,TITLE,BIRTHDATE
              FROM EMPLOYEE WHERE BIRTHDATE > (TO_DATE(BIRTHYEAR,'YYYY')) )
                LOOP
                    EMPLOYEELIST.EXTEND();
                    EMPLOYEELIST(N):= EMP_OBJ(i.employeeid, i.lastname, i.firstname, i.title, i.birthdate);
                    N := N+1;
                END LOOP;
    RETURN EMPLOYEELIST;
END;
/

SELECT Employees_Born_After(1968) FROM DUAL;

/*
4.0 Stored Procedures
In this section you will be creating and executing stored procedures. You will be creating various types
of stored procedures that take input and output parameters.

4.1 Basic Stored Procedure
Task – Create a stored procedure that selects the first and last names of all the employees.
*/
SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE GET_ALL_EMPS(S OUT SYS_REFCURSOR)
IS
BEGIN
OPEN S FOR 
SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE ;
END;
/

DECLARE
S SYS_REFCURSOR;
EMP_FIRSTNAME EMPLOYEE.FIRSTNAME%TYPE; -- SET EMP_FIRSTNAME TO WHATEVER DATA TYPE EMPLOYEE.FIRSTNAME IS
EMP_LASTNAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
    GET_ALL_EMPS(S);
    LOOP
    FETCH S INTO EMP_FIRSTNAME,EMP_LASTNAME;
    EXIT WHEN S%NOTFOUND;   --- BREAK OUT OF THE LOOP WHEN NO MORE ROWS ARE AVAILABLE
    DBMS_OUTPUT.PUT_LINE(' IS CURRENT NAME: ' || EMP_FIRSTNAME || ' ' || EMP_LASTNAME );
END LOOP
CLOSE;
END;
/

/*
4.2 Stored Procedure Input Parameters
Task – Create a stored procedure that updates the personal information of an employee.
Task – Create a stored procedure that returns the managers of an employee .
*/

CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE(FNAME IN VARCHAR2, LNAME IN VARCHAR2, NEWTITLE IN VARCHAR2)
IS
BEGIN
    UPDATE EMPLOYEE SET TITLE = NEWTITLE WHERE FIRSTNAME = FNAME AND LASTNAME = LNAME;
END;
/

EXECUTE UPDATE_EMPLOYEE('Luis','Rivera','CEO');


CREATE OR REPLACE PROCEDURE GET_EMP_MANAGER(FNAME IN VARCHAR2, LNAME IN VARCHAR2, S OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN S FOR SELECT FIRSTNAME,LASTNAME,EMPLOYEEID FROM EMPLOYEE WHERE EMPLOYEE.EMPLOYEEID = 
                (SELECT REPORTSTO FROM EMPLOYEE WHERE EMPLOYEE.FIRSTNAME = FNAME AND EMPLOYEE.LASTNAME = LNAME);  
END;
/

-- Use the stored procedure!
DECLARE
    S SYS_REFCURSOR;
    EMP_FNAME VARCHAR(20) := 'Michael';
    EMP_LNAME VARCHAR(20) := 'Mitchell';
    MGR_FNAME EMPLOYEE.FIRSTNAME%TYPE;
    MGR_LNAME EMPLOYEE.LASTNAME%TYPE;
    MGR_ID EMPLOYEE.EMPLOYEEID%TYPE;
BEGIN
    GET_EMP_MANAGER(EMP_FNAME,EMP_LNAME,S);
    LOOP
        FETCH S INTO MGR_FNAME, MGR_LNAME, MGR_ID;
        EXIT WHEN S%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('EMPLOYEE NAME: ' || EMP_FNAME || ' ' || EMP_LNAME || ' REPORTS TO ->');
        DBMS_OUTPUT.PUT_LINE('MANAGER NAME: ' || MGR_FNAME || ' ' || MGR_LNAME || ' ID: '||MGR_ID);
    END LOOP;
CLOSE S;
END;
/


/*
4.3 Stored Procedure Output Parameters
Task – Create a stored procedure that returns the name and company of a customer.
*/
CREATE OR REPLACE PROCEDURE GET_CUSTOMER_INFO(CID IN NUMBER, S OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN S FOR SELECT FIRSTNAME,LASTNAME,COMPANY FROM CUSTOMER WHERE CUSTOMER.CUSTOMERID = CID;
END;
/

DECLARE
    S SYS_REFCURSOR;
    C_ID NUMBER(5) := 5;
    C_FNAME VARCHAR2(20);
    C_LNAME VARCHAR2(20);
    C_COMPANY VARCHAR2(20);
BEGIN
    GET_CUSTOMER_INFO(C_ID, S);
    LOOP
        FETCH S INTO C_FNAME, C_LNAME, C_COMPANY;
        EXIT WHEN S%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('CUSTOMER INFO FOR ID#: '|| C_ID ||' IS '|| C_FNAME ||' '|| C_LNAME ||' '|| C_COMPANY);
    END LOOP;
    CLOSE S;
END;
/


/*
5.0 Transactions
In this section you will be working with transactions. Transactions are usually nested within a stored
procedure.
Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that
rely on this, find out how to resolve them).
Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer
table
*/
BEGIN
DELETE FROM INVOICE WHERE INVOICE.INVOICEID = 9;
END;

CREATE SEQUENCE SEQ_CUSTOMERID
START WITH 62
INCREMENT BY 1;

CREATE OR REPLACE PROCEDURE NEW_CUSTOMER(FNAME IN VARCHAR2,LNAME IN VARCHAR2,
CMPNY IN VARCHAR2, EML IN VARCHAR2)
AS
BEGIN
    INSERT INTO CUSTOMER(CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,EMAIL)
                VALUES(SEQ_CUSTOMERID.NEXTVAL,FNAME,LNAME,CMPNY,EML);
END;
/

EXECUTE NEW_CUSTOMER('Barrack','Obama','Revature','b.obamz@gov.com');



/*
6.0 Triggers
In this section you will create various kinds of triggers that work when certain DML statements are
executed on a table.

6.1 AFTER/FOR
Task - Create an after insert trigger on the employee table fired after a new record is inserted into the
table.
Task – Create an after update trigger on the album table that fires after a row is inserted in the table
Task – Create an after delete trigger on the customer table that fires after a row is deleted from the
table.
*/
SET SERVEROUTPUT ON;


CREATE OR REPLACE TRIGGER TR_AFTER_INSERT_EMPLOYEE
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('EMPLOYEE INSERTED HAS NAME: '|| :NEW.FIRSTNAME || ' ' || :NEW.LASTNAME || 
    ' TITLE: ' ||:NEW.TITLE || ' EMPLOYEEID: ' || :NEW.EMPLOYEEID );
END;
/
-- TESTING TR_AFTER_INSERT_EMPLOYEE ^
--INSERT INTO EMPLOYEE(EMPLOYEEID,LASTNAME,FIRSTNAME) VALUES(69,'HARAMBE','GEORGE');
--DELETE FROM EMPLOYEE WHERE EMPLOYEEID = 69;


CREATE OR REPLACE TRIGGER TR_AFTER_UPDATE_ALBUM
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('UPDATED ALBUM haD TITLE: ' ||:OLD.TITLE || 'ALBUMID: ' || 
    :OLD.ALBUMID || 'ARTISTID: ' || :OLD.ARTISTID);
    DBMS_OUTPUT.PUT_LINE('UPDATED ALBUM haS TITLE: ' ||:NEW.TITLE || 'ALBUMID: ' || 
    :NEW.ALBUMID || 'ARTISTID: ' || :NEW.ARTISTID);
END;
/

CREATE OR REPLACE TRIGGER TR_AFTER_DELETE_CUSTOMER
AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN 
    DBMS_OUTPUT.PUT_LINE('CUSTOMER DELETED WAS' || :OLD.FIRSTNAME || ' ' || 
    :OLD.LASTNAME || ' ' || 'CUSTOMERID: ' || :OLD.CUSTOMERID);
END;
/


/*
7.0 JOINS
In this section you will be working with combining various tables through the use of joins. You will work
with outer, inner, right, left, cross, and self joins.\
7.1 INNER
Task – Create an inner join that joins customers and orders and specifies the name of the customer and
the invoiceId.
*/
SELECT CUSTOMER.FIRSTNAME , INVOICE.INVOICEID 
FROM CUSTOMER 
INNER JOIN INVOICE 
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

/*
7.2 OUTER
Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId,
firstname, lastname, invoiceId, and total.
*/
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID,INVOICE.TOTAL 
FROM CUSTOMER
RIGHT OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

/*
7.3 RIGHT
Task – Create a right join that joins album and artist specifying artist name and title.
*/

SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST
RIGHT JOIN ALBUM
ON ALBUM.ARTISTID = ARTIST.ARTISTID;


/*
7.4 CROSS
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
*/

SELECT * 
FROM ARTIST 
CROSS JOIN ALBUM
ORDER BY ARTIST.NAME ASC;

/*
7.5 SELF
Task – Perform a self-join on the employee table, joining on the reportsto column.
Upload a .sql file containing your answers to your branch with each solution to each part marked with a
descriptive comment.
*/
SELECT A.FIRSTNAME, B.FIRSTNAME AS REPORTSTO FROM EMPLOYEE 
A LEFT JOIN EMPLOYEE B 
ON A.REPORTSTO = B.EMPLOYEEID;
/*
SELECT A.FIRSTNAME, B.FIRSTNAME
FROM EMPLOYEE A JOIN EMPLOYEE B
ON A.REPORTSTO = B.REPORTSTO
AND A.EMPLOYEEID <> B.EMPLOYEEID;
*/
