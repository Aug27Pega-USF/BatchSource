--2.1 SELECT
-- preforming select queries on the employee table
SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
SELECT * FROM EMPLOYEE WHERE FIRSTNAME ='Andrew' and REPORTSTO is NULL;
-- 2.2 Order BY
SELECT * FROM ABLUM ORDER BY ALBUM.TITL DESC;
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY DESC;
--2.3 INSERT INTO
-- Insert two new records into genre table
INSERT INTO GENRE (GENREID, NAME)
VALUES (26, 'Salsa');
INSERT INTO GENRE (GENREID, NAME)
VALUES (27, 'Merengue');
-- Insert two new records into employee 
INSERT INTO employee(employeeid,lastname,firstname)
values(9,'Rivera','Luis');
INSERT INTO employee(employeeid,lastname,firstname)
values(10,'Medera','Kevin');
--Insert two new records into customer
INSERT INTO customer(customerid,firstname,lastname,email,supportrepid) 
values(123123123,'Sanchez','Bob','bobsanchez@gmail.com',2);
INSERT INTO customer(customerid,firstname,lastname,email,supportrepid) 
values(2242422,'Sanchez','mary','mary@gmail.com',2);
--2.4 UPDATE
UPDATE customer
set firstname = 'Robert', lastname = 'Walter'
where firstname='Aaron' and lastname = 'Mitchell';
UPDATE artist
set name = 'CCR'
where name = 'Creedence Clearwater Revival';
--2.5 LIKE
SELECT * FROM invoice where billingaddress like 'T%';
--2.6 BETWEEN
SELECT * FROM invoice where total between 15 and 50;
SELECT * FROM employee where hiredate 
between '01-JUN-03' and '01-MAR-04';
--2.7 DELETE
DELETE FROM customer
where firstname = 'Robert' and lastname = 'Walter';

-- 3. SQL FUNCTIONS
--3.1 SYSTEM DEFINED FUNCTIONS
CREATE OR REPLACE FUNCTION gettime() RETURN TIME AS $$
        BEGIN                                                                                                                                                                                                   
            RETURN current_time;
        END;
        /
        $$ LANGUAGE plpgsql;
        
SELECT gettime();
--3.2 SYSTEM DEFINED FUNCTIONS
--3.3 User Defined Scalar Functions

--4.0 STORED PROCEDURES
--4.1 BASIC STORED PROCEDURE
CREATE PROCEDURE STORE_NAMES
AS 
BEGIN
SELECT * FIRSTNAME AND LASTNAME 
FROM EMPLOYEE
/
GO;

EXEC STORE_NAMES
--4.2 STORES PROCEDURE INPUT PARAMETERS




--7.0 JOINS 
--7.1 INNER JOIN
SELECT CUSTOMER.FIRSTNAME CUSTOMER.INVOICEID 
FROM CUSTOMER
INNER JOIN INVOICE 
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
--7.2 OUTER JOIN
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER
RIGHT OUTER JOIN INVOICE 
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
--7.3 RIGHT JOIN
SELECT ARTIST.NAME, ALBUM.TITLE 
FROM ARTIST
RIGHT JOIN ALBUM
ON ARTIST.ARTISTID = ALBUM.ARTISTID;
--7.4 CROSS JOIN
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST
CROSS JOIN ALBUM;
--7.5 SELF JOIN (SYNTAX ERROR)
SELECT A.FIRSTNAME, B.FIRSTNAME
FROM EMPLOYEE A JOIN EMPLOYEE B
ON A.REPORTSTO = B.REPORTSTO 
AND A.EMPLOYEEID <> B.EMPLOYEEID;








