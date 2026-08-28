--liquibase formatted sql

--changeset ZakirovS:1
alter table match_service.swipe
    add constraint uk_swipe_from_to
        unique (from_user, to_user);