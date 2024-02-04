drop table if exists users_roles;
drop table if exists roles;
drop table if exists users;

create table roles (id bigint not null auto_increment, role varchar(255), primary key (id)) engine=InnoDB;
create table users_roles (user_id bigint not null, role_id bigint not null) engine=InnoDB;
create table users (id bigint not null auto_increment, email varchar(255), name varchar(255), last_name varchar(255), password varchar(255), age bigint(255), primary key (id)) engine=InnoDB;
alter table users_roles add constraint FKdbv8tdyltxa1qjmfnj9oboxse foreign key (role_id) references roles (id);
alter table users_roles add constraint FKoovdgg7vvr1hb8vw6ivcrv3tb foreign key (user_id) references users (id);