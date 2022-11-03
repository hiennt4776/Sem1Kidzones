create database QLHANGHOA
go
use QLHANGHOA
go

create table Employees
(
	Id int primary key not null identity(1,1),
	FullName nvarchar(100) not null,
	Birthday Date,
	Phone varchar(50),
	Address nvarchar(500) not null,
	Gender bit,
	UserRange nvarchar(100) not null,
	UserName nvarchar(100) not null,
	PassWord nvarchar(100) not null,
	

)
go
create table Categories
(
	Id int primary key not null identity(1,1),
	CategoryName nvarchar(50) UNIQUE not null,
	Description nvarchar(500) ,	
)
go

create table Products
(
	Id int primary key not null identity(1,1),
	ProductName nvarchar(50) not null,
	Price Money not null default 0 check(Price>=0),
	Description nvarchar(max) not null,
	CategoryId int not null foreign key references Categories (Id),
)
go


create table Stocks
(
	Id int primary key not null identity(1,1),
	CreatedDate Date,
	Amount int check(Amount>=0),
	Status varchar(50),
	ProductId int not null foreign key references Products(Id),
	EmployeeId int not null foreign key references Employees(Id),
)
go

drop table Employees
drop table Categories
drop table Products
drop table Stocks

insert into Employees values ('FullName 1','1991-01-10','11111111','Address 1',1,'ADMIN','NV001','ef3e7940545e0633345b71ef4fb38e579d574986173174d9cfa43c79539d2912')
insert into Employees values ('FullName 2','1992-03-11','22222222','Address 2',1,'MANAGEMENT','NV002','9778db4157cf93224ad45ca69ce49684af8fa94a6dabd7a502bcd5b634d73f5e')
insert into Employees values ('FullName 3','1995-02-12','33333333','Address 3',1,'STOCK STAFF','NV003','9e0eeefbc365e5270eabf320dc2bbb845605d0b6a56929373561c9fa89992e7a')
insert into Employees values ('FullName 4','1995-02-13','44444444','Address 4',1,'STOCK STAFF','NV004','d080f3f9c4d40e14c74e02adfae7a645544c3485478a3a296f450bb9c941144c')
insert into Employees values ('FullName 5','1995-02-14','55555555','Address 5',1,'STOCK STAFF','NV005','8607a290a2e36554b7303365e03f38471f42dfe1b1553a775a1825c655f1a71c')



insert into Categories values ('CategoryName 1','Description 1')
insert into Categories values ('CategoryName 2','Description 2')
insert into Categories values ('CategoryName 3','Description 3')
insert into Categories values ('CategoryName 4','Description 4')
insert into Categories values ('CategoryName 5','Description 5')

insert into Products values ('ProductName 1',10000,'Description 1',1)
insert into Products values ('ProductName 2',20000,'Description 2',2)
insert into Products values ('ProductName 3',30000,'Description 3',3)
insert into Products values ('ProductName 4',40000,'Description 4',4)
insert into Products values ('ProductName 5',50000,'Description 5',5)
insert into Products values ('ProductName 6',15000,'Description 1',5)
insert into Products values ('ProductName 7',24000,'Description 2',4)
insert into Products values ('ProductName 8',33000,'Description 3',3)
insert into Products values ('ProductName 9',42000,'Description 4',2)
insert into Products values ('ProductName 10',51000,'Description 5',1)
insert into Products values ('ProductName 11',11000,'Description 1',1)
insert into Products values ('ProductName 12',23000,'Description 2',2)
insert into Products values ('ProductName 13',34000,'Description 3',3)
insert into Products values ('ProductName 14',44000,'Description 4',4)
insert into Products values ('ProductName 15',670000,'Description 5',5)
insert into Products values ('ProductName 16',10000,'Description 1',1)
insert into Products values ('ProductName 17',20000,'Description 2',2)
insert into Products values ('ProductName 18',30000,'Description 3',3)
insert into Products values ('ProductName 19',40000,'Description 4',4)
insert into Products values ('ProductName 20',50000,'Description 5',5)


insert into Stocks values ('2020-04-10',5,'Status 1',1,1)
insert into Stocks values ('2020-09-10',10,'Status 2',2,2)
insert into Stocks values ('2020-08-23',15,'Status 3',3,3)
insert into Stocks values ('2020-12-14',3,'Status 4',4,3)
insert into Stocks values ('2020-02-15',6,'Status 5',5,2)
insert into Stocks values ('2020-05-22',9,'Status 6',6,1)
insert into Stocks values ('2020-05-10',8,'Status 7',7,1)
insert into Stocks values ('2020-09-26',16,'Status 8',8,1)
insert into Stocks values ('2020-04-23',24,'Status 9',9,2)
insert into Stocks values ('2020-10-12',9,'Status 10',10,2)
insert into Stocks values ('2020-09-23',18,'Status 11',11,3)
insert into Stocks values ('2020-06-24',27,'Status 12',12,3)
insert into Stocks values ('2020-04-12',7,'Status 13',13,3)
insert into Stocks values ('2020-07-3',14,'Status 14',14,3)
insert into Stocks values ('2020-01-4',21,'Status 15',15,2)
insert into Stocks values ('2020-11-5',4,'Status 16',16,2)
insert into Stocks values ('2020-1-6',8,'Status 17',17,1)
insert into Stocks values ('2020-5-7',12,'Status 18',18,1)
insert into Stocks values ('2020-3-6',2,'Status 19',19,1)
insert into Stocks values ('2020-5-7',4,'Status 20',20,1)
insert into Stocks values ('2020-06-24',26,'Status 21',12,3)
insert into Stocks values ('2020-04-12',8,'Status 22',13,3)
insert into Stocks values ('2020-01-4',22,'Status 23',15,2)
insert into Stocks values ('2020-04-23',23,'Status 24',9,2)
insert into Stocks values ('2020-04-23',25,'Status 25',9,2)

select * from Employees where UserName = 'NV001' and PassWord ='123456'
select * from Employees where Id = 1
select * from Employees
select * from Categories
select * from Products
select * from Stocks

drop table Stocks
drop table Products
drop table Categories
drop table Employees



select Id,FullName,Birthday,Phone,Address,Gender = (case Gender when 1 then 'Male' when 0 then 'Female' end) from Employees
insert into Employees values ('FullName 1','1991-01-10','123456789','Address 1',1,'NV001','123456')
insert into Employees values ('FullName 1','1991-01-10','123456789','Address 1',1,'NV001','123456')
update Employees set FullName = 'FullName 4', Birthday = '1990-04-05', Phone = '1234562', Address = 'Adress23', Gender = 1  WHERE Id = 4


create table Products
(
	Id int primary key not null identity(1,1),
	ProductName nvarchar(50) not null,
	Price Money not null default 0 check(Price>=0),
	Description nvarchar(max) not null,
	CategoryId int not null foreign key references Categories (Id),
)
go
select p.Id,p.ProductName,p.Amount,c.CategoryName from Products as p inner join Categories as c on p.CategoryId = c.Id
select p.Id, p.ProductName, p.Price, p.Description, c.CategoryName from Products as p inner join Categories as c on p.CategoryId = c.Id
select * from Stocks
select Stocks.Id, Stocks.CreatedDate, Stocks.Amount, Stocks.Status, Products.ProductName, Employees.FullName from((Stocks inner join Products on Products.Id = Stocks.ProductId) inner join Employees on Employees.Id = Stocks.EmployeeId)

create table Stocks
(
	Id int primary key not null identity(1,1),
	CreatedDate Date,
	Amount int check(Amount>=0),
	Status varchar(50),
	ProductId int not null foreign key references Products(Id),
	EmployeeId int not null foreign key references Employees(Id),
)
go
insert into Employees values ('FullName 5','1995-02-14','55555555','Address 5',1,'STOCK STAFF','NV003','112131')

select Id,FullName,UserName, from Employees
select Id,FullName,Birthday,Phone,Address,Gender = (case Gender when 1 then 'Male' when 0 then 'Female' end), UserRange from Employees
select Id,FullName,Birthday,Phone,Address,Gender = (case Gender when 1 then 'Male' when 0 then 'Female' end), UserRange from Employees
select * from Employees where UserName = 'NV001' and PassWord = '11111111'
select * from Employees where Id = 1 and PassWord = 'ef3e7940545e0633345b71ef4fb38e579d574986173174d9cfa43c79539d2912'