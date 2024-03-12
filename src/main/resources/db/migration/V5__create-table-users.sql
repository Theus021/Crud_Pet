create table users(
id bigint not null auto_increment,
username varchar(200) not null unique,
password varchar(200) not null,
role varchar(20) not null,

primary key(id)
);