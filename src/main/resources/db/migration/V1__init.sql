CREATE TABLE products
(
    id    bigserial PRIMARY KEY,
    title VARCHAR(255),
    cost  NUMERIC(6, 2)
);

INSERT INTO products (title, cost)
VALUES ('black leather jacket', 3600.00),
       ('White leather jacket', 3600.00),
       ('black leather bandana', 540.00),
       ('White leather bandana', 540.00),
       ('black jeans', 2200.00),
       ('White jeans', 2200.00),
       ('black leather gloves', 1050.00),
       ('White leather gloves', 1050.00),
       ('T-shirt with print AC/DC', 700.00),
       ('T-shirt with print MANOWAR', 700.00),
       ('T-shirt with print ARIA', 700.00),
       ('T-shirt with print METALLICA', 700.00),
       ('T-shirt with print SCORPIONS', 700.00),
       ('T-shirt with print Queen', 700.00),
       ('T-shirt with print W.A.S.P.', 700.00),
       ('Sunglasses', 600.00),
       ('black motorcycle boots', 4300.00),
       ('White motorcycle boots', 4300.00),
       ('black leather vest', 2300.00),
       ('White leather vest', 2300.00);

CREATE TABLE users
(
    id         bigserial PRIMARY KEY,
    username   VARCHAR(30) unique,
    password   VARCHAR(80) not null,
    email      VARCHAR(50) unique,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

INSERT INTO users (username, password, email)
VALUES ('user', '$2a$12$N0S5l7pIdFkCiAvZ7V.h1ejyKE2v20P/TvjKp8AY/tmShq.hw/8s6', 'robert_rath@mail.com'),
       ('admin', '$2a$12$N0S5l7pIdFkCiAvZ7V.h1ejyKE2v20P/TvjKp8AY/tmShq.hw/8s6', 'admin@mail.com');

CREATE TABLE roles
(
    id         bigserial primary key,
    name       varchar(50) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

INSERT INTO roles (name)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN');

CREATE TABLE users_roles
(
    user_id bigint not null references users (id),
    role_id bigint not null references roles (id),
    primary key (user_id, role_id)
);

INSERT INTO users_roles (user_id, role_id)
VALUES (1, 1),
       (2, 2);