CREATE TABLE users
(
    id            serial    NOT NULL,
    email         varchar,
    enabled       boolean,
    PRIMARY KEY (id)
);