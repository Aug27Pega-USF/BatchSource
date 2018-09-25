CREATE TABLE ACCOUNTHOLDER(
    acc_uid NUMBER PRIMARY KEY,
    fname VARCHAR2(50),
    lname VARCHAR2(50),
    uname VARCHAR2(50),
    pass VARCHAR2(50));

CREATE TABLE ACCOUNT(
	accid NUMBER PRIMARY KEY,
	userid NUMBER,
	bal DECIMAL(10,2),
    CONSTRAINT fk_accountuser FOREIGN KEY(userid) 
    REFERENCES ACCOUNTHOLDER(acc_uid));
    
CREATE TABLE ADMINISTRATOR(
    admid NUMBER,
    aduname VARCHAR2(30),
    adpass VARCHAR2(30),
    CONSTRAINT administrator_pk PRIMARY KEY (admid)
);