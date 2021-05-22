insert into roles(name) values('marketer');
insert into roles(name) values('developer');

insert into users(name, role_id) values('Ivan', 1);

insert into rules(name, mode) values('work till 5', false);

insert into roles_rules(roles_id, rules_id) values(2, 1);

insert into comments(name) values('This is first item!');

insert into attaches(name) values('file for test');

insert into states(status) values('transferred to marketing');

insert into category(name) values('working');

insert into items(name, user_id, comment_id, attach_id, category_id, state_id) values('item001', 1, 1, 1, 1, 1);