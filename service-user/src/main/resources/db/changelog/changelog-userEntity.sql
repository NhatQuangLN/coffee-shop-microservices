--liquibase formatted sql

--changeset quang:1
create table "user" (
    id bigserial primary key,
    username varchar(255) not null unique,
    uuid varchar(255) not null unique,
    password varchar(255) not null,
    user_type varchar(10) not null,
    created_at timestamp not null,
    updated_at timestamp
);

--changeset quang:2
--preconditions onFail:WARN
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM "user"
insert into "user" (username, uuid, password, user_type, created_at)
values 
    ('admin', 'a7bf3ccc-aa04-11ef-971d-710434f19cc6', '123', 'A', current_timestamp),
    ('shop1', 'd22c264c-aa04-11ef-8041-a702e97ac8a6', 'shop1', 'SO', current_timestamp),
    ('shop2', 'e44ac9fc-aa04-11ef-a20d-a77840af787f', 'shop2', 'SO', current_timestamp),
    ('user1', 'f5a7ad57-aa04-11ef-ae92-0798e5a86522', 'user1', 'CU', current_timestamp),
    ('user2', 'fedae148-aa04-11ef-9b39-2f5157c051e5', 'user2', 'CU', current_timestamp);