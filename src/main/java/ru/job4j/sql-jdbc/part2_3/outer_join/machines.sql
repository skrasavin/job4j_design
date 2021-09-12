create table carcase (
    id serial primary key,
    name varchar(255)
);

create table engine (
    id serial primary key,
    name varchar(255)
);

create table transmission (
    id serial primary key,
    name varchar(255)
);

create table car (
    id serial primary key,
    name varchar(255),
    carcase_id int references carcase(id),
    engine_id int references engine(id),
    transmission_id int references transmission(id)
);

insert into carcase(name) values ('sedan');
insert into carcase(name) values ('coupe');
insert into carcase(name) values ('jeep');

insert into engine(name) values ('v1');
insert into engine(name) values ('v2');
insert into engine(name) values ('v3');

insert into transmission(name) values ('mechanic');
insert into transmission(name) values ('automat');
insert into transmission(name) values ('robot');

insert into car(name, carcase_id, engine_id, transmission_id) values ('volvo', 2, 2, 1);
insert into car(name, carcase_id, engine_id, transmission_id) values ('mersedes', 3, 2, 2);
insert into car(name, carcase_id, engine_id, transmission_id) values ('bmw', 3, 3, 1);


1) Вывести список всех машин и все привязанные к ним детали.
select * from car;

2) Вывести отдельно детали (1 деталь - 1 запрос),
которые не используются НИ в одной машине, кузова, двигатели, коробки передач.
select * from carcase c left join car car on c.id = car.carcase_id where car.id is null;
select * from engine e left join car car on e.id = car.engine_id where car.id is null;
select * from transmission t left join car car on t.id = car.transmission_id where car.id is null;
