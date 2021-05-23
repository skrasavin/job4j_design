create table developer (
     id serial primary key,
     name varchar(255),
     position varchar(255)
 );

create table tasks(
     id serial primary key,
     name varchar(255),
     price int,
     developer_id int references developer(id)
 );

insert into developer(name, position) values ('A1', 'junior');
insert into developer(name, position) values ('A2', 'junior');
insert into developer(name, position) values ('B1', 'middle');
insert into developer(name, position) values ('B2', 'middle');
insert into developer(name, position) values ('C1', 'senior');
insert into developer(name, position) values ('C2', 'senior');

insert into tasks(name, price, developer_id) values('Tests1221', 50, 1);
insert into tasks(name, developer_id) values('Simple task', 1);
insert into tasks(name, price, developer_id) values('refactoring', 70, 2);
insert into tasks(name, price, developer_id) values('help the middle', 75, 2);
insert into tasks(name, price, developer_id) values('API', 150, 3);
insert into tasks(name, developer_id) values('process administration', 3);

select * from developer join tasks t on developer.id = t.developer_id;
select t.name, d.position from developer as d join tasks as t on t.developer_id = d.id;
select d.name, d.position, t.price, t.name from developer as d join tasks as t on t.developer_id = d.id;
select t.name, t.price, d.name from developer as d join tasks as t on t.developer_id = d.id AND t.price is not null;

