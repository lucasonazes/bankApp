DROP DATABASE IF EXISTS BANKAPP;
CREATE DATABASE BANKAPP;
USE BANKAPP;

CREATE TABLE ACCOUNTS (
	ACCOUNT_NUMBER INT AUTO_INCREMENT,
    ACCOUNT_USER VARCHAR(20) NOT NULL,
    ACCOUNT_PASSWORD VARCHAR(20) NOT NULL,
    OWNER_NAME VARCHAR(50) NOT NULL,
	OWNER_CPF CHAR(11) NOT NULL,
    OWNER_ROLE CHAR(20) NOT NULL,
    BALANCE DOUBLE,
    ACCOUNT_TYPE VARCHAR(10) NOT NULL,
    CDB DOUBLE,
    PREVIOUS_INCOME DOUBLE,
    TOTAL_INCOME DOUBLE,
    
    PRIMARY KEY(ACCOUNT_NUMBER)
);

CREATE TABLE PERSON (
	PERSON_NAME VARCHAR(50) NOT NULL,
    PERSON_ROLE VARCHAR(20) NOT NULL,
    CPF CHAR(11) NOT NULL,
    
    PRIMARY KEY(CPF)
);

INSERT INTO PERSON (PERSON_NAME, PERSON_ROLE, CPF) 
VALUES ("bank", "admin", "11111111111");

INSERT INTO ACCOUNTS (ACCOUNT_USER, ACCOUNT_PASSWORD, ACCOUNT_TYPE, OWNER_NAME, OWNER_CPF, OWNER_ROLE, BALANCE) 
VALUES ("admin", "12345", "admin", "bank", "11111111111","admin", 0);
