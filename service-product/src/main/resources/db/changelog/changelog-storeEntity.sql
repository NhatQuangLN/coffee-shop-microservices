--liquibase formatted sql

--changeset quang:1
create table "store" (
    id bigserial primary key,
    uuid varchar(255) not null unique,
    store_name varchar(5000) not null,
    created_at timestamp not null,
    updated_at timestamp
);

--changeset quang:2
--preconditions onFail:WARN
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM "store"
insert into "store" (uuid, store_name, created_at)
values 
    ('5dce2b07-aa3a-11ef-9dca-ef5941d0e52b', '{\"en_US\": \"store_1\", \"in_ID\": \"toko_1\"}', current_timestamp),
    ('6368c370-aa3a-11ef-8c6e-e149357b34dc', '{\"en_US\": \"store_2\", \"in_ID\": \"toko_2\"}', current_timestamp),
    ('687d5489-aa3a-11ef-8ff9-1f812da8897c', '{\"en_US\": \"store_3\", \"in_ID\": \"toko_3\"}', current_timestamp),
    ('6dc38400-aa3a-11ef-b7fd-ddff748db241', '{\"en_US\": \"store_4\", \"in_ID\": \"toko_4\"}', current_timestamp);