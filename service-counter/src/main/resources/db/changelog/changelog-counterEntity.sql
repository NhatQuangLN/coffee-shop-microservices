--liquibase formatted sql

--changeset quang:1
create table "counter" (
    id bigserial primary key,
    uuid varchar(255) not null unique,
    counter_name varchar(5000) not null,
    max_queue_no INTEGER not null DEFAULT 100,
    store_uuid varchar(255) not null,
    status varchar(10) not null,
    created_at timestamp not null,
    created_by varchar(255) not null,
    updated_at timestamp,
    updated_by varchar(255)
);

--changeset quang:2
--preconditions onFail:WARN
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM "counter"
insert into "counter" (uuid, counter_name, status, store_uuid, created_at, created_by)
values 
    ('9b5e8406-aa41-11ef-86c3-b56528471aae', '{\"en_US\": \"counter_1\", \"in_ID\": \"menangkal_1\"}', 'Y', '5dce2b07-aa3a-11ef-9dca-ef5941d0e52b', current_timestamp, 'shop1'),
    ('a12821c2-aa41-11ef-a043-712e5c162d08', '{\"en_US\": \"counter_2\", \"in_ID\": \"menangkal_2\"}', 'Y', '5dce2b07-aa3a-11ef-9dca-ef5941d0e52b', current_timestamp, 'shop1'),
    ('a64e951d-aa41-11ef-8993-55c2e6aecaf8', '{\"en_US\": \"counter_3\", \"in_ID\": \"menangkal_3\"}', 'Y', '5dce2b07-aa3a-11ef-9dca-ef5941d0e52b', current_timestamp, 'shop1'),
    ('acb30073-aa41-11ef-978d-3da505cf663c', '{\"en_US\": \"counter_4\", \"in_ID\": \"menangkal_4\"}', 'Y', '687d5489-aa3a-11ef-8ff9-1f812da8897c', current_timestamp, 'shop2');