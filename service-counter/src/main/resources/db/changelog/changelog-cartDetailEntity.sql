--liquibase formatted sql

--changeset quang:1
create table "cart_detail" (
    id bigserial primary key,
    cart_uuid varchar(255) not null,
    product_uuid varchar(255) not null,
    product_code varchar(50) not null,
    price double precision not null,
    quantity integer not null default 1,
    created_at timestamp not null
);