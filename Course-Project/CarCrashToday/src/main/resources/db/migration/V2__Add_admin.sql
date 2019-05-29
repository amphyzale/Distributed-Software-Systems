insert into users (id, activity, password, username, email)
    values (1, true, 123, 'admin', 'enforcer.snk@gmail.com');

insert into user_role (user_id, roles)
    VALUES (1, 'USER'), (1, 'ADMIN');