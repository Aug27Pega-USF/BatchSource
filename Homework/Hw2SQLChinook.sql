/*2.1*/
SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;
/*2.2*/
SELECT * FROM ALBUM ORDER BY TITLE DESC;
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY; 
/*2.3*/
INSERT ALL 
    INTO GENRE (GENREID, NAME) VALUES (26, 'Electro-Swing')
    INTO GENRE (GENREID, NAME) VALUES (27, 'Experimental')
SELECT * FROM DUAL;

INSERT ALL
    INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (9, 'Alpha', 'Bet', 'IT Staff', 6, TO_DATE('1970-1-1 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-1-1 00:00:00','yyyy-mm-dd hh24:mi:ss'), '111 West Falls Drive', 'Lethbridge', 'AB', 'Canada', 'T1K 1N8', '+1 (403) 000-0001', '+1 (403) 000-0000', 'Alpha@chinookcorp.com')
    INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (10, 'Zeta', 'Omega', 'IT Staff', 6, TO_DATE('1970-12-31 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-12-31 00:00:00','yyyy-mm-dd hh24:mi:ss'), '999 9 ST NE', 'Lethbridge', 'AB', 'Canada', 'T1H 9Y8', '+1 (403) 999-9998', '+1 (403) 999-9999', 'Zeta@chinookcorp.com')
SELECT * FROM DUAL;

INSERT ALL
    INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (60, 'Ted', 'Vullus', '7 Hopeful Lane', 'New Hope', 'Iowa', '77341', '4853729505', 'TEDVUL@hotmail.com', 2)
    INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (61, 'Sal', 'Drummond', '800 Synthetic Circle', 'Pale Side', 'Ark City', '99994', '1192340223', 'sal_drummond@gmail.com', 2)
SELECT * FROM DUAL;

/*2.4*/
UPDATE CUSTOMER
SET FIRSTNAME='Robert',  LASTNAME= 'Walter'
WHERE  FIRSTNAME='Aaron' AND LASTNAME= 'Mitchell';


UPDATE ARTIST
SET NAME='CCR'
WHERE NAME='Creedence Clearwater Revival';

/*2.5*/
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

/*2.6*/
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN TO_DATE('2003-6-1 00:00:00','yyyy-mm-dd hh24:mi:ss') AND TO_DATE('2004-3-1 00:00:00','yyyy-mm-dd hh24:mi:ss');

/*2.7* Have to delete invoiceline first, then invoice, then customer/
DELETE (SELECT *
        FROM invoiceline ivl
        INNER JOIN invoice iv
            ON ivl.invoiceid = iv.invoiceid
        INNER JOIN customer cu
            ON cu.customerid = iv.customerid where cu.FIRSTNAME='Robert' AND cu.LASTNAME = 'Walter');
DELETE (SELECT *
        FROM invoice iv
        INNER JOIN customer cu
            ON cu.customerid = iv.customerid where cu.FIRSTNAME='Robert' AND cu.LASTNAME = 'Walter');
DELETE FROM CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME = 'Walter';

/*3.1* This returns varchar2, could be changed to a date, but date variables are annoying./
CREATE OR REPLACE FUNCTION DISPLAY_CURRENT_TIME
RETURN VARCHAR2 AS
    hey VARCHAR2(10);
    BEGIN
    SELECT TO_CHAR(CURRENT_TIMESTAMP, 'hh24:mi:ss') 
    INTO hey
    FROM DUAL;
    RETURN hey;
    END;
    /

select display_current_time() from dual;    

/*Creates a name object, a table of name object, and returns it in the function with a for loop*/
CREATE OR REPLACE TYPE NAME_OBJ IS OBJECT(NAME VARCHAR2(120), NAME_LENGTH NUMBER);
/
CREATE OR REPLACE TYPE NUMBERS IS TABLE OF NAME_OBJ;
/

CREATE OR REPLACE FUNCTION COLUMN_NAME_LENGTH
RETURN NUMBERS AS
    L_NUMBERS NUMBERS :=NUMBERS();
    N INTEGER :=0;
BEGIN
    FOR I IN (SELECT NAME, LENGTH(THIS.NAME) AS VALUE_LENGTH FROM MEDIATYPE THIS)
    LOOP
        L_NUMBERS.EXTEND;
        N:=N+1;
        L_NUMBERS(N) := NAME_OBJ(I.NAME,I.VALUE_LENGTH);
        END LOOP;
    RETURN L_NUMBERS;
    END;
    /
    
SELECT * FROM TABLE (COLUMN_NAME_LENGTH);

/*3.2*/

CREATE OR REPLACE FUNCTION AVG_INVOICE_TOTAL
RETURN NUMBER AS
    AVG_TOTAL NUMBER;
    BEGIN
        SELECT AVG(TOTAL) INTO AVG_TOTAL FROM INVOICE;
        RETURN ROUND(AVG_TOTAL,2);
    END;
/

SELECT AVG_INVOICE_TOTAL() FROM DUAL;

UPDATE TRACK SET UNITPRICE=2.99 WHERE TRACKID=3179;
CREATE OR REPLACE FUNCTION MOST_EXPENSIVE_TRACK
RETURN VARCHAR2 AS
    TRACK_NAME VARCHAR2(200);
    BEGIN
        SELECT NAME INTO TRACK_NAME FROM TRACK WHERE UNITPRICE=(SELECT MAX(UNITPRICE) FROM TRACK);
        RETURN TRACK_NAME;
    END;
/
SELECT MOST_EXPENSIVE_TRACK() FROM DUAL;

/*3.3*/
CREATE OR REPLACE FUNCTION AVG_INVOICELINE_PRICE
RETURN NUMBER AS
    AVG_PRICE NUMBER;
    BEGIN
        SELECT AVG(UNITPRICE) INTO AVG_PRICE FROM INVOICELINE;
        RETURN ROUND(AVG_PRICE,2);
    END;
/

SELECT AVG_INVOICELINE_PRICE() FROM DUAL;

/*3.4* Create a object with name, then a table, then return the table./

CREATE OR REPLACE TYPE EMP_NAME FORCE IS OBJECT(FIRSTNAME VARCHAR2(20), LASTNAME VARCHAR2(20));
/
CREATE OR REPLACE TYPE EMP_TABLE IS TABLE OF EMP_NAME;
/
CREATE OR REPLACE FUNCTION BORN_AFTER_68
RETURN EMP_TABLE AS
    L_EMP_TABLE EMP_TABLE :=EMP_TABLE();
    N INTEGER :=0;
BEGIN
    FOR I IN (SELECT FIRSTNAME,LASTNAME FROM EMPLOYEE WHERE BIRTHDATE>TO_DATE('1968-12-31 23:59:59','yyyy-mm-dd hh24:mi:ss'))
    LOOP
        L_EMP_TABLE.EXTEND;
        N:=N+1;
        L_EMP_TABLE(N) := EMP_NAME(I.FIRSTNAME,I.LASTNAME);
        END LOOP;
    RETURN L_EMP_TABLE;
    END;
    /
    
SELECT * FROM TABLE (BORN_AFTER_68);

/*4.0* Uses a cursor because procedures don't return anything, so you have to use a cursor to output stuff./
CREATE OR REPLACE PACKAGE types
AS
    TYPE ref_cursor IS REF CURSOR;
END;
/

CREATE OR REPLACE PROCEDURE GET_EMPLOYEE_NAMES(cursor_ OUT TYPES.REF_CURSOR)
as name_cursor types.ref_cursor;
begin
    open name_cursor for
        select firstname,lastname from EMPLOYEE;
        dbms_sql.return_result(name_cursor);
     end;
    /
var c refcursor;
exec get_employee_names(:c);

/*4.2 Stored Procedure Input Parameters
Task ?Create a stored procedure that returns the managers of an employee .*/

CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE_INFO (EMPLOYEEID1 IN NUMBER,ADDRESS1 IN VARCHAR2, CITY1 IN VARCHAR2, STATE1 IN VARCHAR2, COUNTRY1 IN VARCHAR2, POSTALCODE1 IN VARCHAR2, PHONE1 IN VARCHAR2,FAX1 IN VARCHAR2,EMAIL1 IN VARCHAR2) as
BEGIN
    UPDATE EMPLOYEE SET ADDRESS=ADDRESS1, CITY=CITY1, STATE=STATE1, COUNTRY=COUNTRY1,POSTALCODE=POSTALCODE1,PHONE=PHONE1,FAX=FAX1,EMAIL=EMAIL1 WHERE EMPLOYEEID=EMPLOYEEID1;
 END;
 /
 
 EXEC UPDATE_EMPLOYEE_INFO(9, '111 UNO AVENUE', 'ALBERTA', 'AB', 'Canada', 'A1A 1A1', '+1 (111) 000-0001', '+1 (111) 000-0000', 'Alpha@chinookcorp.com');
 SELECT * FROM EMPLOYEE;
 
/*Connect by prior is better than self join in this case*/
 
CREATE OR REPLACE PROCEDURE RETURN_MANAGERS(EMPLOYEEID1 IN NUMBER, cursor_ OUT TYPES.REF_CURSOR)
as 
name_cursor types.ref_cursor;
begin
        open name_cursor for
        select firstname || ' ' || lastname as manager_name from employee start with employeeid=(select reportsto from employee where employeeid=employeeid1) connect by prior reportsto=employeeid;
        dbms_sql.return_result(name_cursor);
        end;
/
    
var d refcursor;
exec return_managers(9,:d);
exec return_managers(2,:d);
exec return_managers(1,:d);

/*4.3* Returns a cursor for same reason./
CREATE OR REPLACE PROCEDURE RETURN_COMPANY(CUSTOMERID1 IN NUMBER, cursor_ OUT TYPES.REF_CURSOR)
as 
name_cursor types.ref_cursor;
begin
        open name_cursor for
        select firstname || ' ' || lastname as CUSTOMER_NAME, COMPANY AS COMPANY_NAME from CUSTOMER WHERE CUSTOMERID=CUSTOMERID1;
        dbms_sql.return_result(name_cursor);
        end;
/
var E refcursor;
exec RETURN_COMPANY(9,:E);
exec RETURN_COMPANY(10,:E);   

/*5.0 need to delete invoiceline before invoice*/
CREATE OR REPLACE PROCEDURE DELETE_INVOICE(invoiceID1 IN NUMBER)
as
begin
    Delete (select * from invoiceline where invoiceid=invoiceid1);
    delete (select * from invoice where invoiceid=invoiceid1);
    COMMIT WORK;
    end;
/

CREATE OR REPLACE PROCEDURE INSERT_CUSTOMER(FirstName1 IN VARCHAR2, LastName1 IN VARCHAR2, COMPANY1 IN VARCHAR2, Address1 IN VARCHAR2, City1 IN VARCHAR2, STATE1 IN VARCHAR2, Country1 IN VARCHAR2, PostalCode1 IN VARCHAR2, Phone1 IN VARCHAR2, FAX1 IN VARCHAR2, Email1 IN VARCHAR2, SupportRepId1 IN NUMBER)
AS
BEGIN
    INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES ((SELECT MAX(CUSTOMERID)+1 FROM CUSTOMER),FIRSTNAME1,LASTNAME1,COMPANY1, ADDRESS1,CITY1,STATE1,COUNTRY1,POSTALCODE1,PHONE1,FAX1,EMAIL1,SUPPORTREPID1);
    COMMIT WORK;
    END;
/
exec INSERT_CUSTOMER('JOE', 'SCHMOE', 'GENERIC', 'JACK 23 WEST DRIVE', 'ATLANTA', 'GA', 'USA', '34843', '(123)-123-1234', '(123)-123-1236', 'JOESCHOME@EMAIL.COM', 6);

/*6.1*/

CREATE SEQUENCE EMPLOYEE_PK_SEQ
MINVALUE 1
MAXVALUE 999999999
START WITH 11
INCREMENT BY 1
NOCACHE;
/

CREATE OR REPLACE TRIGGER TR_INSERT_EMPLOYEE
AFTER INSERT ON EMPLOYEE
DECLARE S NUMBER;
BEGIN
SELECT EMPLOYEE_PK_SEQ.NEXTVAL INTO S FROM DUAL;
UPDATE EMPLOYEE SET TITLE = 'INTERN' WHERE EMPLOYEEID=S;
end;
/

INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME,FIRSTNAME) VALUES (11, 'TERN', 'IN');


CREATE OR REPLACE TRIGGER TR_UPDATE_ALBUM
AFTER UPDATE ON ALBUM
BEGIN
DBMS_OUTPUT.PUT_LINE('album successfully updated');
end;
/

set serveroutput on;
UPDATE ALBUM SET TITLE='FRANK' WHERE ALBUMID=322;
set serveroutput off;

CREATE OR REPLACE TRIGGER TR_DELETE_CUSTOMER
AFTER DELETE ON CUSTOMER
BEGIN
DBMS_OUTPUT.PUT_LINE('RIP CUSTOMER');
end;
/
set serveroutput on;
DELETE FROM CUSTOMER WHERE CUSTOMERID=62;
set serveroutput off;

/*7.1*/
SELECT FIRSTNAME || ' ' || LASTNAME AS CUSTOMER_NAME, INVOICEID FROM invoice iv inner join customer cu on cu.customerid=iv.customerid;

/*7.2*/ 
Select cu.customerid, firstname, lastname, invoiceid, total from customer cu left outer join invoice iv on cu.customerid=iv.customerid;

/*7.3*/
select artist.name, album.title from album right outer join artist on album.artistid=artist.artistid;

/*7.4*/

select * from album,artist ORDER BY artist.name asc;

/*7.5*/
select a.firstname || ' ' || a.lastname as "Employee Name", a.employeeid as "Employee ID", b.firstname || ' ' || b.lastname as "Manager Name", b.employeeid as "Manager ID" from employee a, employee b where a.reportsto=b.employeeid;



/*extra stuff below*/


CREATE OR REPLACE TYPE CUSTOMER_NAME FORCE IS OBJECT(FIRSTNAME VARCHAR2(20),LASTNAME VARCHAR2(20));
/
CREATE OR REPLACE TYPE CUSTOMER_TABLE IS TABLE OF CUSTOMER_NAME;
/

CREATE OR REPLACE FUNCTION CUSTOMER_LIST (SUPPORTREPID1 NUMBER)
RETURN customer_TABLE AS
    L_CUSTOMER_TABLE CUSTOMER_TABLE :=CUSTOMER_TABLE();
    N INTEGER :=0;
BEGIN
    FOR I IN (SELECT FIRSTNAME,LASTNAME FROM CUSTOMER WHERE SUPPORTREPID=SUPPORTREPID1)
    LOOP
        L_CUSTOMER_TABLE.EXTEND;
        N:=N+1;
        L_CUSTOMER_TABLE(N) := CUSTOMER_NAME(I.FIRSTNAME,I.LASTNAME);
        END LOOP;
    RETURN L_CUSTOMER_TABLE;
    END;
    /
    
SELECT * FROM TABLE (CUSTOMER_LIST(4));
SELECT * FROM TABLE (CUSTOMER_LIST(5));