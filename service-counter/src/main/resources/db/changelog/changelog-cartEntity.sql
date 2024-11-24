--liquibase formatted sql

--changeset quang:1
create table "cart" (
    id bigserial primary key,
    uuid varchar(255) not null unique,
    username varchar(255),
    user_uuid varchar(255),
    store_uuid varchar(255),
    created_at timestamp,
    updated_at timestamp
);