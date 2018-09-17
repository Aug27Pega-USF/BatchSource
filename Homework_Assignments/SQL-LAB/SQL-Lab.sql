/***********************/
/* Section 2 - Queries */
/***********************/

--2.1 Select
/*
Task – Select all records from the Employee table. 
Task – Select all records from the Employee table where last name is King. 
Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
*/

SELECT * FROM Employee;

SELECT * FROM Employee WHERE LastName = 'King';

SELECT * FROM Employee WHERE FirstName = 'Andrew' AND ReportsTo is NULL;

--2.2 Order By
/*
Task – Select all albums in Album table and sort result set in descending order by title. 
Task – Select first name from Customer and sort result set in ascending order by city
*/

SELECT * FROM Album ORDER BY Title DESC;

SELECT FirstName FROM Customer ORDER BY City ASC;

--2.3 INSERT INTO
/*
Task – Insert two new records into Genre table  
Task – Insert two new records into Employee table 
Task – Insert two new records into Customer table 
*/

INSERT INTO Genre (GenreId, Name) VALUES (26, 'Chiptune');
INSERT INTO Genre (GenreId, Name) VALUES (27, 'Polka');

INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (9, 'Smith', 'Tom', 'Sales Support Agent', 2, TO_DATE('1968-1-9 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-3-4 00:00:00','yyyy-mm-dd hh24:mi:ss'), '923 7 ST NW', 'Lethbridge', 'AB', 'Canada', 'T1H 1Y8', '+1 (403) 424-3323', '+1 (403) 424-8111', 'tom_s@chinookcorp.com');
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (10, 'Lewis', 'Jerry', 'IT Staff', 6, TO_DATE('1968-1-9 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-3-4 00:00:00','yyyy-mm-dd hh24:mi:ss'), '923 7 ST NW', 'Lethbridge', 'AB', 'Canada', 'T1H 1Y8', '+1 (403) 467-8444', '+1 (403) 467-8444', 'jerry_l@chinookcorp.com');

INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (60, 'Willy', 'Billy', '123 Sesame Street', 'Brooklyn', 'USA', '188888', '123 456 7890', 'willy.billy@billy.com', 3);
INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (61, 'Puja', 'Srivastava', '825 Captain Toms Crossing', 'Johns Island', 'USA', '43025', '843 814 4017', 'zrjames@live.com', 3);


--2.4 UPDATE
/*
Task – Update Aaron Mitchell in Customer table to Robert Walter 
Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR” 
*/

UPDATE Customer SET FirstName = 'Robert', LastName = 'Walter' WHERE FirstName = 'Aaron' AND LastName = 'Mitchell';

UPDATE Artist SET Name = 'CCR' WHERE Name = 'Creedence Clearwater Revival';

--2.5 LIKE 
/*
Task – Select all invoices with a billing address like “T%”  
*/

-- 'T%' the % acts like a wildcard with each letter before that asserting those are similar at the start
SELECT * FROM Invoice WHERE BillingAddress LIKE 'T%';

--2.6 BETWEEN
/*
Task – Select all invoices that have a total between 15 and 50 
Task – Select all employees hired between 1?st? of June 2003 and 1?st? of March 2004 
*/

SELECT * FROM Invoice WHERE Total BETWEEN 15 AND 50;

--2.7 DELETE 
/*
Task – Delete a record in Customer table where the name is Robert Walter 
(There may be constraints that rely on this, find out how to resolve them). 
*/

SELECT * FROM Customer;
--First method I found, deleting from customer first mentions constraints, so have to resolve by deleting the others first?
DELETE FROM InvoiceLine WHERE InvoiceId in ( select InvoiceId from Invoice where CustomerId in ( select CustomerId from Customer where FirstName = 'Robert' AND LastName = 'Walter')); --Delete the farthest child first
DELETE FROM Invoice WHERE CustomerId in ( select CustomerId from Customer where FirstName = 'Robert' AND LastName = 'Walter'); --Delete the next child
DELETE FROM Customer WHERE FirstName = 'Robert' AND LastName = 'Walter'; --finally delete the parent row
SAVE POINT save_2_7;

/*****************************/
/* Section 3 - SQL Functions */
/*****************************/

--3.1 System Defined Functions 
/*
Task – Create a function that returns the current time. 
Task – create a function that returns the length of name in MEDIATYPE table
*/

SELECT CURRENT_TIMESTAMP FROM SYS.dual;

SELECT length(name) FROM MediaType;
SELECT name, length(name) FROM MediaType;

--3.2 System Defined Aggregate Functions
/*
Task – Create a function that returns the average total of all invoices  
Task – Create a function that returns the most expensive track 
*/

SELECT AVG(Total) FROM Invoice;

SELECT MAX(UnitPrice) FROM Track;

--3.3 User Defined Scalar Functions 
/*
Task – Create a function that returns the average price of invoiceline items in the invoiceline table
*/

CREATE OR REPLACE FUNCTION get_invoice_average 
RETURN NUMBER AS 
the_average NUMBER;
    BEGIN   
        SELECT AVG(UnitPrice) 
        INTO the_average
        FROM InvoiceLine;

        RETURN the_average; 
    END;
/

SELECT get_invoice_average FROM dual;




--3.4 User Defined Table Valued Functions
/*
Task – Create a function that returns all employees who are born after 1968. 
*/

--CREATING A TYPE OF AN OBJECT THAT WILL STORE OUR NAME FOR EMPLOYEES 
CREATE OR REPLACE TYPE EMPLOYEE_OBJECT FORCE IS OBJECT(EMPLOYEE_NAME VARCHAR2(80)); 
/

--CREATING A TYPE OF TABLE TO HOLD OUR NEW OBJECTS
CREATE OR REPLACE TYPE EMPLOYEES_TABLE IS TABLE OF EMPLOYEE_OBJECT;
/

CREATE OR REPLACE FUNCTION BORN_AFTER_1968
RETURN EMPLOYEES_TABLE AS EBA EMPLOYEES_TABLE:=EMPLOYEES_TABLE(); --EBA IS AN ALIAS 
EBA_I INTEGER:=0; --USED TO INCREMENT THROUGH THE TABLE TYPE
BEGIN
    --EMP_REF IS BEING USED TO STORE A SELECT STATEMENT BASED ON OUR CONDITIONS
    FOR i IN (SELECT FIRSTNAME||' '|| LASTNAME || ' IS BORN AFTER 1968' AS EMPLOYEE_NAME FROM EMPLOYEE WHERE BIRTHDATE > (TO_DATE('1968','YYYY')) )
        LOOP
            EBA.EXTEND(); --APPENDS A NULL ENTRY TO OUR TABLE, INCREASING THE SIZE OF IT
            EBA_I:=EBA_I+1; --INCREMENT
            EBA(EBA_I):=EMPLOYEE_OBJECT(i.EMPLOYEE_NAME); --ADD TO OUR TABLE OBJECT JUST THE STRING PART
        END LOOP;
    RETURN EBA;
END;
/

SELECT * FROM TABLE(BORN_AFTER_1968);

/**********************************/
/* Section 4 - Stored Procedures  */
/**********************************/

--4.1 Basic Stored Procedure 
/*
Task – Create a stored procedure that selects the first and last names of all the employees.
*/

CREATE OR REPLACE PROCEDURE GETEMPLOYEENAMES
(S OUT SYS_REFCURSOR)
IS
BEGIN 
    OPEN S FOR SELECT FirstName || ' ' || LastName FROM EMPLOYEE;
END;
/

DECLARE
    S SYS_REFCURSOR;
    TEMP_EMP_TABLE VARCHAR(41);
BEGIN
    GETEMPLOYEENAMES(S);
    LOOP
        FETCH S INTO TEMP_EMP_TABLE;
        EXIT WHEN S%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(TEMP_EMP_TABLE);
    END LOOP;
    
    CLOSE S;
END;

--4.2 Stored Procedure Input Parameters 
/*
Task – Create a stored procedure that updates the personal information of an employee. 
Task – Create a stored procedure that returns the managers of an employee.
*/

CREATE OR REPLACE PROCEDURE UPDATE_EXISTING_EMPLOYEE
(EMP_ID IN NUMBER, FIRST_NAME IN VARCHAR2, LAST_NAME IN VARCHAR2)
AS 
BEGIN
    UPDATE EMPLOYEE SET FirstName = FIRST_NAME, LastName = LAST_NAME WHERE EMPLOYEEID = EMP_ID;
    COMMIT;
END;
/

EXECUTE UPDATE_EXISTING_EMPLOYEE(15, 'WOW', 'CHARLIE');
SELECT * FROM EMPLOYEE;

----------------------------------


CREATE OR REPLACE PROCEDURE GET_EMPLOYEE_MANAGERS
(EMP_ID NUMBER, S OUT SYS_REFCURSOR)
IS 
BEGIN
  OPEN S FOR
  SELECT FIRSTNAME || ' ' || LASTNAME 
  FROM EMPLOYEE WHERE EMPLOYEEID IN (SELECT REPORTSTO FROM EMPLOYEE WHERE EMPLOYEEID = EMP_ID);
END;
/

DECLARE
    S SYS_REFCURSOR;
    TEMPNAME VARCHAR(41);
BEGIN
    GET_EMPLOYEE_MANAGERS(2,S); --CHANGE 2 TO OTHER EMPLOYEE IDS TO GET THEIR MANAGER
    FETCH S INTO TEMPNAME;
    DBMS_OUTPUT.PUT_LINE(TEMPNAME);
    CLOSE S;
END;
/

--4.3 Stored Procedure Output Parameters
/*
Task – Create a stored procedure that returns the name and company of a customer. 
*/

CREATE OR REPLACE PROCEDURE GET_CUSTOMER_DETAILS
(CUS_ID NUMBER, S OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN S FOR
  SELECT FIRSTNAME||' '|| LASTNAME || ' WORKS AT ' || COMPANY
  FROM CUSTOMER WHERE CUSTOMERID = CUS_ID;
END;
/

DECLARE
    S SYS_REFCURSOR;
    TEMP VARCHAR2(140);
BEGIN
    GET_CUSTOMER_DETAILS(1, S); --CHANGE 1 TO ACCESS OTHER IDS
    FETCH S INTO TEMP;
    
    DBMS_OUTPUT.PUT_LINE(TEMP);
    CLOSE S;
END;



/*****************************/
/* Section 5 - Transactions  */
/*****************************/

/*
Task – Create a transaction that given a invoiceId will delete that invoice 
(There may be constraints that rely on this, find out how to resolve them). 
Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer 
table 
*/

CREATE OR REPLACE PROCEDURE DELETEINVOICE( invid NUMBER )  AS
    BEGIN 
        DELETE FROM InvoiceLine IL WHERE IL.InvoiceId in ( select InvoiceId from Invoice I where I.InvoiceId = INVID); 
        DELETE from Invoice I where I.InvoiceId = INVID;
        COMMIT; --HERE'S THE TRANSACTION
    END DELETEINVOICE;

CALL DELETEINVOICE(217);

SELECT * FROM INVOICE;

------------------------------------

CREATE SEQUENCE CUST_SEQ_PK
START WITH 62
INCREMENT BY 1;

CREATE OR REPLACE PROCEDURE ADDING_NEW_CUSTOMER
(FIRST_NAME IN VARCHAR2, LAST_NAME IN VARCHAR2)
AS 
BEGIN
    INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (CUST_SEQ_PK.NEXTVAL, FIRST_NAME, LAST_NAME, '825 Captain Toms Crossing', 'Johns Island', 'USA', '43025', '843 814 4017', 'zrjames@live.com', 3);
    COMMIT;
END;
/

EXECUTE ADDING_NEW_CUSTOMER('WOO', 'CHARLIE');

SELECT * FROM CUSTOMER;

/*************************/
/* Section 6 - Triggers  */
/*************************/

--6.1 AFTER/FOR
/*
Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table. 
Task – Create an after update trigger on the album table that fires after a row is inserted in the table 
Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table. 
*/

--SEQUENCE KEY FOR MAKING ADDING NEW EMPLOYEES EASIER
CREATE SEQUENCE SQ_EMPLOYEE_PK
START WITH 15
INCREMENT BY 1;

--NEW TABLE WE'LL BE ADDING ON TO
CREATE TABLE NEWLY_ADDED_EMPLOYEES
( EMPLOYEEID NUMBER NOT NULL );

--TRIGGER THAT UPDATES OUR NEW TABLE WHEN A NEW EMPLOYEE IS ADDED
CREATE OR REPLACE TRIGGER TR_INSERT_EMPLOYEE
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
    INSERT INTO NEWLY_ADDED_EMPLOYEES ( EMPLOYEEID ) VALUES ( :new.EMPLOYEEID);
END;
/
--INSERT STATEMENT
INSERT INTO Employee(EmployeeID, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (SQ_EMPLOYEE_PK.NEXTVAL, 'Smith', 'BOB', 'Sales Support Agent', 2, TO_DATE('1968-1-9 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-3-4 00:00:00','yyyy-mm-dd hh24:mi:ss'), '923 7 ST NW', 'Lethbridge', 'AB', 'Canada', 'T1H 1Y8', '+1 (403) 424-3323', '+1 (403) 424-8111', 'tom_s@chinookcorp.com');
--VIEW RESULTS
select * from NEWLY_ADDED_EMPLOYEES;


CREATE OR REPLACE TRIGGER TR_UPDATE_ALBUM
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
    dbms_output.put_line(' ALBUM ' || :NEW.TITLE || ' HAS BEEN CHANGED ');
END;
/

UPDATE ALBUM SET TITLE = 'Creedence Clearwater Revival' WHERE ALBUMID = 10;

SELECT * FROM ALBUM ORDER BY ALBUMID ASC;

--DELETES ALL NECESSARY ROWS FOR ME
CREATE OR REPLACE TRIGGER TR_DELETE_CUSTOMER
BEFORE DELETE ON CUSTOMER
FOR EACH ROW
DECLARE 
TEMP NUMBER;
BEGIN
    TEMP := :old.CUSTOMERID;
    DELETE FROM InvoiceLine IL WHERE IL.InvoiceId in ( select InvoiceId from Invoice where CustomerId = TEMP);
    DELETE FROM Invoice I WHERE I.CustomerId = TEMP;
END;
/

CREATE OR REPLACE TRIGGER TR_DELETE_CUSTOMER_AFTER
AFTER DELETE ON CUSTOMER
FOR EACH ROW
DECLARE 
TEMP NUMBER;
BEGIN
    TEMP := :old.CUSTOMERID;
    INSERT INTO NEWLY_ADDED_EMPLOYEES ( EMPLOYEEID ) VALUES ( TEMP);
END;
/

--DOES A BEFORE AND AFTER TRIGGER
DELETE FROM Customer WHERE CUSTOMERID = 3;

SELECT * FROM CUSTOMER;
SELECT * FROM NEWLY_ADDED_EMPLOYEES;

/**********************/
/* Section 7 - JOINS  */
/**********************/

--7.1 INNER 
/*
Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId. 
*/

SELECT FirstName, LastName, invoice.invoiceid FROM Customer INNER JOIN Invoice ON Customer.CustomerId = Invoice.CustomerId;

--7.2 OUTER 
/*
Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total. 
*/

SELECT Customer.CustomerId, FirstName, LastName, InvoiceID, Total FROM Customer FULL OUTER JOIN Invoice ON Customer.CustomerId = Invoice.CustomerId;

--7.3 RIGHT 
/*
Task – Create a right join that joins album and artist specifying artist name and title. 
*/

SELECT TITLE, NAME FROM ALBUM RIGHT OUTER JOIN ARTIST ON ALBUM.ARTISTID = ARTIST.ARTISTID;

--7.4 CROSS
/*
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order. 
*/

SELECT * FROM ARTIST CROSS JOIN ALBUM ORDER BY ARTIST.NAME ASC;

--7.5 SELF 
/*
Task – Perform a self-join on the employee table, joining on the reportsto column. 
*/

SELECT A.employeeID, B.reportsto AS reportsto 
FROM EMPLOYEE A JOIN EMPLOYEE B ON A.employeeid = B.reportsto;
