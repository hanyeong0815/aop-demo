create table if not exists `aop`.`sign_log` (
    id              bigint       AUTO_INCREMENT       primary key,
    member_id       binary(16)          not null,
    username        varchar(255),
    event_type      varchar(255)        not null,
    sign_at         timestamp(6)        default     current_timestamp(6)

);
