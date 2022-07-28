create database quanlytaikhoan;
use quanlytaikhoan;
-- drop database quanlytaikhoan;
create table account(
	accountid varchar(10),
    password varchar(20),
    primary key(accountid)
);

create table employee(
	employeeid int,
    name varchar(20),
    gender int,
    dob date,
    createdby varchar(10),
    primary key(employeeid),
    foreign key(createdby) references account(accountid)
);
 
insert into account 
values("mva","mva"),
	  ("mvb","mvb"),
      ("mba","mvc");
      
insert into employee
values(1004,"mr X",1,"2000-01-01","mva"),
	  (1005,"mr Y",1,"2000-02-01","mva"),
      (1006,"mr Z",1,"2000-02-01","mvb");