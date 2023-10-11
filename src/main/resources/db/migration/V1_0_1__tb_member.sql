create table if not exists `aop`.`member` (
    id          binary(16)      primary key     default (UNHEX(REPLACE(UUID(), '-', ''))),
    username    varchar(255)                    not null,
    password    varchar(255)                    not null,
    name        varchar(255),
    status      varchar(255),
    created_at  timestamp(6)                    not null    default current_timestamp(6),

    constraint      uq_member_username      unique  (username)
);