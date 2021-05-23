insert into roles(name) values('marketer');
insert into roles(name) values('developer');

insert into users(name, role_id) values('Ivan', 1);

insert into rules(name, mode) values('work till 5', false);

insert into roles_rules(roles_id, rules_id) values(2, 1);

insert into states(status) values('transferred to marketing');

insert into category(name) values('working');

insert into items(name, user_id, category_id, state_id) values('item001', 1, 1, 1);

insert into comments(name, item_id) values('This is first item!', 1);

insert into attaches(name, item_id) values('file for test', 1);