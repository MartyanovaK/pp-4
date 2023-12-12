drop table if exists users_roles;
drop table if exists roles;
drop table if exists users;

create table roles (id bigint not null auto_increment, role varchar(255), primary key (id));
create table users_roles (user_id bigint not null, role_id bigint not null);
create table users (id bigint not null auto_increment, email varchar(255), name varchar(255), last_name varchar(255), password varchar(255), username varchar(255), primary key (id));
