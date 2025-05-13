create database ss06;
# drop database ss06;
use ss06;

-- === Book === --
create table Book
(
    Book_id       int primary key auto_increment,
    Book_title    varchar(200) not null,
    Book_author   varchar(200),
    Book_genre    varchar(200),
    Book_quantity int
);
-- ===============
-- ==procedure book
delimiter //
create procedure find_all_Book()
begin
    select * from Book;
end;
create procedure find_Book_ById(c_id int)
begin
    select * from Book where Book_id = c_id;
end;
create procedure save(c_title varchar(200),c_author varchar(200),c_genre varchar(200),c_quantity int)
begin
    insert into Book (Book_title, Book_author, Book_genre, Book_quantity)
    values (c_title,c_author,c_genre,c_quantity);
end;
create procedure updateBook(c_id int,c_title varchar(200),c_author varchar(200),c_genre varchar(200),c_quantity int)
begin
    update Book set Book_title = c_title, Book_author = c_author , Book_genre = c_genre, Book_quantity = c_quantity where Book_id = c_id;
end;
create procedure deleteBook(c_id int)
begin
    delete from Book where Book_id = c_id;
end;
delimiter //
-- ================
-- ===User=== --
create table users (
                       id int primary key auto_increment,
                       username varchar(100) not null unique,
                       password varchar(100) not null,
                       email varchar(100),
                       phone varchar(20)
);
-- ===============
-- ==procedure User=======
delimiter //
CREATE PROCEDURE register_user(
    IN p_username VARCHAR(100),
    IN p_password VARCHAR(100),
    IN p_email VARCHAR(100),
    IN p_phone VARCHAR(20)
)
BEGIN
    INSERT INTO users (username, password, email, phone)
    VALUES (p_username, p_password, p_email, p_phone);
END;
CREATE PROCEDURE login_user(
    IN p_username VARCHAR(100),
    IN p_password VARCHAR(100)
)
BEGIN
    SELECT * FROM users
    WHERE username = p_username AND password = p_password;
END;
CREATE PROCEDURE find_user_by_username(
    IN p_username VARCHAR(100)
)
BEGIN
    SELECT * FROM users WHERE username = p_username;
END ;
delimiter //
-- ====product====
CREATE TABLE products (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(255) NOT NULL,
                          price DOUBLE NOT NULL,
                          imageUrl VARCHAR(500)
);

CREATE TABLE productCarts (
                              id INT PRIMARY KEY AUTO_INCREMENT,
                              userId INT,
                              productId INT,
                              quantity INT,
                              FOREIGN KEY (productId) REFERENCES products(id)
);

-- ===============
-- ====== procedure product =====
delimiter //


create procedure find_all_products()
begin
    select * from products;
end;
create procedure find_product_by_id(p_id int)
begin
    select * from products where id = p_id;
end;
create procedure insert_product_cart(p_userId int, p_productId int, p_quantity int)
begin
    insert into productCarts(userId, productId, quantity)
    values (p_userId, p_productId, p_quantity);
end;

create procedure get_cart_by_user(p_userId int)
begin
    select pc.id, p.name, p.price, p.imageUrl, pc.quantity
    from productCarts pc
             join products p on pc.productId = p.id
    where pc.userId = p_userId;
end;

create procedure delete_cart_item(p_id int)
begin
    delete from productCarts where id = p_id;
end;
delimiter //
-- ==============================
-- ====== Employee========
CREATE TABLE Employee
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(255)   NOT NULL,
    birthday DATE           NOT NULL,
    phone    VARCHAR(20),
    email    VARCHAR(255) UNIQUE,
    salary   DECIMAL(15, 2) NOT NULL,
    position VARCHAR(100)
);
-- =======================
delimiter //
create procedure find_all_employee()
begin
    select * from Employee;
end;

create procedure find_employee_by_id(
    id_in int
)
begin
    select * from Employee where id = id_in;
end;

create procedure create_employee(
    name_in varchar(255),
    birthday_in date,
    phone_in varchar(20),
    email_in varchar(255),
    salary_in decimal(15, 2),
    position_in varchar(100)
)
begin
    insert into Employee (name, birthday, phone, email, salary, position)
    values (name_in, birthday_in, phone_in, email_in, salary_in, position_in);
end;

create procedure update_employee(
    id_in int,
    name_in varchar(255),
    birthday_in date,
    phone_in varchar(20),
    email_in varchar(255),
    salary_in decimal(15, 2),
    position_in varchar(100)
)
begin
    update Employee
    set name    = name_in,
        birthday   = birthday_in,
        phone    = phone_in,
        email = email_in,
        salary = salary_in,
        position = position_in
    where id = id_in;
end;

create procedure delete_employee(
    id_in int
)
begin
    delete from Employee where id = id_in;
end;
delimiter //