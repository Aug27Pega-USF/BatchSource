/*2.1 SELECT ALL FROM EMPLOYEE */
SELECT * FROM EMPLOYEE;
/*2.1 SELECT ALL FROM EMPLOYEE WHERE LAST NAME IS KING*/
SELECT * FROM EMPLOYEE WHERE lastname='King';
/*2.1 SELECT ALL FROM EMPLOYEE WHERE FIRST NAME IS ANDREW AND REPORTSO IS NULL */
SELECT * FROM EMPLOYEE WHERE firstname='Andrew' AND REPORTSTO IS NULL;

/*2.2 SELECT ALL ALBUMS AND SORT BY TITLE IN DESC ORDER */
SELECT * FROM album ORDER BY title DESC;
/*2.2 SELECT FIRSTNAME FROM CUSTOMER TABLE AND SORT BY CITY IN ASC ORDER */
SELECT firstname FROM Customer ORDER BY CITY ASC;

/*2.3 INSERT 2 RECORDS INTO GENRE TABLE*/
INSERT INTO genre(genreid, name) VALUES(26,'Video Game');
INSERT INTO genre(genreid, name) VALUES(27,'Broadway');

/*2.3 INSERT 2 RECORDS INTO EMployee TABLE*/
INSERT INTO employee(employeeid, lastname, firstname, title, reportsto, birthdate, hiredate,address,city, state,country, postalcode, phone, fax, email) VALUES(9,'Skywalker', 'Luke','IT Staff',6,'02-MAR-65', '17-MAR-04', '1876 Sand Dune Blvd.', 'Leathbridge', 'AB', 'Canada', 'TIC IYE','+1 450-299-1745', '+1 450-289-1746', '4orcebewithU@republic.net');
INSERT INTO employee(employeeid, lastname, firstname, title, reportsto, birthdate, hiredate,address,city, state,country, postalcode, phone, fax, email) VALUES(10,'Skywalker', 'Anakin','IT Staff',6,'09-AUG-85', '17-MAR-04', '1876 Sand Dune Blvd.', 'Leathbridge', 'AB', 'Canada', 'TIC IYE','+1 450-554-8732', '+1 450-554-8733', 'sithLord4life@republic.net');

/*2.3 INSERT 2 RECORDS INTO Customer TABLE*/
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
) VALUES (
    60,
    'Mallow',
    'Star',
    null,
    '8536 Star Rd.',
    'Boston',
    'New Donk',
    'Mushroom Kingdom',
    '29906',
    '+1 854-985-6589',
    '+1 125-541-2145',
    'superToad@starvalley.net',
    3
);
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
) VALUES (
    61,
    'Geno',
    'Toad',
    null,
    '9731 Tadpole Blvd.',
    'Louisville',
    'Utah',
    'Frog Village',
    '58749',
    '+1 251-354-8740',
    '+1 537-951-6580',
    'waiting4smash@puppet.com',
    3
);

/*2.4 Update Aaron Mitchell in Customer table to Robert Walter*/
UPDATE customer SET firstname='Robert', lastname= 'Walter' WHERE firstname='Aaron' AND lastname='Mitchell';

/*2.4 Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”*/
UPDATE artist SET name='CCR' WHERE name='Creedence Clearwater Revival';

/*2.5 SELECT all invoices with a billing address like "T%" */
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

/*2.6 Select all invoices that have a total between 15 and 50*/
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;

/*2.6 Select all EMPLOYEES HIRED BETWEEN 1ST OF JUNE 2003 AND 1ST OF MARCH 2004*/
SELECT * FROM employee WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';

/*2.7 delete a record from customer table where the name Rober Walter*/
/*CustID= 32, Invocie id 50, 61, 116,342,245,268,290*/
DELETE FROM INVOICELINE WHERE invoiceid= 50 OR invoiceid= 61 OR invoiceid= 116 OR invoiceid= 342 OR invoiceid= 245 OR invoiceid= 268 OR invoiceid= 290;
DELETE FROM INVOICE WHERE customerid=32;
DELETE FROM CUSTOMER WHERE firstname='Robert' AND lastname='Walter';

/*3.1 Return current time */
SELECT to_char(sysdate,'HH12:MI:SS') FROM DUAL;
/*3.1 create a function that returns the length of name in MEDIATYPE table*/
SELECT LENGTH(name) FROM MEDIATYPE;

/*3.2 Create a function that returns the average total of all invoices */
SELECT AVG(total) FROM INVOICE;

/*3.2  Create a function that returns the most expensive track*/
SELECT MAX(UNITPRICE) FROM TRACK;

/* 3.3 Create a function that returns the average price of invoiceline items in the invoiceline table*/
SELECT AVG(UNITPRICE) FROM INVOICELINE;

/* 3.4 Create a function that returns all employees who are born after 1968.*/
/*CREATE OR REPLACE TYPE EMP_OBJECT FORCE IS OBJECT(EMP_NAME VARCHAR2(200), YEAR_BORN DATE); 
CREATE OR REPLACE TYPE EMPLOYEE_BORN IS TABLE OF EMP_OBJECT;*/

CREATE OR REPLACE FUNCTION AFTER_DATE(BIRTHYEAR IN NUMBER)
RETURN EMPLOYEE_BORN AS O_EMPS EMPLOYEE_BORN := EMPLOYEE_BORN();
N INTEGER :=0;
BEGIN
    FOR i IN 
    (SELECT (FIRSTNAME||' '|| LASTNAME) AS EMP_NAME, BIRTHDATE AS BDATE FROM EMPLOYEE WHERE BIRTHDATE > (TO_DATE(BIRTHYEAR,'YYYY')) )
        LOOP
        O_EMPS.EXTEND(); 
        N:=N+1;
        O_EMPS(N) :=EMP_OBJECT(i.EMP_NAME,i.BDATE);
        END LOOP;
    RETURN O_EMPS;
END;
/
SELECT * FROM TABLE(AFTER_DATE(1968));

/*4.1 Create a stored procedure that selects the first and last names of all the employees.*/
CREATE OR REPLACE PROCEDURE SELECTALLEMPLOYEENAMES
(S OUT SYS_REFCURSOR)
AS
BEGIN
OPEN S FOR
SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/
DECLARE
S SYS_REFCURSOR;
EMP_FNAME EMPLOYEE.FIRSTNAME%TYPE;
EMP_LNAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
SELECTALLEMPLOYEENAMES(S);
LOOP
FETCH S INTO EMP_FNAME, EMP_LNAME;
    EXIT WHEN S%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(EMP_FNAME||' '||EMP_LNAME);
    END LOOP
CLOSE;
END;
/

/*4.2  Create a stored procedure that updates the personal information of an employee.*/
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE
(EMPLOYEEIDR IN NUMBER,LASTNAMEU IN VARCHAR2, FIRSTNAMEU IN VARCHAR2, TITLEU IN VARCHAR2, REPORTSTOU IN NUMBER, BIRTHDATEU IN DATE, ADDRESSU IN VARCHAR2, CITYU IN VARCHAR2, STATEU IN VARCHAR2, COUNTRYU IN VARCHAR2, POSTALCODEU IN NUMBER, PHONEU IN VARCHAR2, FAXU IN VARCHAR2, EMAILU IN VARCHAR2)
AS
BEGIN
UPDATE EMPLOYEE SET LASTNAME=LASTNAMEU, FIRSTNAME=FIRSTNAMEU, TITLE=TITLEU, REPORTSTO=REPORTSTOU, BIRTHDATE=BIRTHDATEU, ADDRESS=ADDRESSU, CITY=CITYU, STATE=STATEU, COUNTRY=COUNTRYU, POSTALCODE=POSTALCODEU, PHONE=PHONEU, FAX=FAXU, EMAIL=EMAILU
WHERE EMPLOYEEID=EMPLOYEEIDR;
COMMIT;
END;
/

EXECUTE UPDATE_EMPLOYEE(10,'Isabelle', 'Dog', 'Secretary',1,'02-MAR-2013', '545 TOWNHALL','New Leaf', 'AC','United States', '68890', '555-255-2018','555-255-2018','ISABELL@NOOK.COM');
SELECT * FROM EMPLOYEE;

/*4.2 Create a stored procedure that returns the managers of an employee.*/
CREATE OR REPLACE PROCEDURE GET_MANAGER_OF_EMPLOYEE
(EMP_ID IN NUMBER, S OUT SYS_REFCURSOR)
AS
BEGIN
OPEN S FOR
SELECT (FIRSTNAME||' '||LASTNAME) FROM EMPLOYEE WHERE EMPLOYEEID=(SELECT REPORTSTO FROM EMPLOYEE WHERE EMPLOYEEID=EMP_ID);
END;
/
DECLARE
S SYS_REFCURSOR;
TEMP_NAME VARCHAR2(200);
BEGIN
GET_MANAGER_OF_EMPLOYEE(5,S);
LOOP
FETCH S INTO TEMP_NAME;
EXIT WHEN S%NOTFOUND;
DBMS_OUTPUT.PUT_LINE('MANAGER OF THIS EMPLOYEE IS: '|| TEMP_NAME);
END LOOP
CLOSE;
END;
/
/*4.3 Create a stored procedure that returns the name and company of a customer.*/
CREATE OR REPLACE PROCEDURE CUSTOMER_COMPANY
(CUST_ID IN NUMBER, S OUT SYS_REFCURSOR)
AS
BEGIN
OPEN S FOR
SELECT FIRSTNAME, LASTNAME, COMPANY FROM CUSTOMER WHERE CUSTOMERID = CUST_ID;
END;
/
DECLARE 
    S SYS_REFCURSOR;
    CUST_ID CUSTOMER.CUSTOMERID%TYPE; 
    COMP_NAME customer.company%TYPE;
    CUST_FNAME customer.firstname%TYPE;
    CUST_LNAME customer.lastname%TYPE;
BEGIN
    CUSTOMER_COMPANY(5,S);
    LOOP
    FETCH S INTO  CUST_FNAME, CUST_LNAME, COMP_NAME;
    EXIT WHEN S%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(CUST_FNAME||' '||CUST_LNAME|| ' IS PART OF '||COMP_NAME);
    END LOOP
    CLOSE;
END;
/

/*5.1 Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).*/

CREATE OR REPLACE PROCEDURE DELETE_INVOICE (I_ID IN NUMBER)
AS
BEGIN 
DELETE FROM invoiceline WHERE INVOICEID=I_ID;
DELETE FROM INVOICE WHERE INVOICEID= I_ID;
COMMIT;
END;
/
BEGIN
DELETE_INVOICE(323);
END;
/
/*5.1 Create a transaction nested within a stored procedure that inserts a new record in the Customer table*/
CREATE OR REPLACE PROCEDURE INSERT_CUST(CID IN NUMBER, CFNAME IN VARCHAR2,CLNAME IN VARCHAR2,CCOMPANY IN VARCHAR2,CADDRESS IN VARCHAR2, CCITY IN VARCHAR2, CSTATE IN VARCHAR2, CCOUNTRY IN VARCHAR2, CPC IN VARCHAR2,CPHONE IN VARCHAR2, CFAX IN VARCHAR2, CEMAIL IN VARCHAR2, CSID IN NUMBER)
AS
BEGIN 
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
) VALUES (CID, CFNAME, CLNAME, CCOMPANY, CADDRESS, CCITY, CSTATE, CCOUNTRY, CPC, CPHONE, CFAX, CEMAIL, CSID);
COMMIT;
END;
/
BEGIN
INSERT_CUST(62,
    'Valoren',
    'Jill',
    'Target',
    '545 Ignis Way',
    'Fort Stumpter',
    'Virgina',
    'USA',
    '87441',
    '955-757-4141',
    '757-989-9696',
    'feConquest@n.com',
    2);
END;
/

/*6.1 Create an after insert trigger on the employee table fired after a new record is inserted into the table.*/
CREATE OR REPLACE TRIGGER TR_INSERT_EMP
AFTER INSERT ON EMPLOYEE
BEGIN 
    DBMS_OUTPUT.PUT_LINE('EMPLOYEE ADDED');
    END;
/
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
) VALUES (11,'Jones', 'Brad', 'Janitor',6,'05-MAR-1989','07-MAR-2017','1765 Green Rd.', 'Boston','NY','USA','76743','859-688-9577','854-985-7852','joneB@gmail.com');

/*6.1 Create an after update trigger on the album table that fires after a row is inserted in the table*/
CREATE OR REPLACE TRIGGER TR_UPDATE_ALBUM
AFTER UPDATE ON ALBUM
BEGIN 
    DBMS_OUTPUT.PUT_LINE('ALBUM UPDATED');
    END;
/
UPDATE album
SET
    ARTISTID = 2
WHERE
    albumid =1;

/*6.1  Create an after delete trigger on the customer table that fires after a row is deleted from the table.*/
CREATE OR REPLACE TRIGGER TR_DELETE_CUSTOMER
AFTER DELETE ON CUSTOMER
BEGIN 
    DBMS_OUTPUT.PUT_LINE('CUSTOMER DELETED');
    END;
/
DELETE FROM customer
WHERE
    customerid =60;
    
/*7.1 Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.*/
SELECT invoice.InvoiceID, customer.firstname
FROM invoice
INNER JOIN Customer ON Invoice.CustomerID=Customer.CustomerID;

/*7.2 Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.*/
SELECT invoice.InvoiceID, customer.firstname,customer.lastname, customer.customerid, invoice.total
FROM invoice
FULL OUTER JOIN customer ON Invoice.CustomerID=Customer.CustomerID;

/* 7.3  Create a right join that joins album and artist specifying artist name and title.*/
SELECT A.NAME, B.TITLE
FROM ARTIST A
RIGHT JOIN ALBUM B ON a.artistid= b.artistid;

/*7.4 Create a cross join that joins album and artist and sorts by artist name in ascending order.*/
SELECT * 
FROM ARTIST, ALBUM 
ORDER BY artist.name;

/*7.5 Perform a self-join on the employee table, joining on the reportsto column.*/
SELECT (a.firstname ||' '|| a.lastname)AS EMPLOYEENAME, (b.firstname ||' '||b.lastname) AS REPORTSTONAME
FROM EMPLOYEE A JOIN EMPLOYEE B
ON A.REPORTSTO = B.EMPLOYEEID;

