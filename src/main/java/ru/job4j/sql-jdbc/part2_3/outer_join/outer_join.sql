create table departments (
    id serial primary key,
    name varchar(255)
);

create table emploers (
    id serial primary key,
    name varchar(255),
    departments_id int references departments(id)
);

insert into departments(name) values ('Sales');
insert into departments(name) values ('Security');
insert into departments(name) values ('Developers');
insert into departments(name) values ('Marketing');

insert into emploers(name, departments_id) values ('Karl', 1);
insert into emploers(name, departments_id) values ('Tom', 1);
insert into emploers(name, departments_id) values ('Roger', null);
insert into emploers(name, departments_id) values ('Dallas', 2);
insert into emploers(name, departments_id) values ('Karri', 2);
insert into emploers(name, departments_id) values ('Lukas', null);
insert into emploers(name, departments_id) values ('Torwald', 3);
insert into emploers(name, departments_id) values ('Mario', 4);
insert into emploers(name, departments_id) values ('Stefan', null);
insert into emploers(name, departments_id) values ('Lui', 4);
insert into emploers(name, departments_id) values ('Sasha', 1);
insert into emploers(name, departments_id) values ('Klara', 3);


2. Выполнить запросы с left, rigth, full, cross соединениями
select * from departments d left join emploers e on d.id = e.departments_id;
select * from departments d right join emploers e on d.id = e.departments_id;
select * from emploers e full join departments d on e.departments_id = d.id;
select * from departments d cross join emploers e;

3. Используя left join найти департаменты, у которых нет работников
select * from emploers e left join departments d on e.departments_id = d.id where d.id is null;

4. Используя left и right join написать запросы, которые давали бы одинаковый результат.
select * from departments d left join emploers e on d.id = e.departments_id;
select * from emploers e right join departments d on d.id = e.departments_id;

select * from departments d left join emploers e on d.id = e.departments_id;
select * from emploers e right join departments d on e.departments_id = d.id;

select * from departments d right join emploers e on d.id = e.departments_id;
select * from departments d full join emploers e on d.id = e.departments_id;

5. Создать таблицу teens с атрибутами name, gender и заполнить ее.
 Используя cross join составить все возможные разнополые пары

create table teens (
    id serial primary key,
    name varchar(255),
    gender varchar(255)
);

insert into teens(name, gender) values ('Karl', 'M');
insert into teens(name, gender) values ('Sally', 'W');
insert into teens(name, gender) values ('Tomas', 'M');

select n1.name as a, n2.name as b, (n1.gender != n2.gender) as "Pair" from teens n1 cross join teens n2;
