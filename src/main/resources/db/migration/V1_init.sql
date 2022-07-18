create table users
(
    id bigserial,
    username varchar(30) not null unique,
    password varchar(80) not null,
    email    varchar(50) unique,
    primary key (id)
);

create table roles
(
    id serial,
    name varchar(50) not null,
    primary key (id)
);

create table privileges
(
    id serial,
    name_privilege varchar(50) not null,
    primary key (id)
);

CREATE TABLE users_roles
(
    user_id bigint not null,
    role_id int    not null,
    primary key (user_id, role_id),
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);
CREATE TABLE roles_privileges
(
    role_id      bigint not null,
    privilege_id int    not null,
    primary key (role_id, privilege_id),
    foreign key (role_id) references roles (id),
    foreign key (privilege_id) references privileges (id)
);


insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into privileges (name_privilege)
values ('PRIVILEGE_USER'),
       ('PRIVILEGE_ADMIN');

insert into users (username, password, email)
values ('user', '$2a$12$N0S5l7pIdFkCiAvZ7V.h1ejyKE2v20P/TvjKp8AY/tmShq.hw/8s6', 'user@mail.ru'),
       ('admin', '$2a$12$N0S5l7pIdFkCiAvZ7V.h1ejyKE2v20P/TvjKp8AY/tmShq.hw/8s6', 'admin@mail.ru');

insert into users_roles (user_id, role_id)
values (1, 1), (2, 2);

insert into roles_privileges (role_id, privilege_id)
values (1, 1),
       (2, 2);