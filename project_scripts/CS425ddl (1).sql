create table Employee
(
Employee ID		Integer(15),
 First name		varchar(15),
 last name		varchar(15),
 Phone           Integer(20),
 Email           varchar(20),
 Password        varchar(20),
 Store ID        Integer(20),
 primary key (Employee ID),
 Foreign key(Store ID) references store
);
	
create table Product
(
Product ID    varchar(20),
UPC code      varchar(20),
brand name    varchar(20),
Vendor name   varchar(20),
product name   varchar(20);
Cost          numeric(3,2),
Quantity       Integer,
Description   varchar(50),
Primary key(Product ID)
);

Create sequence emp_sequence start with 100001
increment by 1
minvalue 100001
maxvalue 999999;