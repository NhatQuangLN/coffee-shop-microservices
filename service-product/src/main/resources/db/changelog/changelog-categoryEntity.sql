--liquibase formatted sql

--changeset quang:1
create table "category" (
    id bigserial primary key,
    uuid varchar(255) not null unique,
    category_name varchar(5000) not null,
    created_at timestamp not null,
    updated_at timestamp
);

--changeset quang:2
--preconditions onFail:WARN
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM "category"
insert into "category" (uuid, category_name, created_at)
values 
    ('e9753b0c-aa36-11ef-a662-75509f756963', '{\"en_US\": \"category_1\", \"in_ID\": \"kategori_1\"}', current_timestamp),
    ('e4634589-aa37-11ef-b3c5-0d5a9ec884d6', '{\"en_US\": \"category_2\", \"in_ID\": \"kategori_2\"}', current_timestamp),
    ('f4911855-aa37-11ef-b4a4-afbd33558400', '{\"en_US\": \"category_3\", \"in_ID\": \"kategori_3\"}', current_timestamp),
    ('f999375e-aa37-11ef-b79c-b7a25b2c6b42', '{\"en_US\": \"category_4\", \"in_ID\": \"kategori_4\"}', current_timestamp);