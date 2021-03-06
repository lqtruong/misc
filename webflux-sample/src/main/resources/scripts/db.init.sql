create database if not exists `webflux`;
use `webflux`;

create table if not exists `users`(
    `id`            integer primary key auto_increment,
    `username`      varchar(100) not null,
    `email`         varchar(100) not null,
    `tenant`        varchar(20) not null,
    `created_at`     datetime not null default current_timestamp,
    `modified_at`    datetime not null default current_timestamp
);

insert into `users`
(
    id, email, username, tenant, created_at, modified_at
) values
(1, 'truong@mail.com', 'truong', 'vn', sysdate(), sysdate())
,(2, 'peter@mail.com', 'peter', 'tr', sysdate(), sysdate())
;