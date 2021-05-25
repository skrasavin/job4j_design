create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);


insert into devices(name, price) values ('Apple', 1000);
insert into devices(name, price) values ('Samsung', 950);
insert into devices(name, price) values ('Meizu', 350);

insert into people(name) values ('Таня');
insert into people(name) values ('Саша');
insert into people(name) values ('Миша');

insert into devices_people(device_id, people_id) values (1, 3);
insert into devices_people(device_id, people_id) values (2, 2);
insert into devices_people(device_id, people_id) values (3, 1);

select avg(price) from devices;

select p.name, avg(d.price) from devices_people as dp join devices as d on dp.people_id = d.id
join people as p on dp.device_id = p.id group by p.name;

select p.name, avg(d.price) from devices_people as dp join devices as d on dp.people_id = d.id
join people as p on dp.device_id = p.id group by p.name having avg(d.price) > 500;