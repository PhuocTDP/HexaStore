drop  DATABASE J6Store;
CREATE DATABASE J6Store;
use J6Store;
 
CREATE TABLE Accounts(
	Username nvarchar(50) primary key,
	Password nvarchar(50),
	Fullname nvarchar(50),
	Email nvarchar(50),
	Photo nvarchar(50)
);
CREATE TABLE Roles(
	Id nvarchar(10) primary key,
	Name nvarchar(50)
);



CREATE TABLE Authorities(
	Id int primary key,
	Username nvarchar(20),
	RoleId nvarchar(10),
    FOREIGN KEY (Username) REFERENCES Accounts (Username),
    FOREIGN KEY (RoleId) REFERENCES Roles (Id)
);



CREATE TABLE Orders(
	Id bigint primary key AUTO_INCREMENT,
	Username nvarchar(50),
	CreateDate datetime,
	Address nvarchar(100),
    FOREIGN KEY (Username) REFERENCES Accounts (Username)
    );
    
CREATE TABLE OrderDetails(
	Id bigint primary key AUTO_INCREMENT,
	OrderId bigint,
	ProductId int,
	Price float,
	Quantity int,
    Size char(2),
    FOREIGN KEY (OrderId) REFERENCES Orders (Id),
    FOREIGN KEY (ProductId) REFERENCES Products (Id)
);

CREATE TABLE Products(
	Id int primary key AUTO_INCREMENT,
	Name nvarchar(50),
	Image nvarchar(50),
	Price float,
    Size char(4),
	CreateDate date,
	Available bit,
	CategoryId char(4),
    FOREIGN KEY (CategoryId) REFERENCES Categories (Id)
);


CREATE TABLE Categories(
	Id char(4) primary key,
	Name nvarchar(50)
);

INSERT INTO Accounts (Username, Password, Fullname, Email, Photo)
VALUES
('phuoc', 'abc', 'Tieu Dinh Phuoc', 'tph@gmail.com','a.jpg'),
('nhan', 'abc', 'Trong Nhan', 'tph@gmail.com','a.jpg'),
('thien', 'abc', 'Phu Thien', 'tph@gmail.com','a.jpg');

INSERT INTO Roles (Id, Name)
VALUES
('CUS', 'Customer'),
('DIRE', 'Dire'),
('STAFF', 'Staff');

INSERT INTO Categories (Id, name)
VALUES
('CUS', 'Customer'),
('DIRE', 'Dire'),
('STAFF', 'Staff');
INSERT INTO Roles (Id, Name)
VALUES
('1', 'phuoc', 'STAFF'),
('2', 'nhan','DIRE'),
('3', 'thien','CUS');
INSERT INTO Products (Name, Image, Price, CreateDate, Available, CategoryId)
VALUES
('Channel', 'baner-right-image-01.jpg', 90, '2023-01-01', 0, 'Wome'),
('Gucci', 'baner-right-image-02.jpg', 150, '2023-01-01', 0, 'Men'),
('Dior', 'baner-right-image-03.jpg', 120, '2023-12-01', 0, 'Kid'),
('YSL', 'explore-image-02.jpg', 90, '2023-01-01', 0, 'Wome'),
('CK', 'instagram-01.jpg', 150, '2023-01-01', 0, 'Wome'),
('Celine', 'instagram-03.jpg', 120, '2023-12-01', 0, 'Wome'),
('Annoder ', 'instagram-05.jpg', 90, '2023-01-01', 0, 'Wome'),
('Kevin', 'team-member-01.jpg', 150, '2023-01-01', 0, 'Wome'),
('Pandora', 'team-member-02.jpg', 120, '2023-12-01', 0, 'Men');
-- ('Air Force 1 X', 'men-02.jpg', 90, '2023-01-01', 0, 'Men'),
-- ('Love Nana 20', 'men-03.jpg', 150, '2023-01-01', 0, 'Men'),
-- ('Classic Spring', 'men-01.jpg', 120, '2023-12-01', 0, 'Men'),
-- ('New Green Jacket', 'Women-01.jpg', 120, '2023-01-01', 0, 'Wome'),
-- ('Spring Collection', 'Women-03.jpg', 130, '2023-01-01', 0, 'Wome'),
-- ('Classic Dress', 'Women-02.jpg', 45, '2023-01-01', 0, 'Wome'),
-- ('New Green Jacket', 'Women-01.jpg', 120, '2023-12-01', 0, 'Wome'),
-- ('School Collection', 'kid-01.jpg', 80, '2023-01-01', 0, 'Kid'),
-- ('Summer Cap', 'kid-02.jpg', 120, '2023-01-01', 0, 'Kid'),
-- ('Classic Kid', 'kid-03.jpg', 30, '2023-01-01', 0, 'Kid'),
-- ('School Collection', 'kid-01.jpg', 80, '2023-12-01', 0, 'Kid');



