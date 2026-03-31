


DROP TABLE EMP;
DROP TABLE CUSTOMER;
DROP TABLE SLSREP;
DROP TABLE ORDLINE;
DROP TABLE ORDERS;
DROP TABLE PART;
DROP TABLE DEPT;




CREATE TABLE DEPT (DEPTNO int(2), 
	DNAME VARCHAR(14),LOC VARCHAR(13), 
	primary key(deptno) ) ;

CREATE TABLE SLSREP
     (SLSRNUMB int(2) NOT NULL,
     SLSRNAME VARCHAR(15),
     SLSaddr varchar(25),
     TOTCOM double(7,2),
     COMMRATE double(3,2),
     DEPTNO int(2), primary key (slsrnumb), 
	 foreign key (deptno) references dept(deptno) 
     );
	 
	 CREATE TABLE CUSTOMER
     (CUSTNUMB int(4) NOT NULL,
     CUSTNAME VARCHAR(15),
     custaddr varchar(25),
     balance double(7,2),
     credlim double(4,2),
     slsrnumb int(2), primary key (custnumb), 
	 foreign key (slsrnumb) references slsrep (slsrnumb) 
     );
	 
	 CREATE TABLE EMP
       (EMPNO int(4) NOT NULL,
     ENAME VARCHAR(10),
     JOB VARCHAR(9),
     MGR int(4),
     HIREDATE DATE,
     SAL double(7,2),
     COMM double(7,2), primary key (empno),
     DEPTNO int(2), foreign key(deptno) references dept(deptno));

	 
create table Part
     (partnumb varchar(4),
     partdesc varchar(10),
     unonhand int(4),
     itemclss varchar(2),
     wrhsnumb int(2),
     unitprce double(6,2), primary key(partnumb));
	 
	 create table Orders
     (
     ordnumb int(5),
     orddte date,
     custnumb int(4), primary key(ordnumb), foreign key (custnumb) references Customer (custnumb));
	 
	 create table OrdLine 
     ( ordnumb int(5),
     partnumb varchar(4),
     numord int(3),
     quotprce double(6,2), primary key(ordnumb, partnumb), 
	 foreign key (ordnumb) references ORDERS(ordnumb), foreign key (partnumb) references part(partnumb));

	
INSERT INTO DEPT VALUES
     (10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES 	(20,'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES     (30,'SALES','CHICAGO');
INSERT INTO DEPT VALUES     (40,'OPERATIONS','BOSTON');
 

		INSERT INTO SLSREP VALUES
     (3,'JONES, MARY','123 MAIN, GRANT, 		MI',2150.00,.05,30);

INSERT INTO SLSREP VALUES
     (6,'SMITH, WILLIAM','102 RAYMOND, ADA, 		MI',4912.50,.07,30);
INSERT INTO SLSREP VALUES
     (12,'BROWN, SAM','419 HARPER, LANSING, 		MI',2150.00,.05,30);
		
		
		 INSERT INTO customer VALUES
     (124,'ADAMS, SALLY','481 OAK, LANSING, 
		MI',418.75,500,3);
		
INSERT INTO customer VALUES
     (256,'SAMUELS, ANN','215 PETE, GRANT, 		MI',10.75,800,6);
INSERT INTO customer VALUES
     (311,'CHARLES, DON','48 COLLEGE, IRA, 		MI',200.10,300,12);
INSERT INTO customer VALUES
	(315,'DANIELS, TOM','914 CHERRY, KENT, 		MI',320.75,300,6);


INSERT INTO customer VALUES
     (405,'WILLIAMS, AL','519 WATSON, GRANT, 		MI',201.75,800,12);
INSERT INTO customer VALUES
     (412,'ADAMS, SALLY','16 ELM, LANSING, 		MI',908.75,1000,3);
INSERT INTO customer VALUES
     (522,'NELSON, MARY','108 PINE, ADA, 		MI',49.50,800,12);
INSERT INTO customer VALUES
     (567,'BAKER, JOE','808 RIDGE, HARPER, 		MI',201.20,300,6);
INSERT INTO customer VALUES
     (587,'ROBERTS, JUDY','512 PINE, ADA, 		MI',57.75,500,6);
INSERT INTO customer VALUES
     (622,'MARTIN, DAN','419 CHIP, GRANT, 		MI',575.50,500,3);



INSERT INTO part VALUES
     ('AX12','IRON',104,'HW',3,17.95);
INSERT INTO part VALUES
     ('AZ52','SKATES',20 ,'SG',2,24.95);
INSERT INTO part VALUES
     ('BA74','BASEBALL',40,'SG',1,4.95);
INSERT INTO part VALUES
     ('BH22','TOASTER',95,'HW',3,34.95);
INSERT INTO part VALUES
     ('BT04','STOVE',11,'AP',2,402.99);
INSERT INTO part VALUES
     ('BZ66','WASHER',52,'AP',3,311.95);
INSERT INTO part VALUES
     ('CA14','SKILLET',2,'HW',3,19.95);
INSERT INTO part VALUES
     ('CB03','BIKE',44,'SG',1,187.50);
INSERT INTO part VALUES
     ('CX11','MIXER',112,'HW',3,57.95);
INSERT INTO part VALUES
     ('CZ81','WEIGHTS',208,'SG',2,108.99);


	 
INSERT INTO orders VALUES
     (12489,'1991-09-02',124);
INSERT INTO orders VALUES
     (12491,'1991-09-02',311);
INSERT INTO orders VALUES
     (12494,'1991-09-04',315);
INSERT INTO orders VALUES
     (12495,'1991-09-04',256);
INSERT INTO orders VALUES
     (12498,'1991-09-05',522);
INSERT INTO orders VALUES
     (12500,'1991-09-05',124);
INSERT INTO orders VALUES
     (12504,'1991-09-05',522);





INSERT INTO ordline VALUES
     (12489,'AX12',11,14.95);
INSERT INTO ordline VALUES
     (12491,'BT04',1,402.99);
INSERT INTO ordline VALUES
     (12491,'BZ66',1,311.95);
INSERT INTO ordline VALUES
     (12494,'CB03',4,175.00);
INSERT INTO ordline VALUES
     (12495,'CX11',2,57.95);
INSERT INTO ordline VALUES
     (12498,'AZ52',2,22.95);
INSERT INTO ordline VALUES
     (12498,'BA74',4,4.95);
INSERT INTO ordline VALUES
     (12500,'BT04',1,402.99);
INSERT INTO ordline VALUES
     (12504,'CZ81',2,108.99);


INSERT INTO EMP VALUES
(7369,'SMITH','CLERK',7902,'17 DEC 80',800,NULL,20);

INSERT INTO EMP VALUES
(7499,'ALLEN','SALESMAN',7698,'20 FEB 81',1600,300,30);


INSERT INTO EMP VALUES
(7521,'WARD','SALESMAN',7698,'22 FEB 81',1250,500,30);

INSERT INTO EMP VALUES
(7566,'JONES','MANAGER',7839,'2 APR 81',2975,NULL,20);

INSERT INTO EMP VALUES
(7654,'MARTIN','SALESMAN',7698,'28 SEP 81',1250,1400,30);

INSERT INTO EMP VALUES
(7698,'BLAKE','MANAGER',7839,'1 MAY 81',2850,NULL,30);

INSERT INTO EMP VALUES
(7782,'CLARK','MANAGER',7839,'9 JUN 81',2450,NULL,10);

INSERT INTO EMP VALUES
     (7788,'SCOTT','ANALYST',7566,'09 DEC 82',3000,NULL,20);

INSERT INTO EMP VALUES
(7839,'KING','PRESIDENT',NULL,'17 NOV 81',5000,NULL,10);

INSERT INTO EMP VALUES
(7844,'TURNER','SALESMAN',7698,'8 SEP 81',1500,0,30);

INSERT INTO EMP VALUES
(7876,'ADAMS','CLERK',7788,'12 JAN 83',1100,NULL,20);

INSERT INTO EMP VALUES
(7900,'JAMES','CLERK',7698,'3 DEC 81',950,NULL,30);

INSERT INTO EMP VALUES
(7902,'FORD','ANALYST',7566,'3 DEC 81',3000,NULL,20);

INSERT INTO EMP VALUES
(7934,'MILLER','CLERK',7782,'23 JAN 82',1300,NULL,10);
 

