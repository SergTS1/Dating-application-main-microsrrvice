--liquibase formatted sql

--changeset ZakirovS:1
create table if not exists match_service.user_reference
(
    user_id      uuid primary key
);