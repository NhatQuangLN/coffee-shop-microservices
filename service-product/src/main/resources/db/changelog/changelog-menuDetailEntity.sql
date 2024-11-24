--liquibase formatted sql

--changeset quang:1
create table "menu_detail" (
    id bigserial primary key,
    product_uuid varchar(255) not null,
    price double precision not null,
    menu_uuid varchar(255) not null,
    created_at timestamp not null
);

--changeset quang:2
--preconditions onFail:WARN
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM "menu_detail"
insert into "menu_detail" (product_uuid, price, menu_uuid, created_at)
values 
    ('fe7096ae-aa3b-11ef-a3f5-2d3a6529eeeb', 11.95, '1c511f8b-aa3d-11ef-a140-017406adfc24', current_timestamp),
    ('3dd101e4-aa3c-11ef-9c0a-1d06de40d1e4', 5.25, '1c511f8b-aa3d-11ef-a140-017406adfc24', current_timestamp),
    ('44ea6057-aa3c-11ef-b0ed-4941497f24c7', 2.55, '2238f528-aa3d-11ef-9a57-4d905bfd492d', current_timestamp);