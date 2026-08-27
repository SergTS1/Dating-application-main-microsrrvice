--liquibase formatted sql

--changeset ZakirovS:1
create table if not exists match_service.swipe
(
    id                   uuid primary key,
    from_user            uuid not null,
    to_user              uuid not null,
    created_at           timestamp with time zone not null,
    swipe_type           varchar not null
);