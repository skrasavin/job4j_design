create table type(
    id serial primary key,
    name varchar(255)
);

create table product(
    id serial primary key,
    name varchar(255),
    type_id int references type(id),
    expired_date date,
    price int
);

insert into type(name) values ('Сыр');
insert into type(name) values ('Молоко');
insert into type(name) values ('Заморозка');
insert into type(name) values ('Сладкое');


insert into product(name, type_id, expired_date, price) values ('Гауда', 1, '01.12.2021', 800);
insert into product(name, type_id, expired_date, price) values ('Тильтизер',1 , '12.11.2021', 700);
insert into product(name, type_id, expired_date, price) values ('Козий',1 , '12.06.2021', 900);
insert into product(name, type_id, expired_date, price) values ('Овечий',1 , '30.06.2021', 1000);

insert into product(name, type_id, expired_date, price) values ('Домик в деревне', 2, '7.06.2021', 100);
insert into product(name, type_id, expired_date, price) values ('Весёлый молочник', 2, '12.06.2021', 80);
insert into product(name, type_id, expired_date, price) values ('Простоквашино', 2, '14.9.2021', 70 );
insert into product(name, type_id, expired_date, price) values ('Московское', 2, '18.10.2021', 50);

insert into product(name, type_id, expired_date, price) values ('Пельмени', 3, '09.09.2021', 650);
insert into product(name, type_id, expired_date, price) values ('Замороженные фрукты', 3, '17.08.2021', 200);
insert into product(name, type_id, expired_date, price) values ('Курица', 3, '15.08.2021', 500);
insert into product(name, type_id, expired_date, price) values ('Пицца', 3, '06.03.2021', 350);

insert into product(name, type_id, expired_date, price) values ('Торт', 4, '15.06.2021', 700);
insert into product(name, type_id, expired_date, price) values ('Шоколад Milka', 4, '19.07.2021', 80);
insert into product(name, type_id, expired_date, price) values ('Варенье', 4, '30.08.2021', 250);

select * from type;
select * from product;
select * from product p join type t ON p.type_id = t.id AND t.name = 'Сыр';
select * from product where name LIKE '%Домик%';
select * from product where expired_date > '17.08.2021';
select max(price) from product;
select t.name, count(product.type_id) from product inner join type as t on type_id=t.id group by t.name;

select * from product p join type t ON p.type_id = t.id AND t.name = 'Сыр' OR
p.type_id = t.id AND t.name = 'Молоко';

select t.name, count(product.type_id) from product inner join type as t on type_id=t.id group by t.name
having count(product.type_id) < 4;

select p.name, p.price, p.expired_date, t.name from product as p inner join type as t on
 p.type_id=t.id group by p.name, p.price, p.expired_date, t.name ORDER BY t.name ASC;