--liquibase formatted sql

--changeset quang:1
create table "menu" (
    id bigserial primary key,
    uuid varchar(255) not null unique,
    menu_name varchar(5000) not null,
    store_uuid varchar(255) not null,
    created_by varchar(255) not null,
    status varchar(10) not null,
    created_at timestamp not null,
    updated_at timestamp
);

--changeset quang:2
--preconditions onFail:WARN
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM "menu"
insert into "menu" (uuid, menu_name, store_uuid, created_by, status, created_at)
values 
    ('1c511f8b-aa3d-11ef-a140-017406adfc24', '{\"en_US\": \"menu_1\", \"in_ID\": \"daftar makanan_1\"}', '5dce2b07-aa3a-11ef-9dca-ef5941d0e52b', 'shop1', 'Y', current_timestamp),
    ('2238f528-aa3d-11ef-9a57-4d905bfd492d', '{\"en_US\": \"menu_2\", \"in_ID\": \"daftar makanan_2\"}', '6368c370-aa3a-11ef-8c6e-e149357b34dc', 'shop2', 'Y', current_timestamp);