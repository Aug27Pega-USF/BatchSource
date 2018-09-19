-- 2.1 SELECT
SELECT
    *
FROM
    employee;

SELECT
    *
FROM
    employee
WHERE
    lastname = 'King';

SELECT
    *
FROM
    employee
WHERE
    firstname = 'ANDREW'
    AND reportsto IS NULL;

-- 2.2 ORDER BY

SELECT
    *
FROM
    album
ORDER BY
    title DESC;

SELECT
    firstname
FROM
    customer
ORDER BY
    city ASC;

--2.3 INSERT INTO

INSERT INTO genre VALUES (
    '26',
    'FOLK'
);

    INSERT INTO genre VALUES (
        '27',
        'MANS NOT HOT'
    );
    INSERT INTO employee (
        employeeid,
        lastname,
        firstname,
        title,
        reportsto,
        birthdate,
        hiredate,
        address,
        city,
        state,
        country,
        postalcode,
        phone,
        fax,
        email
    ) VALUES (
        '9',
        'Robinson',
        'Sean',
        'Master of the Custodial Arts',
        '',
        '24-MAY-88',
        '08-AUG-18',
        '742 Evergreen Terrace',
        'Springfield',
        'Il',
        'USA',
        '31313',
        '(123) 123-1234',
        '(123) 123-1234',
        'Sean@apache.com'
    ),
         ('10','Howser','Dookie','Doctor','','19-SEP-89','24-MAR-93','11800 Little ln', 'Houston', 'Tx','USA','90210','(123) 555-5555','(123) 555-5555','DrDookie@apache.com');

INSERT INTO customer (
    customerid,
    firstname,
    lastname,
    company,
    address,
    city,
    state,
    country,
    postalcode,
    phone,
    fax,
    email,
    supportrepid
) VALUES ('60','Ali','Muhammed','UFC','100 Big rd','Birmingham','Al','USA','31313','(123) 123-1255)', '(123) 123-1255','ali@boxer.com', '3'),
         ('61','Forest','Gump','All American','500 Run st','Greenbough','Al','USA','31313','(555) 555-5555','(555)555-555','shrimp@nation.com','3');

-- UPDATE
Update Customer set Firstname = 'Robert', Lastname = 'Walter' where CustomerID = 32;
Update Artist set name = 'CCR' where name = 'Creedence Clearwater Revival';

-- LIKE
Select * from invoice where billingaddress LIKE 'T%';

-- BETWEEN
Select * from invoice where total between 15 and 50;
Select * from employee where hiredate between '01-JUN-03' and '01-MAR-04';

-- DELETE Needs to be fixed
DELETE FROM INVOICELINE
WHERE INVOICEID = ANY(
    SELECT INVOICEID FROM INVOICE WHERE CUSTOMERID = 32);
    SELECT FROM CUSTOMER WHERE CUSTOMERID = 32;

--SQL FUNCTIONS BROKEN
--3.1 System Defined Functions
Select TO_CHAR(CURRENT_DATE,'DD-MM-YYYY HH:MI:SS') FROM DUAL;
SELECT LENGTH(NAME) FROM MEDIATYPE;
--3.2 System Defined Aggregate Functions
SELECT AVG(TOTAL) FROM INVOICE;
SELECT * FROM TRACK WHERE UNITPRICE = (SELECT MAX(UNITPRICE)FROM TRACK);
-- 3.3 User Defined Scalar Functions
SELECT AVG(UNITPRICE) FROM INVOICELINE;
-- 3.4 User Defined Table Valued Functions
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

SELECT * FROM TABLE(BORN_AFTER_DATE(1943));
--Task 4.1– Create a stored procedure that 
--selects the first and last names of all the employees.

CREATE OR REPLACE PROCEDURE GET_FULLNAMES
(S OUT SYS_REFCURSOR)
    AS
    BEGIN
        OPEN S FOR
        SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
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

--4.2 Stored Procedure Input Parameters

CREATE OR REPLACE PROCEDURE MANAGERS
(S OUT SYS_REFCURSOR)
    AS
    BEGIN
        OPEN S FOR
        SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE WHERE TITLE LIKE '%MANAGER';
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
SET SERVEROUTPUT ON;

--4.3

CREATE OR REPLACE PROCEDURE CUSTOMERS
(S OUT SYS_REFCURSOR)
    AS
    BEGIN
        OPEN S FOR
        SELECT FIRSTNAME, COMPANY FROM EMPLOYEE;
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
        DBMS_OUTPUT.PUT_LINE(FIRSTNAME||' '||COMPANY);
        END LOOP
        CLOSE;
    END;
/
SET SERVEROUTPUT ON;

--5.0 Transaction 

CREATE OR REPLACE PROCEDURE DELINVOICE (INVOICEID IN X) IS
    BEGIN
        DELETE FROM TABLE
        WHERE INVOICEID = X;
    END;
--Had help with transactions
CREATE OR REPLACE PROCEDURE DELETEINVOICE(ID_TO_DELETE IN INT)
AS
BEGIN
DELETE FROM INVOICELINE WHERE INVOICEID = ID_TO_DELETE;
DELETE FROM INVOICE WHERE INVOICEID = ID_TO_DELETE;
COMMIT;
END;
/
call DELETEINVOICE(1);
/*Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table*/
CREATE SEQUENCE CUSTSEQ;
CREATE OR REPLACE PROCEDURE INSERTCUSTOMER(FIRSTNAME IN VARCHAR2, LASTNAME IN VARCHAR2, EMAIL IN VARCHAR2)
AS
BEGIN
INSERT INTO CUSTOMER VALUES(CUSTSEQ.NEXTVAL +60, FIRSTNAME,LASTNAME,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,EMAIL,NULL);/*Used +60 because rows were already in the table*/
COMMIT;
END;
/


--6.0 Triggers
CREATE OR REPLACE TRIGGER TR_INSERT_EMPLOYEE
BEFORE INSERT ON EMPLOYEE
    FOR EACH ROW
    BEGIN
    INSERT INTO EMPLOYEE VALUES (        
        '9',
        'Robinson',
        'Sean',
        'Master of the Custodial Arts',
        '',
        '24-MAY-88',
        '08-AUG-18',
        '742 Evergreen Terrace',
        'Springfield',
        'Il',
        'USA',
        '31313',
        '(123) 123-1234',
        '(123) 123-1234',
        'Sean@apache.com');
        END;
        /
--update Update
CREATE OR REPLACE TRIGGER TR_AFTER_UPDATE 
AFTER UPDATE ON ALBUM
    FOR EACH ROW
    DECLARE
    BEGIN
        UPDATE ALBUM 
        SET ARTISTID = 300 
        WHERE ARTISTID = 104;
    END;
/
SELECT ARTISTID FROM ALBUM WHERE ARTISTID = '104';
-- TRIGGER delete

CREATE OR REPLACE TRIGGER TR_AFTER_DELETE     
AFTER DELETE
    ON CUSTOMER
    DECLARE
    T_CUSTOMER VARCHAR2(100);
    BEGIN
        SELECT * INTO T_CUSTOMER
        FROM DUAL;
    END;



--7.1 INNER Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT CUSTOMER.FIRSTNAME, INVOICE.INVOICEID FROM CUSTOMER INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
--7.2 OUTER Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT INVOICE.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER FULL outer
JOIN invoice ON customer.customerid !=
invoice.customerid;
-- 7.3 RIGHT Task – Create a right join that joins album and artist specifying artist name and title.

SELECT
    artist.name,
    album.title
FROM
    artist right
    JOIN album ON artist.artistid = album.artistid;
--7.4 CROSS

SELECT
    *
FROM
    artist
    CROSS JOIN album
ORDER BY
    artist.name;
--7.5 SELF

SELECT
    a.firstname,
    b.firstname   AS reports_to
FROM
    employee a,
    employee b
WHERE
    a.reportsto = b.reportsto;
--Task – Create an inner join that joins customers and orders and 
--specifies the name of the customer and the invoiceId.