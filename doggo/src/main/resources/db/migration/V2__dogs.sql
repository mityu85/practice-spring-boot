create table dogs(
    id bigint not null auto_increment,
    name varchar(20),
    breed varchar(20),
    age integer,
    shelter_id bigint,
    primary key (id)
);