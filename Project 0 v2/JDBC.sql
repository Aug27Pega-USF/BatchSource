CREATE TABLE USERS(USERID NUMBER(30) PRIMARY KEY, -- created new users table with the correct type and amount of inputs
USERNAME VARCHAR2(30), PASSWORD VARCHAR2(30), ADMIN NUMBER(10));

CREATE TABLE ACCOUNTS(ACCOUNTID NUMBER(30) PRIMARY KEY, -- Create table for accounts
USERID NUMBER(30), BALANCE NUMBER(30));

ALTER TABLE ACCOUNTS ADD CONSTRAINT FK_ACCOUNTID --Add foreign key constraints linking the Account ID to the Users.UserID
    FOREIGN KEY (USERID) REFERENCES USERS(USERID);

CREATE SEQUENCE SEQ_USER START WITH 1 INCREMENT BY 1; --Automatically makes a userid and increments it by one for a new input

CREATE OR REPLACE PROCEDURE MAKECUSTOMER(USERNAME IN VARCHAR2, PASSWORD IN VARCHAR2, ADMIN IN NUMBER) --procedure to make new customer
AS
BEGIN
INSERT INTO USERS VALUES(SEQ_USER.NEXTVAL, USERNAME, PASSWORD, ADMIN); --insert the new user into users
COMMIT;
END;
/
EXECUTE MAKECUSTOMER ('Joseph', 'MattRocks', '1'); --make dummy account user to test execution

CREATE OR REPLACE PROCEDURE DELETEUSER(UID IN INT) -- A procedure to delete a specific user
AS
BEGIN
DELETE FROM USERS WHERE USERS.USERID = UID; -- delete user if their name is the name of the input
COMMIT;
END;
/
--EXECUTE DELETEUSER('26'); -- used to test procedure by deleting dummy account user

CREATE OR REPLACE PROCEDURE DELETEALLUSERS -- a procedure to delete all users
AS
BEGIN
DELETE FROM USERS;
COMMIT;
END;
/
--EXECUTE DELETEALLUSERS; --delete all users


CREATE SEQUENCE SEQ_ACCOUNT START WITH 1 INCREMENT BY 1; -- created a sequence to automatically set the bank account and 
                                                            --increment by one

CREATE OR REPLACE PROCEDURE MAKEACCOUNT(USERID IN INT, BALANCE IN NUMBER) --created a procedure that would make a new account with
                                                                            -- specific userid and balance
AS
BEGIN
INSERT INTO ACCOUNTS VALUES(SEQ_ACCOUNT.NEXTVAL, USERID, BALANCE); --insert into accounts with the selected values
COMMIT;
END;
/
--EXECUTE MAKEACCOUNT (14, 983); --tested with a dummy account

CREATE OR REPLACE PROCEDURE DELETEACCOUNT(UID IN INT) --created procedure to delete specific accounts by accountid
AS
BEGIN
DELETE FROM ACCOUNTS WHERE ACCOUNTS.ACCOUNTID = UID;
COMMIT;
END;
/
--EXECUTE DELETEACCOUNT(1); -- used to test procedure by deleting dummy account

