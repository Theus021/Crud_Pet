create table Tutors(
    id bigint not null auto_increment,
    tutor varchar(100) not null,
    pet varchar(100) not null,
    age varchar(2) not null,
    weight varchar(5) not null,
    telephone varchar(30) not null unique,
    email varchar(300) not null unique,
    neighborhood varchar(100) not null,
    cep varchar(9) not null,
    complement varchar(100),
    number varchar(20),
    uf char(2) not null,
    city varchar(100) not null,


    primary key(id)
);