--liquibase formatted sql

--changeset quang:1
create table "order" (
    id bigserial primary key,
    uuid varchar(255) not null unique,
    store_uuid varchar(255) not null,
    counter_uuid varchar(255) not null,
    total_price double precision,
    created_by timestamp not null,
    created_at timestamp not null,
    updated_at timestamp
);