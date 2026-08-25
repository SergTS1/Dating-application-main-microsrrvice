--liquibase formatted sql

--changeset ZakirovS:1
create schema if not exists match_service;

--changeset ZakirovS:2
create table if not exists match_service.match
(
    id              uuid primary key,
    user_a          uuid not null,
    user_b          uuid not null,
    created_at      timestamp with time zone not null,
    status          varchar not null
);