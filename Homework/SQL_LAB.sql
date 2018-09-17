/* KEVIN MEDARA
 * 09/07/2018
 *SQL LAB for Week 2
*/

/*2.1 SELECT*/
/*Select all records from Employee*/
SELECT * FROM Employee;

/*Select all employees with last name 'King'*/
SELECT * FROM Employee WHERE LASTNAME = 'King';

/*Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.*/
SELECT * FROM Employee WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

/*2.2 ORDER BY*/
/*Select all albums in Album table and sort result set in descending order by title.*/
SELECT * FROM ALBUM ORDER BY TITLE DESC;

/*Select first name from Customer and sort result set in ascending order by city*/
SELECT * FROM ALBUM ORDER BY TITLE ASC;

/*2.3 INSERT INTO*/
/*Insert two new records into Genre table */
INSERT ALL
INTO GENRE (GENREID, NAME) VALUES(26, 'Classic Rock')
INTO GENRE (GENREID, NAME) VALUES(27, 'Pan Flute')
SELECT * FROM dual;

/*Task – Insert two new records into Employee table*/
INSERT ALL
INTO EMPLOYEE (EMPLOYEEID,LASTNAME,FIRSTNAME,TITLE,REPORTSTO,BIRTHDATE,HIREDATE,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL) 
VALUES(9,'Medara','Kevin','CEO',null,TO_DATE('2003/10/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'),TO_DATE('2006/05/07 21:02:44', 
        'yyyy/mm/dd hh24:mi:ss'),'2631 University Blvd','Jacksonville','FL','United States','32211','222-22-2222','333-33-3333','kevin@gmail.com')
INTO EMPLOYEE (EMPLOYEEID,LASTNAME,FIRSTNAME,TITLE,REPORTSTO,BIRTHDATE,HIREDATE,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL)
VALUES(10,'Knighten','Matthew','Janitor',null,TO_DATE('2003/10/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'),TO_DATE('2003/10/03 21:02:44', 
        'yyyy/mm/dd hh24:mi:ss'),'123 This Road','Tampa','FL','United States','12345','603-973-4609','111-111-1111','jason@hotmail.com')
SELECT * FROM dual;

/*Task – Insert two new records into Customer table*/
INSERT ALL 
INTO CUSTOMER (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) 
VALUES (60, 'This', 'Guy', 'Company', 'Address', 'Rochester', 'NH', 'United states', '32211-3221', '6034567896', '123-45-6789', 'myemail@company.com', 4)
INTO CUSTOMER (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) 
VALUES (61, 'New', 'Person', 'Embraer - Empresa Brasileira de Aeronáutica S.A.', 'Av. Brigadeiro Faria Lima, 2170', 'São José dos Campos', 'SP', 'Brazil', '12227-000', '+55 (12) 3923-5555', '+55 (12) 3923-5566', 'thisone@company.com', 5)
SELECT * FROM DUAL;

/*2.4 UPDATE*/
/*Task – Update Aaron Mitchell in Customer table to Robert Walter*/
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert',LASTNAME = 'Walter'
WHERE FIRSTNAME ='Aaron' AND LASTNAME = 'Mitchell';

/*Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”*/
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

/*2.5 LIKE*/
/*Task – Select all invoices with a billing address like “T%” */
SELECT * FROM INVOICE 
WHERE BILLINGADDRESS LIKE 'T%';

/*2.6 BETWEEN*/
/*Task – Select all invoices that have a total between 15 and 50*/
SELECT * FROM INVOICE 
WHERE TOTAL BETWEEN 15 AND 20;

/*Task – Select all employees hired between 1st of June 2003 and 1st of March 2004*/

SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN TO_DATE('2003/06/01', 'YYYY/MM/DD') AND TO_DATE('2005/03/01','YYYY/MM/DD');

/*2.7 DELETE*/
/*Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).*/
DELETE FROM INVOICELINE
WHERE INVOICEID IN (
SELECT INVOICEID FROM INVOICE 
      WHERE CUSTOMERID IN (
           SELECT CUSTOMERID FROM CUSTOMER
                WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter'));               
DELETE FROM INVOICE 
WHERE CUSTOMERID IN (
SELECT CUSTOMERID FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter');

delete from CUSTOMER
where FIRSTNAME='Robert' AND LASTNAME='Walter';

/* 3. SQL Functions*/
/*In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database*/

/*3.1 System Defined Functions*/
/*Task – Create a function that returns the current time.*/
SELECT TO_CHAR(CURRENT_TIMESTAMP, ' hh12:mi:ss') FROM dual; /*did not include date because only time was asked for*/

/*Task – create a function that returns the length of name in MEDIATYPE table*/
CREATE OR REPLACE TYPE NAME_OBJECT IS OBJECT(NAME VARCHAR2(120), NAME_LENGTH NUMBER);//*Below function will return a set of NAME_OBJECTs*/
CREATE OR REPLACE TYPE NUMBERS IS TABLE OF NAME_OBJECT;/

CREATE OR REPLACE FUNCTION COLUMN_VALUE_LENGTHS
RETURN NUMBERS AS L_NUMBERS NUMBERS :=NUMBERS();
N INTEGER :=0;
BEGIN
FOR i IN (SELECT NAME, LENGTH(MEDIATYPE.NAME) AS VALUE_LENGTH FROM MEDIATYPE )
LOOP
L_NUMBERS.EXTEND();
N:=N+1;
L_NUMBERS(N) :=NAME_OBJECT(i.NAME,i.VALUE_LENGTH);
END LOOP;
RETURN L_NUMBERS;
END;/

SELECT * FROM TABLE(COLUMN_VALUE_LENGTHS);

/*3.2 System Defined Aggregate Functions
Task – Create a function that returns the average total of all invoices*/ 
CREATE OR REPLACE FUNCTION GET_AVG_TOTAL
RETURN NUMBER AS AVG_TOTAL NUMBER;
BEGIN 
    SELECT AVG(TOTAL) INTO AVG_TOTAL FROM INVOICE;
    RETURN ROUND(AVG_TOTAL,2);
 END;
 /
 
SELECT GET_AVG_TOTAL() as AVERAGE_INVOICE FROM DUAL; /*ONE USER CREATED FUNCTION, ONE SYSTEM FUNCTION*/
SELECT ROUND(AVG(TOTAL),2) AS AVERAGE FROM INVOICE;

/*Task – Create a function that returns the most expensive track*/
UPDATE TRACK
SET UNITPRICE = 5.99
WHERE NAME = 'Carolina Hard-Core Ecstasy'; /*Update a track to be the most expensive*/
CREATE OR REPLACE FUNCTION EXPENSIVE_TRACK
RETURN VARCHAR2 AS MOST_EXPENSIVE VARCHAR2(200);
BEGIN 
    SELECT NAME INTO MOST_EXPENSIVE FROM TRACK WHERE UNITPRICE = (SELECT MAX(UNITPRICE) FROM TRACK);
    RETURN MOST_EXPENSIVE;
    RETURN TRACK_PRICE;
 END;
 / 
SELECT EXPENSIVE_TRACK() FROM DUAL; /*ONE USER CREATED FUNCTION, ONE SYSTEM FUNCTION*/
SELECT NAME FROM TRACK WHERE UNITPRICE = (SELECT MAX(UNITPRICE) FROM TRACK);

/*3.3 User Defined Scalar Functions
Task – Create a function that returns the average price of invoiceline items in the invoiceline table*/
CREATE OR REPLACE FUNCTION AVG_INVOICELINE
RETURN NUMBER AS AVG_LINE NUMBER;
BEGIN 
    SELECT AVG(UNITPRICE) INTO AVG_LINE FROM INVOICELINE;
    RETURN ROUND(AVG_LINE, 2);
 END;
/
SELECT AVG_INVOICELINE() FROM DUAL;

/*3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who are born after 1968.*/
/*Creates new employee object with name and year born
 * Create table to fill with new objects 
 * function takes in variable of year you want to check
 * iterates through and finds employees born after specified year 
 */
CREATE OR REPLACE TYPE EMP_OBJECT FORCE IS OBJECT(EMP_NAME VARCHAR2(200), YEAR_BORN DATE);
/
CREATE OR REPLACE TYPE EMPLOYEE_BORN IS TABLE OF EMP_OBJECT;
/
CREATE OR REPLACE FUNCTION BORN_AFTER_DATE(BIRTHYEAR IN NUMBER)
RETURN EMPLOYEE_BORN AS L_EMPS EMPLOYEE_BORN := EMPLOYEE_BORN();
N INTEGER :=0;
BEGIN
    FOR i IN (SELECT (FIRSTNAME||' '|| LASTNAME) AS EMP_NAME, BIRTHDATE AS BIRTH FROM EMPLOYEE WHERE BIRTHDATE > (TO_DATE(BIRTHYEAR,'YYYY')) )
        LOOP
        L_EMPS.EXTEND();
        N:=N+1;
        L_EMPS(N) :=EMP_OBJECT(i.EMP_NAME,i.BIRTH);
        END LOOP;
    RETURN L_EMPS;
END;
/

SELECT * FROM TABLE(BORN_AFTER_DATE(1968));
/*4.0 Stored Procedures
 In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
4.1 Basic Stored Procedure
Task – Create a stored procedure that selects the first and last names of all the employees.*/
SET SERVEROUTPUT ON;
--PROCEDURE UTILIZING CURSORS
CREATE OR REPLACE PROCEDURE GETEMPLOYEENAMES
(S OUT SYS_REFCURSOR)
IS 
BEGIN
OPEN S FOR
SELECT EMPLOYEEID,(FIRSTNAME||' '||LASTNAME) FROM EMPLOYEE;
END;
/

DECLARE --Creates a new variable. Variables must be declared before use
S SYS_REFCURSOR;
EMP_ID EMPLOYEE.EMPLOYEEID%TYPE; --SETS ALBUM_ID TO DATA TYPE OF ALBUM.ALBUMID
EMP_NAME EMPLOYEE.FIRSTNAME%TYPE;
BEGIN 
    GETEMPLOYEENAMES(S);
    LOOP
        FETCH S INTO EMP_ID, EMP_NAME; --retrieves rows of data from the result set of a multiple-row query
        EXIT WHEN S%NOTFOUND; --BREAKS LOOP WHEN NO MORE ROWS ARE AVAILABLE
        DBMS_OUTPUT.PUT_LINE(EMP_ID||' IS CURRENT ID, '||EMP_NAME||' IS CURRENT NAME');
    END LOOP
CLOSE;
END;
/ 
/*4.2 Stored Procedure Input Parameters
Task – Create a stored procedure that updates the personal information of an employee.*/
CREATE OR REPLACE PROCEDURE UPDATEEMPLOYEEPERSONALINFO
(EID IN INT, FNAME IN VARCHAR2, LNAME IN VARCHAR2, BIRTH IN DATE, 
    ADDR IN VARCHAR2, ECITY IN VARCHAR2, ESTATE IN VARCHAR2, ECOUNTRY IN VARCHAR2,
    EPOSTALCODE IN VARCHAR2, EPHONE IN VARCHAR2,EFAX IN VARCHAR2, EEMAIL IN VARCHAR2)
AS
BEGIN
UPDATE EMPLOYEE 
    SET 
    FIRSTNAME = FNAME,
    LASTNAME = LNAME,
    BIRTHDATE = BIRTH,
        ADDRESS = ADDR,
        CITY = ECITY,
        STATE = ESTATE,
        COUNTRY = ECOUNTRY,
        POSTALCODE = EPOSTALCODE,
        PHONE = EPHONE, 
        FAX = EFAX, 
        EMAIL = EEMAIL
    WHERE EMPLOYEEID = EID;
COMMIT;
END;
/

EXECUTE UPDATEEMPLOYEEPERSONALINFO(9,'ROBERT','Medara', '08-JUL-95','10 Spring Street', 'Keene', 'NH','United States','03041','234-543-4566','555-444-6789','kmedara2015@outlook.com');
        
/*Task – Create a stored procedure that returns the managers of an employee .
4.3 Stored Procedure Output Parameters
Task – Create a stored procedure that returns the name and company of a customer.*/
CREATE OR REPLACE PROCEDURE GETCUSTOMERCOMPANY(CUST_ID IN INT, GCC OUT SYS_REFCURSOR)
AS 
BEGIN
OPEN GCC FOR
SELECT COMPANY,FIRSTNAME
FROM CUSTOMER
WHERE CUSTOMERID = CUST_ID;
END;
/
DECLARE
GCC SYS_REFCURSOR;
CUSTOMER_COMPANY CUSTOMER.COMPANY%TYPE;
CUSTOMER_NAME CUSTOMER.FIRSTNAME%TYPE;
BEGIN 
    GETCUSTOMERCOMPANY(5,GCC);
    LOOP
        FETCH GCC INTO CUSTOMER_COMPANY, CUSTOMER_NAME; --retrieves rows of data from the result set of a multiple-row query
        EXIT WHEN GCC%NOTFOUND; --BREAKS LOOP WHEN NO MORE ROWS ARE AVAILABLE
        DBMS_OUTPUT.PUT_LINE('CUSTOMER: ' ||CUSTOMER_NAME);
        DBMS_OUTPUT.PUT_LINE('COMPANY: ' ||CUSTOMER_COMPANY);
        END LOOP
CLOSE;
END;
/ 

/*5.0 Transactions
In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).*/
CREATE OR REPLACE PROCEDURE DELETEINVOICE(ID_TO_DELETE IN INT)
AS
BEGIN
DELETE FROM INVOICELINE WHERE INVOICEID = ID_TO_DELETE;
DELETE FROM INVOICE WHERE INVOICEID = ID_TO_DELETE;
COMMIT;
END;
/
call DELETEINVOICE(1);/*Thought it would be better utilized as a stored procedure, able to pass in id number*/
/*Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table*/
CREATE SEQUENCE CUSTSEQ;
CREATE OR REPLACE PROCEDURE INSERTCUSTOMER(FIRSTNAME IN VARCHAR2, LASTNAME IN VARCHAR2, EMAIL IN VARCHAR2)
AS
BEGIN
INSERT INTO CUSTOMER VALUES(CUSTSEQ.NEXTVAL +60, FIRSTNAME,LASTNAME,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,EMAIL,NULL);/*Used +60 because rows were already in the table*/
COMMIT;
END;
/
call INSERTCUSTOMER('Kevin','Medara','medara.ke@gmail.com'); 
call INSERTCUSTOMER('Matthew','Knighten', 'mknighten@gmail.com');

/*6.0 Triggers
In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
6.1 AFTER/FOR
Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.*/
SET SERVEROUTPUT ON;
CREATE OR REPLACE TRIGGER TR_EMPLOYEE_REPORTSTO /*Reminds user to input a reportsto value in case this employee reports to a manager*/
AFTER INSERT
ON EMPLOYEE
  FOR EACH ROW
BEGIN
  IF(:NEW.REPORTSTO = '' OR :NEW.REPORTSTO IS NULL) THEN
   DBMS_OUTPUT.PUT_LINE('REMEMBER TO INDICATE WHO THIS EMPLOYEE REPORTS TO' );
  ELSE
  INSERT INTO EMPLOYEE(EMPLOYEEID,LASTNAME,FIRSTNAME,REPORTSTO) VALUES(:NEW.EMPLOYEEID,:NEW.LASTNAME,:NEW.FIRSTNAME,:NEW.REPORTSTO);
  END IF;  
END;
/
/*Task – Create an after update trigger on the album table that fires after a row is inserted in the table*/
CREATE OR REPLACE TRIGGER TR_ALBUM_AFTERTITLEUPDATE /*INFORMS USER OF THEIR CHANGES WHEN TITLE IS UPDATED*/
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
 DBMS_OUTPUT.PUT_LINE('CHANGED: '|| :OLD.TITLE || 'TO: ' || :NEW.TITLE|| ' FOR ALBUM: ' || :OLD.ALBUMID );
END;
/
/*Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.*/
CREATE OR REPLACE TRIGGER TR_CUSTOMER_AFTERDELETE
AFTER DELETE ON CUSTOMER
FOR EACH ROW 
BEGIN 
 DBMS_OUTPUT.PUT_LINE('YOU HAVE DELETED CUSTOMER '||:OLD.CUSTOMERID||' '|| :OLD.FIRSTNAME || ' ' || :OLD.LASTNAME );
END;
/
/*7.0 JOINS*/
/*7.1 INNER*/
/*Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.*/
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID
FROM CUSTOMER
INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID ORDER BY FIRSTNAME ASC;

/*7.2 OUTER
Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.*/
/*Used right because it doesn't returns customers with null invoiceid and total*/
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME,INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER
RIGHT OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID; 

/*7.3 RIGHT
Task – Create a right join that joins album and artist specifying artist name and title.*/
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST
RIGHT JOIN ALBUM ON ARTIST.ARTISTID = ALBUM.ARTISTID;

/*7.4 CROSS
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.*/
SELECT * 
FROM ARTIST
CROSS JOIN ALBUM WHERE ARTIST.ARTISTID = ALBUM.ARTISTID ORDER BY ARTIST.NAME ASC;

/*7.5 SELF
Task – Perform a self-join on the employee table, joining on the reportsto column.*/
/*Concatenates names for employees, joins on reportsto, leaves out rows where A.employee is b. employee*/
SELECT (A.FIRSTNAME ||' '|| A.LASTNAME) AS EMPLOYEENAME_1, A.REPORTSTO 
FROM EMPLOYEE A 
JOIN EMPLOYEE B ON A.REPORTSTO = B.EMPLOYEEID;



