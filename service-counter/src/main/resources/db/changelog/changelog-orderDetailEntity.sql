--liquibase formatted sql

--changeset quang:1
create table "order_detail" (
    id bigserial primary key,
    order_uuid varchar(255) not null,
    product_uuid varchar(255) not null,
    product_code varchar(50) not null,
    product_name varchar(5000) not null,
    price double precision not null,
    quantity integer not null,
    created_at timestamp not null
);