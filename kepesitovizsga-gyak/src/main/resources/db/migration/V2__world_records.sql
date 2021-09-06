create table world_record(
    id bigint not null auto_increment,
    description varchar(250),
    value double,
    unit_of_measure varchar(10),
    date_of_record date,
    recorder_id bigint,
    primary key (id)
);