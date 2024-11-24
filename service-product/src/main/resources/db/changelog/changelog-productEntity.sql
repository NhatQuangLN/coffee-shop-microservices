--liquibase formatted sql

--changeset quang:1
create table "product" (
    id bigserial primary key,
    uuid varchar(255) not null unique,
    code varchar(50) not null,
    product_name varchar(5000) not null,
    category_uuid varchar(255) not null,
    created_at timestamp not null,
    updated_at timestamp
);

--changeset quang:2
--preconditions onFail:WARN
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM "product"
insert into "product" (uuid, code, product_name, category_uuid, created_at)
values 
    ('fe7096ae-aa3b-11ef-a3f5-2d3a6529eeeb','P01', '{\"en_US\": \"product_1\", \"in_ID\": \"produk_1\"}', 'e9753b0c-aa36-11ef-a662-75509f756963', current_timestamp),
    ('3dd101e4-aa3c-11ef-9c0a-1d06de40d1e4','P02', '{\"en_US\": \"product_2\", \"in_ID\": \"produk_2\"}', 'e4634589-aa37-11ef-b3c5-0d5a9ec884d6', current_timestamp),
    ('44ea6057-aa3c-11ef-b0ed-4941497f24c7','P03', '{\"en_US\": \"product_3\", \"in_ID\": \"produk_3\"}', 'f4911855-aa37-11ef-b4a4-afbd33558400', current_timestamp),
    ('49f9362b-aa3c-11ef-9750-bb1ed05fc91d','P04', '{\"en_US\": \"product_4\", \"in_ID\": \"produk_4\"}', 'f999375e-aa37-11ef-b79c-b7a25b2c6b42', current_timestamp);