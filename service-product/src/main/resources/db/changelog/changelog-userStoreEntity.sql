--liquibase formatted sql

--changeset quang:1
create table "user_store" (
    id bigserial primary key,
    username varchar(255) not null,
    user_uuid varchar(255) not null,
    store_uuid varchar(255) not null,
    status varchar(10) not null,
    created_at timestamp not null,
    updated_at timestamp
);

--changeset quang:2
--preconditions onFail:WARN
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM "user_store"
insert into "user_store" (username, user_uuid, store_uuid, status, created_at)
values 
    ('shop1', 'd22c264c-aa04-11ef-8041-a702e97ac8a6', '5dce2b07-aa3a-11ef-9dca-ef5941d0e52b', 'Y', current_timestamp),
    ('shop1', 'd22c264c-aa04-11ef-8041-a702e97ac8a6', '6368c370-aa3a-11ef-8c6e-e149357b34dc', 'Y', current_timestamp),
    ('shop2', 'e44ac9fc-aa04-11ef-a20d-a77840af787f', '687d5489-aa3a-11ef-8ff9-1f812da8897c', 'Y', current_timestamp),
    ('shop2', 'e44ac9fc-aa04-11ef-a20d-a77840af787f', '6dc38400-aa3a-11ef-b7fd-ddff748db241', 'N', current_timestamp);