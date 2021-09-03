create table movies(
    id bigint not null auto_increment,
    title varchar(50),
    rate integer,
    category_id bigint,
    primary key (id)
);