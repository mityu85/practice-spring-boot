create table pets(
    id bigint not null auto_increment,
    name varchar(20),
    species varchar(20),
    age integer,
    shop_id bigint,
    primary key (id)
);