CREATE TABLE TESTERS (
    TESTERID INT PRIMARY KEY,
    FIRSTNAME VARCHAR(55),
    LASTNAME VARCHAR(55),
    COUNTRY VARCHAR(2),
    LASTLOGIN DATETIME
) as select * from CSVREAD('classpath:testers.csv');

CREATE TABLE DEVICES (
    DEVICEID INT PRIMARY KEY,
    DESCRIPTION VARCHAR(100)
) as select * from CSVREAD('classpath:devices.csv');

CREATE TABLE BUGS (
    BUGID INT PRIMARY KEY,
    DEVICEID INT ,
    TESTERID INT,
    foreign key (DEVICEID) references DEVICES(DEVICEID),
    foreign key (TESTERID) references TESTERS(TESTERID)
) as select * from CSVREAD('classpath:bugs.csv');

CREATE TABLE TESTER_DEVICE (
    TESTERID INT,
    DEVICEID INT ,
    foreign key (DEVICEID) references DEVICES(DEVICEID),
    foreign key (TESTERID) references TESTERS(TESTERID)
) as select * from CSVREAD('classpath:tester_device.csv');
